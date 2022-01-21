package com.example.demo.service;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    public List<Question> findAll(){
        return questionRepository.findAll();
    }
    public Question saveQuestion(Question question){

        return questionRepository.save(question);
    }
    public void deleteById(String id){

        questionRepository.deleteById(id);
    }
    public List<Question> findBySubjectId(String id){
        return questionRepository.findAllBySubjectId(id);
    }
    public void updateQuestion(Question question){

        questionRepository.save(question);
    }

    public List<Question> findAllQuestionBySubjectID(String id) {
        return questionRepository.findQuestionsBySubjectId_Id(id);
    }
}
