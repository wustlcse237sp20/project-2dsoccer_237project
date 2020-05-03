package game;
import java.awt.Color;
import java.util.Random;

import sedgewick.ArcadeKeys;
import sedgewick.StdDraw;

public class Player {
		public String name;
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
		private int player1Skin = this.random();
		private int player2Skin = this.random();
		
		public Player(double x, double y, int player) {
			this.posX = x;
			this.posY = y;
			this.startPosX = x;
			this.startPosY = y;
			this.player = player;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * Ensures that random number generated is between 1-9
		 * @return a number between 1-9 to be later used for character selection.
		 */
		public int random(){
			Random rn = new Random();
			int randomNum = rn.nextInt((9-1) + 1) + 1;
			return randomNum;
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
		 * draws players 1 and picks a character skin  based on a random value
		 */
		public void drawPlayer1() {
			if(this.powerDown == true) { //red color indicates the controls are reversed.
				StdDraw.setPenColor(StdDraw.RED);
			}
			else {
				StdDraw.setPenColor(StdDraw.BLACK);
			}
			StdDraw.picture(this.posX, this.posY, "character" + player1Skin + " copy.png", this.width, this.height);
			StdDraw.setPenColor(StdDraw.BLACK);
		}
		/**
		 * draws players 2 and picks a character skin  based on a random value
		 */
		public void drawPlayer2() {
			if(this.powerDown == true) { //red color indicates the controls are reversed.
				StdDraw.setPenColor(StdDraw.RED);
			}
			else {
				StdDraw.setPenColor(StdDraw.BLACK);
			}
			if(player1Skin==player2Skin) {
				if(player2Skin==9) {
					player2Skin--;
				}
				else {
					player2Skin++;
				}
			}
			StdDraw.picture(this.posX, this.posY, "character" + player2Skin + ".png", this.width, this.height);	
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
