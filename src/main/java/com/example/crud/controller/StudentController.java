package com.example.crud.controller;

import com.example.crud.model.Student;
import com.example.crud.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private StudentRepository studentRepository;

    @PostMapping(value = "/student")
    public Student createStudent(@RequestBody Student newStudent) {
        studentRepository.save(newStudent);
        return newStudent;
    }
}
