package com.microservice.oauth.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    @Test
    public void  testMap(){
        List<Map<String,Integer>> list=new ArrayList<>();
        Map<String,Integer> map1=new HashMap<>();
        map1.put("datalnBuildingId",1);
        map1.put("datalnBuildingUnitId",2);
        Map<String,Integer> map3=new HashMap<>();
        map3.put("datalnBuildingId",1);
        map3.put("datalnBuildingUnitId",3);
        list.add(map1);
        list.add(map3);
        Map<String,Integer> map2=new HashMap<>();
        map2.put("datalnBuildingId",1);
        map2.put("datalnBuildingUnitId",3);

        System.out.println(">>>>>"+list.contains(map2));
    }

}
