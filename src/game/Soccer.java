package game;

import java.util.*;
import java.util.concurrent.TimeUnit;

import sedgewick.StdDraw;
import java.awt.Color;
public class Soccer {
	private Player player1;
	private Player player2;

	public static void main(String[] args) {
				Board board = new Board();
				board.setupScreen();
				Player player1 = new Player(-.5, -1, 0); //Not calling "Player" causes static/non static error
				Player player2 = new Player(0.5, -1, 1);
				Ball ball = new Ball(0,0);
				// timer and count needed to formulate the time displayed
				int timer = 0;
				int count = 55;
				boolean isgameOver = false;
				while(isgameOver == false) {
					StdDraw.clear();
					StdDraw.picture(0,0,"background.png");
					board.drawGround();
					board.drawTime(count);
					board.drawScore(player1,player2);
					//Checks to see if game is over based on time
					isgameOver = board.gameOver(count);
					board.drawGoals();
					board.drawPlayers(player1,player2);
					board.drawBall(ball);
					board.movePlayers(player1,player2);
					board.moveBall(ball);
					StdDraw.show(2);
					board.handleJumping(player1, player2);
					//Counts by one second for updating the time
					if(timer % 100 == 0) {
						count++;
					}
					timer+=1;
				}
				
				
	}

}