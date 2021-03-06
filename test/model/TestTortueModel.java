package model;

import org.junit.Test;

import static org.junit.Assert.*;


public class TestTortueModel {
	
	@Test
	public void testInstanciationTortue() {
		TortueModel tortueModel = new TortueModel();
		tortueModel.getDir();
		assertEquals(270, tortueModel.getDir());
		assertTrue(tortueModel.getListSegments().isEmpty());
		assertTrue(tortueModel.isCrayon());
	}

	@Test
	public void testAvancerHaut() {
		TortueModel tortueModel = new TortueModel();
		int x = tortueModel.getX();
		int y = tortueModel.getY();
		tortueModel.setDir(270);
		tortueModel.setVitesse(1);
		tortueModel.avancer();
		assertEquals(x, tortueModel.getX());
		assertEquals(y-1, tortueModel.getY());
	}
	
	@Test
	public void testAvancerDroite() {
		TortueModel tortueModel = new TortueModel();
		int x = tortueModel.getX();
		int y = tortueModel.getY();
		tortueModel.setDir(0);
		tortueModel.setVitesse(2);
		tortueModel.avancer();
		assertEquals(x+2, tortueModel.getX());
		assertEquals(y, tortueModel.getY());
	}
	
	@Test
	public void testAvancerBas() {
		TortueModel tortueModel = new TortueModel();
		int x = tortueModel.getX();
		int y = tortueModel.getY();
		tortueModel.setDir(90);
		tortueModel.setVitesse(3);
		tortueModel.avancer();
		assertEquals(x, tortueModel.getX());
		assertEquals(y+3, tortueModel.getY());
	}
	
	@Test
	public void testAvancerGauche() {
		TortueModel tortueModel = new TortueModel();
		int x = tortueModel.getX();
		int y = tortueModel.getY();
		tortueModel.setDir(180);
		tortueModel.setVitesse(4);
		tortueModel.avancer();
		assertEquals(x-4, tortueModel.getX());
		assertEquals(y, tortueModel.getY());
	}
	
	@Test
	public void testAvancerLimite() {
		TortueModel tortueModel = new TortueModel();
		int x = tortueModel.getX();
		int y = tortueModel.getY();
		tortueModel.setDir(-90);
		tortueModel.setVitesse(0);
		tortueModel.avancer();
		assertEquals(x, tortueModel.getX());
		assertEquals(y, tortueModel.getY());

		tortueModel.setVitesse(-1);
		tortueModel.avancer();
		assertEquals(x, tortueModel.getX());
		assertEquals(y + 1, tortueModel.getY());
	}
	
	@Test
	public void testTournerDroite() {
		TortueModel tortueModel = new TortueModel();
		int dir = tortueModel.getDir();
		tortueModel.droite(0);
		assertEquals(dir, tortueModel.getDir());
		tortueModel.droite(10);
		assertEquals(dir + 10, tortueModel.getDir());
		tortueModel.droite(-5);
		assertEquals(dir + 5, tortueModel.getDir());
	}
	
	@Test
	public void testTournerGauche() {
		TortueModel tortueModel = new TortueModel();
		int dir = tortueModel.getDir();
		tortueModel.gauche(0);
		assertEquals(dir, tortueModel.getDir());
		tortueModel.gauche(10);
		assertEquals(dir - 10, tortueModel.getDir());
		tortueModel.gauche(-5);
		assertEquals(dir - 5, tortueModel.getDir());
	}
	
	@Test
	public void testTournerLimite() {
		TortueModel tortueModel = new TortueModel();
		tortueModel.setDir(0);
		
		tortueModel.droite(360);
		assertEquals(0, tortueModel.getDir());
		tortueModel.droite(-360);
		assertEquals(0, tortueModel.getDir());
		
		tortueModel.gauche(360);
		assertEquals(0, tortueModel.getDir());
		tortueModel.gauche(-360);
		assertEquals(0, tortueModel.getDir());
	}

}
