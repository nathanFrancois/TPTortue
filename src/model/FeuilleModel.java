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
		int v = 10;
		int action = 0;
		while (true) {
			tempo(100);
			for (TortueModel tortueModel : listTortues) {
				action = random.nextInt(3);
				switch (action) {
				case 0:
					tortueModel.avancer(v);
					break;
				case 1:
					tortueModel.droite(v);
					break;
				case 2:
					tortueModel.gauche(v);
					break;
				}
			}
		}
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
