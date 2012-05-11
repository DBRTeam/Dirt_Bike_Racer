package game;

import static org.junit.Assert.assertTrue;

import java.io.File;

/**
 * Starts the game.
 *
 * @author schuenjr.
 *         Created Apr 13, 2012.
 */
public class Game {
	public static Session currentSession;
	private static  GUI gui;
	
	public static void main(String[] args) {
		String testFileName = "testLevel.txt";
		File testFile = new File(testFileName);
		currentSession = new Session(testFile);
		setGui(new GUI(currentSession));
	}
	
	public void setCurrentSession(Session s){
		currentSession = s;
	}
	
	public Session getCurrentSession(){
		return currentSession;
	}

	public static void setGui(GUI gui) {
		Game.gui = gui;
	}

	public static GUI getGui() {
		return gui;
	}

}
