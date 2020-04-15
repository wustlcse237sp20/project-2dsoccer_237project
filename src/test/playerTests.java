package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.Player;
import sedgewick.ArcadeKeys;
import sedgewick.StdDraw;

class playerTests {
	private Player player;
	private Player player1;
	private Player player2;
	
	@BeforeEach
	void setupTestingObjects() {
		player = new Player(0.5, -1, 0);
		player1 = new Player(0.5, -1, 1);
		player2 = new Player(0.5,-1,2);
	}
	
	@Test
	void testGravity(){
		player.gravity();
		assertEquals(player.velocityY, -0.005);
	}
	
	@Test
	void testDeterminePlayer0() {
		String whichPlayer = player.determinePlayer();
		assertEquals("Left Player", whichPlayer);
	}
	@Test
	void testDeterminePlayer1() {
		String whichPlayer = player1.determinePlayer();
		assertEquals("Right Player", whichPlayer);		
	}
	@Test
	void testDeterminePlayer3() {
		String whichPlayer = player2.determinePlayer();
		assertEquals("Invalid Player", whichPlayer);		
	}
	
	

}
