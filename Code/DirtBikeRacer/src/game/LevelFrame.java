package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JPanel;

/**
 * This class draws the basic representation of the game.
 *
 * @author spurrme.
 *         Created May 4, 2012.
 */
public class LevelFrame extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Session currentSession = Game.currentSession;
	private long start = 0;
	private long finish = 0;
	private double totalTime = 0;
	private int level = 1;
	private String winMessage = "";
	private String timeMessage = "";
	
	public LevelFrame(){
		super();
		setBackground(Color.WHITE);
		setFocusable(true);
		addKeyListener(new Listener2());
	}
	
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D graphics = (Graphics2D) g;

			Font font = new Font("Broadway", Font.PLAIN, 40);
			graphics.setFont(font);
			graphics.drawString(winMessage, 200, 100);
			font = new Font("Broadway", Font.PLAIN, 30);
			graphics.setFont(font);
			graphics.drawString(timeMessage, 200, 160);
			
			drawLevel(graphics);
			graphics.draw(new Ellipse2D.Double(currentSession.getBike().getXFrontWheel(), currentSession.getBike().getYFrontWheel()-25, 5, 5));
			graphics.draw(new Ellipse2D.Double(currentSession.getBike().getXRearWheel(), currentSession.getBike().getYRearWheel()-25, 5, 5));
			graphics.draw(new Line2D.Double(currentSession.bike.getX(), currentSession.bike.getY(), currentSession.bike.getRiderX(), currentSession.bike.getRiderY()));
		}
		
		/**
		 * Draws the current level in the session.
		 *
		 * @param graphics
		 */
		private void drawLevel(Graphics2D g) {
			int i = 0;
			Point2D.Double startingPoint = this.currentSession.getLevel().get(i);
			i++;
			while(i < this.currentSession.getLevel().size()){
				Point2D.Double endingPoint = this.currentSession.getLevel().get(i);
				Line2D.Double line = new Line2D.Double(startingPoint, endingPoint);
				startingPoint = this.currentSession.getLevel().get(i);
				i++;
				g.setStroke(new BasicStroke(10));
				g.draw(line);
			}
		}
		
		
		class BikeDrawer implements Runnable{
			private Thread runner;
			
			public BikeDrawer(){
				repaint();
				runner = new Thread(this);
				runner.start();
			}

			@Override
			public void run() {
				double length = currentSession.getLevel().get(currentSession.getLevel().size()-1).x;
				
				while(currentSession.getBike().getXFrontWheel() < length){
					repaint();
					currentSession.moveBike();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e){
						System.out.println("error");
					}
					if(currentSession.bikeCrash()){
						File testFile = currentSession.file;
						Game.currentSession = new Session(testFile, level);
						currentSession = Game.currentSession;
					}
				}
				finish = System.currentTimeMillis();
				double levelTime = (finish-start)/1000.0;
				totalTime += levelTime;
				System.out.println(totalTime);
				File testFile = new File("");
				if(currentSession.levelNum == 1) testFile = new File("level2.txt");
				if(currentSession.levelNum == 2) testFile = new File("level3.txt");
				level = currentSession.levelNum + 1;
				if(level < 4){
					Game.currentSession = new Session(testFile, level);
					currentSession = Game.currentSession;
				}else {
					winMessage = "Congratulations!";
					DecimalFormat df = new DecimalFormat(".##");
					timeMessage = "Total time: " + df.format(totalTime) + " seconds";
				}
				repaint();
			}
		}
		
		class Listener extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				new BikeDrawer();
				start = System.currentTimeMillis();
			}
		}
		
		class Listener2 extends KeyAdapter{

			@Override
			public void keyPressed(KeyEvent k) {
				int keyCode = k.getKeyCode();
		        String keyText = KeyEvent.getKeyText(keyCode);
		        if(keyText == "Enter"){
		        	new BikeDrawer();
					start = System.currentTimeMillis();
		        }
		        if(keyText == "Up"){
		        	currentSession.physics.setUptoTrue();
		        }
		        if(keyText == "Down"){
		        	currentSession.physics.setDowntoTrue();
		        }
		        if(keyText == "Left"){
		        	currentSession.physics.setLefttoTrue();
		        }
		        if(keyText == "Right"){
		        	currentSession.physics.setRighttoTrue();
		        }
			}

			@Override
			public void keyReleased(KeyEvent k) {
				int keyCode = k.getKeyCode();
		        String keyText = KeyEvent.getKeyText(keyCode);
		        if(keyText == "Up"){
		        	currentSession.physics.setUptoFalse();
		        }
		        if(keyText == "Down"){
		        	currentSession.physics.setDowntoFalse();
		        }
		        if(keyText == "Left"){
		        	currentSession.physics.setLefttoFalse();
		        }
		        if(keyText == "Right"){
		        	currentSession.physics.setRighttoFalse();
		        }
			}

			@Override
			public void keyTyped(KeyEvent k) {
				// 
			}
			
		}
		
		public double getTime(){
			return (finish-start)/1000.0;
		}
}
