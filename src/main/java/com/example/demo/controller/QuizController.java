package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.pojo.PaginationHeader;
import com.example.demo.model.Option;
import com.example.demo.model.Question;
import com.example.demo.model.Quiz;
import com.example.demo.model.QuizResponses;
import com.example.demo.model.Response;
import com.example.demo.pojo.QuizResponseInputPojo;
import com.example.demo.services.QuizService;

@RestController
public class QuizController {
	
	@Autowired
	private QuizService service;
	
	@GetMapping(path="quizes", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Quiz> getQuizes(@RequestParam("pageNumber") int page, @RequestParam("limit") int limit) {
		PaginationHeader header = new PaginationHeader(page, limit);
		return service.fetchAllQuizes(header);
	}
	
	@GetMapping(path="quizes/{quizId}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Question> getQuiz(@PathParam("quizId") int id) {
		return service.fetchQuestionsByQuizId(id);
	}
	
	@PostMapping(path="quizes", produces=MediaType.APPLICATION_JSON_VALUE)
	public Quiz saveQuiz(@RequestBody Quiz quiz) {
		return service.createQuiz(quiz);
	}
	
	@PostMapping(path="quizes/{quiz}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Response> saveResponse(@Valid @RequestBody QuizResponseInputPojo input) {
		System.out.println(input);
		Quiz quiz = new Quiz();
		quiz.setId(input.getQuizId());
		quiz.setResponses(new ArrayList<>());
		Response response = new Response();
		response.setQuiz(quiz);
		response.setAnswers(new ArrayList<>());
		for(Entry<Integer, Integer> answer: input.getResponses().entrySet()) {
			QuizResponses qr = new QuizResponses();
			qr.setQuestion(new Question());
			qr.getQuestion().setId(answer.getKey());
			qr.setAnswer(new Option());
			qr.getAnswer().setId(answer.getValue());
			response.getAnswers().add(qr);
			qr.setResponse(response);
		}
		quiz.getResponses().add(response);
		
		return service.createResponse(quiz);
	}
	
}
