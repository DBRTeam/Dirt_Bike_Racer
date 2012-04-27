package tests;

import static org.junit.Assert.*;

import java.awt.Point;
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
	 * Makes sure that a session can read a level from a file.
	 */
	@Test
	public void testTerrainIsReadInCorrectlyFromFile() {
		String testFileName = "testLevel.txt";
		File testFile = new File(testFileName);
		assertTrue(testFile.exists());
		Session testSession = new Session(testFile);
		ArrayList<Point> actualTrack = testSession.getLevel();
		ArrayList<Point> testTrack = new ArrayList<Point>();
		testTrack.add(new Point(0,0));
		testTrack.add(new Point(4,6));
		testTrack.add(new Point(8,12));
		testTrack.add(new Point(12,12));
		testTrack.add(new Point(16,6));
		testTrack.add(new Point(20,0));
		for (int i = 1; i < actualTrack.size(); i++) {
			assertEquals(testTrack.get(i), actualTrack.get(i));
		}

	}
	
	/**
	 * Makes sure that a session can make a level from an ArrayList
	 */
	@Test
	public void testTerrainIsReadInCorrectlyFromArrayList() {
		ArrayList<Point> actualTrack = new ArrayList<Point>();
		actualTrack.add(new Point(0,0));
		actualTrack.add(new Point(4,6));
		actualTrack.add(new Point(8,12));
		actualTrack.add(new Point(12,12));
		actualTrack.add(new Point(16,6));
		actualTrack.add(new Point(20,0));
		Session testSession = new Session(actualTrack);
		actualTrack = testSession.getLevel();
		ArrayList<Point> testTrack = new ArrayList<Point>();
		testTrack.add(new Point(0,0));
		testTrack.add(new Point(4,6));
		testTrack.add(new Point(8,12));
		testTrack.add(new Point(12,12));
		testTrack.add(new Point(16,6));
		testTrack.add(new Point(20,0));
		for (int i = 0; i < actualTrack.size(); i++) {
			assertEquals(testTrack.get(i), actualTrack.get(i));
		}
		
	}
	
	/**
	 * Makes sure that the bike moves along the track based on its speed.
	 */
	@Test
	public void testBikeXPositionIsTrackedCorrectly() {
		ArrayList<Point> track = new ArrayList<Point>();
		track.add(new Point(0,0)); track.add(new Point(1,0));
		track.add(new Point(2,1)); track.add(new Point(3,1));
		track.add(new Point(4,0)); track.add(new Point(5,0));
		track.add(new Point(6,2)); track.add(new Point(7,1));
		track.add(new Point(8,0)); track.add(new Point(9,0));
		Session testSession = new Session(track);
		testSession.getBike().UpdateVector(1, 0);
		for (int i = 0; i < track.size()-1; i++) {
			assertEquals(track.get(i).x, testSession.getBike().getX(), 0.001);
			testSession.moveBike();
		}
	}

	/**
	 * Makes sure that the bike can follow the terrain of the level,
	 * such as going up and down hills.
	 */
	@Test
	public void testBikeYPositionIsTrackedCorrectly() {
		ArrayList<Point> track = new ArrayList<Point>();
		track.add(new Point(0,0)); track.add(new Point(1,0));
		track.add(new Point(2,1)); track.add(new Point(3,1));
		track.add(new Point(4,0)); track.add(new Point(5,0));
		track.add(new Point(6,2)); track.add(new Point(7,1));
		track.add(new Point(8,0)); track.add(new Point(9,0));
		Session testSession = new Session(track);
		testSession.getBike().UpdateVector(1, 0);
		for (int i = 0; i < track.size() - 1; i++) {
			assertEquals(track.get(i).y, testSession.getBike().getY(), 0.001);
			testSession.moveBike();
		}
	}
	
	/**
	 * Makes sure that the bike can follow a complex terrain.
	 */
	@Test
	public void testMoreComplexTerrainMovement(){
		String testFileName = "testLevel.txt";
		File testFile = new File(testFileName);
		Session testSession = new Session(testFile);
		testSession.getBike().UpdateVector(1, 0);
		for (int i = 0; i < 20; i++){
			double bikeX = testSession.getBike().getX();
			double bikeY = testSession.getBike().getY();
			double trackY = testSession.getTrackY(bikeX);
			assertEquals(bikeY, trackY, 0.001);
			testSession.moveBike();
		}
	}
	
	/**
	 * Makes sure that a bike can crash from an impact.
	 */
	@Test
	public void testBikeCrashFromForce() {
		ArrayList<Point> track = new ArrayList<Point>();
		track.add(new Point(0,0)); track.add(new Point(1,0));
		track.add(new Point(2,1)); track.add(new Point(3,1));
		track.add(new Point(4,0)); track.add(new Point(5,0));
		track.add(new Point(6,2)); track.add(new Point(7,1));
		track.add(new Point(8,0)); track.add(new Point(9,0));
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
		ArrayList<Point> track = new ArrayList<Point>();
		track.add(new Point(0,0)); track.add(new Point(1,0));
		track.add(new Point(2,1)); track.add(new Point(3,1));
		track.add(new Point(4,0)); track.add(new Point(5,0));
		track.add(new Point(6,2)); track.add(new Point(7,1));
		track.add(new Point(8,0)); track.add(new Point(9,0));
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
		ArrayList<Point> track = new ArrayList<Point>();
		track.add(new Point(0,0)); track.add(new Point(1,0));
		track.add(new Point(2,1)); track.add(new Point(3,1));
		track.add(new Point(4,0)); track.add(new Point(5,0));
		track.add(new Point(6,2)); track.add(new Point(7,1));
		track.add(new Point(8,0)); track.add(new Point(9,0));
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
		ArrayList<Point> track = new ArrayList<Point>();
		track.add(new Point(0,0)); track.add(new Point(1,0));
		track.add(new Point(2,1)); track.add(new Point(3,1));
		track.add(new Point(4,0)); track.add(new Point(5,0));
		track.add(new Point(6,2)); track.add(new Point(7,1));
		track.add(new Point(8,0)); track.add(new Point(9,0));
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
}