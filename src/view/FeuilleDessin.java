package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import model.Model;
import model.TortueModel;

public class FeuilleDessin extends JPanel {

	private static final long serialVersionUID = -5081539632093544214L;
	
	private List<TortueView> listTortues;

    public FeuilleDessin(Model model) {
        super();
        setBackground(Color.white);
        setSize(new Dimension(600,400));
        setPreferredSize(new Dimension(600,400));
        this.listTortues = new ArrayList<TortueView>();
        for (TortueModel tortueModel : model.getListTortues()) {
        	listTortues.add(new TortueView(tortueModel));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color c = g.getColor();

        Dimension dim = getSize();
        g.setColor(Color.white);
        g.fillRect(0,0,dim.width, dim.height);
        g.setColor(c);

        showTurtles(g);
    }

    public void showTurtles(Graphics g) {
        for (TortueView tortueView : listTortues) {
            tortueView.drawTurtle(g);
        }
    }
}
