package com.example.smartagriculture.service;

import com.example.smartagriculture.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IndexService {
    ResponseEntity<Map<String, Object>> getRegister(User user);

    ResponseEntity<Map<String, Object>> getLogin(User user);

}
