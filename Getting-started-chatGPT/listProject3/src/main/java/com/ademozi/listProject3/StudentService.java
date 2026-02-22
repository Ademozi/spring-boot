package com.ademozi.listProject3;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return Arrays.asList(
                new Student(1, "Ademozi", 22),
                new Student(2, "Sara", 21),
                new Student(3, "Yacine", 23)
        );
    }
}
