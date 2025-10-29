package org.example.demo_spring_mvc.service;

import org.example.demo_spring_mvc.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    boolean add(Student student);
    Student findById(int id);

}
