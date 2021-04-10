package com.example.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Quiz;

@Repository
public interface QuizDao extends PagingAndSortingRepository<Quiz, Integer> {

}
