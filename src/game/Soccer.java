package game;

import java.util.*;
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
				while(true) {
					StdDraw.clear();
					StdDraw.picture(0,0,"background.png");
					board.drawGoals();
					board.drawPlayers(player1,player2);
					board.movePlayers(player1,player2);
					StdDraw.show(2);
					board.handleJumping(player1, player2);
				}
	}
}



