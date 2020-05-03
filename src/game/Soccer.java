package game;
import java.util.*;
import java.util.concurrent.TimeUnit;
import sedgewick.StdDraw;
import cse131.ArgsProcessor;
import java.awt.Color;
import java.awt.Font;
public class Soccer {
	private Player player1;
	private Player player2;
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		boolean decision = true;
		String player1Name = ap.nextString("Player 1 name?");
		String player2Name = ap.nextString("Player 2 name?");
		while(decision == true) {
			Board board = new Board();
			board.setupScreen(player1Name, player2Name);
			Player player1 = new Player(-1, -0.95, 0); //Not calling "Player" causes static/non static error
			player1.setName(player1Name);
			Player player2 = new Player(1, -0.95, 1);
			player2.setName(player2Name);
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
			// because you can't pass variables in by reference just get new values
			// from returning and array - 
			boolean[] runGameSettings = board.rerunGame();
			decision = runGameSettings[0];
			isgameOver = runGameSettings[1];
		}		
		

	}
	private static boolean runGame(Board board, Player player1, Player player2, Ball ball, int count) {
		//Checks to see if game is over based on time
		boolean isgameOver = board.gameOver(count);	
		
		//draw names
		Font font = new Font("Arial",Font.PLAIN, 25);
		StdDraw.setFont(font);
		StdDraw.setPenColor(Color.RED);
		StdDraw.text(-1.6, 0.9, player1.name);
		StdDraw.text(1.6, 0.9, player2.name);
		

		board.drawEverything(player1, player2, ball, count);		
		board.powerUpCheckAndDraw(player1, player2, ball);
		ball.playerCollision(player1, player2);
		player1.setBallDist(player1.calcBallDist(ball));
		player2.setBallDist(player2.calcBallDist(ball));
		board.movePlayers(player1,player2);
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