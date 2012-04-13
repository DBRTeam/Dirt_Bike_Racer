package tests;

import static org.junit.Assert.*;
import game.Game;

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
	public void testBikeisCreated() {
		Game test = new Game();
		assertEquals(test.getClass(),Game.class);
	}

}
