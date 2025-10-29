package org.example.demo_spring_mvc.repository;

import org.example.demo_spring_mvc.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chánh1",true,List.of("JS","JAVA"),"C06"));
        studentList.add(new Student(2,"chánh1",true,List.of("PHP","JAVA","SQL"),"C07"));
        studentList.add(new Student(3,"chánh1",true,List.of("SQL","JAVA"),"C08"));

    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        return studentList.add(student);
    }

    @Override
    public Student findById(int id) {
        return studentList.stream().filter(s->s.getId()==id)
                .findFirst().orElse(null);
    }
}
