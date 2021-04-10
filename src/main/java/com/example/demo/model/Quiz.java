package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	
	@ManyToMany
	@JoinTable(name="quiz_questions", joinColumns = @JoinColumn(name="quiz_id"), inverseJoinColumns = @JoinColumn(name="question_id"))
	private List<Question> questions;
	
//	@Json
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
	private List<Response> responses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

//	@JsonIgnore
	public List<Response> getResponses() {
		return responses;
	}
	
//	@JsonInclude(Include.)
	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Quiz [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", questions=");
		builder.append(questions);
		builder.append(", responses=");
		builder.append(responses);
		builder.append("]");
		return builder.toString();
	}

}
