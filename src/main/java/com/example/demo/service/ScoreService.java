package com.example.demo.service;

import com.example.demo.model.Score;
import com.example.demo.repository.ScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    private ScoreRepository scoreRepository;
    public ScoreService(ScoreRepository ScoreRepository) {

        this.scoreRepository = ScoreRepository;
    }

    public List<Score> findAll(){
        return scoreRepository.findAll();
    }
    public Score saveScore(Score Score){

        return scoreRepository.save(Score);
    }
    public void deleteById(String id){

        scoreRepository.deleteById(id);
    }
    public void updateSubject(Score Score){

        scoreRepository.save(Score);
    }
}
