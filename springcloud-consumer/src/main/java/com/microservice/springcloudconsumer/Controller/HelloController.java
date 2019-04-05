package com.microservice.springcloudconsumer.Controller;

import com.microservice.springcloudconsumer.Interface.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bert.hu
 * @Description:
 * @date 2018/11/322:59
 **/
@RestController
public class HelloController {

    @Autowired
    private IHelloService helloService;

    @Value("${test.name}")
    private String nameS;

    @GetMapping("/hi")
    String SayHi(String name){
        return  helloService.SayHello(nameS);
    }
}
