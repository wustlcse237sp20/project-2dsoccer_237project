package game;

import java.awt.Color;
import java.awt.Font;
import java.util.concurrent.TimeUnit;

import sedgewick.StdDraw;

public class Board {
	
	// The variable to hold who wins the game at the end of time.
	private String winner;

	/**
	 * Starts by setting up the splash screen, which then leads to our main screen after the user presses the mouse
	 */
	public void setupScreen() {
		StdDraw.setCanvasSize(1364,682);
		StdDraw.setPenColor(Color.black);
		StdDraw.filledRectangle(0.5, 0.5, 682, 384);
		StdDraw.setPenColor(Color.white);
		Font font = new Font("Arial", Font.BOLD, 60);
		StdDraw.setFont(font);
		StdDraw.text(0.5, 0.8, "2-D Soccer");
		font = new Font("Arial", Font.PLAIN, 16);
		StdDraw.setFont(font);
		StdDraw.text(0.5, 0.6, "Move left player with keys : A   W   D");
		StdDraw.text(0.5, 0.55, "Left player, kick ball with key :      S    ");
		StdDraw.text(0.5, 0.45, "Move right player with keys: LEFT  UP   RIGHT");
		StdDraw.text(0.5, 0.4, "Right player, kick ball with key :      DOWN    ");
		StdDraw.text(0.5, 0.3, "Right Click to Continue");
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
		StdDraw.setPenColor(Color.BLACK);
		Font font = new Font("Arial",Font.PLAIN, 16);
		StdDraw.setFont(font);
		String time = Timer(timer);
		StdDraw.text(0, .85, time);
	}
	/**
	 * draws the current score based on the number of points the player has.
	 * @params player1 points to be drawn
	 * @params player2 poitns to be drawn.
	*/
	
	public void drawScore(Player player1, Player player2) {
		StdDraw.setPenColor(Color.BLACK);
		Font font = new Font("Arial", Font.BOLD, 48);
		StdDraw.setFont(font);
		String playerOneScore = String.valueOf(player1.getScore());
		String playerTwoScore = String.valueOf(player2.getScore());
		this.winner = determineWinner(player1, player2);
		String fullScore = playerOneScore + " - " + playerTwoScore;
		StdDraw.text(0,.95,fullScore);
	}
	/**
	 * determines the winner based on who has most amount of points, or tie otherwise
	 * @params player1 points 
	 * @params player2 poitns 
	*/
	
	public String determineWinner(Player player1, Player player2) {
		if(player1.getScore() > player2.getScore()) {
			return "Player 1 wins";
		}else if(player2.getScore() > player1.getScore()) {
			return "Player 2 wins";
		}else {
			return "Tied Game";
		}
	}
	/**
	 * Draws the game over screen once there is no time left
	*/
	
	public void drawGameOverScreen() {
		StdDraw.setPenColor(Color.BLACK);
		Font font = new Font("Arial", Font.BOLD, 60);
		StdDraw.setFont(font);
		StdDraw.text(0,0,"Game Over");
		Font font2 = new Font("Arial", Font.PLAIN, 32);
		StdDraw.setFont(font2);
		StdDraw.text(0,-0.2,this.winner);
	}
	
	/**
	 * Based on the time decides whether game is over or not.
	 * @params the current timer time
	 * @return boolean indicating if game is over or not
	*/
	public boolean gameOver(int timer) {
		if(timer >= 60) {
			drawGameOverScreen();
			return true;
		}
		return false;
	}
	
	/**
	 * draws two sets of goals (one on each side)
	*/
	public void drawGoals() {
		StdDraw.filledRectangle(0,-0.95,0.01,.2);
		StdDraw.filledRectangle(-2.0, 0.4, 0.2, 0.8); 
		StdDraw.filledRectangle(2.0,0.4,0.2,0.8);
	}
	/**
	 * draws the ground
	*/
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
	/**
	 * draws the ball on the screen
	 * @params the ball to be drawn.
	*/
	
	public void drawBall(Ball ball) {
		ball.draw();
	}
	/**
	 * moves the ball on the screen
	 * @params the ball to be moved
	*/
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
	
	public void powerUpCheck(Player player1, Player player2, Ball ball) {
		if(player1.getScore() == 2) {
			player1.powerUp = true;
			player2.powerDown = true;
		}
		if(player2.getScore() == 2) {
			player2.powerUp = true;
			player1.powerDown = true;
		}
		else if(player1.getScore() > 2) {
			player1.powerUp = false;
			player2.powerDown = false;
		}
		else if(player2.getScore() > 2) {
			player2.powerUp = false;
			player1.powerDown = false;
		}
	}

}