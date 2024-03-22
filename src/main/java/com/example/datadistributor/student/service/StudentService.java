package com.example.datadistributor.student.service;

import com.example.datadistributor.student.model.Student;
import com.example.datadistributor.student.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Transactional // do not need to put jpql queries, just use getters and setters we have
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new
                IllegalStateException("Student with id " + studentId + " does not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentEmail = studentRepository.findStudentByEmail(email);
            if(!studentEmail.isPresent()) {
                student.setEmail(email);
            }
            else {
                throw new IllegalStateException("Email already in use");
            }
        }
    }
}
