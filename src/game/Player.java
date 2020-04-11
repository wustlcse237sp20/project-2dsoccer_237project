package game;
import java.awt.Color;

import sedgewick.ArcadeKeys;
import sedgewick.StdDraw;

public class Player {
		
		public double posX;
		private double posY; 
		public double velocityX;
		public double velocityY;
		private final double startPosX;
		private final double startPosY;
		private final double width = 0.1;
		private final double height = 0.1;
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
		}
		/**
		 * movement of each player depending on which keys are pressed.
		 */
		public void move() {
		
			//player movement with constraints of the boundaries of the field
			if (player == 0){
				if ((ArcadeKeys.isKeyPressed(0, 1)) && this.posX>-1) {
					//key pressed changes velocity
					this.velocityX -= 0.005;
				}
				else if ((ArcadeKeys.isKeyPressed(0, 3)) && this.posX<-0.1) {
					this.velocityX += 0.005;
				}
				else if ((ArcadeKeys.isKeyPressed(0, 0)) && this.posY <= -0.95) {
					//a jump starts you off at a fixed velocity, if you are currently on the ground
					this.velocityY = 0.1;
		
				}
			}
			if (player == 1){
				if ((ArcadeKeys.isKeyPressed(1, 1)) && this.posX > 0.1) {
					//key pressed changes velocity
					this.velocityX -= 0.005;
				}
				else if ((ArcadeKeys.isKeyPressed(1, 3)) && this.posX < 1) {
					this.velocityX += 0.005;
				}
				else if ((ArcadeKeys.isKeyPressed(1, 0)) && this.posY <= -0.95) {
					//a jump starts you off at a fixed velocity, if you are currently on the ground
					this.velocityY = 0.1;
				}
			}
			
			//velocities update the position
			this.posX += this.velocityX;
			this.posY += this.velocityY;
			
			//vertical acceleration updates the velocity
			if(this.posY > -0.95) {
				this.velocityY = this.velocityY - 0.0000005;
			}
			
			this.velocityX = 0;
			
			
			
		}
		public double getPosX() {
			return this.posX;
		}
		
		public double getPosY() {
			return this.posY;
		}
		public void gravity() {
			this.velocityY = this.velocityY - 0.005;
		}
		
		
}
