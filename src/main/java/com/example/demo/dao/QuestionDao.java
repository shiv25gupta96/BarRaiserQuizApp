package com.example.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Question;

@Repository
public interface QuestionDao extends PagingAndSortingRepository<Question, Integer>{
	
	
//	public List<Question> findAllByQuiz
	
}
