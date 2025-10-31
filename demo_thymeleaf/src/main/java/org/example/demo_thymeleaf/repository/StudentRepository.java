package org.example.demo_thymeleaf.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.example.demo_thymeleaf.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Student> findAll() {
       TypedQuery<Student> typedQuery = entityManager.createQuery("from Student",Student.class);
        return typedQuery.getResultList();
    }

    @Transactional
    @Override
    public boolean add(Student student) {
        try{
            entityManager.persist(student);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }
}
