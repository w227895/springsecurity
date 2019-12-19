package com.kebo.springsecurity.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @program: springsecurity
 * @description:
 * @author: kb
 * @create: 2019-12-19 19:11
 **/
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder createPasswordEncode() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/product/add").hasAnyAuthority("add")
                .antMatchers("/product/update").hasAnyAuthority("update")
                .antMatchers("/product/delete").hasAnyAuthority("delete")
                .antMatchers("/product/list").hasAnyAuthority("list")
                .antMatchers("/**")
                .fullyAuthenticated()
                .and()
                .formLogin().loginPage("/login").and()
                .csrf().disable();
    }
}

