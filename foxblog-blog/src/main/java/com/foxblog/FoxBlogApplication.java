package com.foxblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.foxblog.mapper")
public class FoxBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoxBlogApplication.class,args);
    }
}
