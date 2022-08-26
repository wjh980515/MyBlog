package com.wjh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wjh.mapper")
public class MyBlogWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBlogWebApplication.class,args);
    }
}
