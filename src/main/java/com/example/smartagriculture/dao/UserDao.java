package com.example.smartagriculture.dao;

import com.example.smartagriculture.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("Mapper")
public interface UserDao {
    // 插入操作
    @Insert("INSERT INTO users (user_id, username, password, role, phone_number, avatar_url, create_at, update_at) " +
            "VALUES (#{user_id}, #{username}, #{password}, #{role}, #{phone_number}, #{avatar_url}, #{create_at}, #{update_at})")
    int insert(User user);

    // 删除操作
    @Delete("DELETE FROM users WHERE user_id = #{user_id}")
    int deleteById(@Param("user_id") Long user_id);

    @Update("UPDATE users SET username = #{username}, phone_number = #{phone_number}, avatar_url = #{avatar_url}, update_time = NOW() " +
            "WHERE user_id = #{user_id}")
    int update(User user);

    @Update("UPDATE users SET password = #{password}, update_time = NOW() " +
            "WHERE user_id = #{user_id}")
    int updatePassword(User user);

    // 根据ID查询
    @Select("SELECT * FROM users WHERE user_id = #{user_id}")
    User selectById(Long user_id);

    @Select("SELECT * FROM users WHERE phone_number = #{phone_number}")
    User selectByPhone(String phone_number);

    // 查询所有
    @Select("SELECT * FROM users")
    List<User> selectAll();

    // 统计数量
    @Select("SELECT COUNT(*) FROM users")
    Long count();

    // 根据电话号码统计数量
    @Select("SELECT COUNT(*) FROM users WHERE phone_number = #{phone_number}")
    int countByPhone(String phone_number);
}
