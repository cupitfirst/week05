package com.bh1ofp.week05autoconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(StudentConfiguration.class)
@EnableConfigurationProperties(StudentProperties.class)
public class StudentAutoConfiguration {

    @Autowired
    StudentConfiguration studentConfiguration;

    @Autowired
    StudentProperties studentProperties;

    @Bean
    public StudentInfo createInfo(){
        return new StudentInfo(studentConfiguration.id, studentProperties.getStudentName());
    }
}
