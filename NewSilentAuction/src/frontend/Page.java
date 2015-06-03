package frontend;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

import backend.*;

/**
 * This class is the main frame for our silent auction software for TCSS 360.
 * 
 * @author The Expendables
 * @version 0.0.0.1
 * @since 20.05.2015
 */



public class Page extends JFrame
{

//Fields	
	
	//Holds the different panes that we use as windows.
	public static JPanel contentPane;
	
	//Toolkit to center the application.
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	
	//The size of the screen for centering.
	private static Dimension dm = tk.getScreenSize();
	
	//Width and Height of the screen to keep it centered.
	private static double screenwidth = dm.getWidth();
	private static double screenheight = dm.getHeight();
	
	public static JPanel itemPanel;	
	public static JPanel homePanel;
	public static JPanel registrationPanel;
	public static JPanel donatePanel;
	public static JPanel generalStatsPanel;
	public static JPanel QRPanel;
	public static JPanel specificStatsPanel;
	
	public static Auction Auction = new Auction(102394820);
	
	
	
//Main
	
	/**
	 * Launch the application.
	 * 
	 * @param args is the command line required array of arguments in order to run.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Page frame = new Page();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
//Constructor	

	/**
	 * Create the frame. This creates the entire JFrame in addition to the menu and all of the
	 * individual pages and puts them all together so a user can switch between different pages.
	 */
	public Page()
	{
		basicSetup();
		
	/** Start menu */
		//the menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//home button
		JMenuItem mntmHome = new JMenuItem("Home");
		menuBar.add(mntmHome);
		
		//register button
		JMenuItem mntmRegister = new JMenuItem("Register");
		menuBar.add(mntmRegister);
		
		//donate button
		JMenuItem mntmDonate = new JMenuItem("Donate");
		menuBar.add(mntmDonate);
		
		//stats button
		JMenuItem mntmStatistics = new JMenuItem("Statistics");
		menuBar.add(mntmStatistics);
		
		//help button
		JMenuItem mntmHelp = new JMenuItem("Help");
		menuBar.add(mntmHelp);
	/** End menu */
		
		//the content pane the pages rest in.
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
	/** Start 'pages' */
		//home panel
		homePanel = new Home();
		contentPane.add(homePanel);
		
		//registration panel
		registrationPanel = new Registration();
		contentPane.add(registrationPanel);
		
		//donate panel
		donatePanel = new Donor();
		contentPane.add(donatePanel);
		
		//general stats panel
		generalStatsPanel = new GeneralStats();
		contentPane.add(generalStatsPanel);
		
		//QR panel
		QRPanel = new JPanel();
		contentPane.add(QRPanel);
		
		//fake item to use in initialization of item panel and specific stats panel
		Item item = new Item("Conner", "is awesome", 200.00, new backend.Donor("Conner", "123", "123"));
		
		//specific stats panel
		specificStatsPanel = new SpecificStats(item);
		contentPane.add(specificStatsPanel);
		
		//item panel
		itemPanel = new ItemPage(item);
		contentPane.add(itemPanel);
	/** End 'pages' */
		
	/** Start listeners */
		//the home listener
		mntmHome.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setAllVisible(false);
				
				homePanel = new Home();
				contentPane.add(homePanel);
				homePanel.setVisible(true);
			}
		});
		
		//the register listener
		mntmRegister.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setAllVisible(false);
				
				registrationPanel = new Registration();
				contentPane.add(registrationPanel);
				registrationPanel.setVisible(true);
				
			}
		});

		//the donate listener
		mntmDonate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setAllVisible(false);
				
				donatePanel = new Donor();
				contentPane.add(donatePanel);
				donatePanel.setVisible(true);
			}
		});
		
		//the stats listener
		mntmStatistics.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setAllVisible(false);
				
				generalStatsPanel = new GeneralStats();
				contentPane.add(generalStatsPanel);
				generalStatsPanel.setVisible(true);
			}
		});
		
		//the help listener
		mntmHelp.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(contentPane, "    Welcome to our Silent Auction "
						+ "software, by The Expendables Software LLC\nHere, you can register "
						+ "and start bidding on items in our silent auction. In this system, "
						+ "you can\nfind items you are interested in and you will see an amount"
						+ " of information about an item, most\nimportantly, the current "
						+ "highest bid. If you decide that you would wish to go for it and bid,"
						+ " you\nmust bid any amount higher than this bid. At the end of the "
						+ "event when the auction closes, the\nwinners will be assembled "
						+ "together and notified. Thank you for participating. -Conner Martin, "
						+ "CEO\n\nIf you would like to bid on an item, click the ‘Home’ "
						+ "button.\n    Remember to register first! (Found by clicking the "
						+ "‘register’ button.)\nIf you would like to donate an item, click the"
						+ " ‘Donate’ button.\nIf you would like to see statistics on this "
						+ "event, click the ‘Statistics’ button.\n    Here, you can find "
						+ "general stats for all items, or select an item and get its specific"
						+ " stats.\nRemember, all of these buttons are available at all times!"
						+ "\n\n   Who we are:\nWe are The Expendables Software LLC. We consist "
						+ "of Christopher Otterson, Conner Martin,\nHannah Silva and Robert "
						+ "Gillis. And we are the MOTHA FUCKIN BEST.\n    Contact us:\nWebsite"
						+ " – https://sites.google.com/site/theexpendablessoftware/\nEmail – "
						+ "theexpendables@u.washington.edu", "Help", JOptionPane.PLAIN_MESSAGE);
			}
		});
	/** End listeners */
	}
	
//Methods	
	
	/**
	 * Builds the general basic things that a JFrame needs.
	 * Including the title, size, location, exit operation, and the custom icon.
	 */
	private void basicSetup()
	{
		setTitle("Silent Auction");
		setBounds(100, 100, 700, 500);
		setLocation((int)(screenwidth - getWidth()) / 2, (int)(screenheight - getHeight()) / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("assets/logo.png");
		setIconImage(img.getImage());
	}	
	
	private void setAllVisible(boolean bool) {
		homePanel.setVisible(bool);
		donatePanel.setVisible(bool);
		registrationPanel.setVisible(bool);
		QRPanel.setVisible(bool);
		specificStatsPanel.setVisible(bool);
		itemPanel.setVisible(bool);
		generalStatsPanel.setVisible(bool);
		
	}
}
