package com.ghs.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 */
@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/system/config/hello")
    public String hello2(){
        return "/system/config/hello";
    }

    @GetMapping("/course/showTab/hello")
    public String hello3(){
        return "/course/showTab/hello";
    }
}
