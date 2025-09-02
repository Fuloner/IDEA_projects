package com.example.smartagriculture.service;

import com.example.smartagriculture.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
    ResponseEntity<Map<String, Object>> getUserInfo(Integer user_id);

    ResponseEntity<Map<String, Object>> updateUserInfo(Integer user_id, String username, String avatar_url);
}
