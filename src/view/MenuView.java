package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.MenuController;

public class MenuView extends JFrame {
	
	private static final long serialVersionUID = -6405667967542027212L;
	
	private MenuController menuController;
    private JPanel mainPanel;
    private JButton tortueGuidee;
    private JButton tortueAleatoire;
    private JButton tortueIntelligente;

    public MenuView() {
        menuController = new MenuController(this);
        build();
    }
    
    private void build() {
        setTitle("MenuView tortue");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        tortueGuidee = new JButton();
        tortueGuidee.setSize(30, 10);
        tortueGuidee.setText("Tortue guidée");
        tortueGuidee.addActionListener(menuController);

        tortueAleatoire = new JButton();
        tortueAleatoire.setSize(30, 10);
        tortueAleatoire.setText("Tortue aléatoire");
        tortueAleatoire.addActionListener(menuController);
        
        tortueIntelligente = new JButton();
        tortueIntelligente.setSize(30, 10);
        tortueIntelligente.setText("Tortue intelligente");
        tortueIntelligente.addActionListener(menuController);

        mainPanel.add(tortueGuidee);
        mainPanel.add(tortueAleatoire);
        mainPanel.add(tortueIntelligente);

        add(mainPanel);
        setLocationRelativeTo(null);
    }
}
