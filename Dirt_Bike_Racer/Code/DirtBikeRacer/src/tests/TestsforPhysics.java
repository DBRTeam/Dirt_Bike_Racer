
package tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.io.File;
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

		String FileName = "C:/Users/schuenjr/Documents/ROSE/CSSE_376/Dirt_Bike_Racer/Code/DirtBikeRacer/src/testLevel.txt";
		File testFile = new File(FileName);
		
		Session test = new Session(testFile);
		double BikeX = test.getBikeXPosition();
		double BikeY = test.getBikeYPosition();
		
		test.physics.motorStart();
		for (int i = 0; i < 20; i++) {
			test.physics.step();
		}
		assertTrue((BikeX != test.getBikeXPosition()) && (BikeY != test.getBikeYPosition()));
	}
	
	/**
	 * Makes sure that the bike's position is affected by wall
	 *
	 */
	@Test
	public void testPhysicsEnginetracksBikeStop() {
		String FileName = "C:/Users/schuenjr/Documents/ROSE/CSSE_376/Dirt_Bike_Racer/Code/DirtBikeRacer/src/testLevelWall.txt";
		File testFile = new File(FileName);
		Session test = new Session(testFile);
		double BikeY = test.getBike().getY();
		test.physics.motorStart();
		for (int i = 0; i < 200; i++) {
			test.physics.step();
		}
		assertTrue((test.getBike().getX() == 8.5) && (BikeY == test.getBike().getY()));
	}
	

	/**
	 * Makes sure that the bike's position is affected by a ramp
	 *
	 */
	@Test
	public void testPhysicsEnginetracksBikeUpRamp() {
		String FileName = "C:/Users/schuenjr/Documents/ROSE/CSSE_376/Dirt_Bike_Racer/Code/DirtBikeRacer/src/testLevelHill.txt";
		File testFile = new File(FileName);
		Session test = new Session(testFile);
		double BikeX = test.getBike().getX();
		double BikeY = test.getBike().getY();
		test.physics.motorStart();
		for (int i = 0; i < 20; i++) {
			test.physics.step();
		}
		assertTrue((BikeX < test.getBike().getX()) && (BikeY < test.getBike().getY()));
	}
}
