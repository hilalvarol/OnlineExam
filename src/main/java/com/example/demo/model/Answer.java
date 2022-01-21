package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "answers")
public class Answer {
    @Id
    @Column(name = "id", nullable = false, length = 10)
    private String id;

    @Column(name = "answer", nullable = false, length = 250)
    private String answer;

    @Column(name = "status", nullable = false, length = 10)
    private String status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    private Question questionId;

}