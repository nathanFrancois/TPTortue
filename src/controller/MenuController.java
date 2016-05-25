package controller;

import model.FeuilleModel;
import model.TortueModel;
import view.FenetreView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {


    public MenuController() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch (command) {
            case "Tortue guidée":
                FeuilleModel model = new FeuilleModel();
                FenetreView fenetreView = new FenetreView(model);
                fenetreView.setVisible(true);

                break;

            case "Tortue aléatoire":
                FeuilleModel model1 = new FeuilleModel();
                FenetreView fenetreView1 = new FenetreView(model1);
                fenetreView1.disableButton();
                fenetreView1.setVisible(true);
                model1.tortueAleatoire();

                break;
        }
    }
}
