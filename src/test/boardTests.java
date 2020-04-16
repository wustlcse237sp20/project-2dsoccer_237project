package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Board;
import game.Player;
import sedgewick.StdDraw;


class boardTests {
	private Board board;
	private Player player;
	private Player player1;

	@BeforeEach
	void setupTestingObjects() {
		board = new Board();
		player = new Player(0.5, -1, 0);
		player1 = new Player(0.5, -1, 1);
	}
	
	
	@Test
	void testMovePlayers() {
		board.movePlayers(player,player1);
		assert(true);
	}
	
	@Test
	void testGameOver() {
		for(int i = 0; i < 61; i++) {
			assertEquals(false, board.gameOver(i));
		}
		for(int i = 61; i < 1000; i++) {
			assertEquals(true, board.gameOver(i));
		}
	}
	
	//handleJumping unit test
	//Timer unit test

}
