package com.example.smartagriculture.service;

import com.example.smartagriculture.entity.DeviceStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface DeviceCommandService {
    ResponseEntity<Map<String, Object>> controlDevice(Integer device_id, Integer level, Integer auto_mode);
}
