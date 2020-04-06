import java.awt.Color;

import sedgewick.ArcadeKeys;
import sedgewick.StdDraw;

public class Player {
	//
	private double posX;
	private double posY; 
	private final double startPosX;
	private final double startPosY;
	private final double width = 0.1;
	private final double height = 0.1;
	private final Color [] colors = {StdDraw.RED, StdDraw.YELLOW, StdDraw.WHITE};
	private int player;
	

	public Player(double x, double y, int player) {
		this.posX = x;
		this.posY = y;
		this.startPosX = x;
		this.startPosY = y;
		this.player = player;
	}
	
	/**
	 * draws players
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(this.posX, this.posY, this.width/2, this.height/2);
		StdDraw.filledRectangle(this.posX, (this.posY + this.height/1.5), this.width/6, this.height/2);
	}
	/**
	 * movement of each player depending on which keys are pressed.
	 */
	public void move() {
		
		//If movements are possible:
		if (player == 0){
			if ((ArcadeKeys.isKeyPressed(0, 1))) {
				this.posX -= 0.05;
			}
			else if ((ArcadeKeys.isKeyPressed(0, 3))) {
				this.posX += 0.05;
			}
		}
		if (player == 1){
			if ((ArcadeKeys.isKeyPressed(1, 1))) {
				this.posX -= 0.05;
			}
			else if ((ArcadeKeys.isKeyPressed(1, 3))) {
				this.posX += 0.05;
			}
		}
	}
	

	public double getPosX() {
		return this.posX;
	}

	public double getPosY() {
		return this.posY;
	}


}
