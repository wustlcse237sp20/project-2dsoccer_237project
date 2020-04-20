package game;

import java.awt.Color;

import sedgewick.ArcadeKeys;
import sedgewick.StdDraw;

public class Ball {
	private double posX;
	private double posY; 
	private final double startPosX;
	private final double startPosY;
	private double velocityX = 0.005;
	private double velocityY;
	private final double radius = 0.05;
	public double distP1;
	public double distP2;
	
	public Ball(double x, double y){
		this.posX = x;
		this.posY = y;
		this.startPosX = x;
		this.startPosY = y;
		//to start the game, the ball starts with a slow x velocity, direction is random
		double val = Math.random();
		if(val<0.5) {
			velocityX = 0.005;
		}
		else if(val>=0.5) {
			velocityX = -0.005;
		}
	}
	/**
	 * draws the ball
	 */
	
	public void draw() {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledCircle(this.posX, this.posY, this.radius);
		StdDraw.setPenColor(StdDraw.BLACK);
	}
	/**
	 * moves the ball's position on the screen
	 */
	
	public void move() {
		updatePosition();
	}
	/**
	 * based on changes to the velocities, update the position of ball
	 */
	
	public void updatePosition() {
		this.posX += this.velocityX;
		this.posY += this.velocityY;
		updateVelocity();
	}
	
	/**
	 * Based on physics and game happenings, change velocities.
	 */
	public void updateVelocity() {
		//gravity
		if(posY > -1) {
			this.velocityY = this.velocityY - 0.0005;
		}
		//left upper wall bounce
		if(posX < -1.8 && posY > -0.4) {
			this.posX = -1.8;
			this.velocityX = this.velocityX * -0.9;
		}
		//right upper wall bounce
		if(posX > 1.8 && posY > -0.4) {
			this.posX = 1.8;
			this.velocityX = this.velocityX * -0.9;
		}
		//left bounce
		if(posX < -2.1) {
			this.posX = -2.1;
			this.velocityX = this.velocityX * -0.9;
		}
		//right bounce
		if(posX > 2.1) {
			this.posX = 2.1;
			this.velocityX = this.velocityX * -0.9;
		}
		//ground bounce
		if(posY < -1) {
			this.posY = -1;
			this.velocityY = this.velocityY * -0.85;
		}
		//ceiling bounce
		if(posY >=1) {
			this.posY = 1;
			this.velocityY = this.velocityY * -1;
		}
		//friction of ball on ground
		if(posY == -1) {
			this.velocityX = this.velocityX * 0.97;
		}
		
	}
	/**
	 * when the ball's distance to a player gets low enough to touch it,
	 * change the ball's velocities based on the velocities of the player it touches
	 * @param p1 player 1
	 * @param p2 player 2
	 */
	
	public void playerCollision(Player p1, Player p2) {
		distP1 = calcDist(p1);
		distP2 = calcDist(p2);
		if(distP1 <= 0.12) {
			this.posX = this.posX + 0.05;
			this.posY = this.posY + 0.05;
			this.velocityX = p1.getvelocityX()*1.6;
			this.velocityY = p1.getvelocityY()*0.7;
		}
		if(distP2 <= 0.12) {
			this.posX = this.posX - 0.05;
			this.posY = this.posY + 0.05;
			this.velocityX = p2.getvelocityX()*1.6;
			this.velocityY = p2.getvelocityY()*0.7;
		}
	}
	/**
	 * when a player kicks the ball, the ball is assigned a fixed x and y velocity.
	 * We will want to look into this to possibly make a more physics based approach.
	 * @param i direction the ball should go. 0 is right, 1 is left.
	 */
	
	public void isKicked(int i) {
		if(i == 0) {
			this.velocityX = 0.02;
			this.velocityY = 0.03;
		}
		else if(i == 1) {
			this.velocityX = -0.02;
			this.velocityY = 0.03;
		}
	}
	
	public void setVelocityX(double vX) {
		this.velocityX = vX;
	}
	
	public void setVelocityY(double vY) {
		this.velocityY = vY;
	}
	
	/**
	 * calculates distance from ball to player p. Uses pythagorean theorem.
	 * @param p the player for distance to be measured
	 * @return distance between player p and ball this.
	 */
	public double calcDist(Player p) {
		double dist = Math.sqrt((this.posY - p.getPosY())*(this.posY - p.getPosY()) + (this.posX - p.getPosX())*(this.posX - p.getPosX()));
		return dist;
	}

	/**
	 * when the ball enters a goal, add a point to the correct player. 
	 * Also reset the ball's position to the middle of the field, with a starting
	 * velocity in the direction of the player who did not score.
	 * @param p1
	 * @param p2
	 */
	public boolean goal(Player p1, Player p2) {
		if(this.posX > 1.85 && this.posY < -0.4) {
			p1.goalScored();
			resetBall(1);
			p1.resetPos();
			p2.resetPos();
			return true;
		}
		if(this.posX < -1.85 && this.posY < -0.4) {
			p2.goalScored();
			resetBall(-1);
			p1.resetPos();
			p2.resetPos();
			return true;
		}
		return false;
	}
	/**
	 * after a goal, the ball should reset to a starting position and velocity.
	 * We decided the ball should start close to and in front of the player who just got scored on.
	 * @param dir direction (and position) of the restart spot of the ball after the goal.
	 */
	public void resetBall(int dir) {
		this.posX = dir;
		this.posY = 0.5;
		this.velocityX = 0;
		this.velocityY = 0;
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
	
}