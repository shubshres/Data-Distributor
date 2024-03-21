package com.example.datadistributor.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/* Will contain resources for API */
@RestController
@RequestMapping(path = "api/vi/student")
public class StudentController {
    @GetMapping
    public List<Student> getStudents() {
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
