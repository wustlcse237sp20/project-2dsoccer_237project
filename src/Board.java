import java.awt.Color;

import sedgewick.StdDraw;

public class Board {
	
	/**
	 * Starts by setting up the splash screen, which then leads to our main screen after the user presses the mouse
	 */
	public void setupScreen() {
		StdDraw.setCanvasSize(1364,768);
		StdDraw.setPenColor(Color.black);
		StdDraw.filledRectangle(0.5, 0.5, 682, 384);
		StdDraw.setPenColor(Color.white);
		StdDraw.text(0.5, 0.8, "2-D Soccer");
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
		StdDraw.setScale(-1,1);
	}
	
	/**
	 * draws two sets of goals (one on each side)
	*/
	public void drawGoals() {
		StdDraw.filledRectangle(0,-0.95,0.01,.2);
		StdDraw.filledRectangle(-1.0, 0.4, 0.1, 0.8); 
		StdDraw.filledRectangle(1.0,0.4,0.1,0.8);
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
