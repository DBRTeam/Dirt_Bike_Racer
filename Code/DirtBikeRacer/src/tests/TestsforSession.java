package tests;

import static org.junit.Assert.*;
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
	public void testBikeisCreated() {
		Session test = new Session();
		assertEquals(test.getClass(),Session.class);
	}

}
