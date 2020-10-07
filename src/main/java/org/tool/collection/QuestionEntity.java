package org.tool.collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="questions")
public class QuestionEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int slno;
	private String collectionCode;
	
	private String question_code;
	
	private String question ;
	
	private String answer;
	
	private String correctAnswer;


	public QuestionEntity() {
		
	}


	public QuestionEntity(String collectionCode, String question_code, String question, String answer,
			String correctAnswer) {
		super();
		this.collectionCode = collectionCode;
		this.question_code = question_code;
		this.question = question;
		this.answer = answer;
		this.correctAnswer = correctAnswer;
	}


	public int getSlno() {
		return slno;
	}


	public void setSlno(int slno) {
		this.slno = slno;
	}


	public String getCollectionCode() {
		return collectionCode;
	}


	public void setCollectionCode(String collectionCode) {
		this.collectionCode = collectionCode;
	}


	public String getQuestion_code() {
		return question_code;
	}


	public void setQuestion_code(String question_code) {
		this.question_code = question_code;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public String getCorrectAnswer() {
		return correctAnswer;
	}


	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}


	@Override
	public String toString() {
		return "QuestionEntity [slno=" + slno + ", collectionCode=" + collectionCode + ", question_code="
				+ question_code + ", question=" + question + ", answer=" + answer + ", correctAnswer=" + correctAnswer
				+ "]";
	}
	
	

	
}
