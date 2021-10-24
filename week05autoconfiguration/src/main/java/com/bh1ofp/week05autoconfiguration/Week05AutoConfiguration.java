package com.bh1ofp.week05autoconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Week05AutoConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(Week05AutoConfiguration.class, args);
    }

    @Autowired
    StudentInfo studentInfo;

    @Bean
    public void printInfo() {
        System.out.println("学号：" + studentInfo.getId() +"     姓名：" +  studentInfo.getName());

    }
}
