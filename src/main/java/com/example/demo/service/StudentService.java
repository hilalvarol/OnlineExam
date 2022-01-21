package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    public Student saveStudent(Student student){

        return studentRepository.save(student);
    }
    public void deleteById(String id){

        studentRepository.deleteById(id);
    }
    public void updateStudent(Student student){

        studentRepository.save(student);
    }

    public Student findById(String id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public Student findStudentByStudentEmail(String id) {
        return  studentRepository.findByEmail(id).orElseThrow();
    }
}
