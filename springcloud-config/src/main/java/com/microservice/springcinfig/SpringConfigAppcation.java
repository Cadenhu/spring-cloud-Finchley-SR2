/**
 * Copyright (C), 2015-2019
 * FileName: SpringConfigAppcation
 * Author:   huhu
 * Date:     2019/3/28 23:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.microservice.springcinfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 〈配置中心〉<br>
 * 〈〉
 *
 * @author huhu
 * @create 2019/3/28
 * @since 1.0.0
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class SpringConfigAppcation {
    public static void main(String[] args) {
        SpringApplication.run(SpringConfigAppcation.class);
    }
}