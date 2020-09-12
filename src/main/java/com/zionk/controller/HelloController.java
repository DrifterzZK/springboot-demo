package com.zionk.controller;

import com.zionk.pojo.User;
import com.zionk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class HelloController {
    @Autowired
    private DataSource dataSource;
    @Value("${zionk.url}")
    private String zionkurl;
    @Value("${zzk.url}")
    private String zzkurl;
    @Autowired
    private UserService userService;
/*
* 根据用户id查询用户*/
    @GetMapping("/user/{id}")
    public User queryById(@PathVariable Long id){
       return userService.queryById(id);
    }


    @GetMapping("hello")
    public String hello(){
        System.out.println("datasource="+dataSource);
        System.out.println("zionkurl="+zionkurl);
        System.out.println("zzkurl="+zzkurl);
        return "hello,,Spring Boot!";
    }
}
