package com.example.smartagriculture.dao;

import com.example.smartagriculture.entity.Alert;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("AlertMapper")
public interface AlertDao {
    @Insert("INSERT INTO alerts (alert_id, alert_type, source_type, source_id, alert_message, alert_time, status)"+
            " VALUES (#{alert_id}, #{alert_type}, #{source_type}, #{source_id}, #{alert_message}, #{alert_time}, #{status})")
    int insert(Alert alert);

    @Update("UPDATE alerts SET alert_time = NOW(), status = #{status}" +
            "WHERE alert_id = #{alert_id}")
    int update(Alert alert);

    @Delete("DELETE FROM alerts WHERE alert_id = #{alert_id}")
    int deleteById(Integer alert_id);

    @Select("SELECT * FROM alerts ORDER BY alert_time DESC")
    List<Alert> findAll();
}
