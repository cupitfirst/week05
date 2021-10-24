package com.bh1ofp.week05springbootjdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface StudentDao {
    void insert(Student student);

    void batchInsert(List<Student> studentList);


    void deleteById(int id);

    void deleteAll();

    void update(Student student);

    Integer count();

    List<Student> list();

    Student queryById(int id);


    JdbcTemplate getJdbcTemplate();

    void truncate();

    void recreateTable();
}
