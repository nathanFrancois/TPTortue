package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Random;

import model.TortueModel;

public class FormeTriangle implements Forme {
	
	private Color color;
	
	public FormeTriangle() {
		Random random = new Random();
		color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
	}

	public FormeTriangle(Color color) {
		super();
		this.color = color;
	}

	@Override
	public void dessiner(Graphics graph, Point position, int direction) {
		Polygon arrow = new Polygon();

        double theta=TortueModel.getRatioDegRad()*(-direction);
        double alpha=Math.atan( (float)TortueModel.getRb() / (float)TortueModel.getRp() );
        double r=Math.sqrt( TortueModel.getRp()*TortueModel.getRp() + TortueModel.getRb()*TortueModel.getRb() );

        Point p2=new Point((int) Math.round(position.x+r*Math.cos(theta)),
                (int) Math.round(position.y-r*Math.sin(theta)));

        arrow.addPoint(p2.x,p2.y);
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta + alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta + alpha) ));
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta - alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta - alpha) ));

        arrow.addPoint(p2.x,p2.y);
        graph.setColor(color);
        graph.fillPolygon(arrow);
	}

}
