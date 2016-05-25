package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.FeuilleModel;
import model.TortueModel;
import view.FenetreView;

public class FenetreController implements ActionListener {

    private FeuilleModel model;
    private FenetreView fenetreView;

    public FenetreController(FenetreView fenetreView, FeuilleModel model) {
        this.model = model;
        this.fenetreView = fenetreView;
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
            case "Lever":
            	for (TortueModel tortueModel : model.getListTortues()) {
            		tortueModel.setCrayon(false);
                }
            	break;
            case "Baisser":
            	for (TortueModel tortueModel : model.getListTortues()) {
            		tortueModel.setCrayon(true);
                }
            	break;
            case "Proc1":
            	for (TortueModel tortueModel : model.getListTortues()) {
            		tortueModel.carre();
                }
            	break;
            case "Proc2":
            	for (TortueModel tortueModel : model.getListTortues()) {
            		tortueModel.poly(60,8);
                }
            	break;
            case "Proc3":
            	for (TortueModel tortueModel : model.getListTortues()) {
            		tortueModel.spiral(50,40,6);
                }
            	break;
            case "Effacer":
            	//TODO
            	break;
            case "Quitter":
            	//TODO
            	break;
            	//TODO: corriger
            case "colorList":
            	int n = fenetreView.getColorList().getSelectedIndex();
            	for (TortueModel tortueModel : model.getListTortues()) {
            		tortueModel.setCouleur(n);
                }
            	break;
        }
    }
}
