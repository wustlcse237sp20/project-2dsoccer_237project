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
			updatePosition();
			
		}
		/**
		 * determines the player based on the when it was initalized
	     * @return String of the whether it is left player or right player
		*/
		
		public String determinePlayer() {
			if(player == 0) {
				return "Left Player";
			}else if(player == 1) {
				return "Right Player";
			}
			return "Invalid Player";
		}
		/**
		 * Determines how to move left player based on button pressed and posX or posY 
	     * @param indication of which button was pressed
		*/
		
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
		/**
		 * Determines how to move right player based on button pressed and posX or posY 
	     * @param indication of which button was pressed
		*/
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
		/**
		 * updates the position of a player by adding to its x position and y position and sets x and y velocity
	     * @param indication of which button was pressed
		*/
		
		public void updatePosition() {
			this.posX += this.velocityX;
			this.posY += this.velocityY;
			updateVelocity(this.posY);
		}
		
		/**
		 * updates the x velocity and updates the y velocity based on y position.
	     * @param the current y position
		*/
		
		public void updateVelocity(double posY) {
			if(posY > -0.95) {
				this.velocityY = this.velocityY - 0.0000005;
			}
			
			this.velocityX = 0;
			
		}
		
		/**
		 * updates the x velocity and updates the y velocity based on y position.
	     * @return a String indication which key was pressed
		*/
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
		/**
		 * get's the current x position
		*/
		public double getPosX() {
			return this.posX;
		}
		/**
		 * get's the current y position
		*/
		public double getPosY() {
			return this.posY;
		}
		/**
		 * updates the y velocity to act in a way of gravity.
		*/
		public void gravity() {
			this.velocityY = this.velocityY - 0.005;
		}
		
		
}
