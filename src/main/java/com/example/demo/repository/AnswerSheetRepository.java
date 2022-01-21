package com.example.demo.repository;

import com.example.demo.model.AnswerSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerSheetRepository extends JpaRepository<AnswerSheet,String> {

}
