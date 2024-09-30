package com.spglobal.practice.microservices.microservvices.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spglobal.practice.microservices.microservvices.Service.QuestionService;
import com.spglobal.practice.microservices.microservvices.model.QuestionModel;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	
	
	@GetMapping("allquestions")
	public ResponseEntity<List<QuestionModel>> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	
	@GetMapping("getlanguage/{CourseName}")
	public  ResponseEntity<List<QuestionModel>> getCourseName(@PathVariable String CourseName){
		return questionService.getCourseName(CourseName);
	}
	
	
	@PostMapping("addquestion")
	public ResponseEntity<String> addQuestion(@RequestBody QuestionModel question) {
		return questionService.addQuestion(question);
	}
	
	
	
	@DeleteMapping("deletequestion/{Id}")
	public ResponseEntity<String> deleteCourseById(@PathVariable int Id){
		return questionService.deleteCourseById(Id);
	}
	
	@PutMapping("updatequestion/{Id}")
	public ResponseEntity<QuestionModel> updateQuestion(@PathVariable int Id, @RequestBody QuestionModel question ){
		question.setiD(Id);
		return questionService.updateQuestion(question);
	}
	
	 
}
