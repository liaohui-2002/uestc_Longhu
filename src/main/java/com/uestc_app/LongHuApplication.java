package com.uestc_app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.uestc_app.mapper")
@SpringBootApplication
public class  LongHuApplication {

    public static void main(String[] args) {
        SpringApplication.run(LongHuApplication.class, args);
    }

}
