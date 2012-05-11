package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

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
	public LevelFrame(){
		super();
		setBackground(Color.WHITE);
	}
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D graphics = (Graphics2D) g;
			drawLevel(graphics);
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
				this.repaint();
			}
		}
	
	
}
