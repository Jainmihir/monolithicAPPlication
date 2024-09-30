package com.spglobal.practice.microservices.microservvices.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spglobal.practice.microservices.microservvices.model.QuestionModel;

@Repository
public interface QuestionDao extends JpaRepository<QuestionModel, Integer> {

    List<QuestionModel> findByCourseName(String CourseName);

    @Query(value = "SELECT * FROM question_model WHERE course_name = :CourseName ORDER BY RAND() LIMIT 5 ", nativeQuery = true)
    List<QuestionModel> findRandomQuestionByCourseName(String CourseName);
}
