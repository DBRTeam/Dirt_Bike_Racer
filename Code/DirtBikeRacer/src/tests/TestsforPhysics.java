
package tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
		Session test = new Session(testFile,1);
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
		Session test = new Session(testFile,1);
		assertTrue(test.physics.level != null);
	}
	
	/**
	 * Makes sure that the bike's position changes
	 *
	 */
	@Test
	public void testPhysicsEnginetracksBikeMovement() {
		String FileName = "level1.txt";
		File testFile = new File(FileName);
		Session test = new Session(testFile,1);
		double BikeX = test.getBikeXPosition();
		test.physics.setUptoTrue();
		for (int i = 0; i < 300; i++) {
			test.physics.step();
		}
		assertTrue((BikeX < test.getBikeXPosition()));
		
		
	}

	/**
	 * Makes sure that the bike's position is affected by a ramp
	 *
	 */
	@Test
	public void testPhysicsEnginetracksBikeUpRamp() {
		String FileName = "level1.txt";
		File testFile = new File(FileName);
		Session test = new Session(testFile,1);
		double BikeX = test.getBikeXPosition();
		double BikeY = test.getBikeYPosition();
		test.physics.setUptoTrue();
		for (int i = 0; i < 300; i++) {
			test.physics.step();
		}
		assertTrue((BikeX < test.getBikeXPosition()) && (BikeY < test.getBikeYPosition()));
	}
}
