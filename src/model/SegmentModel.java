package model;

import java.awt.*;

public class SegmentModel {

    private Point ptStart, ptEnd;
    private int couleur;

    public SegmentModel() {
        ptStart = new Point(0,0);
        ptEnd = new Point(0,0);
    }

    public void setPtStart(Point ptStart) {
        this.ptStart = ptStart;
    }

    public void setPtEnd(Point ptEnd) {
        this.ptEnd = ptEnd;
    }

    public Point getPtEnd() {
        return ptEnd;
    }

    public Point getPtStart() {
        return ptStart;
    }

	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}
}
