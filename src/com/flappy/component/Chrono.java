package com.flappy.component;

import com.flappy.main.Game;

public class Chrono implements Runnable {

	private Game scene ;
	private boolean run = true  ;
	private final int PAUSE = 5 ;
	
	public Chrono(Game scene) {
		this.scene = scene ;
		
		Thread thread = new Thread(this);
		thread.start();
	}
	@Override
	public void run() {
		
		while(run) {
			scene.repaint();
			
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean isRun() {
		return run ;
	}
	public void setRun(boolean run) {
		this.run = run ;
	}

}
