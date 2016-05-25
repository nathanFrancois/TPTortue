package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.FeuilleModel;
import model.TortueModel;

public class FeuilleDessin extends JPanel implements Observer {

	private static final long serialVersionUID = -5081539632093544214L;
	
	private List<TortueView> listTortuesView;

    public FeuilleDessin(FeuilleModel feuilleModel) {
        super();
        setBackground(Color.white);
        setSize(new Dimension(600,400));
        setPreferredSize(new Dimension(600,400));
        this.listTortuesView = new ArrayList<TortueView>();

        for (TortueModel tortueModel : feuilleModel.getListTortues()) {
        	tortueModel.addObserver(this);
        	listTortuesView.add(new TortueView(tortueModel));
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
        for (TortueView tortueView : listTortuesView) {
            tortueView.drawTurtle(g);
        }
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}
}
