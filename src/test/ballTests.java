package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Ball;

import sedgewick.StdDraw;

import org.junit.jupiter.api.Test;

class ballTests {
	private Ball ball;
	private Ball ball2;
	private Ball ball3;
	
	@BeforeEach
	void setupTestingObjects() {
		ball = new Ball(.5,.5);
		ball2 = new Ball(-2,0);
		ball3 = new Ball(2,-2);
	}
	@Test
	void moveTest() {
		ball.move();
		assertEquals(0.52, ball.getPosX());
		assertEquals(0.5, ball.getPosY());
	}
	@Test 
	void updatePosition() {
		ball.updatePosition();
		assertEquals(0.52, ball.getPosX());
		assertEquals(0.5, ball.getPosY());
	}
	@Test
	void updateVelocity() {
		ball2.updateVelocity();
		assertEquals(-0.0005, ball2.getvelocityY());
		assertEquals(-1.9, ball2.getPosX());
		
	}
	@Test
	void updateVelocity1() {
		ball3.updateVelocity();
		assertEquals(1.9, ball3.getPosX());
		assertEquals(-1, ball3.getPosY());
		//assertEquals(1.9, ball3.getvelocityX());
		//assertEquals(0.0, ball3.getvelocityY());
	}


}
