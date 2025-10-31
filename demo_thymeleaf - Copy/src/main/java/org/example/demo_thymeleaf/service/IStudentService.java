package org.example.demo_thymeleaf.service;

import org.example.demo_thymeleaf.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    boolean add(Student student);
    Student findById(int id);

}
