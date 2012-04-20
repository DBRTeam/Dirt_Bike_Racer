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
		xPosition = 0;
		yPosition = 0;
		directionVector = 0;
		speedVector = 0;
		rotation = 0;
	}

	/**
	 * Changes the position to reflect movement.
	 *
	 * @param x
	 * @param y
	 */
	public void UpdatePosition(int x, int y) {
		xPosition = x;
		yPosition = y;
	}

	/**
	 * Changes the vector to reflect acceleration.
	 *
	 * @param speed
	 * @param direction
	 */
	public void UpdateVector(int speed, int direction) {
		speedVector = speed;
		directionVector = direction;
	}

	/**
	 * Changes the orientation of the bike.
	 *
	 * @param r
	 */
	public void UpdateRotation(int r) {
		rotation = r;
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
		return xPosition;
	}
	
	public int getY(){
		return yPosition;
	}

	public int getDirection(){
		return directionVector;
	}

	public int getSpeed(){
		return speedVector;
	}

	public int getRotation(){
		return rotation;
	}
	
}
