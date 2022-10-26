package com.luochao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.luochao.dao")
public class SpringbootnovelsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootnovelsApplication.class, args);
    }

}
