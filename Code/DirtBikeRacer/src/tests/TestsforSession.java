package tests;

import static org.junit.Assert.*;

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
		Session test = new Session(null);
		assertEquals(test.getClass(),Session.class);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeisCreated() {
		Session test = new Session(null);
		assertEquals(test.getBike().getClass(), Bike.class);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testLevelReturned() {
		int[] level = new int[4];
		level[0] = 0;level[1] = 0;level[2] = 1;level[3] = 0;
		Session test = new Session(level);
		assertEquals(test.getLevel(), level);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testTerrainIsReadInCorrectly() {
		String testFile = "C:/Users/schuenjr/Documents/ROSE/CSSE_376/Dirt_Bike_Racer/Code/Levels/LevelTest.txt";
		Session testSession = new Session(testFile);
		ArrayList<int[]> testTrack = new ArrayList<int[]>();
		int[] Array0 = new int[2];
		Array0[0] = 0;
		Array0[1] = 0;
		int[] Array1 = new int[2];
		Array1[0] = 0;
		Array1[1] = 1;
		int[] Array2 = new int[2];
		Array2[0] = 1;
		Array2[1] = 1;
		testTrack.add(Array0);
		testTrack.add(Array1);
		testTrack.add(Array2);
		assertEquals(testSession.getLevel(), testTrack);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeXPositionIsTrackedCorrectly() {
		String testFile = "C:/Users/schuenjr/Documents/ROSE/CSSE_376/Dirt_Bike_Racer/Code/Levels/LevelTest.txt";
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
		String testFile = "C:/Users/schuenjr/Documents/ROSE/CSSE_376/Dirt_Bike_Racer/Code/Levels/LevelTest.txt";
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