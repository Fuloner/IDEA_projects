package com.example.smartagriculture.controller;

import com.example.smartagriculture.entity.Area;
import com.example.smartagriculture.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("/api/areas")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAreas(@RequestParam("user_id") Integer user_id)
    {return areaService.getAreas(user_id);}

    @RequestMapping("/api/areas/add")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addArea(@RequestParam("user_id") Integer user_id,
                                                       @RequestParam("areaname") String areaname,
                                                       @RequestParam("address") String address)
    {return areaService.addArea(user_id, areaname, address);}
}
