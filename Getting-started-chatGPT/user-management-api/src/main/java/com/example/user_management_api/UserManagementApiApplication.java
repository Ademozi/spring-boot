package com.example.user_management_api;

import com.example.user_management_api.entity.Student;
import com.example.user_management_api.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository) {
		return args -> {
			repository.save(new Student("Ali", "ali@email.com"));
			repository.save(new Student("Sara", "sara@email.com"));

			System.out.println("Students inserted!");
		};
	}
}
