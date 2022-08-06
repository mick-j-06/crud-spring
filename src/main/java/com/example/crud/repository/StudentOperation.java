package com.example.crud.repository;

import com.example.crud.model.Student;

public class StudentOperation {
    public static Student update(Student oldStudent,Student student){
        if(student.getFirstName() != null){
            oldStudent.setFirstName(student.getFirstName());
        }
        if(student.getLastName() != null){
            oldStudent.setLastName(student.getLastName());
        }
        return oldStudent;
    }
}
