import java.util.*;
import sedgewick.StdDraw;
import java.awt.Color;
public class Soccer {

	public static void main(String[] args) {
<<<<<<< HEAD
		StdDraw.setCanvasSize(1364,768);
		StdDraw.picture(0.5,0.5,"background.png");	
=======
		// TODO Auto-generated method stub
				StdDraw.setCanvasSize(1364,768);
				StdDraw.setPenColor(Color.black);
				StdDraw.filledRectangle(0.5, 0.5, 682, 384);
				StdDraw.setPenColor(Color.white);
				StdDraw.text(0.5, 0.8, "2-D Soccer");
				StdDraw.text(0.5, 0.4, "Right Click to Continue");
				StdDraw.show(0);
				StdDraw.picture(0.5,0.5,"background.png");
				while(true) {
					if(StdDraw.mousePressed()) {
						StdDraw.show(0);
					}
				}

			}
>>>>>>> branch 'dev' of https://github.com/wustlcse237sp20/project-2dsoccer_237project.git
	}

