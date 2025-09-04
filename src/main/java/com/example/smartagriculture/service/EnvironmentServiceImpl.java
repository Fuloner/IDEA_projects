package com.example.smartagriculture.service;

import com.example.smartagriculture.dao.AirConditionDao;
import com.example.smartagriculture.dao.LightIntensityDao;
import com.example.smartagriculture.dao.SoilHumidityDao;
import com.example.smartagriculture.entity.AirCondition;
import com.example.smartagriculture.entity.LightIntensity;
import com.example.smartagriculture.entity.SoilHumidity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EnvironmentServiceImpl implements EnvironmentService{

    @Autowired
    private AirConditionDao airConditionDao;

    @Autowired
    private LightIntensityDao lightIntensityDao;

    @Autowired SoilHumidityDao soilHumidityDao;

    @Override
    public ResponseEntity<Map<String, Object>> getAirMessage(){
        Map<String, Object> response = new HashMap<>();

        List<AirCondition> data = airConditionDao.findAirCondition();

        List<Map<String, Object>> out = new java.util.ArrayList<>();

        for (AirCondition d : data) {
            Map<String, Object> m = new HashMap<>();
            m.put("record_id", d.getRecord_id());
            m.put("temperature", d.getTemperature());
            m.put("humidity", d.getHumidity());
            m.put("timestamp", d.getTimestamp());
            m.put("device_id", d.getDevice_id());
            m.put("status", d.getStatus());
            m.put("remarks", d.getRemarks());
            out.add(m);
        }

        response.put("code", 200);
        response.put("message", "获取成功");
        response.put("data", out);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getSoilMessage(){
        Map<String, Object> response = new HashMap<>();

        List<SoilHumidity> data = soilHumidityDao.findSoilHumidity();

        List<Map<String, Object>> out = new java.util.ArrayList<>();

        for (SoilHumidity d : data) {
            Map<String, Object> m = new HashMap<>();
            m.put("record_id", d.getRecord_id());
            m.put("humidity", d.getHumidity());
            m.put("timestamp", d.getTimestamp());
            m.put("device_id", d.getDevice_id());
            m.put("status", d.getStatus());
            m.put("remarks", d.getRemarks());
            out.add(m);
        }

        response.put("code", 200);
        response.put("message", "获取成功");
        response.put("data", out);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getLightMessage(){
        Map<String, Object> response = new HashMap<>();

        List<LightIntensity> data = lightIntensityDao.findLightIntensity();

        List<Map<String, Object>> out = new java.util.ArrayList<>();

        for (LightIntensity d : data) {
            Map<String, Object> m = new HashMap<>();
            m.put("record_id", d.getRecord_id());
            m.put("intensity", d.getIntensity());
            m.put("timestamp", d.getTimestamp());
            m.put("device_id", d.getDevice_id());
            m.put("status", d.getStatus());
            m.put("remarks", d.getRemarks());
            out.add(m);
        }

        response.put("code", 200);
        response.put("message", "获取成功");
        response.put("data", out);

        return ResponseEntity.ok(response);
    }
}
