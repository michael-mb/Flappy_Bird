package com.flappy.component;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Flappy {

	private double width ; 
	private double height ;
	private double posX ;
	private double posY ; 
	
	private final double gravity = 0.2; 
	private double velocity = 0 ;
	private Image flappyImage ;
	private String flappyImagePath;
	private int compteur ;
	
	public Flappy(){
		posX = 10 ;
		posY = 1;
	    width = 50 ; 
	    height = 50 ;
	    compteur = 0 ;
	    flappyImagePath = "/images/flappy-on.png";
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
	
	public Image fly (int frequence) {
		ImageIcon ico ;		
		compteur += 1 ;
		
		if(compteur / frequence == 0) {
			flappyImagePath = "/images/flappy-off.png";
		}
		else {
			flappyImagePath = "/images/flappy-on.png";
		}
		if(compteur >= 2*frequence) {
			compteur = 0 ;
		}
		
		ico = new ImageIcon(getClass().getResource(flappyImagePath));
		flappyImage = ico.getImage();
		
		return flappyImage ;
	}
}
