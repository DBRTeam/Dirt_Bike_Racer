package game;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ChooseLanguage extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ChooseLanguage(){
		this.setBounds(300, 200, 200, 100);
		this.setTitle("");
		this.setVisible(true);
		setResizable(false);
		JPanel buttonHolder = new JPanel();
		JPanel text = new JPanel();
		JLabel chooseLanguage = new JLabel();
		Font font = new Font("Arial", Font.PLAIN, 20);
		chooseLanguage.setFont(font);
		chooseLanguage.setText("Choose Language");
		text.add(chooseLanguage);
		this.add(text, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton english = new JButton("English");
		english.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.setGui(new GUI(Game.currentSession, "en", "US"));
				
			}
		});
		JButton spanish = new JButton("Espanol");
		spanish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.setGui(new GUI(Game.currentSession, "es", "ES"));
				
			}
		});
		buttonHolder.add(english);
		buttonHolder.add(spanish);
		this.add(buttonHolder, BorderLayout.SOUTH);
	}


}
