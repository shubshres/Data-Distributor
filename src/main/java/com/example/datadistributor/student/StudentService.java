package com.example.datadistributor.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// Service Layer responsible for business logic
//@Component // need this to be a class that has to be instantiated / bean
@Service // Same as component, but make it as service for readability
public class StudentService {
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
