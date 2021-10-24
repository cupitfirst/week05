package com.bh1ofp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course implements Serializable, BeanNameAware, ApplicationContextAware {


    private String courseName;
    private String teacherName;

    private String beanName;
    private ApplicationContext applicationContext;


}
