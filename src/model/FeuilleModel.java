package model;

import java.util.ArrayList;
import java.util.List;

public class FeuilleModel {
	
	private List<TortueModel> listTortues;
	
	public FeuilleModel() {
		listTortues = new ArrayList<>();
		TortueModel tortueModel = new TortueModel();
		listTortues.add(tortueModel);
	}

	public void tortueAleatoire() {
		int v = 15;
		for (int i = 0 ; i<3 ; i++) {
			tempo();
			for (TortueModel tortueModel : getListTortues()) {
				tortueModel.avancer(v);
			}
		}
	}
	
	private void tempo() {
		try {
			Thread.sleep(100);
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
