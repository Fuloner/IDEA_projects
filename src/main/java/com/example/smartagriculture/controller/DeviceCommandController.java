package com.example.smartagriculture.controller;

import com.example.smartagriculture.entity.DeviceLog;
import com.example.smartagriculture.service.DeviceCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class DeviceCommandController {
    @Autowired
    private DeviceCommandService deviceCommandService;

    @RequestMapping("/api/devices/{device_id}/control")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> controlDevice(@PathVariable Integer device_id,
                                                             @RequestParam Integer level,
                                                             @RequestParam Integer auto_mode){
        return deviceCommandService.controlDevice(device_id, level, auto_mode);
    }
}
