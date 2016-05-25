package model;

import java.awt.Point;
import java.util.List;

public class TortueModel {

    private static final int rp=10, rb=5;
    private static final double ratioDegRad = 0.0174533;
    private List<SegmentModel> listSegments;
    private int x, y;
    private int dir;
    private boolean crayon;

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
        System.out.println(newX);
    }

    public void setPosition(int newX, int newY) {
        x = newX;
        y = newY;
    }

    public void droite(int ang) {
        dir = (dir + ang) % 360;
    }

    public void gauche(int ang) {
        dir = (dir - ang) % 360;
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
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
}
