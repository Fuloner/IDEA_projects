package com.example.smartagriculture.service;

import com.example.smartagriculture.entity.Device;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface DeviceService {
    ResponseEntity<Map<String, Object>> getDevice(Integer area_id, String device_type);
}
