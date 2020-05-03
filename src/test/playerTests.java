package test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.Ball;
import game.Player;
import sedgewick.ArcadeKeys;
import sedgewick.StdDraw;

class playerTests {
	private Player player;
	private Player player1;
	private Player player2;
	private Player player3;
	private Ball ball;
	
	@BeforeEach
	void setupTestingObjects() {
		player = new Player(-0.5, -1, 0);
		player1 = new Player(0.2, -1, 1);
		player2 = new Player(0.5,-1,2);
		player3 = new Player(0,0,0);
		ball = new Ball(0,0.5);
	}
	
	@Test
	void testGravity(){
		player.gravity();
		assertEquals(player.velocityY, -0.0005);
	}
	@Test
	void testRandom() {
		HashSet<Integer>  nums = new HashSet<Integer>();
		for(int i = 1; i < 10; i++) {
			nums.add(i);
		}
		int randomNumber = player.random();
		assertEquals(true, nums.contains(randomNumber));
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
	void updateVelocity() {
		player.updateVelocity(1);
		assertEquals(0, player.getvelocityX());
		assertEquals(-0.0000003, player.getvelocityY());
	}
	@Test 
	void updatePosition() {
		player.updatePosition();
		assertEquals(-0.5, player.getPosX());
		assertEquals(-1.0, player.getPosY());
	}
	@Test
	void testGoalScored() {
		player.goalScored();
		player1.goalScored();
		assertEquals(1, player.getScore());
		assertEquals(1, player.getScore());
	}
	
	@Test 
	void testResetPosition() {
		player.resetPos();
		player1.resetPos();
		assertEquals(-1.8, player.getPosX());
		assertEquals(0, player.getvelocityY());
		assertEquals(1.8, player1.getPosX());
		assertEquals(0, player1.getvelocityY());
	}
	
	@Test 
	void testCalculateBallDist() {
		double value = player3.calcBallDist(ball);
		assertEquals(0.5,value);
	}
	
	
	
	

}
