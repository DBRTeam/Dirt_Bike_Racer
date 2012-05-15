
package tests;



import static org.junit.Assert.*;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
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
		Session s2 = new Session(new ArrayList<Point2D.Double>());
		test.setCurrentSession(s1);
		test.setCurrentSession(s2);
		assertEquals(test.getCurrentSession(), s2);
	}


	/**
	 * Makes sure the game records the correct time to finish a level. 
	 * @throws AWTException 
	 *
	 */
	@Test
	public void testTimeIsTrackedCorrectly() throws AWTException {
		Game test = new Game();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		//robot.delay(25000);
		//assertEquals(20.00, test.getTime(), 0.01);
	}
	
	/**
	 * Makes sure that the bike starts with the correct speed.
	 * @throws AWTException 
	 *
	 */
	@Test
	public void testSpeedStaysConstant() throws AWTException {
		Game test = new Game();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(100);
		assertEquals(2, test.getCurrentSession().getBike().getSpeed(), 0.1);
	}
	
	
	
	
	/**
	 * Makes sure that the bike can increase its speed. 
	 * @throws AWTException 
	 *
	 */
	@Test
	public void testSpeedIncreases() throws AWTException {
		Game test = new Game();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_UP);
		assertEquals(5, test.getCurrentSession().getBike().getSpeed(), 0.1);
	}
	
	/**
	 * Makes sure the bike does not exceed the maximum. 
	 * @throws AWTException 
	 *
	 */
	@Test
	public void testSpeedDoesntPassMax() throws AWTException {
		Game test = new Game();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_UP);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_UP);
		assertEquals(10, test.getCurrentSession().getBike().getSpeed(), 0.1);
	}
	
	/**
	 * Makes sure that the bike can stop 
	 * @throws AWTException 
	 *
	 */
	@Test
	public void testSpeedGoesToZero() throws AWTException {
		Game test = new Game();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		assertEquals(0, test.getCurrentSession().getBike().getSpeed(), 0.1);
	}
	
	/**
	 * Makes sure that the bike can go backwards 
	 * @throws AWTException 
	 *
	 */
	@Test
	public void testSpeedGoesBackwards() throws AWTException {
		Game test = new Game();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		assertEquals(-1, test.getCurrentSession().getBike().getSpeed(), 0.1);
	}
	
	/**
	 * Makes sure the bike does not exceed the maximum speed
	 * going backwards
	 * @throws AWTException 
	 *
	 */
	@Test
	public void testSpeedGoesBackwardToMax() throws AWTException {
		Game test = new Game();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.delay(100);
		robot.keyPress(KeyEvent.VK_DOWN);
		assertEquals(-10, test.getCurrentSession().getBike().getSpeed(), 0.1);
	}
	
	/**
	 * Make sure the English version displays the correct title.
	 */
	@Test
	public void testTitleEnglishCorrect(){
		
	}
	
	/**
	 * Make sure the Spanish version displays the correct title.
	 */
	@Test
	public void testTitleSpanishCorrect(){
		
	}
	
	/**
	 * Make sure the English version displays the correct start button.
	 */
	@Test
	public void testStartEnglishCorrect(){
		
	}
	
	/**
	 * Make sure the Spanish version displays the correct start button.
	 */
	@Test
	public void testStartSpanishCorrect(){
		
	}
	
	/**
	 * Make sure the English version displays the correct directions menu.
	 */
	@Test
	public void testDirectionsEnglishCorrect(){
		
	}
	
	/**
	 * Make sure the Spanish version displays the correct directions menu.
	 */
	@Test
	public void testDirectionsSpanishCorrect(){
		
	}

}
