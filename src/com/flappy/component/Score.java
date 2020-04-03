package com.flappy.component;

public class Score {

	private int score ;
	public Score() {
		score = 0 ;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getMessage() {
		return "score : " + score ; 
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
