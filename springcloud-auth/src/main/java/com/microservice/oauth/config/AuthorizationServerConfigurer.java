package com.microservice.oauth.config;

import com.microservice.oauth.services.ClientServices;
import com.microservice.oauth.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;

/**
 * @ClassName AuthorizationServerConfigurer
 * @Description
 * @Author 74716
 * @Date 2019/4/23 14:20
 * @Version 1.0
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {


    @Autowired
    private UserServices userServices;
    //让其 支持 password grant_type
    private AuthenticationManager authenticationManager;

    public AuthorizationServerConfigurer(AuthenticationConfiguration configuration) throws Exception {
        this.authenticationManager =
                configuration.getAuthenticationManager();

    }

    public ClientDetailsService clientDetailsService() {
        return new ClientServices();
    }

    /*
     * 确定客户详细情况，比如声明单个客户及其属性。
     * 请注意，除非向AuthorizationServerEndpointsConfigurator提供authenticationManager，否则不会启用密码授权。
     * 必须声明至少一个客户端或完全格式的自定义客户端详细信息服务，否则服务器将无法启动。
     * */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService());
    }

    /*
     * 配置授权服务器的安全性，这意味着在/oauth/token个接口中。
     * /oauth/authorize 接口也需要是安全的，但是这是一个面向用户的普通端点，应该像其他用户界面一样受到保护，所以这里没有介绍。
     * 默认设置包括最常见的需求，遵循OAuth2规范的建议，所以您不需要在这里做任何事情来启动和运行一个基本的服务器。
     * */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .allowFormAuthenticationForClients()//允许对客户端进行表单身份验证
               // .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
        ;
    }

    /*
     *配置授权服务器终结点的非安全功能，如令牌存储、令牌自定义、用户批准和授予类型。
     *默认情况下，您不需要做任何事情，
     * 除非您需要密码授权，在这种情况下，您需要提供一个authenticationmanager
     * */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints

                .authenticationManager(this.authenticationManager)//认证管理器，当你选择了资源所有者密码（password）授权类型的时候，请设置这个属性注入一个 AuthenticationManager 对象。
                .userDetailsService(userServices)
                .allowedTokenEndpointRequestMethods(HttpMethod.POST)//允许的令牌终结点请求方法
        //.tokenStore(new InMemoryTokenStore())//内存令牌
        ;
    }


}
