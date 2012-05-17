//package game;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.RenderingHints;
//import java.awt.Toolkit;
//import java.io.File;
//import java.io.IOException;
//import java.util.Locale;
//import java.util.ResourceBundle;
//
//import javax.imageio.ImageIO;
//import javax.swing.JPanel;
//
//public class MainScreen extends JPanel{
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private Graphics2D graphics;
//	private boolean clear;
//	private ResourceBundle messages;
//	private Locale aLocale;
//	public MainScreen(String l, String c){
//		setBackground(Color.WHITE);
//		this.aLocale = new Locale(l, c);
//		this.messages = ResourceBundle.getBundle("MessagesBundle", this.aLocale);
//		this.clear = false;
//	}
//		@Override
//		public void paintComponent(Graphics g){
//			super.paintComponent(g);
//
//			this.graphics = (Graphics2D) g;
//			if(this.clear){
//				this.graphics.setColor(Color.WHITE);
//				this.graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
//			}
//			try {
//				drawMenu(graphics);
//			} catch (IOException e) {
//				System.out.println(messages.getString("Picture_Error"));
//			}
//		}
//
//
//	public boolean userClicksPlay() {
//		return false;
//	}
//	
//	public void undraw() {
//		this.clear = true;
//		this.repaint();
//	}
//	public void drawAgain(String l, String c) {
//		this.aLocale = new Locale(l, c);
//		this.messages = ResourceBundle.getBundle("MessagesBundle", this.aLocale);
//		repaint();
//	}
//
//}
