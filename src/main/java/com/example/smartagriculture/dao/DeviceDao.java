package com.example.smartagriculture.dao;

import com.example.smartagriculture.entity.Device;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("DeviceMapper")
public interface DeviceDao {

    @Select("SELECT * FROM devices")
    List<Device> findAll();

    @Select("SELECT * FROM devices WHERE area_id = #{area_id}")
    List<Device> findByAreaId(Integer area_id);

    @Select("SELECT * FROM devices WHERE device_type = #{device_type}")
    List<Device> findByType(String device_type);

    @Insert("INSERT INTO devices (device_id, area_id, device_name, device_category, device_type, device_description, create_at, update_at) " +
            "VALUES (#{device_id}, #{area_id}, #{device_name}, #{device_category}, #{device_type}, #{device_description}, #{create_at}, #{update_at})")
    int insert(Device device);

    @Delete("DELETE FROM devices WHERE device_id = #{device_id}")
    int deleteById(Integer device_id);
}
