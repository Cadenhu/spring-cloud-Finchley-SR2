package com.microservice.oauth.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName PasswordEncoder
 * @Description
 * @Author 74716
 * @Date 2019/4/26 11:36
 * @Version 1.0
 **/
public class PasswordEncoder {

    public static BCryptPasswordEncoder BCrypt(){
         return new BCryptPasswordEncoder();
    }

    public static String encode(String pwd){
        return "{bcrypt}"+BCrypt().encode(pwd);
    }

}
