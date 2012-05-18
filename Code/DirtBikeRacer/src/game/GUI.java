package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GUI extends JFrame{

	/**
	 */
	private static final long serialVersionUID = 1L;
	private Session currentSession;
	private GUI g = this;
	private ResourceBundle messages;
	private Locale aLocale;


	protected JButton playButton;
	//protected MainScreen mainMenu;
	private JMenuBar menu;
	private MainScreen screen;
	public GUI(Session session, String l, String c){
		this.setSize(800, 450);
		this.setTitle("");
		this.setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initScreen(l, c);
		 this.screen = new MainScreen(l, c);
		this.add(screen);
		

	}
	
	private void initScreen(String l, String c) {
		//this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.aLocale = new Locale(l, c);
		this.messages = ResourceBundle.getBundle("MessagesBundle", this.aLocale);
		this.menu = new JMenuBar();
		setUpMenu(this.menu, this.messages);
		setJMenuBar(this.menu);
		this.playButton = new JButton(this.messages.getString("Start"));
		playButton.setFont(new Font("Broadway", Font.PLAIN, 32));
		playButton.setBackground(Color.WHITE);
		playButton.setBounds(433, 206, 200, 75);
		this.add(playButton);
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				playButton.setVisible(false);
				LevelFrame level = new LevelFrame();
				g.add(level);
				g.remove(playButton);
				g.remove(screen);

			}
		});
		
	}

	private void setUpMenu(JMenuBar menu, final ResourceBundle r){
		JMenu help = new JMenu(this.messages.getString("Help"));
		JMenuItem directions = new JMenuItem(this.messages.getString("Directions"));
		directions.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(g,
								r.getString("Directions_Menu"),
								r.getString("Directions"), JOptionPane.PLAIN_MESSAGE);
			}
		});
		help.add(directions);
		JMenuItem about = new JMenuItem(r.getString("About"));
		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(g,
								r.getString("About_Menu"),
								r.getString("About"), JOptionPane.PLAIN_MESSAGE);
			}
		});
		help.add(about);
		menu.add(help);
	}


	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Session getCurrentSession() {
		return currentSession;
	}
	
}
