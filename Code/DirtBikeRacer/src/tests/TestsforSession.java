package tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

import game.Bike;
import game.Session;

import org.junit.Test;

/**
 * TODO Put here a description of what this class does.
 *
 * @author schuenjr.
 *         Created Apr 13, 2012.
 */
public class TestsforSession {

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testSessionisCreated() {
		Session test = new Session();
		assertEquals(test.getClass(),Session.class);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeisCreated() {
		Session test = new Session();
		assertEquals(test.getBike().getClass(), Bike.class);
	}
	

	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testTerrainIsReadInCorrectly() {
		String testFileName = "C:/Users/spurrme/Documents/Sophomore Year/CSSE376/Project/Dirt_Bike_Racer/Code/DirtBikeRacer/src/testLevel.txt";
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
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeXPositionIsTrackedCorrectly() {
		String testFileName = "C:/Users/schuenjr/Documents/ROSE/CSSE_376/Dirt_Bike_Racer/Code/Levels/LevelTest.txt";
		File testFile = new File(testFileName);
		Session testSession = new Session(testFile);
		testSession.getBike().UpdatePosition(14,27);
		assertEquals(testSession.getBike().getX(), 14);
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeYPositionIsTrackedCorrectly() {
		String testFileName = "C:/Users/schuenjr/Documents/ROSE/CSSE_376/Dirt_Bike_Racer/Code/Levels/LevelTest.txt";
		File testFile = new File(testFileName);
		Session testSession = new Session(testFile);
		testSession.getBike().UpdatePosition(14,27);
		assertEquals(testSession.getBike().getY(), 27);
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