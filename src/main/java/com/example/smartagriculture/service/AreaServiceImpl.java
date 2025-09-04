package com.example.smartagriculture.service;

import com.example.smartagriculture.dao.AreaDao;
import com.example.smartagriculture.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AreaServiceImpl implements AreaService{

    @Autowired
    private AreaDao areaDao;

    @Override
    public ResponseEntity<Map<String, Object>> getAreas(Integer user_id){
        Map<String, Object> response = new HashMap<>();

        List<Area> areas = areaDao.findByUserId(user_id);

        response.put("code", 200);
        response.put("message", "获取成功");
        response.put("data", areas);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> addArea(Integer user_id, String areaname, String address){
        Map<String, Object> response = new HashMap<>();

        Area area = new Area();
        area.setUser_id(user_id);
        area.setAreaname(areaname);
        area.setAddress(address);

        areaDao.insert(area);

        response.put("code", 200);
        response.put("message", "创建区域成功");
        response.put("data", area);
        return ResponseEntity.ok(response);
    }
}
