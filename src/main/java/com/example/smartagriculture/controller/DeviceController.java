package com.example.smartagriculture.controller;

import com.example.smartagriculture.entity.Device;
import com.example.smartagriculture.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping("/api/devices")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getDevices(@RequestParam(required = false) Integer area_id,
                                                          @RequestParam(required = false) String device_type){
        return deviceService.getDevice(area_id, device_type);
    }
}
