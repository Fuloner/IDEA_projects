package com.example.smartagriculture.service;

import com.example.smartagriculture.entity.Alert;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface AlertService {
    ResponseEntity<Map<String, Object>> getAlerts();

    ResponseEntity<Map<String, Object>> deleteAlert(Integer alert_id);

    ResponseEntity<Map<String, Object>> updateAlert(Alert alert);
}
