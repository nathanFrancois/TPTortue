package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.FeuilleModel;
import model.TortueModel;

public class FeuilleDessin extends JPanel implements Observer {

	private static final long serialVersionUID = -5081539632093544214L;
	private FeuilleModel feuilleModel;
	
    public FeuilleDessin(FeuilleModel feuilleModel) {
        super();
        this.feuilleModel = feuilleModel;
        setBackground(Color.white);
        setSize(new Dimension(600,400));
        setPreferredSize(new Dimension(600,400));

        for (TortueModel tortueModel : feuilleModel.getListTortues()) {
        	tortueModel.addObserver(this);
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
        for (TortueModel tortueModel : feuilleModel.getListTortues()) {
            new TortueView(tortueModel).drawTurtle(g, getSize());
        }
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}
}
