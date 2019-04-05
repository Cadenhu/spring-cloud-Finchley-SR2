package com.microservice.springcloudconsumer.Interface;

import com.microservice.springcloudconsumer.Services.HelloServiceImp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author bert.hu
 * @Description:
 * @date 2018/11/323:02
 **/
@FeignClient(value = "service-provider",fallback = HelloServiceImp.class)
public interface IHelloService {

    @GetMapping(value = "/say")
    String SayHello(@RequestParam(value = "name") String name);
}
