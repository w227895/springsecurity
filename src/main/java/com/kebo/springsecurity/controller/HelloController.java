package com.kebo.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: springsecurity
 * @description:
 * @author: kb
 * @create: 2019-12-19 18:57
 **/
@Controller
public class HelloController {
    @GetMapping("index")
    public String getIndex(){
        return "index";
    }
    @GetMapping("403")
    public String getForbbin(){
        return "403";
    }
    @GetMapping("login")
    public String getLogin(){
        return "login";
    }
    @GetMapping("/product/add")
    public String add(){
        return "add";
    }
    @GetMapping("/product/update")
    public String update(){
        return "update";
    }
    @GetMapping("/product/delete")
    public String delete(){
        return "delete";
    }
    @GetMapping("/product/list")
    public String list(){
        return "list";
    }
}
