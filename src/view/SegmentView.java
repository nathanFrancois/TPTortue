package view;

import java.awt.Graphics;

import model.SegmentModel;

public class SegmentView {
	
	private SegmentModel segmentModel;
	
	public SegmentView(SegmentModel segmentModel) {
		this.segmentModel = segmentModel;
	}
	
	public void drawSegment(Graphics graph) {
		graph.setColor(Utils.decodeColor(segmentModel.getCouleur()));
		graph.drawLine(segmentModel.getPtStart().x, segmentModel.getPtStart().y, segmentModel.getPtEnd().x, segmentModel.getPtEnd().y);
	}

}
