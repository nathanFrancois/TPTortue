import javax.swing.SwingUtilities;

import model.Model;
import view.FenetreView;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Model model = new Model();
                FenetreView fenetreView = new FenetreView(model);
                fenetreView.setVisible(true);
            }
        });
    }
}