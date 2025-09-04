package com.example.smartagriculture.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.example.smartagriculture.dao.AirConditionDao;
import com.example.smartagriculture.dao.SoilHumidityDao;
import com.example.smartagriculture.dao.LightIntensityDao;
import com.example.smartagriculture.entity.AirCondition;
import com.example.smartagriculture.entity.SoilHumidity;
import com.example.smartagriculture.entity.LightIntensity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@Configuration
public class MqttPubSub {

    @Autowired
    private MqttPahoClientFactory mqttClientFactory;

    @Autowired
    private SoilHumidityDao soilHumidityDao;

    @Autowired
    private AirConditionDao airConditionDao;

    @Autowired
    private LightIntensityDao lightIntensityDao;

    @Value("${mqtt.topic}")
    private String topic;

    private final ObjectMapper objectMapper = new ObjectMapper();


    //订阅板子数据的(去连接板子发来的MQTT中的数据：温湿传感器。。。。。。。)
    @Bean
    public MqttPahoMessageDrivenChannelAdapter mqttInbound() {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter("mqtt-printer-" + System.currentTimeMillis()+"-in", mqttClientFactory, "mqtt_receivedTopic");
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        return adapter;
    }

    //获取topic的数据
    @Bean
    public IntegrationFlow mqttInFlow() {
        return IntegrationFlows.from(mqttInbound())
                .handle(message -> {
                    String topic = (String) message.getHeaders().get("mqtt_receivedTopic");
                    String payload = (String) message.getPayload();

                    System.out.println(payload);

                    JsonObject jsonObject = JsonParser.parseString(payload).getAsJsonObject();
                    BigDecimal airTemperature = jsonObject.get("airtemperature").getAsBigDecimal();
                    BigDecimal airHumidity = jsonObject.get("airhumidity").getAsBigDecimal();
                    BigDecimal soilHumidity = jsonObject.get("soilhumidity").getAsBigDecimal();
                    Integer lightIntensity = jsonObject.get("lightintensity").getAsInt();

                    System.out.println(airTemperature);
                    System.out.println(airHumidity);
                    System.out.println(soilHumidity);
                    System.out.println(lightIntensity);

                    AirCondition airCondition_ = new AirCondition();
                    SoilHumidity soilHumidity_ = new SoilHumidity();
                    LightIntensity lightIntensity_ = new LightIntensity();


                    LocalDateTime now_time = LocalDateTime.now();

                    airCondition_.setTimestamp(now_time);
                    soilHumidity_.setTimestamp(now_time);
                    lightIntensity_.setTimestamp(now_time);


                    //status字段
                    String status_ = "Normal";
                    airCondition_.setStatus(status_);
                    soilHumidity_.setStatus(status_);
                    lightIntensity_.setStatus(status_);

                    airCondition_.setTemperature(airTemperature);
                    airCondition_.setHumidity(airHumidity);
                    soilHumidity_.setHumidity(soilHumidity);
                    lightIntensity_.setIntensity(lightIntensity);

                    airConditionDao.insert(airCondition_);
                    soilHumidityDao.insert(soilHumidity_);
                    lightIntensityDao.insert(lightIntensity_);
                })
                .get();
    }



    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }


    //给板子发送数据
    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound() {
        MqttPahoMessageHandler messageHandler =
                new MqttPahoMessageHandler("mqtt-printer-" + System.currentTimeMillis() + "-out", mqttClientFactory);
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic(topic);
        return messageHandler;
    }

}