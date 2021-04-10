package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.model.Option;
import com.example.demo.model.Question;
import com.example.demo.services.QuestionService;
import com.example.demo.services.QuizService;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	private QuestionService service;
	
	private Question ques;
	
	@BeforeEach
	public void beforeTest() {
		ques = new Question();
		ques.setValue("asd");
		List<Option> opts = new ArrayList<>();
		Option op1 = new Option();
		op1.setValue("adfvds");
		opts.add(op1);
		ques.setOptions(opts);
	}
	
	@Test
	public void testCreateQuestion() {
		boolean res = service.createQuestion(ques);
	}

}
