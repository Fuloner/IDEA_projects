package com.example.smartagriculture.controller;

import com.example.smartagriculture.entity.User;
import com.example.smartagriculture.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/api/auth/register")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getRegister(@RequestBody User user){return indexService.getRegister(user);}

    @RequestMapping("/api/auth/login")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getLogin(@RequestBody User user){return indexService.getLogin(user);}
}
