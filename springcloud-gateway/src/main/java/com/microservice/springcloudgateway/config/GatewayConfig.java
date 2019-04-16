/**
 * Copyright (C), 2015-2019
 * FileName: GatewayConfig
 * Author:   huhu
 * Date:     2019/3/30 20:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.microservice.springcloudgateway.config;

import com.microservice.springcloudgateway.filter.OAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author huhu
 * @create 2019/3/30
 * @since 1.0.0
 */
@Configuration
public class GatewayConfig {


    @Bean
    public OAuthFilter init(){
        return new OAuthFilter();
    }
}