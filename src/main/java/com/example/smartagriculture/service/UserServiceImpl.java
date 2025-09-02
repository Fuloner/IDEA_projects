package com.example.smartagriculture.service;

import com.example.smartagriculture.dao.UserDao;
import com.example.smartagriculture.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseEntity<Map<String, Object>> getUserInfo(Integer user_id){

        Map<String, Object> response = new HashMap<>();

        if(user_id>userDao.count()){
            response.put("code", 400);
            response.put("message", "用户不存在");
            response.put("data", null);
            return ResponseEntity.status(400).body(response);
        }

        User data = userDao.selectById(user_id.longValue());
        response.put("code", 400);
        response.put("message", "用户不存在");
        response.put("data", data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> updateUserInfo(Integer user_id, String username, String avatar_url){

        Map<String, Object> response = new HashMap<>();

        if(user_id>userDao.count()){
            response.put("code", 400);
            response.put("message", "用户不存在");
            response.put("data", null);
            return ResponseEntity.status(400).body(response);
        }

        int updateflag = userDao.updateUsernameAndAvatar(user_id, username, avatar_url);
        User user = userDao.selectById(user_id.longValue());

        Map<String, Object> data = new HashMap<>();
        data.put("user_id", user_id);
        data.put("update_at",user.getUpdate_at());

        response.put("code", 400);
        response.put("message", "用户不存在");
        response.put("data", null);

        return ResponseEntity.ok(response);
    }
}
