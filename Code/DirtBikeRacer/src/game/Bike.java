package game;

/**
 * Player controlled bike during game
 *
 * @author schuenjr.
 *         Created Apr 13, 2012.
 */
public class Bike {

	/**
	 * The horizontal coordinate of the bike.
	 */
	private int xPosition;
	/**
	 * The vertical coordinate of the bike.
	 */
	private int yPosition;
	/**
	 * The direction the bike is traveling, in degrees.
	 */
	private int directionVector;
	/**
	 * The speed of the bike.
	 */
	private int speedVector;
	/**
	 * The orientation of the bike, in degrees.
	 */
	private int rotation;
	
	public Bike(){
		this.xPosition = 0;
		this.yPosition = 0;
		this.directionVector = 0;
		this.speedVector = 0;
		this.rotation = 0;
	}

	/**
	 * Changes the position to reflect movement.
	 *
	 * @param x
	 * @param y
	 */
	public void UpdatePosition(int x, int y) {
		this.xPosition = x;
		this.yPosition = y;
	}

	/**
	 * Changes the vector to reflect acceleration.
	 *
	 * @param speed
	 * @param direction
	 */
	public void UpdateVector(int speed, int direction) {
		this.speedVector = speed;
		this.directionVector = direction;
	}

	/**
	 * Changes the orientation of the bike.
	 *
	 * @param r
	 */
	public void UpdateRotation(int r) {
		this.rotation = r;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return boolean
	 */
	public boolean Crash() {
		// TODO Auto-generated method stub.
		return false;
	}
	
	public int getX(){
		return this.xPosition;
	}
	
	public int getY(){
		return this.yPosition;
	}

	public int getDirection(){
		return this.directionVector;
	}

	public int getSpeed(){
		return this.speedVector;
	}

	public int getRotation(){
		return this.rotation;
	}
	
}
