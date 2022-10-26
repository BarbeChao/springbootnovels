package com.luochao.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public void set(String Key,Object Value){
        redisTemplate.opsForValue().set(Key,Value);
    }

    public Object get(String Key){
        if(!redisTemplate.hasKey(Key)){
            return null;
        }
        return redisTemplate.opsForValue().get(Key);
    }

    public boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }

    public void incre(String key){
        redisTemplate.opsForValue().increment(key);
    }

    public void decre(String key){
        redisTemplate.opsForValue().decrement(key);
    }

    public Set<String> keys(String pattern){
        Set<String> set = redisTemplate.keys(pattern);
        return set;
    }

}
