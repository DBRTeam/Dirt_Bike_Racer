package tests;

import static org.junit.Assert.*;
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

}
