package com.example.smartagriculture.dao;

import com.example.smartagriculture.entity.SoilHumidity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
@Component("SoilMapper")
public interface SoilHumidityDao {
    @Select("SELECT * FROM soil_humidity")
    List<SoilHumidity> findSoilHumidity();

    @Insert("INSERT INTO soil_humidity (record_id, humidity, timestamp, device_id, status, remarks)" +
            "VALUES (#{record_id}, #{humidity}, #{timestamp}, #{device_id}, #{status}, #{remarks})")
    int insert(SoilHumidity soilHumidity);
}
