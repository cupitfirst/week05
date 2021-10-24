package com.bh1ofp.week05springbootjdbc;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImpl implements  StudentDao{
    private final JdbcTemplate jdbcTemplate;

    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Student student) {
        jdbcTemplate.update("INSERT INTO student(id, name) VALUES(?, ?)",
                student.getId(), student.getName());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchInsert(List<Student> students) {
        String sql = "INSERT INTO student(id, name) VALUES(?, ?)";

        List<Object[]> params = new ArrayList<>();

        students.forEach(student -> {
            params.add(new Object[] { student.getId(), student.getName() });
        });
        jdbcTemplate.batchUpdate(sql, params);
    }


    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM student WHERE id = ?", id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAll() {
        jdbcTemplate.execute("DELETE FROM student");
    }

    @Override
    public void update(Student student) {
        jdbcTemplate.update("UPDATE student SET id=name WHERE id=?",
                student.getName(), student.getId());
    }

    @Override
    public Integer count() {
        try {
            return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM student", Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Student> list() {
        return jdbcTemplate.query("SELECT * FROM student", new BeanPropertyRowMapper<>(Student.class));
    }


    @Override
    public Student queryById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM student WHERE id = ?",
                    new BeanPropertyRowMapper<>(Student.class), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public void truncate() {
        jdbcTemplate.execute("TRUNCATE TABLE student");
    }

    @Override
    public void recreateTable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS student");

        String sqlStatement =
                "CREATE TABLE student (\n"
                        + "    id      BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '学号',\n"
                        + "    name    VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '姓名'\n"
                        + ");";
        jdbcTemplate.execute(sqlStatement);
    }
}
