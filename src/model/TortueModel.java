package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class TortueModel extends Observable {

    private static final int rp=10, rb=5;
    private static final double ratioDegRad = 0.0174533;
    private List<SegmentModel> listSegments;
    private int x, y;
    private int dir;
    private boolean crayon;
    private int couleur;

	public TortueModel() {
    	listSegments = new ArrayList<SegmentModel>();
    	couleur = 0;
    }
    
    public void reset() {
		x = 0;
		y = 0;
		dir = -90;
		couleur = 0;
		crayon = true;
		listSegments.clear();
  	}

    public void avancer(int dist) {
        int newX = (int) Math.round(x+dist*Math.cos(ratioDegRad*dir));
        int newY = (int) Math.round(y+dist*Math.sin(ratioDegRad*dir));

        if (crayon) {
            SegmentModel seg = new SegmentModel();
            Point pointStart = new Point();
            Point pointEnd = new Point();

            pointStart.x = x;
            pointStart.y = y;

            pointEnd.x = newX;
            pointEnd.y = newY;

            seg.setPtStart(pointStart);
            seg.setPtEnd(pointEnd);

            listSegments.add(seg);
        }

        setPosition(newX, newY);
        draw();
        System.out.println(newX);
    }
    
    private void draw() {
    	setChanged();
    	notifyObservers();
    }

    public void setPosition(int newX, int newY) {
        x = newX;
        y = newY;
        draw();
    }

    public void droite(int ang) {
        dir = (dir + ang) % 360;
        draw();
    }

    public void gauche(int ang) {
        dir = (dir - ang) % 360;
        draw();
    }

    public List<SegmentModel> getListSegments() {
        return listSegments;
    }

    public void setListSegments(List<SegmentModel> listSegments) {
        this.listSegments = listSegments;
    }

    public static int getRp() {
        return rp;
    }

    public static int getRb() {
        return rb;
    }

    public static double getRatioDegRad() {
        return ratioDegRad;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        draw();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        draw();
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public boolean isCrayon() {
        return crayon;
    }

    public void setCrayon(boolean crayon) {
        this.crayon = crayon;
    }
    
    public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}
	
	public void couleur(int n) {
		couleur = n % 12;
	}

	public void couleurSuivante() {
	 	couleur(couleur+1);
	}
	
	public void carre() {
		for (int i=0;i<4;i++) {
			avancer(100);
			droite(90);
		}
	}

	public void poly(int n, int a) {
		for (int j=0;j<a;j++) {
			avancer(n);
			droite(360/a);
		}
	}

	public void spiral(int n, int k, int a) {
		for (int i = 0; i < k; i++) {
			couleur(couleur+1);
			avancer(n);
			droite(360/a);
			n = n+1;
		}
	}
}
