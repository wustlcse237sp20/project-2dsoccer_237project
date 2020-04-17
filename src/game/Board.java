package game;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import sedgewick.StdDraw;

public class Board {

	/**
	 * Starts by setting up the splash screen, which then leads to our main screen after the user presses the mouse
	 */
	public void setupScreen() {
		StdDraw.setCanvasSize(1364,682);
		StdDraw.setPenColor(Color.black);
		StdDraw.filledRectangle(0.5, 0.5, 682, 384);
		StdDraw.setPenColor(Color.white);
		StdDraw.text(0.5, 0.8, "2-D Soccer");
		StdDraw.text(0.5, 0.6, "Move Left player with keys: a, w, d");
		StdDraw.text(0.5, 0.5, "Move Right player with keys: left, up, right");
		StdDraw.text(0.5, 0.4, "Right Click to Continue");
		StdDraw.show(0);
		StdDraw.picture(0.5,0.5,"background.png");
		while(true) {
			if(StdDraw.mousePressed()) {
				StdDraw.show(0);
				break;
			}
		}
		// sets up new scale so when players are drawn.
		StdDraw.setXscale(-2,2);
		StdDraw.setYscale(-1,1);
		
	}
	/**
	 * gets the time based on the current timer time
	 * @params the current timer time
	 * @return the beginning part of the time
	*/
	
	public String getTime(int timer) {
		if(timer < 10 && timer >= 0) {
			return "00:0";
		}else if(timer < 60 && timer >= 10) {
			return "00:";
		}else if(timer >= 60){
			return "01:00";
		}
		return "Invalid time";
		
	}
	/**
	 * Constructs the full time that should be displayed
	 * @params the current timer time
	 * @return the time that should be displayed
	*/
	
	public String Timer(int timer) {
		String time = getTime(timer);
		String fullTime = time + timer;
		if(timer < 0) {
			return "Can't display time";
		}else if(timer >= 60) {
			return time;
		}
		return fullTime;
	}
	/**
	 * draws the time that should be displayed on the screen with the field.
	 * @params the current timer time
	*/
	
	public void drawTime(int timer) {
		String time = Timer(timer);
		StdDraw.text(0.5, 0.8, time);
	}
	
	/**
	 * Based on the time decides whether game is over or not.
	 * @params the current timer time
	 * @return boolean indicating if game is over or not
	*/
	public boolean gameOver(int timer) {
		if(timer >= 60) {
			return true;
		}
		return false;
	}
	//public void drawGameOverScreen();
	
	/**
	 * draws two sets of goals (one on each side)
	*/
	public void drawGoals() {
		StdDraw.filledRectangle(0,-0.95,0.01,.2);
		StdDraw.filledRectangle(-2.0, 0.4, 0.2, 0.8); 
		StdDraw.filledRectangle(2.0,0.4,0.2,0.8);
	}
	
	public void drawGround() {
		StdDraw.setPenColor(Color.green);
		StdDraw.filledRectangle(0, -1.1, 2.2, 0.05);
		StdDraw.setPenColor(Color.black);
	}
	
	/**
	 * draws each individual player on the screen 
	 * @param Player 1 to be drawn
     * @param Player 2 to be drawn
	*/
	public void drawPlayers(Player player1, Player player2) {
		player1.draw();
		player2.draw();
	}
	/**
	 * moves players based on the key that is pressed. Movement implementation is in Player.java
	 * @param Player 1 to be moved
     * @param Player 2 to be moved
	*/
	public void movePlayers(Player player1, Player player2) {
		player1.move();
		player2.move();
	}
	
	public void drawBall(Ball ball) {
		ball.draw();
	}
	
	public void moveBall(Ball ball) {
		ball.move();
	}
	/**
	 * implements a jumping movement based on the location of each player.
	 * @param Player 1 to be moved
     * @param Player 2 to be moved
	*/
	public void handleJumping(Player player1, Player player2) {
		//not taking gravity into effect when on the ground
		if(player1.getPosY()>-0.95) {
			player1.gravity();
		}
		//stopping the player's vertical movement when on the ground
		else if(player1.getPosY()<-0.95) {
			player1.velocityY = 0;
		}
		//same thing with player 2
		if(player2.getPosY()>-0.95) {
			player2.gravity();
		}
		else if(player2.getPosY()<-0.95) {
			player2.velocityY = 0;
		}
	}

}