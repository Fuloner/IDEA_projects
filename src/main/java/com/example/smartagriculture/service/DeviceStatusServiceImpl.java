package com.example.smartagriculture.service;

import com.example.smartagriculture.dao.DeviceStatusDao;
import com.example.smartagriculture.entity.DeviceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceStatusServiceImpl implements DeviceStatusService{

    @Autowired
    private DeviceStatusDao deviceStatusDao;

    @Override
    public ResponseEntity<Map<String, Object>> getDeviceStatus(Integer device_id){
        Map<String, Object> response = new HashMap<>();
        List<DeviceStatus> devicestatuses;
        devicestatuses = deviceStatusDao.find(device_id);
        response.put("code", 200);
        response.put("message", "获取成功");
        response.put("data", devicestatuses);
        return ResponseEntity.ok(response);
    }
}
