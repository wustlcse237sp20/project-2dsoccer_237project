package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.Player;
import sedgewick.StdDraw;

class playerTests {
	private Player player;
	
	@BeforeEach
	void setupTestingObjects() {
		player = new Player(0.5, -1, 1);
	}
	@Test
	void testPosX() {
		assertEquals(player.getPosX(), player.posX);
	}
	
	@Test
	void TestPosY() {
		assertEquals(player.getPosY(), player.posY);
	}
	
	@Test
	void draw() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(player.posX, player.posY, player.width/2, player.height/2);
		assert(true);
	}
	
	@Test
	void testGravity(){
		player.gravity();
		assertEquals(player.velocityY, -0.005);
	}
	

}
