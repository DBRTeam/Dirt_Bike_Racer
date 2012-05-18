package tests;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;
import game.Bike;
import game.Session;

import org.junit.Test;

/**
 * Tests everything in the Session class.
 *
 * @author schuenjr.
 *         Created Apr 13, 2012.
 */
public class TestsforSession {

	/**
	 * Makes sure that a session can be created.
	 */
	@Test
	public void testSessionisCreated() {
		Session test = new Session();
		assertEquals(test.getClass(),Session.class);
	}
	
	/**
	 * Makes sure that a new session creates a bike.
	 */
	@Test
	public void testBikeisCreated() {
		Session test = new Session();
		assertEquals(test.getBike().getClass(), Bike.class);
	}
	/**
	 * Makes sure that a session can load a level from a file.
	 */
	@Test
	public void testTerrainIsReadInCorrectlyFromFile() {
		String testFileName = "Level1.txt";
		File testFile = new File(testFileName);
		assertTrue(testFile.exists());
		Session testSession = new Session(testFile,1);
		ArrayList<Point2D.Double> actualTrack = testSession.getLevel();
		ArrayList<Point2D.Double> testTrack = new ArrayList<Point2D.Double>();
		testTrack.add(new Point2D.Double(5,390));
		testTrack.add(new Point2D.Double(275,390));
		testTrack.add(new Point2D.Double(305,365));
		testTrack.add(new Point2D.Double(360,345));
		testTrack.add(new Point2D.Double(600,345));
		testTrack.add(new Point2D.Double(800,175));
		for (int i = 1; i < actualTrack.size(); i++) {
			assertEquals(testTrack.get(i), actualTrack.get(i));
		}

	}
	/**
	 * Makes sure that a session can load a level from an
	 * ArrayList.
	 */
	public void testTerrainIsReadInCorrectlyFromArrayList() {
		ArrayList<Point2D.Double> actualTrack = new ArrayList<Point2D.Double>();
		actualTrack.add(new Point2D.Double(0,0));
		actualTrack.add(new Point2D.Double(4,6));
		actualTrack.add(new Point2D.Double(8,12));
		actualTrack.add(new Point2D.Double(12,12));
		actualTrack.add(new Point2D.Double(16,6));
		actualTrack.add(new Point2D.Double(20,0));
		Session testSession = new Session(actualTrack);
		actualTrack = testSession.getLevel();
		ArrayList<Point2D.Double> testTrack = new ArrayList<Point2D.Double>();
		testTrack.add(new Point2D.Double(0,0));
		testTrack.add(new Point2D.Double(4,6));
		testTrack.add(new Point2D.Double(8,12));
		testTrack.add(new Point2D.Double(12,12));
		testTrack.add(new Point2D.Double(16,6));
		testTrack.add(new Point2D.Double(20,0));
		for (int i = 1; i < actualTrack.size(); i++) {
			assertEquals(testTrack.get(i), actualTrack.get(i));
		}
	}
	
	/**
	 * Makes sure that a bike can crash from an impact.
	 */
	@Test
	public void testBikeCrashFromForce() {
		ArrayList<Point2D.Double> track = new ArrayList<Point2D.Double>();
		track.add(new Point2D.Double(0,0)); track.add(new Point2D.Double(1,0));
		track.add(new Point2D.Double(2,1)); track.add(new Point2D.Double(3,1));
		track.add(new Point2D.Double(4,0)); track.add(new Point2D.Double(5,0));
		track.add(new Point2D.Double(6,2)); track.add(new Point2D.Double(7,1));
		track.add(new Point2D.Double(8,0)); track.add(new Point2D.Double(9,0));
		Session testSession = new Session(track);
		testSession.getBike().UpdateRotation(20);
		assertTrue(testSession.bikeCrash());
	}

	/**
	 * Makes sure that a bike can crash from landing with bad
	 * rotation.
	 */
	@Test
	public void testBikeCrashFromFlip() {
		ArrayList<Point2D.Double> track = new ArrayList<Point2D.Double>();
		track.add(new Point2D.Double(0,0)); track.add(new Point2D.Double(1,0));
		track.add(new Point2D.Double(2,1)); track.add(new Point2D.Double(3,1));
		track.add(new Point2D.Double(4,0)); track.add(new Point2D.Double(5,0));
		track.add(new Point2D.Double(6,2)); track.add(new Point2D.Double(7,1));
		track.add(new Point2D.Double(8,0)); track.add(new Point2D.Double(9,0));
		Session testSession = new Session(track);
		testSession.getBike().UpdateRotation(-100);
		assertTrue(testSession.bikeCrash());
	}
	
	/**
	 * Makes sure that a bike doesn't crash from an impact
	 * that shouldn't cause a crash.
	 */
	@Test
	public void testBikeDoesntFalseCrashFromForce() {
		ArrayList<Point2D.Double> track = new ArrayList<Point2D.Double>();
		track.add(new Point2D.Double(0,0)); track.add(new Point2D.Double(1,0));
		track.add(new Point2D.Double(2,1)); track.add(new Point2D.Double(3,1));
		track.add(new Point2D.Double(4,0)); track.add(new Point2D.Double(5,0));
		track.add(new Point2D.Double(6,2)); track.add(new Point2D.Double(7,1));
		track.add(new Point2D.Double(8,0)); track.add(new Point2D.Double(9,0));
		Session testSession = new Session(track);
		testSession.getBike().UpdateRotation(0);
		assertFalse(testSession.bikeCrash());
	}

	/**
	 * Makes sure that a bike doesn't crash when it has an acceptable
	 * rotation.
	 */
	@Test
	public void testBikeDoesntFalseCrashFromFlip() {
		ArrayList<Point2D.Double> track = new ArrayList<Point2D.Double>();
		track.add(new Point2D.Double(0,0)); track.add(new Point2D.Double(1,0));
		track.add(new Point2D.Double(2,1)); track.add(new Point2D.Double(3,1));
		track.add(new Point2D.Double(4,0)); track.add(new Point2D.Double(5,0));
		track.add(new Point2D.Double(6,2)); track.add(new Point2D.Double(7,1));
		track.add(new Point2D.Double(8,0)); track.add(new Point2D.Double(9,0));
		Session testSession = new Session(track);
		testSession.getBike().UpdateRotation(-10);
		assertFalse(testSession.bikeCrash());
	}
	

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testTimeIsTrackedCorrectly() {
		//TODO: Write Test where time can be measured
	}
	
	/**
	 * Tests that the game receives input from the up button
	 * @throws AWTException 
	 */
	@Test
	public void testInputforUp() throws AWTException {
		Session test = new Session();
		Robot gamer = new Robot();
		gamer.keyPress(KeyEvent.VK_UP);
		assertTrue(test.physics.up);
	}
	
	/**
	 * Tests that the game receives input from the up button
	 * @throws AWTException 
	 */
	@Test
	public void testInputforDown() throws AWTException {
		Session test = new Session();
		Robot gamer = new Robot();
		gamer.keyPress(KeyEvent.VK_DOWN);
		assertTrue(test.physics.down);
	}
	
	/**
	 * Tests that the game receives input from the up button
	 * @throws AWTException 
	 */
	@Test
	public void testInputforLeft() throws AWTException {
		Session test = new Session();
		Robot gamer = new Robot();
		gamer.keyPress(KeyEvent.VK_LEFT);
		assertTrue(test.physics.left);
	}
	
	/**
	 * Tests that the game receives input from the up button
	 * @throws AWTException 
	 */
	@Test
	public void testInputforRight() throws AWTException {
		Session test = new Session();
		Robot gamer = new Robot();
		gamer.keyPress(KeyEvent.VK_RIGHT);
		assertTrue(test.physics.right);
	}

}