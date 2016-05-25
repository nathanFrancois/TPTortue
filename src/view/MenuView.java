package view;

import controller.MenuController;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class MenuView extends JFrame {

    private MenuController menuController;
    private JPanel mainPanel;
    private JButton simpleGame;
    private JButton multiGame;
    private BufferedImage image;


    public MenuView(){

        menuController = new MenuController();

        mainPanel = new JPanel();
        setTitle("MenuView tortue");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
    }
}
