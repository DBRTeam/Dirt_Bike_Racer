package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainScreen extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Graphics2D graphics;
	private boolean clear;
	public MainScreen(){
		setBackground(Color.WHITE);
		this.clear = false;
	}
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);

			this.graphics = (Graphics2D) g;
			if(this.clear){
				this.graphics.setColor(Color.WHITE);
				this.graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
			}
			try {
				drawMenu(graphics);
			} catch (IOException e) {
				System.out.println("background file does not exhist");
			}
		}
	private void drawMenu(Graphics2D graphics) throws IOException {
			Image img = ImageIO.read(new File("dirt-bike-clipart.jpg"));
			
			this.graphics.drawImage(img, 0, 50, null);
			int screenRes = Toolkit.getDefaultToolkit().getScreenResolution();
		    int fontSize = (int)Math.round(12.0 * screenRes / 24.0);
		    
		    Font font = new Font("Broadway", Font.PLAIN, fontSize);
		    
		    this.graphics.setFont(font);
		    this.graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    this.graphics.drawString("Dirt Bike", 375, 75);
		    this.graphics.drawString("Racer", 410, 130);
		    this.graphics.setFont(new Font("Arial", Font.PLAIN, 14));
		    this.graphics.drawString("Choose Language:", 410, 200);	
			
		}
	
	public boolean userClicksPlay() {
		return false;
	}
	
	public void undraw() {
		this.clear = true;
		this.repaint();
	}

}
