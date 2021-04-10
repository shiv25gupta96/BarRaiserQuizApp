package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.pojo.PaginationHeader;
import com.example.demo.dao.QuizDao;
import com.example.demo.dao.ResponseDao;
import com.example.demo.model.Question;
import com.example.demo.model.Quiz;
import com.example.demo.model.Response;

@Service
public class QuizService {

	@Autowired
	private QuizDao dao;
	@Autowired
	private ResponseDao resDao;
	@Autowired
	private PaginationService pagination;
	
	public List<Quiz> fetchAllQuizes(PaginationHeader header) {
		return dao.findAll(pagination.getPaginationVal(header)).toList();
	}
	
	public List<Question> fetchQuestionsByQuizId(int quizId) {
		Optional<Quiz> quiz = dao.findById(quizId);
		return quiz.map(Quiz::getQuestions).get();
	}
	
	@Transactional
	public Iterable<Response> createResponse(Quiz quiz) {
		System.out.println(quiz);
		return resDao.saveAll(quiz.getResponses());
		
	}

	@Transactional
	public Quiz createQuiz(Quiz quiz) {
		return dao.save(quiz);
	}
	
}
