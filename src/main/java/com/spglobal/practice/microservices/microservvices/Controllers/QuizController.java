package com.spglobal.practice.microservices.microservvices.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spglobal.practice.microservices.microservvices.Service.QuizService;
import com.spglobal.practice.microservices.microservvices.model.QuestionWrapper;
import com.spglobal.practice.microservices.microservvices.model.Response;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@GetMapping("getquiz/{Id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable int Id){
		System.out.println(Id);
		return quizService.getQuizQuestion(Id);
	}

	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String CourseName,@RequestParam int numQ, @RequestParam String title){
		return quizService.createQuiz(CourseName,numQ,title);
	}
	
	@PostMapping("submit/{Id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int Id , @RequestBody List<Response> Responses){
		return quizService.getAnswer(Id,Responses);
	}
	
}
