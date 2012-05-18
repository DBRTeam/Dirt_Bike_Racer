package game;

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
		String testFileName = "level1.txt";
		File testFile = new File(testFileName);
		currentSession = new Session(testFile, 1);
		new ChooseLanguage();

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
