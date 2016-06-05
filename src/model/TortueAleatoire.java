package model;

import java.util.List;
import java.util.Random;

public class TortueAleatoire extends TortueModel implements TortueMobile {

	public TortueAleatoire() {
		super();
	}
	
	@Override
	public void bouger(List<TortueModel> listTortueModels) {
		randomVitesse();

		if(getRandom().nextInt(5) > 3) {
			randomAngle();
		}
		avancer();
	}
}
