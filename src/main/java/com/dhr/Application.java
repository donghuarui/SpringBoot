package com.dhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("com.dhr.mapper")//告诉mapper所在的包名
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
