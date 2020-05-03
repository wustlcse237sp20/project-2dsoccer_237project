package game;
import java.util.*;
<<<<<<< Updated upstream
=======
import java.util.concurrent.TimeUnit;
>>>>>>> Stashed changes
import sedgewick.StdDraw;
import cse131.ArgsProcessor;
import java.awt.Color;
public class Soccer {
<<<<<<< Updated upstream
	private Player player1;
	private Player player2;

	public static void main(String[] args) {
				Board board = new Board();
				board.setupScreen();
				Player player1 = new Player(-.5, -1, 0); //Not calling "Player" causes static/non static error
				Player player2 = new Player(0.5, -1, 1);
				while(true) {
					StdDraw.clear();
					StdDraw.picture(0,0,"background.png");
					board.drawGoals();
					board.drawPlayers(player1,player2);
					board.movePlayers(player1,player2);
					StdDraw.show(2);
					board.handleJumping(player1, player2);
=======
	public Player player1;
	public Player player2;


	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		boolean decision = true;
		while(decision == true) {
			String player1Name = ap.nextString("Player 1 name?");
			String player2Name = ap.nextString("Player 2 name?");
			Board board = new Board();
			board.setupScreen();
			Player player1 = new Player(-1, -0.95, 0); //Not calling "Player" causes static/non static error
			Player player2 = new Player(1, -0.95, 1);
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
>>>>>>> Stashed changes
				}
	}
}



