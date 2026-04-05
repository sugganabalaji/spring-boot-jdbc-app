package com.app.repository;

import com.app.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    List<Student> students = new ArrayList<>();

    public void save(Student student) {
        System.out.println("saved.");
        students.add(student);
    }

    public List<Student> findAll() {
        return students;
    }
}
