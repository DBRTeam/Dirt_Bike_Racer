package game;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Creates a session with a level and a bike.
 *
 * @author schuenjr.
 *         Created Apr 13, 2012.
 */
public class Session {
	public Bike bike;
	public int levelNum;
	private ArrayList<Point2D.Double> parsedLevel;
	public PhysicsEngine physics;
	private static final double xSCALE = 8.1;
	private static final double ySCALE = 7.0;
	/**
	 * Empty constructor for a level.
	 *
	 */
	public Session(){
		this.bike = new Bike();
		this.physics = new PhysicsEngine();
	}

	/**
	 * Constructor for a level that uses a file to build the game.
	 *
	 * @param level
	 */
	public Session(File level, int levelnum){
		this.bike = new Bike();
		this.levelNum = levelnum;
		this.bike.UpdateVector(2,0);
		this.parsedLevel = parseLevel(level);
		this.physics = new PhysicsEngine(levelnum);
	}

	/**
	 * Constructor for a level that uses an array list to build the game.
	 *
	 * @param parsedLevel
	 */
	public Session(ArrayList<Point2D.Double> parsedLevel){
		this.bike = new Bike();
		this.parsedLevel = parsedLevel;
	}

	/**
	 * Gets the bike for the session.
	 *
	 * @return the bike
	 */
	public Bike getBike(){
		return this.bike;
	}
	
	/**
	 * Returns the level represented as an Arraylist.
	 *
	 * @return the parsed level
	 */
	public ArrayList<Point2D.Double> getLevel(){
		return this.parsedLevel;
	}

	/**
	 * Parses the given File to make into into a level.
	 *
	 * @param level2
	 * @return the parsed level
	 */
	private ArrayList<Point2D.Double> parseLevel(File level) {
		ArrayList<Point2D.Double> levelList = new ArrayList<Point2D.Double>();
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream(level);
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null) {
			  // Print the content on the console
				  StringTokenizer tok = new StringTokenizer(strLine, ",");
				  int x = Integer.parseInt(tok.nextElement().toString());
				  int y = Integer.parseInt(tok.nextElement().toString());
				 levelList.add(new Point2D.Double(x,y));
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		
		return levelList;
	}

	/**
	 * Moves the bike based on its speed and the terrain.
	 */
	public void moveBike(){
		double newFrontWheelx = (getBikeFrontWheelXPosition() + 47.00) * xSCALE ;
		double newFrontWheely = (400 - (getBikeFrontWheelYPosition() + 32.00) * ySCALE);
		double newRearWheelx = (getBikeRearWheelXPosition() + 47.00) * xSCALE ;
		double newRearWheely = (400 - (getBikeRearWheelYPosition() + 32.00) * ySCALE);
		this.physics.step();
		this.physics.step();
		this.physics.step();
		bike.UpdatePositionFW(newFrontWheelx,newFrontWheely);
		bike.UpdatePositionRW(newRearWheelx, newRearWheely);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	private double getBikeFrontWheelXPosition() {
		return this.physics.getBikeFrontWheelx();
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	private double getBikeFrontWheelYPosition() {
		return this.physics.getBikeFrontWheely();
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	private double getBikeRearWheelXPosition() {
		return this.physics.getBikeRearWheelx();
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	private double getBikeRearWheelYPosition() {
		return this.physics.getBikeRearWheely();
	}

	/**
	 * Gets the y position on the track at a given x position.
	 * 
	 * @param x
	 * @return y
	 */
	public double getTrackY(double x){
		int index = 0;
		while(x > parsedLevel.get(index+1).x){
			index++;
		}
		double left = parsedLevel.get(index).x;
		double right = parsedLevel.get(index+1).x;
		double ratio = (x-left)/(right-left);
		double top = parsedLevel.get(index+1).y;
		double bottom = parsedLevel.get(index).y;
		return parsedLevel.get(index).y + ratio*(top-bottom);
	}
	
	/**
	 * Checks to see if the bike should crash or not.
	 * 
	 * @return
	 */
	public boolean bikeCrash(){
		if(bike.getY() == getTrackY(bike.getX())){
			if((Math.cos(Math.toRadians(bike.getRotation())) < Math.cos(Math.toRadians(15))))return true;
		}
		return false;
	}

	public double getBikeXPosition(){
		return this.physics.getBikeXPostion();
	}
	
	public double getBikeYPosition(){
		return this.physics.getBikeYPostion();
	}

	
}
