package game;

import java.util.*;
import java.util.concurrent.TimeUnit;

import sedgewick.StdDraw;
import java.awt.Color;
public class Soccer {
	public Player player1;
	public Player player2;
	

	public static void main(String[] args) {
				Board board = new Board();
				board.setupScreen();
				Player player1 = new Player(-.5, -1, 0); //Not calling "Player" causes static/non static error
				Player player2 = new Player(0.5, -1, 1);
				Ball ball = new Ball(0,0.5);
				int timer = 0;
				int count = 0;
				boolean isgameOver = false;
				while(isgameOver == false) {
					StdDraw.clear();
					StdDraw.picture(0,0,"background.png");
					isgameOver = runGame(board, player1, player2, ball, count);
					if(timer % 100 == 0) {
						count++;
					}
					timer+=1;
				}
	}

	private static boolean runGame(Board board, Player player1, Player player2, Ball ball, int count) {
		boolean isgameOver;
		board.drawGround();
		board.drawTime(count);
		board.drawScore(player1,player2);
		//Checks to see if game is over based on time
		isgameOver = board.gameOver(count);
		board.drawGoals();
		board.drawPlayers(player1,player2);
		board.drawBall(ball);
		board.movePlayers(player1,player2);
		ball.playerCollision(player1, player2);
		player1.setBallDist(player1.calcBallDist(ball));
		player2.setBallDist(player2.calcBallDist(ball));
		board.moveBall(ball);
		player1.kickBall(ball);
		player2.kickBall(ball);
		StdDraw.show(0);
		if(ball.goal(player1, player2)) {
			StdDraw.pause(500);
		}
		board.handleJumping(player1, player2);
		return isgameOver;
	}

}