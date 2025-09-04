package com.example.smartagriculture.controller;

import com.example.smartagriculture.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class EnvironmentController {

    @Autowired
    private EnvironmentService environmentService;

    @RequestMapping("/api/environment/air_condition")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAirMessage(){return environmentService.getAirMessage();}

    @RequestMapping("/api/environment/soil_humidity")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getSoilMessage(){return environmentService.getSoilMessage();}

    @RequestMapping("/api/environment/light_intensity")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getLightMessage(){return environmentService.getLightMessage();}
}
