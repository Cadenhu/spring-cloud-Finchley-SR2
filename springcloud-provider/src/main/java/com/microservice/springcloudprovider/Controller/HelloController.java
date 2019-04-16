package com.microservice.springcloudprovider.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author bert.hu
 * @Description:
 * @date 2018/11/322:47
 **/
@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/say")
    String SayHi(String name) {
        return "Hello," + name + "--->By Port" + port;
    }
}
