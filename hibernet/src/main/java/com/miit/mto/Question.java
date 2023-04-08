package com.miit.mto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@Column(name = "question_id")
	private int questionId;
	private String question;

	@OneToMany(mappedBy = "question")
	private List<Answer> answers;

	/*
	 * @OneToOne
	 * @JoinColumn(name="answer_id") 
	 * private Answer answer;
	 */

	public Question() {
		super();
	}

	public Question(int questionId, String question, List<Answer> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
