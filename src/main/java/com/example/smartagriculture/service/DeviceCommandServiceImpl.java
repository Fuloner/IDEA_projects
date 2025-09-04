package com.example.smartagriculture.service;

import com.example.smartagriculture.dao.DeviceLogDao;
import com.example.smartagriculture.dao.DeviceStatusDao;
import com.example.smartagriculture.dao.MqttMessageSender;
import com.example.smartagriculture.entity.DeviceLog;
import com.example.smartagriculture.entity.DeviceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class DeviceCommandServiceImpl implements DeviceCommandService{

    @Autowired
    private DeviceStatusDao deviceStatusDao;

    @Autowired
    private DeviceLogDao deviceLogDao;

    @Autowired
    private MqttMessageSender mqttMessageSender;

    public ResponseEntity<Map<String, Object>> controlDevice(Integer device_id, Integer level, Integer auto_mode){
        Map<String, Object> response = new HashMap<>();

        if (level == null || auto_mode == null) {
            response.put("code", 400);
            response.put("message", "level和auto_mode参数不能为空");
            return ResponseEntity.badRequest().body(response);
        }

        DeviceStatus deviceStatus = new DeviceStatus();
        deviceStatus.setDeviceId(device_id);
        deviceStatus.setLevel(level);
        deviceStatus.setAutoMode(auto_mode);
        deviceStatus.setOperationTime(LocalDateTime.now());

        deviceStatusDao.update(deviceStatus);

        // 发送MQTT控制消息
        String topic = "devices/control";
        Map<String, Object> payload = new HashMap<>();
        payload.put("device_id", device_id);
        payload.put("level", level);
        payload.put("auto_mode", auto_mode);
        payload.put("timestamp", System.currentTimeMillis());

        mqttMessageSender.sendMessage(topic, payload.toString());

        DeviceLog deviceLog = new DeviceLog();
        deviceLog.setDevice_id(device_id.longValue());
        if(level==0){
            deviceLog.setOperation_type("关闭");
        }
        else{
            deviceLog.setOperation_type("开启");
        }
        if(auto_mode==1){
            deviceLog.setOperation_type("调节");
        }
        Map<String, Object> operationParams = new HashMap<>();
        operationParams.put("level", level);
        operationParams.put("auto_mode", auto_mode);
        //deviceLog.setOperation_params(operationParams);

        deviceLog.setOperator_id(1);//获取用户id, 暂时用1

        deviceLog.setOperator_type("用户");
        deviceLog.setOperation_time(LocalDateTime.now());
        deviceLogDao.insert(deviceLog);

        Map<String, Object> data = new HashMap<>();
        data.put("device_id", device_id);
        data.put("level", level);
        data.put("auto_mode", auto_mode);
        data.put("operation_user", 1); // 获取用户id, 暂时用1
        data.put("operation_time", deviceStatus.getOperationTime());

        response.put("code", 200);
        response.put("message", "控制指令已发送");
        response.put("data", data);

        return ResponseEntity.ok(response);
    }
}
