package org.example.demo_spring_data_jpa.service;

import org.example.demo_spring_data_jpa.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable);
    Page<Student> findAllByNameContaining(String searchName, Pageable pageable);
    boolean add(Student student);
    Student findById(int id);

}
