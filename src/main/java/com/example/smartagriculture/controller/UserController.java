package com.example.smartagriculture.controller;

import com.example.smartagriculture.entity.User;
import com.example.smartagriculture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{user_id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getUserInfo(@PathVariable("user_id") Integer user_id)
    {return userService.getUserInfo(user_id);}

    @PostMapping("/users/{user_id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> updateUserInfo(
            @PathVariable("user_id") Integer user_id,
            @PathVariable("username") String username,
            @PathVariable("avatar_url") String avatar_url){
        return userService.updateUserInfo(user_id,username, avatar_url);
    }
}
