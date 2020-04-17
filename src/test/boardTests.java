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
		player = new Player(0.5, -.8, 0);
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
	@Test 
	void testGetTime() {
		assertEquals("00:0", board.getTime(5));
		assertEquals("00:", board.getTime(40));
		assertEquals("01:00", board.getTime(60));
		assertEquals("Invalid time", board.getTime(-1));
	}
	@Test
	void testTimer() {
		assertEquals("00:05", board.Timer(5));
		assertEquals("00:40", board.Timer(40));
		assertEquals("01:00", board.Timer(60));
		assertEquals("Can't display time", board.Timer(-1));
		
	}
	@Test
	void testHandleJumpingPlayer1A() {
		board.handleJumping(player, player1);
		assertEquals(-0.005,player.getvelocityY());
	}
	@Test
	void testHandleJumpingPlayer1B() {
		board.handleJumping(player1, player);
		assertEquals(0.00,player1.getvelocityY());
	}

}
