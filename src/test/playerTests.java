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
		player = new Player(-0.5, -1, 0);
		player1 = new Player(0.2, -1, 1);
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
	@Test
	void moveLeftPlayerA() {
		player.moveLeftPlayer("a");
		assertEquals(-0.01, player.getvelocityX());
	}
	@Test
	void moveLeftPlayerW() {
		player.moveLeftPlayer("w");
		assertEquals(0.1, player.getvelocityY());
	}
	@Test
	void moveLeftPlayerD() {
		player.moveLeftPlayer("d");
		assertEquals(0.01, player.getvelocityX());
	}
	@Test
	void moveRightPlayerLeft() {
		player1.moveRightPlayer("left");
		assertEquals(-0.01, player1.getvelocityX());
	}
	@Test
	void moveRightPlayerRight() {
		player1.moveRightPlayer("right");
		assertEquals(0.01, player1.getvelocityX());
	}
	@Test
	void moveRightPlayerUp() {
		player1.moveRightPlayer("up");
		assertEquals(0.1, player1.getvelocityY());
	}
	@Test 
	void updateVelocity() {
		player.updateVelocity(1);
		assertEquals(0, player.getvelocityX());
		assertEquals(-0.0000005, player.getvelocityY());
	}
	@Test 
	void updatePosition() {
		player.updatePosition();
		assertEquals(-0.5, player.getPosX());
		assertEquals(-1.0, player.getPosY());
	}
	
	//test for move function
	//test for updateScore
	
	
	
	

}
