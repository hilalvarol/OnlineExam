package com.example.demo.service;

import com.example.demo.model.Answer;
import com.example.demo.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    private AnswerRepository answerRepository;
    public AnswerService(AnswerRepository answerRepository) {

        this.answerRepository = answerRepository;
    }

    public List<Answer> findAll(){
        return answerRepository.findAll();
    }
    public Answer saveAnswer(Answer answer){

        return answerRepository.save(answer);
    }
    public void deleteById(String id){
        answerRepository.deleteById(id);
    }
    public List<Answer> findByQuestionId(String id){
        return answerRepository.findAllByQuestionId(id);
    }
    public void updateAnswer(Answer answer){

        answerRepository.save(answer);
    }

    public Answer findAnswerById(String id) {
        return answerRepository.findById(id).orElseThrow();
    }
}
