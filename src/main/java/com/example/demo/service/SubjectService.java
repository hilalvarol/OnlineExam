package com.example.demo.service;

import com.example.demo.model.Subject;
import com.example.demo.model.User;
import com.example.demo.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private SubjectRepository subjectRepository;
    public SubjectService(SubjectRepository subjectRepository) {

        this.subjectRepository = subjectRepository;
    }

    public List<Subject> findAll(){
        return subjectRepository.findAll();
    }

    public Subject saveSubject(Subject subject){

        return subjectRepository.save(subject);
    }
    public void deleteById(String id){

        subjectRepository.deleteById(id);
    }
    public void updateSubject(Subject subject){

        subjectRepository.save(subject);
    }

    public Subject findById(String id) {
        return subjectRepository.findById(id).orElseThrow();
    }
}
