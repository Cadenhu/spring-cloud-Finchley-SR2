package com.microservice.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description
 * @Author 74716
 * @Date 2019/4/25 14:49
 * @Version 1.0
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    String hello(){
        return "Oauth2";
    }
}
