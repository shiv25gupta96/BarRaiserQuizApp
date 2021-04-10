package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Response {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	@JsonIgnore
	@ManyToOne
	private Quiz quiz;
	
	@OneToMany(mappedBy = "response", cascade = CascadeType.ALL)
	private List<QuizResponses> answers;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public List<QuizResponses> getAnswers() {
		return answers;
	}

	public void setAnswers(List<QuizResponses> answers) {
		this.answers = answers;
	}
	
	
		
}

