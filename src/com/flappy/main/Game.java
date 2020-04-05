package com.flappy.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.flappy.component.Chrono;
import com.flappy.component.Flappy;
import com.flappy.component.Obstacle;
import com.flappy.component.Score;


@SuppressWarnings("serial")
public class Game extends JPanel{

	private final int windowsWidth = 434 ;
	private final int windowsHeight = 483 ;
	
	private Chrono chrono; 
	private Flappy flappy ;
	private List<Obstacle> obstacles;
	private int frame = 0 ;
	private Score score ;
	private Font fontScore ;
	
	private Image backgroundImage ;
	private String backgroundImagePath = "/images/background.png";
	
	private Image pipeUpImage;
	private String pipeUpImagePath = "/images/pipe-up.png";
	
	private Image pipeDownImage;
	private String pipeDownImagePath = "/images/pipe-down.png";
	

	
	public Game() {
		flappy = new Flappy();
		chrono = new Chrono(this);
		obstacles = new ArrayList<>();
		obstacles.add(new Obstacle());
		score = new Score();
		fontScore = new Font ("Arial" , Font.BOLD, 25);
		
		this.setBackground(Color.black);
		
		try {
			backgroundImage = ImageIO.read(getClass().getResource(backgroundImagePath));
			pipeUpImage = ImageIO.read(getClass().getResource(pipeUpImagePath));
			pipeDownImage = ImageIO.read(getClass().getResource(pipeDownImagePath));
			
		    } catch (IOException e) {
		      e.printStackTrace();
		 }
	}
	public void paintComponent(Graphics g){
		 super.paintComponent(g);
		 Graphics2D g2 = (Graphics2D)g;	
		 g2.drawImage(backgroundImage, 0, 0, windowsWidth, windowsHeight, null);
		 
		 for(Obstacle obs : obstacles) {
			 g2.drawImage(pipeDownImage, (int)obs.getPosX(), 0, (int)obs.getWidth(), (int)obs.getTop(), null);
			 g2.drawImage(pipeUpImage, (int)obs.getPosX(), (int)(windowsHeight - obs.getBottom()), (int)(obs.getWidth()), (int)obs.getBottom(), null);
			 
			 if(!isDeath()) {
				 obs.update();
			 }
		 }
		 
		 g2.drawImage(flappy.fly(50), (int)flappy.getPosX(), (int)flappy.getPosY(),(int)flappy.getWidth(),(int) flappy.getHeight(), null);
		 if(!isDeath()) {
			 flappy.update();
		 }
		 else {
			 chrono.setRun(false);
		 }
		 
		updateObstaclesList(); 
		
		// draw score
		g2.setColor(Color.white);
		g.setFont(fontScore);
		g2.drawString(score.getMessage(), windowsWidth - 110 , 20);
		 
	}
	
	public void keyPressed() {
		flappy.jump();
		this.repaint();
	}

	private void updateObstaclesList() {
		for(int i = 0 ; i< obstacles.size() ; i++) {
			if(obstacles.get(i).getPosX() < - obstacles.get(i).getWidth() ) { 
				obstacles.remove(i);
				score.setScore(score.getScore() + 1 );
			}
		}
		frame ++ ;
		if(frame >= 250) {
			obstacles.add(new Obstacle());
			frame = 0 ;
		}		
	}
	
	private boolean isDeath() {		
		if(flappy.getPosY() >= windowsHeight - (flappy.getWidth() - 15 )) {
			flappy.setPosY(windowsHeight - (flappy.getWidth() - 15 ));
			flappy.setVelocity(0);
			return true ;
		}
		
		for(Obstacle obs : obstacles) {
			if(flappy.getPosX() + flappy.getWidth() >= obs.getPosX() 
					&& flappy.getPosX() <= obs.getPosX() + obs.getWidth()){
				if(flappy.getPosY() < obs.getTop()) {
					return true;
				}
				else if(flappy.getPosY() + flappy.getHeight() > windowsHeight - obs.getBottom()) {
					return true;
				}
			}
		}
		return false ;
	}
}
