package com.example.demo.service;

import com.example.demo.model.Exam;
import com.example.demo.repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
    private ExamRepository examRepository;
    public ExamService(ExamRepository examRepository) {

        this.examRepository = examRepository;
    }

    public List<Exam> findAll(){
        return examRepository.findAll();
    }
    public Exam saveExam(Exam exam){

        return examRepository.save(exam);
    }
    public void deleteById(String id){

        examRepository.deleteById(id);
    }
    public void updateSubject(Exam exam){

        examRepository.save(exam);
    }

    public Exam findById(String id) {
        return examRepository.findById(id).orElseThrow();
    }
}
