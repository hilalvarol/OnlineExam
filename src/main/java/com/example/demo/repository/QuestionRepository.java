package com.example.demo.repository;

import com.example.demo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,String> {
    List<Question> findAllBySubjectId(String id);
    List<Question> findQuestionsBySubjectId_Id(String id);
}
