package com.example.user_management_api.service;

import com.example.user_management_api.dto.StudentDTO;
import com.example.user_management_api.entity.Student;
import com.example.user_management_api.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    public Student createStudent(StudentDTO dto){
        Student student = new Student(dto.getName(), dto.getEmail());
        return repository.save(student);
    }

    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

}
