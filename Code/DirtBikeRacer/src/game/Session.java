package game;

import java.awt.Point;
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
	private Bike bike;
	private File level;
	private ArrayList<Point> parsedLevel;

	/**
	 * Empty constructor for a level.
	 *
	 */
	public Session(){
		this.bike = new Bike();
	}

	/**
	 * Constructor for a level that uses a file to build the game.
	 *
	 * @param level
	 */
	public Session(File level){
		this.bike = new Bike();
		this.level = level;
		this.parsedLevel = parseLevel(level);
	}

	/**
	 * Constructor for a level that uses an array list to build the game.
	 *
	 * @param parsedLevel
	 */
	public Session(ArrayList<Point> parsedLevel){
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
	public ArrayList<Point> getLevel(){
		return this.parsedLevel;
	}

	/**
	 * Parses the given File to make into into a level.
	 *
	 * @param level2
	 * @return the parsed level
	 */
	private ArrayList<Point> parseLevel(File level) {
		ArrayList<Point> levelList = new ArrayList<Point>();
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream(level);
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
				  StringTokenizer tok = new StringTokenizer(strLine, ",");
				  int x = Integer.parseInt(tok.nextElement().toString());
				  int y = Integer.parseInt(tok.nextElement().toString());
				 levelList.add(new Point(x,y));
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
		double newX = bike.getX()+bike.getSpeed();
		double newY = getTrackY(newX);
		bike.UpdatePosition(newX, newY);
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


	
}
