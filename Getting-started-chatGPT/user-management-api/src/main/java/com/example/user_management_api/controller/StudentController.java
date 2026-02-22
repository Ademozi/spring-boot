package com.example.user_management_api.controller;

import com.example.user_management_api.dto.StudentDTO;
import com.example.user_management_api.entity.Student;
import com.example.user_management_api.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service){
        this.service = service;
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentDTO dto) {
        return service.createStudent(dto);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }
}
