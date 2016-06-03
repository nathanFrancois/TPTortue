package model;

import java.util.ArrayList;
import java.util.List;

public class FeuilleModel {
	
	private List<TortueModel> listTortues;
	
	public FeuilleModel() {
		listTortues = new ArrayList<>();
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
