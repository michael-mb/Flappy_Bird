package com.flappy.main;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame{

	private Game game ; 
	private final int windowsWidth = 450 ;
	private final int windowsHeight = 522 ;
	public Window() {

		initParts();
		initWindow();
		initListener();
		
		this.setVisible(true);
	}
	
	private void initParts() {
		game = new Game();
	}
	
	private void initWindow() {
	
		this.setTitle("Flappy Bird");
		this.setSize(windowsWidth,windowsHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setAlwaysOnTop(false);
		this.setLocationRelativeTo(null);
		this.add(game , BorderLayout.CENTER);	
	}
	
	private void initListener() {
		KeyboardListener keyboardListener = new KeyboardListener();
		this.addKeyListener(keyboardListener);
	}
	
	class KeyboardListener implements KeyListener{

	    public void keyPressed(KeyEvent event) {}

	    public void keyReleased(KeyEvent event) {
	    	if(event.getKeyCode() == 32) {
	    		game.keyPressed();
	    	}
	    	pause();                
	    }

	    public void keyTyped(KeyEvent event) {}   	
	  }
	
	 private void pause(){
		    try {
		      Thread.sleep(10);
		    } catch (InterruptedException e) {
		      e.printStackTrace();
		    }
	 } 	  
}