package com.example.smartagriculture.dao;

import com.example.smartagriculture.entity.AirCondition;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
@Component("AirMapper")
public interface AirConditionDao {
    @Select("SELECT * FROM air_condition")
    List<AirCondition> findAirCondition();

    @Insert("INSERT INTO air_condition (record_id, temperature, humidity, device_id, timestamp, status, remarks)" +
            "VALUES (#{record_id}, #{temperature}, #{humidity}, #{device_id}, #{timestamp}, #{status}, #{remarks})")
    int insert(AirCondition airCondition);
}
