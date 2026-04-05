package com.app.repository;

import com.app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student student) {
        String sql = "insert into student(rollNo, name, marks) values (?, ?, ?)";
        int rows = jdbcTemplate.update(sql, student.getRollNo(), student.getName(), student.getMarks());
        System.out.println(rows + " row(s) inserted successfully.");
    }

    public List<Student> findAll() {
        String sql = "select * from student";
        //return jdbcTemplate.query(sql, rowMapper);
        //way-4
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setRollNo(rs.getInt("rollNo"));
            student.setName(rs.getString("name"));
            student.setMarks(rs.getInt("marks"));
            return student;
        });
    }

    // way-1
    //RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);

    // way-2
    /* RowMapper<Student> rowMapper = new RowMapper<>() {
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setRollNo(rs.getInt("rollNo"));
            student.setName(rs.getString("name"));
            student.setMarks(rs.getInt("marks"));
            return student;
        }
    }; */

    // way-3
    RowMapper<Student> rowMapper = (rs, rowNum) -> {
        Student student = new Student();
        student.setRollNo(rs.getInt("rollNo"));
        student.setName(rs.getString("name"));
        student.setMarks(rs.getInt("marks"));
        return student;
    };
}
