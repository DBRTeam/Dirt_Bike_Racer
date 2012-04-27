package tests;

import static org.junit.Assert.*;
import game.Bike;

import org.junit.Test;

/**
 * Tests everything in the bike class.
 *
 * @author schuenjr.
 *         Created Apr 13, 2012.
 */
public class TestsforBike {

	/**
	 * Makes sure that a bike can be created.
	 */
	@Test
	public void testBikeisCreated() {
		Bike test = new Bike();
		assertEquals(test.getClass(),Bike.class);
	}
	
	/**
	 * Makes sure that a bike can get a new x location.
	 */
	@Test
	public void testBikeRecievesNewLocationX() {
		Bike test = new Bike();
		test.UpdatePosition(55,37);
		assertEquals(test.getX(),55, 0.001);
	}

	/**
	 * Makes sure that a bike can change the x location
	 * multiple times.
	 */
	@Test
	public void testBikeRecievesNewLocationXAgain() {
		Bike test = new Bike();
		test.UpdatePosition(55,37);
		test.UpdatePosition(57,37);
		test.UpdatePosition(58,39);
		test.UpdatePosition(60,42);
		test.UpdatePosition(62,44);
		assertEquals(test.getX(),62, 0.001);
	}
	
	/**
	 * Makes sure that a bike can get a new y location.
	 */
	@Test
	public void testBikeRecievesNewLocationY() {
		Bike test = new Bike();
		test.UpdatePosition(55,37);
		assertEquals(test.getY(),37, 0.001);
	}
	
	/**
	 * Makes sure that a bike can change the y location
	 * multiple times.
	 */
	@Test
	public void testBikeRecievesNewLocationYAgain() {
		Bike test = new Bike();
		test.UpdatePosition(55,37);
		test.UpdatePosition(57,37);
		test.UpdatePosition(58,39);
		test.UpdatePosition(60,42);
		test.UpdatePosition(62,44);
		assertEquals(test.getY(),44, 0.001);
	}
	
	/**
	 * Makes sure that a bike can get a new direction vector.
	 */
	@Test
	public void testBikeRecievesNewVectorDirection() {
		Bike test = new Bike();
		test.UpdateVector(200,110);
		assertEquals(test.getDirection(),110, 0.001);
	}
	
	/**
	 * Makes sure that a bike can change the direction vector
	 * multiple times.
	 */
	@Test
	public void testBikeRecievesNewVectorDirectionAgain() {
		Bike test = new Bike();
		test.UpdateVector(200,110);
		test.UpdateVector(198,103);
		test.UpdateVector(195,100);
		test.UpdateVector(192,95);
		test.UpdateVector(190,90);
		assertEquals(test.getDirection(),90, 0.001);
	}

	/**
	 * Makes sure that a bike can get a new speed.
	 */
	@Test
	public void testBikeRecievesNewVectorSpeed() {
		Bike test = new Bike();
		test.UpdateVector(200,110);
		assertEquals(test.getSpeed(),200, 0.001);
	}
	
	/**
	 * Makes sure that a bike can change the speed multiple times.
	 */
	@Test
	public void testBikeRecievesNewVectorSpeedAgain() {
		Bike test = new Bike();
		test.UpdateVector(200,110);
		test.UpdateVector(198,103);
		test.UpdateVector(195,100);
		test.UpdateVector(192,95);
		test.UpdateVector(190,90);
		assertEquals(test.getSpeed(),190, 0.001);
	}
	
	/**
	 * Makes sure that a bike can get a new rotation.
	 */
	@Test
	public void testBikeRecievesNewRotation() {
		Bike test = new Bike();
		test.UpdateRotation(118);
		assertEquals(test.getRotation(),118, 0.001);
	}
	
	/**
	 * Makes sure that a bike can change the rotation multiple times.
	 */
	@Test
	public void testBikeRecievesNewRotationAgain() {
		Bike test = new Bike();
		test.UpdateRotation(118);
		test.UpdateRotation(120);
		test.UpdateRotation(123);
		test.UpdateRotation(125);
		test.UpdateRotation(127);
		assertEquals(test.getRotation(),127, 0.001);
	}
	
}
