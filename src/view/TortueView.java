package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.SegmentModel;
import model.TortueModel;

public class TortueView {

    private TortueModel tortueModel;
    private Forme forme;
    private List<SegmentView> listSegmentViews;

    public TortueView(TortueModel tortueModel, Forme forme) {
        this.tortueModel = tortueModel;
        this.forme = forme;
        listSegmentViews = new ArrayList<SegmentView>();
    }

    public void drawTurtle(Graphics graph, Dimension dimension) {
        if (graph==null)
            return;
        
        updateListSegmentViews();
        
        for (SegmentView segmentView : listSegmentViews) {
        	segmentView.drawSegment(graph, dimension);
        }

        if (tortueModel.getX() < 0) {
            tortueModel.setX((int)(dimension.getWidth() + (tortueModel.getX()%dimension.getWidth())));
        }
        if (tortueModel.getX() > dimension.getWidth()) {
            tortueModel.setX((int)(tortueModel.getX()%dimension.getWidth()));
        }
        if (tortueModel.getY() < 0) {
            tortueModel.setY((int)(dimension.getHeight() + (tortueModel.getY()%dimension.getHeight())));
        }
        if (tortueModel.getY() > dimension.getHeight()) {
            tortueModel.setY((int)(tortueModel.getY()%dimension.getHeight()));
        }

        Point p = new Point(tortueModel.getX(),tortueModel.getY());
        forme.dessiner(graph, p, tortueModel.getDir());
    }

    private void updateListSegmentViews() {
    	//Copie de la liste pour eviter les acces concurrents
        List<SegmentModel> listSegmentModels = new ArrayList<SegmentModel>(tortueModel.getListSegments());
        if (listSegmentViews.size() > listSegmentModels.size()) {
			listSegmentViews.clear();
		}
        if (listSegmentViews.size() < listSegmentModels.size()) {
			int d = listSegmentViews.size();
			int f = listSegmentModels.size();
			for (int i=d; i<f; i++) {
				listSegmentViews.add(new SegmentView(listSegmentModels.get(i)));
			}
		}
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
