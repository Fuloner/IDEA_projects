package com.example.smartagriculture.dao;

import com.example.smartagriculture.entity.DeviceLog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("DeviceLogMapper")
public interface DeviceLogDao {
    @Insert("INSERT INTO device_operation_logs (log_id, device_id, operation_type, operator_id, operator_type, operation_time)" +
            "VALUES (#{log_id}, #{device_id}, #{operation_type}, #{operator_id}, #{operator_type}, #{operation_time})")
    int insert(DeviceLog record);

    @Select("SELECT * FROM device_operation_logs WHERE device_id = #{device_id}")
    List<DeviceLog> findByDeviceId(String device_id);
}
