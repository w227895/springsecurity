package com.kebo.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program: springsecurity
 * @description:
 * @author: kb
 * @create: 2019-12-19 19:25
 **/
@Configuration
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(s);
        String myPass=passwordEncoder.encode("123456");
        System.out.println(myPass);
        Collection<GrantedAuthority> authorities=authorities();
        //return new User(s,myPass, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        return new User(s,myPass, authorities);
    }

    private Collection<GrantedAuthority> authorities(){
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("add"));
        authorities.add(new SimpleGrantedAuthority("update" ));
        return authorities;
    }
}
