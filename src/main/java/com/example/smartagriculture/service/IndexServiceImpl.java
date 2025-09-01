package com.example.smartagriculture.service;

import com.example.smartagriculture.dao.UserDao;
import com.example.smartagriculture.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private User user;

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseEntity<Map<String, Object>> getRegister(User user){
        System.out.println(user);
        Map<String, Object> response = new HashMap<>();

        // 基本参数校验
        if(user == null || user.getUsername() == null || user.getPassword() == null || user.getPhone_number() == null){
            response.put("code", 400);
            response.put("message", "信息不全");
            response.put("data", user);
            return ResponseEntity.status(400).body(response);
        }
        if(user.getUsername().length() < 6 || user.getPassword().length() < 6){
            response.put("code", 400);
            response.put("message", "用户名/密码长度不足");
            response.put("data", user);
            return ResponseEntity.status(400).body(response); // 用户名/密码长度不足
        }
        // 简单手机号格式校验（仅数字，长度11）
        String phone = user.getPhone_number();
        if(!phone.matches("^\\d{11}$")){
            response.put("code", 400);
            response.put("message", "手机号错误");
            response.put("data", user);
            return ResponseEntity.status(400).body(response);
        }

        int phoneCount = userDao.countByPhone(user.getPhone_number());
        if(phoneCount > 0){
            response.put("code", 400);
            response.put("message", "手机号已注册其他账户");
            response.put("data", user);
            return ResponseEntity.status(400).body(response); // 已存在相同用户名或手机号
        }

        // 写入数据库
        userDao.insert(user);
        response.put("code", 200);
        response.put("message", "注册成功");
        response.put("data", user);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getLogin(User user){
        Map<String, Object> response = new HashMap<>();

        String phoneNumber = user.getPhone_number();
        String password = user.getPassword();

        if (phoneNumber == null || password == null) {
            response.put("code", 400);
            response.put("message", "手机号和密码不能为空");
            response.put("data", user);
            return ResponseEntity.status(400).body(response);
        }

        User user_ = userDao.selectByPhone(phoneNumber);
        if (user == null || password != user.getPassword()) {
            response.put("code", 400);
            response.put("message", "用户名或密码错误");
            response.put("data", user);
            return ResponseEntity.status(400).body(response);
        }

        response.put("code", 200);
        response.put("message", "登录成功");
        response.put("data", user);

        return ResponseEntity.ok(response);
    }
}
