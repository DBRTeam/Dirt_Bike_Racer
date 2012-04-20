package tests;

import static org.junit.Assert.*;
import game.Bike;

import org.junit.Test;

/**
 * TODO Put here a description of what this class does.
 *
 * @author schuenjr.
 *         Created Apr 13, 2012.
 */
public class TestsforBike {

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeisCreated() {
		Bike test = new Bike();
		assertEquals(test.getClass(),Bike.class);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeRecievesNewLocationX() {
		Bike test = new Bike();
		test.UpdatePosition(55,37);
		assertEquals(test.getX(),55);
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeRecievesNewLocationXAgain() {
		Bike test = new Bike();
		test.UpdatePosition(55,37);
		test.UpdatePosition(57,37);
		test.UpdatePosition(58,39);
		test.UpdatePosition(60,42);
		test.UpdatePosition(62,44);
		assertEquals(test.getX(),62);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeRecievesNewLocationY() {
		Bike test = new Bike();
		test.UpdatePosition(55,37);
		assertEquals(test.getY(),37);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeRecievesNewLocationYAgain() {
		Bike test = new Bike();
		test.UpdatePosition(55,37);
		test.UpdatePosition(57,37);
		test.UpdatePosition(58,39);
		test.UpdatePosition(60,42);
		test.UpdatePosition(62,44);
		assertEquals(test.getY(),44);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeRecievesNewVectorDirection() {
		Bike test = new Bike();
		test.UpdateVector(200,110);
		assertEquals(test.getDirection(),110);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeRecievesNewVectorDirectionAgain() {
		Bike test = new Bike();
		test.UpdateVector(200,110);
		test.UpdateVector(198,103);
		test.UpdateVector(195,100);
		test.UpdateVector(192,95);
		test.UpdateVector(190,90);
		assertEquals(test.getDirection(),90);
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeRecievesNewVectorSpeed() {
		Bike test = new Bike();
		test.UpdateVector(200,110);
		assertEquals(test.getSpeed(),200);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeRecievesNewVectorSpeedAgain() {
		Bike test = new Bike();
		test.UpdateVector(200,110);
		test.UpdateVector(198,103);
		test.UpdateVector(195,100);
		test.UpdateVector(192,95);
		test.UpdateVector(190,90);
		assertEquals(test.getSpeed(),190);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeRecievesNewRotation() {
		Bike test = new Bike();
		test.UpdateRotation(118);
		assertEquals(test.getRotation(),118);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeRecievesNewRotationAgain() {
		Bike test = new Bike();
		test.UpdateRotation(118);
		test.UpdateRotation(120);
		test.UpdateRotation(123);
		test.UpdateRotation(125);
		test.UpdateRotation(127);
		assertEquals(test.getRotation(),127);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeCrashFromForce() {
		Bike test = new Bike();
		// TODO setup a scenario where Bike should crash
		assertTrue(test.Crash());
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeCrashFromFlip() {
		Bike test = new Bike();
		// TODO setup a scenario where Bike should crash
		assertTrue(test.Crash());
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeDoesntFalseCrashFromForce() {
		Bike test = new Bike();
		// TODO setup a scenario where Bike shouldn't crash
		assertFalse(test.Crash());
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testBikeDoesntFalseCrashFromFlip() {
		Bike test = new Bike();
		// TODO setup a scenario where Bike shouldn't crash
		assertFalse(test.Crash());
	}
}
