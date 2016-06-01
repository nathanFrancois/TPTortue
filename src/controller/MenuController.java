package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.FeuilleModel;
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
            	fenetreView.setVisible(true);
            	menuView.setVisible(false);
                break;

            case "Tortue aléatoire":
            	Thread thread = new Thread() {
        			public void run() {
        				fenetreView.setVisible(true);
        				menuView.setVisible(false);
        				fenetreView.disableButton();
                        model.tortueAleatoire();
        			}
            	};
            	thread.start();
                break;
        }
    }
}
