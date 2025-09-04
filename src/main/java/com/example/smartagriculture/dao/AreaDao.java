package com.example.smartagriculture.dao;

import com.example.smartagriculture.entity.Area;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("AreaMapper")
public interface AreaDao {
    @Insert("INSERT INTO areas (area_id, user_id, areaname, address, create_at, update_at)"+
    " VALUES (#{area_id}, #{user_id}, #{areaname}, #{address}, #{create_at}, #{update_at})")
    int insert(Area area);

    @Update("UPDATE areas SET areaname = #{areaname}, address = #{address}, update_time = NOW() " +
            "WHERE area_id = #{area_id}")
    int update(Area area);

    @Delete("DELETE FROM areas WHERE area_id = #{area_id}")
    int deleteById(Integer areaId);

    @Select("SELECT * FROM areas WHERE user_id = #{user_id}")
    List<Area> findByUserId(Integer userId);

    @Select("SELECT * FROM areas WHERE area_id = #{area_id}")
    Area findById(Integer areaId);
}
