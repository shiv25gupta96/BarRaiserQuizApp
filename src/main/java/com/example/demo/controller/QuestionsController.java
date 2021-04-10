package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Question;
import com.example.demo.services.QuestionService;

@RestController
public class QuestionsController {
	
	@Autowired
	private QuestionService service;
	
	@PostMapping(path="questions", consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean createQuestion(@RequestBody Question ques) {
		service.createQuestion(ques);
		return true;
	}
	
}
