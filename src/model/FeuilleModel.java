package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RunnableFuture;

public class FeuilleModel {
	
	private List<TortueModel> listTortues;
	
	public FeuilleModel() {
		listTortues = new ArrayList<>();
		TortueModel tortueModel = new TortueModel();
		tortueModel.setPosition(500/2, 400/2);
		listTortues.add(tortueModel);
	}

	public void tortueAleatoire() {

		Thread thread = new Thread() {
			public void run(){
				for(int i = 0 ; i<3 ; i++){
					int v = 15;
					for (TortueModel tortueModel : getListTortues()) {
						tortueModel.avancer(v);
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		thread.start();
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
