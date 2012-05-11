package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class GUI extends JFrame{
	private static final Dimension SIZE = java.awt.Toolkit.getDefaultToolkit()
	.getScreenSize();
	private Session currentSession;
	private LevelFrame frame = new LevelFrame();
	
	public GUI(Session session){
		this.currentSession = session;
		this.setSize(800, 450);
		this.setTitle("Dirt Bike Racer");
		this.setVisible(true);
		this.add(frame);
		final JRadioButton englishButton = new JRadioButton("English");
		final JRadioButton spanishButton = new JRadioButton("Spanish");
		final JButton playButton = new JButton("Start!");
		playButton.setFont(new Font("Broadway", Font.PLAIN, 32));
		playButton.setBackground(Color.WHITE);
		playButton.setBounds(433, 286, 200, 75);
		englishButton.setBounds(533, 185, 100, 20);
		spanishButton.setBounds(533, 205, 100, 20);
		spanishButton.setBackground(Color.WHITE);
		englishButton.setBackground(Color.WHITE);
		this.add(englishButton);
		this.add(spanishButton);
		this.add(playButton);
		final MainScreen mainMenu = new MainScreen();
		this.add(mainMenu);
		playButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				playButton.setVisible(false);
				englishButton.setVisible(false);
				spanishButton.setVisible(false);
				mainMenu.undraw();
				LevelFrame level = new LevelFrame();
				add(level);
			
				
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	public double getTime(){
		
		return frame.getTime();
	}
}
