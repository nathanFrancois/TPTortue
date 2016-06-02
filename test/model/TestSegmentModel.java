package model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class TestSegmentModel {
	
	@Test
	public void testAjoutSegment() {
		TortueModel tortueModel = new TortueModel();
		Point pStart = new Point(tortueModel.getX(), tortueModel.getY());
		tortueModel.avancer(10);
		Point pEnd = new Point(tortueModel.getX(), tortueModel.getY());
		
		assertEquals(1, tortueModel.getListSegments().size());
		SegmentModel segmentModel = tortueModel.getListSegments().get(0);
		assertEquals(pStart, segmentModel.getPtStart());
		assertEquals(pEnd, segmentModel.getPtEnd());
	}
	
	@Test
	public void testNonAjoutSegment() {
		TortueModel tortueModel = new TortueModel();
		tortueModel.setCrayon(false);
		tortueModel.avancer(10);
		
		assertTrue(tortueModel.getListSegments().isEmpty());
	}

}
