package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Board;
import sedgewick.StdDraw;


class boardTests {
	private Board board;

	@BeforeEach
	void setupTestingObjects() {
		board = new Board();
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

}
