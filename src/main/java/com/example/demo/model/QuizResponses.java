package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class QuizResponses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="ResponseId")
	private Response response;
	
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey)
	private Option answer;
	
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey)
	private Question question;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public Option getAnswer() {
		return answer;
	}

	public void setAnswer(Option answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
