package com.kebo.springsecurity.security;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @program: springsecurity
 * @description:
 * @author: kb
 * @create: 2019-12-19 19:54
 **/
@Configuration
public class MyErrorPage implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage errorPage=new ErrorPage(HttpStatus.FORBIDDEN,"/403");
        registry.addErrorPages(errorPage);
    }
}
