package com.ghs.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 */

@SpringBootApplication
@MapperScan("com.ghs.server.mapper")
public class StuasstApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuasstApplication.class,args);
    }
}
