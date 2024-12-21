package com.miniproject.groupa.question;

public class Questions {
	
	private int questionId;
	private String questionText;
	private String option_1;
	private String option_2;
	private String option_3;
	private String option_4;
	private String correctChoice;
	
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getOption_1() {
		return option_1;
	}
	public void setOption_1(String option_1) {
		this.option_1 = option_1;
	}
	public String getOption_2() {
		return option_2;
	}
	public void setOption_2(String option_2) {
		this.option_2 = option_2;
	}
	public String getOption_3() {
		return option_3;
	}
	public void setOption_3(String option_3) {
		this.option_3 = option_3;
	}
	public String getOption_4() {
		return option_4;
	}
	public void setOption_4(String option_4) {
		this.option_4 = option_4;
	}
	public String getCorrectChoice() {
		return correctChoice;
	}
	public void setCorrectChoice(String correctChoice) {
		this.correctChoice = correctChoice;
	}
	
	
	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", questionText=" + questionText + ", option_1=" + option_1
				+ ", option_2=" + option_2 + ", option_3=" + option_3 + ", option_4=" + option_4 + ", correctChoice="
				+ correctChoice + "]";
	}
	
	
	
	
	}
