package game;
import java.awt.Color;

import sedgewick.ArcadeKeys;
import sedgewick.StdDraw;

public class Player {
		
		private double posX;
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
			String buttonPressed = buttonPressed();
			if (determinePlayer() == "Left Player"){
				moveLeftPlayer(buttonPressed);
			}
			if (determinePlayer() == "Right Player"){
				moveRightPlayer(buttonPressed);
			}
			//velocities update the position
			updateVelocity();
			
		}
		
		public String determinePlayer() {
			if(player == 0) {
				return "Left Player";
			}else if(player == 1) {
				return "Right Player";
			}
			return "Invalid Player";
		}
		
		public void moveLeftPlayer(String buttonPressed) {
			if ((buttonPressed == "a") && this.posX>-1) {
				//key pressed changes velocity
				this.velocityX -= 0.005;
			}
			else if ((buttonPressed == "d") && this.posX<-0.1) {
				this.velocityX += 0.005;
			}
			else if ((buttonPressed == "w") && this.posY <= -0.95) {
				//a jump starts you off at a fixed velocity, if you are currently on the ground
				this.velocityY = 0.1;
	
			}
		}
		public void moveRightPlayer(String buttonPressed) {
			if ((buttonPressed == "left") && this.posX > 0.1) {
				//key pressed changes velocity
				this.velocityX -= 0.005;
			}
			else if ((buttonPressed == "right") && this.posX < 1) {
				this.velocityX += 0.005;
			}
			else if ((buttonPressed == "up") && this.posY <= -0.95) {
				//a jump starts you off at a fixed velocity, if you are currently on the ground
				this.velocityY = 0.1;
			}
			
		}
		
		public void updateVelocity() {
			this.posX += this.velocityX;
			this.posY += this.velocityY;
			//vertical acceleration updates the velocity
			if(this.posY > -0.95) {
				this.velocityY = this.velocityY - 0.0000005;
			}
			
			this.velocityX = 0;
		}
		
		
		public String buttonPressed() {
			if(ArcadeKeys.isKeyPressed(0, 1)) {
				return "a";
			}else if((ArcadeKeys.isKeyPressed(0, 3))) {
				return "d";
			}else if((ArcadeKeys.isKeyPressed(0, 0))) {
				return "w";
			}else if((ArcadeKeys.isKeyPressed(1, 1))) {
				return "left";
			}else if((ArcadeKeys.isKeyPressed(1, 3))){
				return "right";
			}else if((ArcadeKeys.isKeyPressed(1, 0))){
				return "up";
			}
			return "not valid button";
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
