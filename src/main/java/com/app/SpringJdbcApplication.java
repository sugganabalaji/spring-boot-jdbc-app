package com.app;

import com.app.model.Student;
import com.app.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

        Student s1 = context.getBean(Student.class);
        s1.setSId(50);
        s1.setSName("Balaji");
        s1.setMarks(78);

        StudentService service = context.getBean(StudentService.class);
        //service.save(s1);

        Student s2 = context.getBean(Student.class);
        s2.setSId(52);
        s2.setSName("John");
        s2.setMarks(50);

        //service.save(s2);

        List<Student> students = service.findAll();
        students.forEach(System.out::println);

    }

}