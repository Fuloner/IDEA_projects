package com.example.smartagriculture.dao;

import com.example.smartagriculture.entity.LightIntensity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
@Component("LightMapper")
public interface LightIntensityDao {

    @Select("SELECT * FROM light_intensity")
    List<LightIntensity> findLightIntensity();

    @Insert("INSERT INTO light_intensity (record_id, intensity, device_id, timestamp, status, remarks)" +
            "VALUES (#{record_id}, #{intensity}, #{device_id}, #{timestamp}, #{status}, #{remarks})")
    int insert(LightIntensity lightIntensity);
}
