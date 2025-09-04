package com.example.smartagriculture.service;

import com.example.smartagriculture.dao.DeviceDao;
import com.example.smartagriculture.entity.Device;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceServiceImpl implements DeviceService{

    @Autowired
    private DeviceDao deviceDao;

    @Override
    public ResponseEntity<Map<String, Object>> getDevice(Integer area_id, String device_type){
        Map<String, Object> response = new HashMap<>();
        List<Device> devices;
        if (area_id != null) {
            devices = deviceDao.findByAreaId(area_id);
        } else if (device_type != null) {
            devices = deviceDao.findByType(device_type);
        } else {
            devices = deviceDao.findAll();
        }
        response.put("code", 200);
        response.put("message", "获取成功");
        response.put("data", devices);
        return ResponseEntity.ok(response);
    }
}
