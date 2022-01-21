package com.example.demo.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ScoreId implements Serializable {
    private static final long serialVersionUID = -6298559415083925346L;
    @Column(name = "score_id", nullable = false, length = 10)
    private String scoreId;
    @Column(name = "student_id", nullable = false, length = 10)
    private String studentId;
    @Column(name = "subject_id", nullable = false, length = 10)
    private String subjectId;
    @Column(name = "marks", nullable = false)
    private Integer marks;
    @Column(name = "exam_id", nullable = false, length = 10)
    private String examId;

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreId, studentId, examId, marks, subjectId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ScoreId entity = (ScoreId) o;
        return Objects.equals(this.scoreId, entity.scoreId) &&
                Objects.equals(this.studentId, entity.studentId) &&
                Objects.equals(this.examId, entity.examId) &&
                Objects.equals(this.marks, entity.marks) &&
                Objects.equals(this.subjectId, entity.subjectId);
    }
}