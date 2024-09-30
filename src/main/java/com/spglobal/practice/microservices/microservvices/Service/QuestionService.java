package com.spglobal.practice.microservices.microservvices.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spglobal.practice.microservices.microservvices.dao.QuestionDao;
import com.spglobal.practice.microservices.microservvices.model.QuestionModel;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<QuestionModel>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<QuestionModel>> getCourseName(String CourseName) {
		try {
			return new ResponseEntity<>(questionDao.findByCourseName(CourseName), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<String> addQuestion(QuestionModel question) {
		questionDao.save(question);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<String> deleteCourseById(int id) {
		questionDao.deleteById(id);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}

	public ResponseEntity<QuestionModel> updateQuestion(QuestionModel question) {
		 return new ResponseEntity<>(questionDao.save(question),HttpStatus.OK);
	}

	

}
