package com.example.demo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.OptionDao;
import com.example.demo.dao.QuestionDao;
import com.example.demo.model.Question;

@Component
public class QuestionService {
	
	@Autowired
	private QuestionDao dao;
	
	@Autowired
	private OptionDao optionDao;
	
	@Transactional
	public boolean createQuestion(Question ques) {
		
		optionDao.saveAll(ques.getOptions());
		dao.save(ques);
		
		return true;
		
	}
	
}
