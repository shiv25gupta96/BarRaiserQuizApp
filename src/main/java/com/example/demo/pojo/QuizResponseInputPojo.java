package com.example.demo.pojo;

import java.util.Map;

import com.sun.istack.NotNull;

public class QuizResponseInputPojo {

	@NotNull
	private int quizId;
	
	@NotNull
	private Map<Integer, Integer> responses;

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public Map<Integer, Integer> getResponses() {
		return responses;
	}

	public void setResponses(Map<Integer, Integer> responses) {
		this.responses = responses;
	}
	
}
