package game;

import java.awt.Color;

import sedgewick.ArcadeKeys;
import sedgewick.StdDraw;

public class Ball {
	private double posX;
	private double posY; 
	private final double startPosX;
	private final double startPosY;
	private double velocityX = 0.02;
	private double velocityY;
	private final double radius = 0.05;
	public double distP1;
	public double distP2;
	
	public Ball(double x, double y){
		this.posX = x;
		this.posY = y;
		this.startPosX = x;
		this.startPosY = y;
	}
	
	public void draw() {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledCircle(this.posX, this.posY, this.radius);
		StdDraw.setPenColor(StdDraw.BLACK);
	}
	
	public void move() {
		updatePosition();
		
	}
	
	public void updatePosition() {
		this.posX += this.velocityX;
		this.posY += this.velocityY;
		updateVelocity();
	}
	
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
			this.velocityY = this.velocityY * -0.7;
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
	
	public void playerCollision(Player p1, Player p2) {
		distP1 = calcDist(p1);
		distP2 = calcDist(p2);
		if(distP1 <= 0.12) {
			this.posX = this.posX + 0.05;
			this.posY = this.posY + 0.05;
			this.velocityX = p1.getvelocityX()*1.6;
			this.velocityY = p1.getvelocityY()*0.4;
		}
		if(distP2 <= 0.12) {
			this.posX = this.posX - 0.05;
			this.posY = this.posY + 0.05;
			this.velocityX = p2.getvelocityX()*1.6;
			this.velocityY = p2.getvelocityY()*0.4;
		}
	}
	
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
	
	public double calcDist(Player p) {
		double dist = Math.sqrt((this.posY - p.getPosY())*(this.posY - p.getPosY()) + (this.posX - p.getPosX())*(this.posX - p.getPosX()));
		return dist;
	}

	public double getPosX() {
		return posX;
	}
	
	public double getPosY() {
		return posY;
	}
	
}

