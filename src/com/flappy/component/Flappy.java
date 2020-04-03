package com.flappy.component;

public class Flappy {

	private double width ; 
	private double height ;
	private double posX ;
	private double posY ; 
	
	private final double gravity = 0.2; 
	private double velocity = 0 ;
	
	public Flappy(){
		posX = 10 ;
		posY = 1;
	    width = 50 ; 
	    height = 30 ;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public double getGravity() {
		return gravity;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public void update() {		
		velocity += gravity ;
		this.posY += velocity ;
		velocity *= 0.94 ;
	}
	
	public void jump() {
		velocity -= gravity * 50 ;
	}
}
