package com.microservice.oauth.config;

import com.microservice.oauth.services.UserServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @ClassName WebSecurityConfig
 * @Description
 * @Author 74716
 * @Date 2019/4/25 14:39
 * @Version 1.0
 **/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/oauth/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()//关闭csrd拦截
        ;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserServices()).passwordEncoder(passwordEncoder());
    }

    private BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
