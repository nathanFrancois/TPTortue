package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class Utils {
	
	public static Color decodeColor(int c) {
		switch(c) {
			case 0: return(Color.black);
			case 1: return(Color.blue);
			case 2: return(Color.cyan);
			case 3: return(Color.darkGray);
			case 4: return(Color.red);
			case 5: return(Color.green);
			case 6: return(Color.lightGray);
			case 7: return(Color.magenta);
			case 8: return(Color.orange);
			case 9: return(Color.gray);
			case 10: return(Color.pink);
			case 11: return(Color.yellow);
			default : return(Color.black);
		}
	}
	
	public static Point recadrer(Point point, Dimension dimension) {
		Point p = new Point(point.x, point.y);
		if (p.getX() < 0) {
            p.setLocation((dimension.getWidth() + (p.getX()%dimension.getWidth())), p.getY());
        }
        if (p.getX() > dimension.getWidth()) {
            p.setLocation(p.getX()%dimension.getWidth(), p.getY());
        }
        if (p.getY() < 0) {
            p.setLocation(p.getX(), (dimension.getHeight() + (p.getY()%dimension.getHeight())));
        }
        if (p.getY() > dimension.getHeight()) {
            p.setLocation(p.getX(), p.getY()%dimension.getHeight());
        }
        return p;
	}
	
}
