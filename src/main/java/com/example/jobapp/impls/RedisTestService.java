package com.example.jobapp.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisTestService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void testRedis() {
        redisTemplate.opsForValue().set("hello", "upstash");
        String result = redisTemplate.opsForValue().get("hello");
        System.out.println("Redis OK, value: " + result);
    }

}
