import java.util.*;
import sedgewick.StdDraw;
import java.awt.Color;
public class Soccer {
	private Player player1;
	private Player player2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				StdDraw.setCanvasSize(1364,768);
				StdDraw.setPenColor(Color.black);
				StdDraw.filledRectangle(0.5, 0.5, 682, 384);
				StdDraw.setPenColor(Color.white);
				StdDraw.text(0.5, 0.8, "2-D Soccer");
				StdDraw.text(0.5, 0.4, "Right Click to Continue");
				StdDraw.show(0);
				StdDraw.picture(0.5,0.5,"background.png");
				StdDraw.setPenColor();
//				StdDraw.filledRectangle(.5,.05,.005,.1);
//				StdDraw.line(0.02, 0.5, 0.2, 0.5);
//				StdDraw.line(0.8, 0.5, 0.98, 0.5);
//				StdDraw.line(0.02, 0, 0.02, 0.5);
//				StdDraw.line(0.98, 0, 0.98, 0.5);
				while(true) {
					if(StdDraw.mousePressed()) {
						StdDraw.show(0);
						break;
					}
				}
				StdDraw.setScale(-1,1);
				Player player1 = new Player(-.5, -1, 0); //Not calling "Player" causes static/non static error
				Player player2 = new Player(0.5, -1, 1);
				while(true) {
					StdDraw.clear();
					StdDraw.picture(0,0,"background.png");
					StdDraw.setPenColor();
					StdDraw.filledRectangle(0,-0.95,0.01,.2);
					StdDraw.filledRectangle(-1.0, 0.3, 0.1, 0.7);
					StdDraw.filledRectangle(1.0,0.3,0.1,0.7);
					player1.draw();
					player2.draw();
					player1.move();
					player2.move();
					StdDraw.show(1);
					if(player1.getPosY()>-0.95) {
						player1.gravity();
					}
					if(player2.getPosY()>-0.95) {
						player2.gravity();
					}
				}
	}
}

