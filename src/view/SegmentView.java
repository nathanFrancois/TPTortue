package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import model.SegmentModel;

public class SegmentView {
	
	private SegmentModel segmentModel;
	
	public SegmentView(SegmentModel segmentModel) {
		this.segmentModel = segmentModel;
	}
	
	public void drawSegment(Graphics graph, Dimension dimension) {
		graph.setColor(Utils.decodeColor(segmentModel.getCouleur()));

		Point pStart = Utils.recadrer(segmentModel.getPtStart(), dimension);
		Point pStart2 = new Point(
				pStart.x + (segmentModel.getPtEnd().x - segmentModel.getPtStart().x),
				pStart.y + (segmentModel.getPtEnd().y - segmentModel.getPtStart().y)
				);
		Point pEnd = Utils.recadrer(segmentModel.getPtEnd(), dimension);
		Point pEnd2 = new Point(
				pEnd.x - (segmentModel.getPtEnd().x - segmentModel.getPtStart().x),
				pEnd.y - (segmentModel.getPtEnd().y - segmentModel.getPtStart().y)
				);
		graph.drawLine(pStart.x, pStart.y, pStart2.x, pStart2.y);
		graph.drawLine(pEnd.x, pEnd.y, pEnd2.x, pEnd2.y);
	}

}
