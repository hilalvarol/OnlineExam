package com.example.demo.service;

import com.example.demo.model.AnswerSheet;
import com.example.demo.repository.AnswerSheetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerSheetService {
    private AnswerSheetRepository answerSheetRepository;

    public AnswerSheetService(AnswerSheetRepository answerSheetRepository) {

        this.answerSheetRepository = answerSheetRepository;
    }

    public List<AnswerSheet> findAll() {
        return answerSheetRepository.findAll();
    }

    public AnswerSheet saveAnswerSheet(AnswerSheet answerSheet) {

        return answerSheetRepository.save(answerSheet);
    }

    public void deleteById(String id) {

        answerSheetRepository.deleteById(id);
    }

    public void updateAnswerSheet(AnswerSheet answerSheet) {

        answerSheetRepository.save(answerSheet);
    }


}
