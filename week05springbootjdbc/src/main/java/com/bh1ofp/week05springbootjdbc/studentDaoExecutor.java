package com.bh1ofp.week05springbootjdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Component
public class studentDaoExecutor {
    private final StudentDao studentDao;

    public studentDaoExecutor(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @PostConstruct
    public void method() {
        if (studentDao != null) {
            log.info("Connect to datasource success.");
        } else {
            log.error("Connect to datasource failed!");
            return;
        }


    }
}
