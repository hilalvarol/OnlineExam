package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exam")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    @Id
    @Column(name = "id", nullable = false, length = 10)
    private String id;

    @Column(name = "exam_date", nullable = false, length = 10)
    private LocalDateTime examDate;

    @Column(name = "exam_term", nullable = false, length = 10)
    private String examTerm;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subjectId;

}