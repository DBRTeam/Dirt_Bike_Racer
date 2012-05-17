
package tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.io.File;
import java.util.Calendar;
import game.PhysicsEngine;
import game.Session;

import org.junit.Test;

/**
 * TODO Put here a description of what this class does.
 *
 * @author schuenjr.
 *         Created May 4, 2012.
 */
public class TestsforPhysics {
	/**
	 * Makes sure that a PhysicsEngine can be created.
	 */
	@Test
	public void testPhysicsEngineisCreated() {
		PhysicsEngine test = new PhysicsEngine();
		assertEquals(test.getClass(),PhysicsEngine.class);
	}
	
	/**
	 * Makes sure that a session creates a PhysicsEngine when create
	 *
	 */
	@Test
	public void testPhysicsEngineisCreatedbySession() {
		String FileName = "testLevel.txt";
		File testFile = new File(FileName);
		Session test = new Session(testFile);
		assertEquals(test.physics.getClass(), PhysicsEngine.class);
	}

	/**
	 * Makes sure the PhysicsEngine can build a level from a file
	 *
	 */
	@Test
	public void testPhysicsEngineReadsFromFile() {
		String FileName = "testLevel.txt";
		File testFile = new File(FileName);
		Session test = new Session(testFile);
		assertTrue(test.physics.level != null);
	}
	
	/**
	 * Makes sure that the bike's position changes
	 *
	 */
	@Test
	public void testPhysicsEnginetracksBikeMovement() {
		String FileName = "testLevel.txt";
		File testFile = new File(FileName);
		Session test = new Session(testFile);
		double BikeX = test.getBike().getX();
		double BikeY = test.getBike().getY();
		test.physics.motorStart();
		Calendar cal = Calendar.getInstance();
		long TimetoWait = 5000;
		while (cal.getTimeInMillis() < TimetoWait){
			System.out.println("waiting...\n");
		}
		assertTrue((BikeX != test.getBike().getX()) && (BikeY != test.getBike().getY()));
	}
	
	/**
	 * Makes sure that the bike's position is affected by wall
	 *
	 */
	@Test
	public void testPhysicsEnginetracksBikeStop() {
		String FileName = "testLevelWall.txt";
		File testFile = new File(FileName);
		Session test = new Session(testFile);
		double BikeY = test.getBike().getY();
		test.physics.motorStart();
		Calendar cal = Calendar.getInstance();
		long TimetoWait = 5000;
		while (cal.getTimeInMillis() < TimetoWait){
			System.out.println("waiting...\n");
		}
		assertTrue((test.getBike().getX()) == 8.5 && (BikeY == test.getBike().getX()));
	}
	

	/**
	 * Makes sure that the bike's position is affected by a ramp
	 *
	 */
	@Test
	public void testPhysicsEnginetracksBikeUpRamp() {
		String FileName = "testLevelHill.txt";
		File testFile = new File(FileName);
		Session test = new Session(testFile);
		double BikeX = test.getBike().getX();
		double BikeY = test.getBike().getY();
		test.physics.motorStart();
		Calendar cal = Calendar.getInstance();
		long TimetoWait = 5000;
		while (cal.getTimeInMillis() < TimetoWait){
			System.out.println("waiting...\n");
		}
		assertTrue((BikeX < test.getBike().getX()) && (BikeY < test.getBike().getY()));
	}
}