package model;

import com.sun.javafx.geom.Point2D;
import com.sun.javafx.geom.Vec2d;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TortueIntelligente extends TortueModel implements TortueMobile {

	private List<TortueModel> tortuesVision;
	private int angleVision;
	private int distanceVision;

	public TortueIntelligente() {
		super();
		this.tortuesVision = new ArrayList<>();
		distanceVision = 30;
		angleVision = 50;
	}
	
	@Override
	public void bouger(List<TortueModel> listTortueModels) {

		for (TortueModel t : listTortueModels ) {

			if(!t.equals(this) && !tortuesVision.contains(t)) {
				if(estDansVision(t) ) {
					addTortueVision(t);
				}
				else {
					removeTortueVision(t);
				}
			}
		}

		if (this.getTortuesVision().size() == 0) {
			randomVitesse();

			if(getRandom().nextInt(5) > 3){
				randomAngle();
			}
		}
		else {
			setVitesse(vitesseMoyenne());
			setDir(directionMoyenne());
		}
		avancer();
	}

	private void removeTortueVision(TortueModel t) {
		tortuesVision.remove(t);
	}

	private int vitesseMoyenne(){
		int sommeVitesse = 0;

		for (TortueModel t : getTortuesVision()) {
			sommeVitesse += t.getVitesse();
		}
		sommeVitesse = (sommeVitesse + getVitesse())/(getTortuesVision().size()+1);

		return sommeVitesse;
	}

	private int directionMoyenne(){
		int sommeDirection = 0;

		for (TortueModel t : getTortuesVision()) {
			sommeDirection += t.getDir();
		}
		sommeDirection = (sommeDirection+getDir())/(getTortuesVision().size()+1);

		return sommeDirection;
	}

	private boolean estDansVision(TortueModel tortueModel){

		int newX = (int) Math.round(getX()+getVitesse()*Math.cos(getRatioDegRad()*getDir()));
		int newY = (int) Math.round(getY()+getVitesse()*Math.sin(getRatioDegRad()*getDir()));

		Point2D a = new Point2D(newX, newY);
		Point2D b = new Point2D(tortueModel.getX(), tortueModel.getY());
		Point2D origin = new Point2D(getX(), getY());

		if((getAngle(a, origin, b) <= angleVision)
				&& (Math.sqrt(sqr(getX() - tortueModel.getX()) + sqr(getY() - tortueModel.getY())) < distanceVision )) {
			return true;
		}
		return false;
	}



	public List<TortueModel> getTortuesVision() {
		return tortuesVision;
	}

	public void setTortuesVision(List<TortueModel> tortuesVision) {
		this.tortuesVision = tortuesVision;
	}

	public void addTortueVision(TortueModel tortueModel) {
		tortuesVision.add(tortueModel);
	}

	public double getAngle(Point2D a, Point2D origine, Point2D c) {

		Vec2d v1 = vector(a, origine);
		Vec2d v2 = vector(c, origine);

		double cosA = (v1.x*v2.x + v1.y*v2.y) / (Math.sqrt( sqr(v1.x)+sqr(v1.y) )*Math.sqrt( sqr(v2.x)+sqr(v2.y) ) );

		double aRad = Math.toDegrees(Math.acos(cosA));

		return aRad;
	}

	private double sqr(double a) {
		return a*a;
	}

	public static Vec2d vector(Point2D a, Point2D b) {
		return new Vec2d(
				b.x-a.x,
				b.y-a.y
		);
	}
}
