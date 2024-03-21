package com.example.datadistributor;

import com.example.datadistributor.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class DataDistributorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataDistributorApplication.class, args);
    }

    @GetMapping
    public List<Student> hello() {
        return List.of(
                new Student(
                        1L,
                        "Shubhayu Shrestha",
                        "shubshresdev@gmail.com",
                        23,
                        LocalDate.of(2000, Month.DECEMBER, 29)

                )
        );
    }

}
