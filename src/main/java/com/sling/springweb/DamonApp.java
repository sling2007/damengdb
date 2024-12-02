package com.sling.springweb;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * User: sunling
 * Date: 2024/11/29 13:37
 * Description:
 **/
@MapperScan("com.sling.springweb.mapper")
@SpringBootApplication
public class DamonApp {

    public static void main(String[] args) {
        SpringApplication.run(DamonApp.class, args);
    }

}
