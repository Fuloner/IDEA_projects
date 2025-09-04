package com.example.smartagriculture.controller;

import com.example.smartagriculture.entity.Device;
import com.example.smartagriculture.service.DeviceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class DeviceStatusController {

    @Autowired
    private DeviceStatusService deviceStatusService;

    @RequestMapping("/api/devices/{device_id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getDeviceStatus(@PathVariable("device_id") Integer device_id){
        return deviceStatusService.getDeviceStatus(device_id);
    }
}
