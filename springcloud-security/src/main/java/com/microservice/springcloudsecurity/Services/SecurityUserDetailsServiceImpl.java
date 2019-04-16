package com.microservice.springcloudsecurity.Services;

import com.microservice.springcloudsecurity.Model.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

/**
 * @Author :bert.hu
 * @Description:
 * @Date:Create in 9:56 2018/11/15
 * @Modified By:
 */
public class SecurityUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String lowcaseUsername = username.toLowerCase();
        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("findclient"));
        UserInfo user = new UserInfo(1, "system", "{bcrypt}$2a$10$prv7Xhe5PuXiK4SJLjbstuZauW7/jwl9UnUvuEBGEoiEjnW41vA4u", grantedAuthorities, true);
        return user;
    }
}
