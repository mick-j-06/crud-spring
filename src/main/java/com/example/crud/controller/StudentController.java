package com.example.crud.controller;

import com.example.crud.model.Student;
import com.example.crud.repository.StudentOperation;
import com.example.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(value = "/")
    public Student createStudent(@RequestBody Student newStudent) {
        studentRepository.save(newStudent);
        return newStudent;
    }

    @GetMapping(value = "/")
    public List<Student> getAllStudents(
            @RequestParam(name = "page", required = false) String page,
            @RequestParam(name = "size", required = false) String size
    ) {
        if (page != null && size != null) {
            return studentRepository.findAll(PageRequest.of(Integer.parseInt(page), Integer.parseInt(size)))
                    .toList();
        } else {
            return studentRepository.findAll();
        }
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentRepository.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable int id, @RequestBody Student student) {
        Student oldStudent = studentRepository.getStudentById(id);
        Student updatedStudent = StudentOperation.update(oldStudent, student);
        studentRepository.save(updatedStudent);
        return updatedStudent;
    }

    @DeleteMapping(value = "/{id}")
    public Map<String, String> delete(@PathVariable int id) {
        studentRepository.deleteById(id);
        Map<String, String> message = new HashMap<>();
        message.put("id", String.valueOf(id));
        message.put("code", "200");
        message.put("message", "deleted");
        return message;
    }
}
