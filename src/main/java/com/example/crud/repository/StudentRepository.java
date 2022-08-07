package com.example.crud.repository;

import com.example.crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student getStudentById(int id);

    
}
