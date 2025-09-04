package com.example.smartagriculture.dao;

import com.example.smartagriculture.entity.DeviceStatus;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("DeviceStatusMapper")
public interface DeviceStatusDao {

    @Insert("INSERT INTO device_status (device_id, level, auto_mode, operation_time, operation_user)" +
            "VALUES (#{device_id}, #{level}, #{auto_mode}, #{operation_time}, #{operation_user})")
    int insert(DeviceStatus devicestatus);

    @Update("UPDATE device_status SET level = #{level}, auto_mode = #{auto_mode}, operation_time = NOW() " +
            "WHERE device_id = #{device_id}")
    int update(DeviceStatus devicestatus);

    @Delete("DELETE FROM device_status WHERE device_id = #{device_id}")
    int deleteById(Integer device_id);

    @Select("SELECT * FROM device_status WHERE device_id = #{device_id}")
    List<DeviceStatus> find(Integer device_id);
}
