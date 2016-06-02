package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FeuilleModel {
	
	private List<TortueModel> listTortues;
	private Random random;
	
	public FeuilleModel() {
		random = new Random();
		listTortues = new ArrayList<>();
		addTortue(new TortueModel());
	}

	public void tortueAleatoire() {
		boolean orientation = false;
		int vitesse = 0;
		int angle = 0;

		while (true) {
			tempo(100);
			for (TortueModel tortueModel : getListTortues()) {

				orientation = getRandomBoolean();
				vitesse = getRandomSpeed();
				angle = getRandomAngle();

				if(orientation)
					tortueModel.droite(angle);
				else
					tortueModel.gauche(angle);

				tortueModel.avancer(vitesse);
			}
		}
	}

	private int getRandomSpeed() {
		return (int) (Math.random() * 50);
	}

	private boolean getRandomBoolean() {
		Random random = new Random();
		return random.nextBoolean();
	}

	private int getRandomAngle() {
		return (int) (Math.random() * 360);
	}
	
	private void tempo(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addTortue(TortueModel tortueModel) {
		listTortues.add(tortueModel);
	}

	public List<TortueModel> getListTortues() {
		return listTortues;
	}
	
	public TortueModel getFirstTortueModel() {
		return listTortues.get(0);
	}

	public void reset() {
		for (TortueModel tortueModel : listTortues) {
			tortueModel.reset();
		}
	}

}
