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
	
	@BeforeEach
	void setupTestingObjects() {
		player = new Player(0.5, -1, 1);
	}
	
	@Test
	void testGravity(){
		player.gravity();
		assertEquals(player.velocityY, -0.005);
	}
	@Test
	void testPlayer(){
		assertEquals("Left Player", player.determinePlayer());
		
	}
	
	@Test
	void testButtonPressed() {
		String buttonPressed = player.buttonPressed();
		assertEquals("a", ArcadeKeys.isKeyPressed(0, 1));
		assertEquals("d", ArcadeKeys.isKeyPressed(0, 3));
		assertEquals("w", ArcadeKeys.isKeyPressed(0, 0));
		assertEquals("left", ArcadeKeys.isKeyPressed(1, 1));
		assertEquals("right", ArcadeKeys.isKeyPressed(1, 3));
		assertEquals("up", ArcadeKeys.isKeyPressed(1, 0));
		
	}
	

}
