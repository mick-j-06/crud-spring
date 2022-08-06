package com.example.crud.controller;

import com.example.crud.model.Student;
import com.example.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(value = "/student")
    public Student createStudent(@RequestBody Student newStudent) {
        studentRepository.save(newStudent);
        return newStudent;
    }

    @GetMapping(value = "/student")
    public List<Student> getAllStudents(
            @RequestParam(name = "page",required = false) String page,
            @RequestParam(name = "size",required = false) String size
    ) {
        if(page != null && size != null) {
            return studentRepository.findAll(PageRequest.of(Integer.parseInt(page),Integer.parseInt(size)))
                    .toList();
        } else {
            return studentRepository.findAll();
        }
    }

    @DeleteMapping(value = "/student/{id}")
    public Map<String,String> delete(@PathVariable int id) {
        studentRepository.deleteById(id);
        Map<String,String> m = new HashMap<>();
        m.put("id",String.valueOf(id));
        m.put("code","200");
        m.put("message","deleted");
        return m;
    }
}
