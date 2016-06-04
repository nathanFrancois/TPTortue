package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class FeuilleModel extends Observable {
	
	private List<TortueModel> listTortues;
	
	public FeuilleModel() {
		listTortues = new ArrayList<>();
	}

	public void addTortue(TortueModel tortueModel) {
		listTortues.add(tortueModel);
		setChanged();
		notifyObservers();
	}

	public List<TortueModel> getListTortues() {
		return listTortues;
	}

	public void reset() {
		for (TortueModel tortueModel : listTortues) {
			tortueModel.reset();
		}
	}

}
