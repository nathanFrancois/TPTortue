import javax.swing.SwingUtilities;

import view.MenuView;

public class Main {

    public static void main(String[] args) {
    	
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MenuView menu = new MenuView();
                menu.setVisible(true);
            }
        });
    }
}