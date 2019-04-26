package com.microservice.oauth.services;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * @ClassName OAuthUser
 * @Description
 * @Author 74716
 * @Date 2019/4/26 11:07
 * @Version 1.0
 **/
@Getter
@Setter
public class OAuthUser  implements UserDetails,Serializable {
    private    Integer id;
    private   String username;
    private   String password;
    private Collection<? extends GrantedAuthority> authorities;
    private  boolean enabled;

    public OAuthUser(){

    }
    public OAuthUser(Integer id ,String username, String password, Collection<? extends GrantedAuthority> authorities,boolean enabled) {
        this.id=id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.enabled=enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
