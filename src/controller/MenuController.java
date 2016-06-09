package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.FeuilleModel;
import model.TortueAleatoire;
import model.TortueIntelligente;
import model.TortueMobile;
import model.TortueModel;
import view.FenetreView;
import view.MenuView;

public class MenuController implements ActionListener {

    private FeuilleModel model;
	private FenetreView fenetreView;
	private MenuView menuView;

	public MenuController(MenuView menuView) {
        super();
        this.menuView = menuView;
        model = new FeuilleModel();
        fenetreView = new FenetreView(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch (command) {
            case "Tortue guidée":
            	tortueGuidee();
                break;
            case "Tortue aléatoire":
            	tortueAleatoire();
                break;
            case "Tortue intelligente":
            	tortueIntelligente();
            	break;
        }
    }
    
    private void tortueGuidee() {
    	fenetreView.setVisible(true);
    	menuView.setVisible(false);
    	model.addTortue(new TortueModel());
    }
    
    private void tortueAleatoire() {
    	fenetreView.setVisible(true);
		menuView.setVisible(false);
		fenetreView.disableButton();
		for (int i=0; i<8; i++) {
			model.addTortue(new TortueAleatoire());
		}
    	tortueMobile();
    }
    
    private void tortueIntelligente() {
    	fenetreView.setVisible(true);
		menuView.setVisible(false);
		fenetreView.disableButton();
		for (int i=0; i<20; i++) {
			TortueIntelligente tortueIntelligente = new TortueIntelligente();
			tortueIntelligente.setCrayon(false);
			model.addTortue(tortueIntelligente);
		}
    	tortueMobile();
    }
    
    private void tortueMobile() {
    	Thread thread = new Thread() {
			public void run() {
                while (true) {
					for (TortueModel tortueModel : model.getListTortues()) {
                		TortueMobile tortueMobile = (TortueMobile) tortueModel;
                		tortueMobile.bouger(model.getListTortues());
                	}
					tempo(100);
                }
			}
    	};
    	thread.start();
    }
    
    private void tempo(int t) {
    	try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
