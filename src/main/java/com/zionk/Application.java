package com.zionk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/*spring boot工程都有个启动引导类，这是工程的入口，并在引导了类上添加@springbootapplication*/
@SpringBootApplication
//扫瞄mybatis所有的业务mapper接口
//@MapperScan("com.zionk.mapper")//mybatis官方
@MapperScan("com.zionk.mapper")//通用mapper扫描(tk
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
