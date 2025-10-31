package org.example.demo_thymeleaf.repository;

import jakarta.persistence.TypedQuery;
import org.example.demo_thymeleaf.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();

    @Override
    public List<Student> findAll() {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Student> typedQuery = session.createQuery("from Student");
//        TypedQuery<Student> typedQuery = session.createNativeQuery("select * from student",Student.class);
        List<Student> students = typedQuery.getResultList();
        session.close();
        return students;
    }

    @Override
    public boolean add(Student student) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        try{
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(student);
            // update
//            Student student1 = findById(student.getId());
//            student1.setName(student.getName());
//            session.merge(student1)
            // xoá
//            session.remove(student1);

            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Student findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        return session.find(Student.class,id);
    }
}
