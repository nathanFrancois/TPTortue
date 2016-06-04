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
	private FeuilleModel feuilleModel;
	private List<TortueView> listTortueViews;
	
    public FeuilleDessin(FeuilleModel feuilleModel) {
        super();
        this.feuilleModel = feuilleModel;
        listTortueViews = new ArrayList<TortueView>();
        setBackground(Color.white);
        setSize(new Dimension(600,400));
        setPreferredSize(new Dimension(600,400));

        feuilleModel.addObserver(this);
        for (TortueModel tortueModel : feuilleModel.getListTortues()) {
        	tortueModel.addObserver(this);
        	listTortueViews.add(new TortueView(tortueModel, new FormeTriangle()));
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
        for (TortueView tortueView : listTortueViews) {
            tortueView.drawTurtle(g, getSize());
        }
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		if (listTortueViews.size() != feuilleModel.getListTortues().size()) {
			int d = listTortueViews.size();
			int f = feuilleModel.getListTortues().size();
			for (int i=d; i<f; i++) {
				TortueModel tortueModel = feuilleModel.getListTortues().get(i);
				tortueModel.addObserver(this);
				listTortueViews.add(new TortueView(tortueModel, new FormeTriangle()));
			}
		}
		repaint();
	}
}
