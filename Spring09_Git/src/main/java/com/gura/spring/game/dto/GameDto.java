package com.gura.spring.game.dto;

public class GameDto {
	private int score;
	private String id;
	
	
	public GameDto(){}


	public GameDto(int score, String id) {
		super();
		this.score = score;
		this.id = id;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	
	
	
}
