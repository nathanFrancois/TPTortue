import javax.swing.SwingUtilities;

import model.FeuilleModel;
import view.FenetreView;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FeuilleModel model = new FeuilleModel();
                FenetreView fenetreView = new FenetreView(model);
                fenetreView.setVisible(true);
            }
        });
    }
}