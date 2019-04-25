package com.microservice.oauth.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * @ClassName UserServices
 * @Description
 * @Author 74716
 * @Date 2019/4/25 17:30
 * @Version 1.0
 **/
public class UserServices  implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String lowcaseUsername = username.toLowerCase();
        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("findclient"));
        User user = new User("user", "{bcrypt}" + new BCryptPasswordEncoder().encode("12312312"), new ArrayList<GrantedAuthority>() {{
            add(new SimpleGrantedAuthority("admin"));
        }});
        return user;
    }
}
