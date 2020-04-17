package game;

import java.awt.Color;

import sedgewick.ArcadeKeys;
import sedgewick.StdDraw;

public class Ball {
	private double posX;
	private double posY; 
	private final double startPosX;
	private final double startPosY;
	private final double radius = 0.1;
	
	public Ball(double x, double y){
		this.posX = x;
		this.posY = y;
		this.startPosX = x;
		this.startPosY = y;
	}
	
	public void draw() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.circle(this.posX, this.posY, this.radius);
	}
	
}