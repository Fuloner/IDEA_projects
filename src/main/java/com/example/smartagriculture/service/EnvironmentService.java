package com.example.smartagriculture.service;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EnvironmentService {
    ResponseEntity<Map<String, Object>> getAirMessage();

    ResponseEntity<Map<String, Object>> getSoilMessage();

    ResponseEntity<Map<String, Object>> getLightMessage();
}
