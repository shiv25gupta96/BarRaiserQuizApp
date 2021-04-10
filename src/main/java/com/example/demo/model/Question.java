package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	private String value;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "questions")
	private List<Quiz> quizes;
	
	@OneToMany
	private List<Option> options;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

//	@JsonIgnore
	public List<Quiz> getQuizes() {
		return quizes;
	}

	public void setQuizes(List<Quiz> quizes) {
		this.quizes = quizes;
	}
//
//	public List<Response> getResponses() {
//		return responses;
//	}
//
//	public void setResponses(List<Response> responses) {
//		this.responses = responses;
//	}
	
}
