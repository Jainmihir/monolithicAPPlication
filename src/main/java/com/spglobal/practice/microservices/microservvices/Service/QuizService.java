package com.spglobal.practice.microservices.microservvices.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spglobal.practice.microservices.microservvices.dao.QuestionDao;
import com.spglobal.practice.microservices.microservvices.dao.QuizDao;
import com.spglobal.practice.microservices.microservvices.model.QuizModel;
import com.spglobal.practice.microservices.microservvices.model.Response;
import com.spglobal.practice.microservices.microservvices.model.QuestionModel;
import com.spglobal.practice.microservices.microservvices.model.QuestionWrapper;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizdao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String CourseName, int numQ, String title) {
		
		List<QuestionModel> questions = questionDao.findRandomQuestionByCourseName(CourseName);
		
		QuizModel quiz = new QuizModel();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizdao.save(quiz);
		return new ResponseEntity<String>("Success" ,HttpStatus.CREATED ) ;
		
		
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int Id) {
		Optional<QuizModel> quiz = quizdao.findById(Id);
		List<QuestionModel> questionFromDb = quiz.get().getQuestions();
		List<QuestionWrapper> questionFromUser = new ArrayList<>();
		for(QuestionModel q : questionFromDb) {
			QuestionWrapper qw = new QuestionWrapper(q.getiD(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionFromUser.add(qw);
		}
		return new ResponseEntity<>(questionFromUser,HttpStatus.OK);
		
	}

	public ResponseEntity<Integer> getAnswer(int Id, List<Response> responses) {
		Optional<QuizModel> quiz = quizdao.findById(Id);
		List<QuestionModel> questions = quiz.get().getQuestions();
		int rightAnswer = 0;
		int i=0;
		for(Response res : responses ) {
			if(res.getResponse().equals(questions.get(i).getRightAnswer())){
				rightAnswer++;
			}
			i++;
		}
		return new ResponseEntity<>(rightAnswer,HttpStatus.OK);
		
	}
	
	
}
