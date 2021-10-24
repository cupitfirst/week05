package com.bh1ofp.week05autoconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@Data
@ConfigurationProperties(prefix = "student")
public class StudentProperties {

    private String studentName = "Kevin Lee";



}
