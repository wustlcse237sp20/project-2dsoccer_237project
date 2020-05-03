package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Ball;
import game.Player;
import sedgewick.StdDraw;

import org.junit.jupiter.api.Test;

class ballTests {
	private Ball ball;
	private Ball ball2;
	private Ball ball3;
	private Ball ball4;
	private Player player;
	
	@BeforeEach
	void setupTestingObjects() {
		ball = new Ball(.5,.5);
		ball2 = new Ball(-2,0);
		ball3 = new Ball(2,-2);
		ball4 = new Ball(0,0);
		player = new Player(0,0,0);
	}
//	@Test
//	void moveTest() {
//		ball.move();
//		assertEquals(0.505, ball.getPosX());
//		assertEquals(0.5, ball.getPosY());
//	}
//	@Test 
//	void updatePosition() {
//		ball.updatePosition();
//		assertEquals(0.495, ball.getPosX());
//		assertEquals(0.5, ball.getPosY());
//	}
	@Test 
	void isKickedTest() {
		ball.isKicked(0);
		assertEquals(0.02, ball.getvelocityX());
		assertEquals(0.03, ball.getvelocityY());
	}
	@Test
	void isKickedTest1() {
		ball.isKicked(1);
		assertEquals(-0.02, ball.getvelocityX());
		assertEquals(0.03, ball.getvelocityY());
	}
	@Test
	void calcDistanceTest() {
		double value = ball4.calcDist(player);
		assertEquals(0, value);
		
	}
	@Test
	void testRestBall() {
		ball.resetBall(2);
		assertEquals(2.0, ball.getPosX());
		assertEquals(0.5, ball.getPosY());
		assertEquals(0, ball.getvelocityX());
		assertEquals(0, ball.getvelocityY());
	}
	@Test
	void updateVelocity() {
		ball2.updateVelocity();
		assertEquals(-0.0005, ball2.getvelocityY());
		assertEquals(-1.8, ball2.getPosX());
		
	}
	@Test
	void updateVelocity1() {
		ball3.updateVelocity();
		assertEquals(2.0, ball3.getPosX());
		assertEquals(-1, ball3.getPosY());
	}


}
