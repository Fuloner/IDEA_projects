package com.example.smartagriculture.controller;

import com.example.smartagriculture.entity.Alert;
import com.example.smartagriculture.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class AlertController {

    @Autowired
    private AlertService alertService;

    @RequestMapping("/api/alerts")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAlerts(){
        return alertService.getAlerts();
    }

    @RequestMapping("/api/alerts/delete")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteAlert(Integer alert_id){
        return alertService.deleteAlert(alert_id);
    }

    @RequestMapping("/api/alerts/update")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> updateAlert(Alert alert){
        return alertService.updateAlert(alert);
    }
}
