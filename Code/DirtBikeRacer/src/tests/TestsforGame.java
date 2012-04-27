package tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import game.Game;
import game.Session;

import org.junit.Test;

/**
 * Tests everything in the game class.
 *
 * @author schuenjr.
 *         Created Apr 13, 2012.
 */
public class TestsforGame {

	/**
	 * Makes sure that a game can be created.
	 */
	@Test
	public void testGameisCreated() {
		Game test = new Game();
		assertEquals(test.getClass(), Game.class);
	}
	
	/**
	 * Makes sure that a game can create a session.
	 */
	@Test
	public void testSessionisCreated() {
		Game test = new Game();
		Session s = new Session();
		test.setCurrentSession(s);
		assertEquals(test.getCurrentSession(), s);
	}
	
	/**
	 * Makes sure that the game can change sessions.
	 */
	@Test
	public void testSessionCanBeChanged() {
		Game test = new Game();
		Session s1 = new Session();
		Session s2 = new Session(new ArrayList<Point>());
		test.setCurrentSession(s1);
		test.setCurrentSession(s2);
		assertEquals(test.getCurrentSession(), s2);
	}

}
