package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class GUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GUI(Session session){
		this.setSize(800, 450);
		this.setTitle("Dirt Bike Racer");
		this.setVisible(true);
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
				//LevelFrame level = new LevelFrame();
				//add(level);
			
				
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

}
