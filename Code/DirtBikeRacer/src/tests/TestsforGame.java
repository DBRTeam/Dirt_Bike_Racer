package tests;

import static org.junit.Assert.*;
import game.Game;
import game.Session;

import org.junit.Test;

/**
 * TODO Put here a description of what this class does.
 *
 * @author schuenjr.
 *         Created Apr 13, 2012.
 */
public class TestsforGame {

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testGameisCreated() {
		Game test = new Game();
		assertEquals(test.getClass(), Game.class);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testSessionisCreated() {
		Game test = new Game();
		Session s = new Session(null);
		test.setCurrentSession(s);
		assertEquals(test.getCurrentSession(), s);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	@Test
	public void testSessionCanBeChanged() {
		Game test = new Game();
		Session s1 = new Session(null);
		Session s2 = new Session(new int[3]);
		test.setCurrentSession(s1);
		test.setCurrentSession(s2);
		assertEquals(test.getCurrentSession(), s2);
	}

}
