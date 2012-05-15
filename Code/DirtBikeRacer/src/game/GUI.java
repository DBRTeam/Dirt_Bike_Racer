package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class GUI extends JFrame{

	/**
	 */
	private static final long serialVersionUID = 1L;
	private Session currentSession;
	private GUI g = this;
	
	public GUI(Session session){
		this.setSize(800, 450);
		this.setTitle("Dirt Bike Racer");
		this.setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menu = new JMenuBar();
		setUpMenu(menu);
		setJMenuBar(menu);
		
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
				LevelFrame level = new LevelFrame();
				g.add(level);
				g.remove(playButton);
				g.remove(englishButton);
				g.remove(spanishButton);
				g.remove(mainMenu);
			}
		});

	}
	
	private void setUpMenu(JMenuBar menu){
		JMenu help = new JMenu("Help");
		JMenuItem directions = new JMenuItem("Directions");
		directions.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(g,
								"Start level: ENTER\nAccelerate: UP\nDecelerate: DOWN\nRotate: LEFT/RIGHT",
								"Directions", JOptionPane.PLAIN_MESSAGE);
			}
		});
		help.add(directions);
		JMenuItem about = new JMenuItem("About");
		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(g,
								"Team Project By:\n Jake Schuenke\n Tyler Shelton\n Matt Spurr",
								"About", JOptionPane.PLAIN_MESSAGE);
			}
		});
		help.add(about);
		menu.add(help);
	}
	
}
