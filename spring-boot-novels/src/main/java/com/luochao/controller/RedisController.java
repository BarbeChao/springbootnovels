package com.luochao.controller;

import com.luochao.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/redis/set")
    public String set(String key,String value){
        redisUtil.set(key,value);
        return "success";
    }

    @GetMapping("/redis/get")
    public String get(String key){
        return (String) redisUtil.get(key);
    }
}
