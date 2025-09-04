package com.example.smartagriculture.service;

import com.example.smartagriculture.entity.DeviceStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface DeviceStatusService {
    ResponseEntity<Map<String, Object>> getDeviceStatus(Integer device_id);
}
