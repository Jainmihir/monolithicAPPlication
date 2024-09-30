package com.spglobal.practice.microservices.microservvices.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;


@Entity
public class QuizModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	@ManyToMany
	private List<QuestionModel> questions;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<QuestionModel> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionModel> questions) {
		this.questions = questions;
	}
	
	
}
