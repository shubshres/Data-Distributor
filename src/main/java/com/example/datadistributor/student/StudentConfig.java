package com.example.datadistributor.student;

import com.example.datadistributor.student.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean // object that is instantiated, assembled, and managed by Spring Container
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student shubhayu = new Student(
                    1L,
                    "Shubhayu Shrestha",
                    "shubshresdev@gmail.com",
                    LocalDate.of(2000, Month.DECEMBER, 29)
            );

            Student rohan = new Student(
                    "Rohan Shrestha",
                    "rohanshrestha@gmail.com",
                    LocalDate.of(2005, Month.JANUARY, 21)
            );

            repository.saveAll(List.of(shubhayu, rohan));
        };
    }
}
