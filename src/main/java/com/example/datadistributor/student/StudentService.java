package com.example.datadistributor.student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// Service Layer responsible for business logic
//@Component // need this to be a class that has to be instantiated / bean
@Service // Same as component, but make it as service for readability
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        boolean studentPresent = studentRepository.findStudentByEmail(student.getEmail()).isPresent();
        if(studentPresent){
            throw new IllegalStateException("Email already in use");
        }
        else {
            studentRepository.save(student);
        }
    }

    public void deleteStudent(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if (!exist){
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
        else {
            studentRepository.deleteById(studentId);
        }
    }
}
