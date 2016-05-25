package view;

import java.awt.Graphics;

import model.SegmentModel;

public class SegmentView {

	private SegmentModel segmentModel;
	private TortueView tortueView;
	
	public SegmentView(SegmentModel segmentModel, TortueView tortueView) {
		this.segmentModel = segmentModel;
		this.tortueView = tortueView;
	}
	
	public void drawSegment(Graphics graph) {
		if (graph==null)
			return;

		graph.setColor(tortueView.getColor());
		graph.drawLine(segmentModel.getPtStart().x, segmentModel.getPtStart().y, segmentModel.getPtEnd().x, segmentModel.getPtEnd().y);
	}
	
}
