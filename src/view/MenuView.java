package view;

import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.MenuController;

public class MenuView extends JFrame {
	
	private static final long serialVersionUID = -6405667967542027212L;
	
	private MenuController menuController;
    private JPanel mainPanel;
    private JButton simpleGame;
    private JButton multiGame;
    private BufferedImage image;


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
        simpleGame = new JButton();
        simpleGame.setSize(30, 10);
        simpleGame.setText("Tortue guidée");
        simpleGame.addActionListener(menuController);

        multiGame = new JButton();
        multiGame.setSize(30, 10);
        multiGame.setText("Tortue aléatoire");
        multiGame.addActionListener(menuController);

        mainPanel.add(simpleGame);
        mainPanel.add(multiGame);

        add(mainPanel);
        setLocationRelativeTo(null);
    }
}
