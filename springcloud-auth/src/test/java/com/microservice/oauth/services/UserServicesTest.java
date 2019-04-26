package com.microservice.oauth.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServicesTest {

    private BCryptPasswordEncoder passwordEncoder;


    @Test
    public void BCryptPasswordEncoderTest(){
        String value="123456";
        String newValue=passwordEncoder.encode(value);
        System.out.println("---->"+newValue.trim());
        boolean isD=passwordEncoder.matches("123456",passwordEncoder.encode(value));
        System.out.println("---->"+isD);
    }

    @Before
    public void  building() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

}
