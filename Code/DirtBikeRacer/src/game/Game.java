package game;

/**
 * Starts the game.
 *
 * @author schuenjr.
 *         Created Apr 13, 2012.
 */
public class Game {
	private static Session currentSession;
	
	public static void main(String[] args) {
		currentSession = new Session();
	}
	
	public void setCurrentSession(Session s){
		currentSession = s;
	}
	
	public Session getCurrentSession(){
		return currentSession;
	}
}
