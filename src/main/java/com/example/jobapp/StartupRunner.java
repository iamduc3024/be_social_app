package com.example.jobapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.jobapp.impls.RedisTestService;

@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private RedisTestService redisTestService;
    @Override
    public void run(String... args) {
        redisTestService.testRedis();
    }
}
