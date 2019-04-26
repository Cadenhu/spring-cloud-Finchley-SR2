package com.microservice.oauth.services;


import com.microservice.oauth.utils.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName ClientServices
 * @Description
 * @Author 74716
 * @Date 2019/4/25 15:49
 * @Version 1.0
 **/
public class ClientServices implements ClientDetailsService {
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        BaseClientDetails baseClientDetails = new BaseClientDetails();
        baseClientDetails.setClientId("client");//用来标识客户的Id
        baseClientDetails.setScope(new HashSet<String>(){{add("all");}});//用来限制客户端的访问范围
        //baseClientDetails.setAuthorities(); //此客户端可以使用的权限
        baseClientDetails.setClientSecret(PasswordEncoder.encode("123456"));//客户端安全码
        return baseClientDetails;
    }

}
