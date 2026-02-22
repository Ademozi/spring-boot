package com.ademozi.returnJSON2Project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1, "Ademozi", 22);
    }
}
