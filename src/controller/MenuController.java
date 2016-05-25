package controller;

import model.FeuilleModel;
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


                break;
        }
    }
}
