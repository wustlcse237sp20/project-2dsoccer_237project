import java.util.*;
import sedgewick.StdDraw;
import java.awt.Color;
public class Soccer {

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
				StdDraw.filledRectangle(.5,.05,.005,.1);
				StdDraw.line(0.02, 0.5, 0.2, 0.5);
				StdDraw.line(0.8, 0.5, 0.98, 0.5);
				StdDraw.line(0.02, 0, 0.02, 0.5);
				StdDraw.line(0.98, 0, 0.98, 0.5);
				while(true) {
					if(StdDraw.mousePressed()) {
						StdDraw.show(0);
					}
				}

	}
}

