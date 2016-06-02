package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import model.SegmentModel;
import model.TortueModel;

public class TortueView {

    private TortueModel tortueModel;

    public TortueView(TortueModel tortueModel) {
        this.tortueModel = tortueModel;
    }

    public void drawTurtle(Graphics graph, Dimension dimension) {
        if (graph==null)
            return;
        
        //Copie de la liste pour eviter les acces concurrents
        List<SegmentModel> listSegments = new ArrayList<SegmentModel>(tortueModel.getListSegments());
        for (SegmentModel segmentModel : listSegments) {
        	new SegmentView(segmentModel).drawSegment(graph, dimension);
        }

        Point p = Utils.recadrer(new Point(tortueModel.getX(),tortueModel.getY()), dimension);
        Polygon arrow = new Polygon();

        double theta=TortueModel.getRatioDegRad()*(-tortueModel.getDir());
        double alpha=Math.atan( (float)TortueModel.getRb() / (float)TortueModel.getRp() );
        double r=Math.sqrt( TortueModel.getRp()*TortueModel.getRp() + TortueModel.getRb()*TortueModel.getRb() );

        Point p2=new Point((int) Math.round(p.x+r*Math.cos(theta)),
                (int) Math.round(p.y-r*Math.sin(theta)));

        arrow.addPoint(p2.x,p2.y);
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta + alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta + alpha) ));
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta - alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta - alpha) ));

        arrow.addPoint(p2.x,p2.y);
        graph.setColor(Color.green);
        graph.fillPolygon(arrow);
    }

    public TortueModel getTortueModel() {
        return tortueModel;
    }

    public void setTortueModel(TortueModel tortueModel) {
        this.tortueModel = tortueModel;
    }
    
    public Color getColor() {
    	return Utils.decodeColor(tortueModel.getCouleur());
    }
}
