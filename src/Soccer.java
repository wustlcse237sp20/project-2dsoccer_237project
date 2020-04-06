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
				while(true) {
					if(StdDraw.mousePressed()) {
						StdDraw.show(0);
					}
				}

	}
}

