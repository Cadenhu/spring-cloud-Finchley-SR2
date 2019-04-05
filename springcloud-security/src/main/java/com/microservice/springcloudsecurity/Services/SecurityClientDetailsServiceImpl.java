package com.microservice.springcloudsecurity.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;


/**
 * @Author :bert.hu
 * @Description:
 * @Date:Create in 10:48 2018/11/15
 * @Modified By:
 */
public class SecurityClientDetailsServiceImpl implements ClientDetailsService {

    private  static  final Logger logger= LoggerFactory.getLogger(SecurityClientDetailsServiceImpl.class);

    /**
     * @Author :bert.hu
     * @Description:
     * resourceIds 授权的服务实例ResourceID
     * granttypes 该client允许的授权类型
     * scopes  允许的授权范围
     * authorities
     * @Date:Create in 11:28 2018/11/15
     * @Modified By:
     * @parmer:
     */
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        BaseClientDetails baseClientDetails = new BaseClientDetails("client", "", "all", "password", "", "");
        Collection<String> scopes = new HashSet<>();
        scopes.add("all");
        baseClientDetails.setScope(scopes);
        baseClientDetails.setClientId("client");
        baseClientDetails.setClientSecret("{bcrypt}$2a$10$Zudy9yrwEEmlFpCK6alys.1ha/fiQic30T.dpgIY/E8AxN2hZbiPe");
        //baseClientDetails.addAdditionalInformation();
        return baseClientDetails;
    }

}
