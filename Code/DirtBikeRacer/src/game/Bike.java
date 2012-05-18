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
	public double xPosition;
	/**
	 * The vertical coordinate of the bike.
	 */
	public double yPosition;
	/**
	 * The direction the bike is traveling, in degrees.
	 */
	private double directionVector;
	/**
	 * The speed of the bike.
	 */
	private double speedVector;
	/**
	 * The orientation of the bike, in degrees.
	 */
	private double rotation;
	private double xPositionFW;
	private double yPositionFW;
	private double xPositionRW;
	private double yPositionRW;
	private double xPositionRider;
	private double yPositionRider;
	
	public Bike(){
		this.xPosition = 0;
		this.yPosition = 0;
		this.directionVector = 0;
		this.speedVector = 0;
		this.rotation = 0;
		this.xPositionFW = 0;
		this.yPositionFW = 0;
		this.xPositionRW = 0;
		this.yPositionRW = 0;
	}

	/**
	 * Changes the position to reflect movement.
	 *
	 * @param x
	 * @param y
	 */
	public void UpdatePosition(double x, double y) {
		this.xPosition = x;
		this.yPosition = y;
	}

	/**
	 * Changes the vector to reflect acceleration.
	 *
	 * @param speed
	 * @param direction
	 */
	public void UpdateVector(double speed, double direction) {
		this.speedVector = speed;
		this.directionVector = direction;
	}

	/**
	 * Changes the orientation of the bike.
	 *
	 * @param r
	 */
	public void UpdateRotation(double r) {
		this.rotation = r;
	}
	
	public double getX(){
		return this.xPosition;
	}
	
	public double getY(){
		return this.yPosition;
	}

	public double getDirection(){
		return this.directionVector;
	}

	public double getSpeed(){
		return this.speedVector;
	}

	public double getRotation(){
		return this.rotation;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public double getXRearWheel() {
		return this.xPositionRW;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public double getXFrontWheel() {
		return this.xPositionFW;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public double getYRearWheel() {
		return this.yPositionRW;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public double getYFrontWheel() {
		return this.yPositionFW;
	}

	/**
	 * TODO Put here a description of what this method does.
	 * @param newFrontWheely 
	 * @param newFrontWheelx 
	 *
	 */
	public void UpdatePositionFW(double newFrontWheelx, double newFrontWheely) {
		this.xPositionFW = newFrontWheelx;
		this.yPositionFW = newFrontWheely;
		
	}
	
	public void UpdatePositionRW(double newRearWheelx, double newRearWheely) {
		this.xPositionRW = newRearWheelx;
		this.yPositionRW = newRearWheely;
		
	}

	public double getRiderX() {
		return this.xPositionRider;
	}

	public double getRiderY() {
		return this.yPositionRider;
	}

	public void UpdatePositionRider(double newRiderx, double newRidery) {
		this.xPositionRider = newRiderx;
		this.yPositionRider = newRidery;
	}
	
}
