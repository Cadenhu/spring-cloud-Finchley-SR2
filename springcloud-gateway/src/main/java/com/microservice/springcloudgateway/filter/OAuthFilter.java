/**
 * Copyright (C), 2015-2019
 * FileName: OAuthFilter
 * Author:   huhu
 * Date:     2019/4/16 22:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.microservice.springcloudgateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author huhu
 * @create 2019/4/16
 * @since 1.0.0
 */
@Slf4j
public class OAuthFilter implements GlobalFilter, Ordered {

    //@Autowired
    //private DiscoveryClient discoveryClient;

    //授权服务器
    private static final String OAUTHSERVER = "springcloud-security";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // List<String> services= discoveryClient.getServices();

        String path = exchange.getRequest().getURI().getPath();
        String serverIndtance = path.split("/")[1].toLowerCase().trim();
        log.info(">>>>" + serverIndtance);
        if (!serverIndtance.equals(OAUTHSERVER)) {
            if (!exchange.getRequest().getHeaders().containsKey("token")) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
        } else {
            if (!exchange.getRequest().getHeaders().containsKey("Authorization")) {
                return chain.filter(exchange.mutate().request(exchange.getRequest().mutate().header("Authorization", "Basic Y2xpZW50OnNlY3JldA==").build()).build());
            } else {
                return chain.filter(exchange);
            }
        }
        return chain.filter(exchange);
    }
    @Override
    public int getOrder() {
        return 0;
    }
}