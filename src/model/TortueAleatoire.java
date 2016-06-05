package model;

import java.util.List;
import java.util.Random;

public class TortueAleatoire extends TortueModel implements TortueMobile {
	
	private Random random;
	
	public TortueAleatoire() {
		super();
		random = new Random();
	}
	
	@Override
	public void bouger(List<TortueModel> listTortueModels) {
		randomVitesse();

		if(random.nextInt(5) > 3) {
			randomAngle();
		}
		avancer();
	}
	
	private void randomVitesse() {
		setVitesse(random.nextInt(50));
	}
	
	private void randomAngle() {
		setDir(random.nextInt(360));
	}

}
