package com.microservice.oauth.services;

import com.microservice.oauth.utils.PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
/**
 * @ClassName UserServices
 * @Description
 * @Author 74716
 * @Date 2019/4/25 17:30
 * @Version 1.0
 **/
@Component
public class UserServices  implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!username.equals("user1"))
            throw new UsernameNotFoundException("用户不存在");
        //String lowcaseUsername = username.toLowerCase();

        /*
        * password 模式加{bcrypt} ，授权码模式不加{bcrypt}。...
        * */
        OAuthUser user = new OAuthUser(1,"user1", PasswordEncoder.encode("123456") , new ArrayList<GrantedAuthority>() {{
            add(new SimpleGrantedAuthority("USER"));
        }},true);
        return user;
    }
}
