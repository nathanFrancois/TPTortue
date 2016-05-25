package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import model.TortueModel;
import view.FenetreView;

public class FenetreController implements ActionListener {

    private FenetreView fenetreView;
    private Model model;

    public FenetreController(FenetreView fenetreView, Model model) {
        this.fenetreView = fenetreView;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();

        // actions des boutons du haut
        switch (c) {
            case "Avancer":
                System.out.println("command avancer");
                try {
                    int v = 15;
                    for (TortueModel tortueModel : model.getListTortues()) {
                    	tortueModel.avancer(v);
                    }
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre");
                }

                break;
            case "Droite":
                try {
                    int v = 15;
                    for (TortueModel tortueModel : model.getListTortues()) {
                    	tortueModel.droite(v);
                    }
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : ");
                }
                break;
            case "Gauche":
                try {
                    int v = 15;
                    for (TortueModel tortueModel : model.getListTortues()) {
                    	tortueModel.gauche(v);
                    }
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : ");
                }
                break;
        }

        fenetreView.getFeuille().repaint();
    }
}
