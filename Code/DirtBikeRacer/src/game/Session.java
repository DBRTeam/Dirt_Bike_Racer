package game;

/**
 * Creates a session with a level and a bike.
 *
 * @author schuenjr.
 *         Created Apr 13, 2012.
 */
public class Session {
	private Bike bike;
	private int[] level;
	
	public Session(int[] level){
		this.bike = new Bike();
		this.level = level;
	}

	public Bike getBike(){
		return this.bike;
	}
	
	public int[] getLevel(){
		return this.level;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param level2
	 */
	public void setLevel(int[] level2) {
		// TODO Auto-generated method stub.
		
	}
}
