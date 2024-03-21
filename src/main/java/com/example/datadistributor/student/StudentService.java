package com.example.datadistributor.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// Service Layer responsible for business logic
//@Component // need this to be a class that has to be instantiated / bean
@Service // Same as component, but make it as service for readability
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
