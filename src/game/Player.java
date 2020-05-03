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
		private final double width = 0.2;
		private final double height = 0.2;
		private int player;
		private double ballDistance;
		private int score;
		public boolean powerUp = false;
		public boolean powerDown = false; //true if the opposing player has a powerUp
		private int a = this.random(0);
		private int b = this.random(0);
		
		public int random(int z){
			int a = 0;
			double random = Math.random();
			if(random>=.9) {
				z = 9;
			}
			else if(random>=.8) {
				z = 9;
			}
			else if(random>=.7) {
				z = 8;
			}
			else if(random>=.6) {
				z = 7;
			}
			else if(random>=.5) {
				z = 6;
			}
			else if(random>=.4) {
				z = 5;
			}
			else if(random>=.3) {
				z = 4;
			}
			else if(random>=.2) {
				z = 3;
			}
			else if(random>=.1) {
				z = 2;
			}
			else {
				z = 1;
			}
			return z;
		}


		public Player(double x, double y, int player) {
			this.posX = x;
			this.posY = y;
			this.startPosX = x;
			this.startPosY = y;
			this.player = player;
		}
		/**
		 * gets the score of the player
		 * @return the points the player has
		 */
		public int getScore() {
			return this.score;
		}
		/**
		 * sets the score (for testing purposes)
		 */
		public void setScore(int score) {
			this.score = score;
		}
		/**
		 * Updates the score based if a goal was score
		 */	
		public void goalScored() {
			score += 1;
		}
		
		/**
		 * draws players
		 */
		public void drawPlayer1() {
			if(this.powerDown == true) { //red color indicates the controls are reversed.
				StdDraw.setPenColor(StdDraw.RED);
			}
			else {
				StdDraw.setPenColor(StdDraw.BLACK);
			}
		//	StdDraw.filledRectangle(this.posX, this.posY, this.width/2, this.height/2);

			StdDraw.picture(this.posX, this.posY, "character" + a + " copy.png", this.width, this.height);
			
		
			StdDraw.setPenColor(StdDraw.BLACK);
		}
		public void drawPlayer2() {
			if(this.powerDown == true) { //red color indicates the controls are reversed.
				StdDraw.setPenColor(StdDraw.RED);
			}
			else {
				StdDraw.setPenColor(StdDraw.BLACK);
			}
			
			if(a==b) {
				if(b==10) {
					b--;
				}
				else {
					b++;
				}
			}
			StdDraw.picture(this.posX, this.posY, "character" + b + ".png", this.width, this.height);
			
			StdDraw.setPenColor(StdDraw.BLACK);
		}
		/**
		 * movement of each player depending on which keys are pressed.
		 */
		//Can't refactor much right now on further iteration get movement of 2 players at the same time to work.		
		public void move() {			
			if (determinePlayer() == "Left Player") {
				if(this.powerDown == false) {
					if((ArcadeKeys.isKeyPressed(0, 1)) && this.posX>-2) {
						this.velocityX -= 0.002;
					}
					else if((ArcadeKeys.isKeyPressed(0, 1)) && this.posX<=-2) {
						this.velocityX = 0;
					}
					if((ArcadeKeys.isKeyPressed(0, 3)) && this.posX<-0.11) {
						this.velocityX += 0.002;
					}
					else if((ArcadeKeys.isKeyPressed(0, 3)) && this.posX>=-0.11) {
						this.velocityX = 0;
					}
					if((ArcadeKeys.isKeyPressed(0, 0)) && this.posY<=-0.95) {
						this.velocityY = 0.02;
					}

				}
				else {
					if((ArcadeKeys.isKeyPressed(0, 1)) && this.posX<-0.11) {
						this.velocityX += 0.002;
					}
					else if((ArcadeKeys.isKeyPressed(0, 1)) && this.posX>=-0.11) {
						this.posX = -0.12;
						this.velocityX = 0;
					}
					if((ArcadeKeys.isKeyPressed(0, 3)) && this.posX>-2) {
						this.velocityX -= 0.002;
					}
					else if((ArcadeKeys.isKeyPressed(0, 3)) && this.posX<=-2) {
						this.posX = -1.99;
						this.velocityX = 0;
					}
					if((ArcadeKeys.isKeyPressed(0, 0)) && this.posY<=-0.95) {
						this.velocityY = 0.02;
					}
				}
				
			}
			if(determinePlayer() == "Right Player") {
				if(this.powerDown == false) {
					if((ArcadeKeys.isKeyPressed(1, 1)) && this.posX>0.11) {
						this.velocityX -= 0.002;
					}
					else if((ArcadeKeys.isKeyPressed(1, 1)) && this.posX<=0.11) {
						this.velocityX = 0;
					}
					if((ArcadeKeys.isKeyPressed(1, 3)) && this.posX<2) {
						this.velocityX += 0.002;
					}
					else if((ArcadeKeys.isKeyPressed(1, 3)) && this.posX>=2) {
						this.velocityX = 0;
					}
					if((ArcadeKeys.isKeyPressed(1, 0)) && this.posY<=-0.95) {
						this.velocityY = 0.02;
					}
				}
				else {
					if((ArcadeKeys.isKeyPressed(1, 1)) && this.posX<2) {
						this.velocityX += 0.002;
					}
					else if((ArcadeKeys.isKeyPressed(1, 1)) && this.posX>=2) {
						this.posX = 1.99;
						this.velocityX = 0;
					}
					if((ArcadeKeys.isKeyPressed(1, 3)) && this.posX>0.11) {
						this.velocityX -= 0.002;
					}
					else if((ArcadeKeys.isKeyPressed(1, 3)) && this.posX<=0.11) {
						this.posX = 0.12;
						this.velocityX = 0;
					}
					if((ArcadeKeys.isKeyPressed(1, 0)) && this.posY<=-0.95) {
						this.velocityY = 0.02;
					}
				}
				
			}
			//velocities update the position
			updatePosition();
		}
		
		/**
		 * if the ball is in kicking range, call ball isKicked(), setting a velocity
		 * up and towards the other goal.
		 * @param ball the game ball
		 */
		public void kickBall(Ball ball) {
			if(player == 0) {
				if(ball.distP1 <= 0.18 && ArcadeKeys.isKeyPressed(0, 2)) {
					ball.isKicked(0);
				}
			}
			if(player == 1) {
				if(ball.distP2 <= 0.18 && ArcadeKeys.isKeyPressed(1, 2)) {
					ball.isKicked(1);
				}
			}
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
//		
//		/**
//		 * Determines how to move left player based on button pressed and posX or posY 
//	     * @param indication of which button was pressed
//		*/
//		
//		public void moveLeftPlayer(String buttonPressed) {
//			if ((buttonPressed == "a") && this.posX>-1.99) {
//				//key pressed changes velocity
//				this.velocityX -= 0.1;
//			}
//			else if((buttonPressed == "a") && this.posX<1.99) {
//				this.velocityX = 0;
//			}
//			if ((buttonPressed == "d") && this.posX<-0.11) {
//				this.velocityX += 0.1;
//			}
//			else if((buttonPressed == "d") && this.posX>-0.11) {
//				this.velocityX = 0;
//			}
//			if ((buttonPressed == "w") && this.posY <= -0.95) {
//				//a jump starts you off at a fixed velocity, if you are currently on the ground
//				this.velocityY = 0.05;
//	
//			}
//			System.out.println(this.velocityX);
//		}
//		/**
//		 * Determines how to move right player based on button pressed and posX or posY 
//	     * @param indication of which button was pressed
//		*/
//		public void moveRightPlayer(String buttonPressed) {
//			if ((buttonPressed == "left") && this.posX > 0.21) {
//				//key pressed changes velocity
//				this.velocityX -= 0.1;
//			}
//			else if((buttonPressed == "left") && this.posX>0.21) {
//				this.velocityX = 0;
//			}
//			if ((buttonPressed == "right") && this.posX < 1.99) {
//				this.velocityX += 0.1;
//			}
//			else if ((buttonPressed == "right") && this.posX>1.99) {
//				this.velocityX = 0;
//			}
//			if ((buttonPressed == "up") && this.posY <= -0.95) {
//				//a jump starts you off at a fixed velocity, if you are currently on the ground
//				this.velocityY = 0.05;
//			}
//			
//		}

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
				this.velocityY = this.velocityY - 0.0000003;
			}
			this.velocityX = this.velocityX * 0.8;
			
		}
		
		/**
		 * updates the x velocity and updates the y velocity based on y position.
	     * @return a String indication which key was pressed
		*/
		public String buttonPressed() {
			if(ArcadeKeys.isKeyPressed(0, 1)) {
				return "a";
			}
			if((ArcadeKeys.isKeyPressed(0, 3))) {
				return "d";
			}
			if((ArcadeKeys.isKeyPressed(0, 0))) {
				return "w";
			}
			if((ArcadeKeys.isKeyPressed(1, 1))) {
				return "left";
			}
			if((ArcadeKeys.isKeyPressed(1, 3))){
				return "right";
			}
			if((ArcadeKeys.isKeyPressed(1, 0))){
				return "up";
			}
			return "not valid button";
		}
		/**
		 * Resets the players position after a goal is scored.
		*/
		
		public void resetPos() {
			if(player == 0) {
				this.posX = -1.8;
				this.velocityX = 0;
			}
			else if(player == 1) {
				this.posX = 1.8;
				this.velocityX = 0;
			}
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
		 * get's the current x velocity
		*/
		public double getvelocityX() {
			return this.velocityX;
		}
		/**
		 * get's the current y velocity
		*/
		public double getvelocityY() {
			return this.velocityY;
		}
		/**
		 * updates the y velocity to act in a way of gravity.
		*/
		public void gravity() {
			this.velocityY = this.velocityY - 0.0005;
		}
		/**
		 * Calculates the distance between player and ball
		 * @param ball, distance is measured from.
		*/
		public double calcBallDist(Ball b) {
			double dist = Math.sqrt((this.posY - b.getPosY())*(this.posY - b.getPosY()) + (this.posX - b.getPosX())*(this.posX - b.getPosX()));
			return dist;
		}
		/**
		 * Sets the ball distance
		 * @param ball, distance is measured from.
		*/
		public void setBallDist(double dist) {
			this.ballDistance = dist;
		}
		
		
}
