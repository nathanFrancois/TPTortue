package model;

import java.util.List;
import java.util.Random;

public class TortueAleatoire extends TortueModel implements TortueMobile {
	
	private boolean orientation;
	private int vitesse;
	private int angle;
	private Random random;
	
	public TortueAleatoire() {
		super();
		orientation = false;
		vitesse = 0;
		angle = 0;
		random = new Random();
	}
	
	@Override
	public void bouger(List<TortueModel> listTortueModels) {
		randomOrientation();
		randomVitesse();
		randomAngle();

		if (orientation) {
			droite(angle);
		} else {
			gauche(angle);
		}
		avancer(vitesse);
	}
	
	private void randomVitesse() {
		vitesse = random.nextInt(50);
	}
	
	private void randomAngle() {
		angle = random.nextInt(360);
	}
	
	private void randomOrientation() {
		orientation = random.nextBoolean();
	}

}
