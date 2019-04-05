package com.microservice.springcloudsecurity.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bert.hu
 * @Description:
 * @date 2018/11/622:09
 **/
@RestController
public class HelloController {

    @RequestMapping("/")
    String Home(String name) {
        return "Hell " + name;
    }
}
