package model;

import java.util.ArrayList;
import java.util.List;

public class FeuilleModel {
	
	private List<TortueModel> listTortues;
	
	public FeuilleModel() {
		listTortues = new ArrayList<>();
		TortueModel tortueModel = new TortueModel();
		tortueModel.setPosition(500/2, 400/2);
		listTortues.add(tortueModel);
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

}
