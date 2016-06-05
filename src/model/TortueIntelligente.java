package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TortueIntelligente extends TortueModel implements TortueMobile {

	private List<TortueModel> tortuesVision;
	private int angleVision;
	private int distanceVision;
	private Random random;

	public TortueIntelligente() {
		super();
		random = new Random();
		this.tortuesVision = new ArrayList<>();
		distanceVision = 50;
		angleVision = 180;
	}
	
	@Override
	public void bouger(List<TortueModel> listTortueModels) {

		for (TortueModel t : listTortueModels ) {

			if(!t.equals(this)){
				if(estDansVision(t) && !tortuesVision.contains(t)) {
					addTortueVision(t);
				}
			}
		}

		if (this.getTortuesVision().isEmpty()) {
			randomVitesse();

			if(random.nextInt(3) > 1){
				randomAngle();
			}
		}
		else {
			setVitesse(vitesseMoyenne());
			setDir(directionMoyenne());
		}
		avancer();
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

		double a = Math.toDegrees(Math.atan2(tortueModel.getY(), tortueModel.getX()));
		if(a < 0) {
			a += 360;
		}

		if( (Math.sqrt(sqr(getX() - tortueModel.getX()) + sqr(getY() - tortueModel.getY())) < distanceVision )
				&& (Math.abs(a-getDir()) <= angleVision)) {
			return true;
		}
		return false;
	}

	private double sqr(double a) {
		return a*a;
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

	private void randomVitesse() {
		setVitesse(random.nextInt(40));
		while (getVitesse() == 0) {
			setVitesse(random.nextInt(40));
		}
	}

	private void randomAngle() {
		setDir(random.nextInt(360));
	}
}
