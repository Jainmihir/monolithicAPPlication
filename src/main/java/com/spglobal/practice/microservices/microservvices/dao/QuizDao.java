package com.spglobal.practice.microservices.microservvices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spglobal.practice.microservices.microservvices.model.QuizModel;

public interface QuizDao extends JpaRepository<QuizModel, Integer> {

}
