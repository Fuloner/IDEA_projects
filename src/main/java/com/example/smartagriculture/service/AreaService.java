package com.example.smartagriculture.service;

import com.example.smartagriculture.entity.Area;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface AreaService {
    ResponseEntity<Map<String, Object>> getAreas(Integer user_id);

    ResponseEntity<Map<String, Object>> addArea(Integer user_id, String areaname, String address);
}
