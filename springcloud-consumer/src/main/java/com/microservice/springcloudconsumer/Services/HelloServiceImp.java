package com.microservice.springcloudconsumer.Services;

import com.microservice.springcloudconsumer.Interface.IHelloService;
import org.springframework.stereotype.Component;

/**
 * @author bert.hu
 * @Description:
 * @date 2018/11/323:03
 **/
@Component
public class HelloServiceImp implements IHelloService {
    @Override
    public String SayHello(String name) {
        return "sorry" + name;
    }
}
