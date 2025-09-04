package com.example.smartagriculture.service;

import com.example.smartagriculture.entity.Alert;
import com.example.smartagriculture.dao.AlertDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlertServiceImpl implements AlertService{

    @Autowired
    private AlertDao alertDao;

    @Override
    public ResponseEntity<Map<String, Object>> getAlerts(){
        Map<String, Object> response = new HashMap<>();

        List<Alert> alerts = alertDao.findAll();

        response.put("code", 200);
        response.put("message", "获取告警信息成功");
        response.put("data", alerts);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> deleteAlert(Integer alert_id){
        Map<String, Object> response = new HashMap<>();

        alertDao.deleteById(alert_id);

        response.put("code", 200);
        response.put("message", "删除告警信息成功");
        response.put("data", null);//暂时为null
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> updateAlert(Alert alert){
        Map<String, Object> response = new HashMap<>();

        alertDao.update(alert);

        response.put("code", 200);
        response.put("message", "更新告警信息成功");
        response.put("data", null);//暂时为null
        return ResponseEntity.ok(response);
    }
}
