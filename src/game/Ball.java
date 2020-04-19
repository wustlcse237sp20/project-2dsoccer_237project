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
		if(posY > -1) {
			this.velocityY = this.velocityY - 0.0005;
		}
		if(posX < -1.9 && posY < 0.4) {
			this.posX = -1.9;
			this.velocityX = this.velocityX * -0.9;
		}
		if(posX > 1.9 && posY < 0.4) {
			this.posX = 1.9;
			this.velocityX = this.velocityX * -0.9;
		}
		if(posY < -1) {
			this.posY = -1;
			this.velocityY = this.velocityY * -0.7;
		}
		if(posY == -1) {
			this.velocityX = this.velocityX * 0.97;
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
	
}