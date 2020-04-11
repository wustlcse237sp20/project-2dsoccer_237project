package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.Player;

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
	

}
