package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainScreen extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Graphics2D graphics;
	private ResourceBundle messages;
	private Locale aLocale;
	public MainScreen(String l, String c){
		setBackground(Color.WHITE);
		this.aLocale = new Locale(l, c);
		this.messages = ResourceBundle.getBundle("MessagesBundle", this.aLocale);
	}
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);

			this.graphics = (Graphics2D) g;
			
			try {
				drawMenu(graphics);
			} catch (IOException e) {
				System.out.println(messages.getString("Picture_Error"));
			}
		}

		private void drawMenu(Graphics2D graphics) throws IOException {
			Image img = ImageIO.read(new File("dirt-bike-clipart.jpg"));
			
			this.graphics.drawImage(img, 0, 50, null);
			int screenRes = Toolkit.getDefaultToolkit().getScreenResolution();
		    int fontSize = (int)Math.round(12.0 * screenRes / 24.0);
		    
		    Font font = new Font("Broadway", Font.PLAIN, fontSize);
		    
		    this.graphics.setFont(font);
		    //this.graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    if(this.aLocale.getCountry() == "US"){
			    this.graphics.drawString(this.messages.getString("Bike"), 375, 100);
			    this.graphics.drawString(this.messages.getString("Racer"), 410, 155);
		    }
		    if(this.aLocale.getCountry() == "ES"){
			    this.graphics.drawString(this.messages.getString("Bike"), 180, 50);
			    this.graphics.drawString(this.messages.getString("Racer"), 285, 110);
		    }
	
			
		}
	public boolean userClicksPlay() {
		return false;
	}
	

	public void drawAgain(String l, String c) {
		this.aLocale = new Locale(l, c);
		this.messages = ResourceBundle.getBundle("MessagesBundle", this.aLocale);
		repaint();
	}

}
