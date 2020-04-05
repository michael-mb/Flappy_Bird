package com.flappy.component;

public class Obstacle {
	
	private final int windowsWidth = 434 ;
	private final int windowsHeight = 483 ;
	
	private double width = 40 ;
	private double top ;
	private double bottom ;
	private double speedX = 0.8; 
	private double posX ; 
	
	public Obstacle(){
		top = (Math.random() * ((windowsHeight/2 - 55  - 20) + 1)) + 20;
		bottom = (Math.random() * ((windowsHeight/2 - 55 - 20) + 1)) + 20;
		posX = windowsWidth ;
	}
	
	public double getPosX() {
		return posX;
	}
	
	public void setPosX(double posX) {
		this.posX = posX;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getTop() {
		return top;
	}
	
	public void setTop(double top) {
		this.top = top;
	}
	
	public double getBottom() {
		return bottom;
	}
	
	public void setBottom(double bottom) {
		this.bottom = bottom;
	}
	
	public double getSpeedX() {
		return speedX;
	}
	
	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}
	
	public void update() {
		posX -= speedX ;
	}
	
}
