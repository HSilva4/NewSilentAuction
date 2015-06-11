package frontend;

import backend.Item;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.ArrayList;

/**
 * This class creates the home 'page' which will hold all of the items that are able to be bid on.
 * 
 * @author Hannah Silva
 * @author Conner Martin
 * @version 0.0.0.1
 * @since 20.05.2015
 */
@SuppressWarnings("serial")
public class Home extends JPanel
{

//Fields	
	
	//Text field that holds the filter box.
	private JTextField homeFilterText;
	
	//Holds all the items
	private ArrayList<Item> items;
	
	//items in list form.
	private static JList<String> homeItemsList;
	
	//a scroll pane for the list.
	private JScrollPane homeScrollPane;
	
//Constructor
	
	/**
	 * Creates the home page.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Home()
	{
		//puts them in the normal order.
		items = Page.Auction.filter(0, null);
		//Make the layout border layout.
		setLayout(new BorderLayout(0, 0));
		
		//Creates the inner panel with the gridbag layout.
		JPanel innerHomePanel = new JPanel();
		add(innerHomePanel, BorderLayout.CENTER);
		GridBagLayout gbl_innerHomePanel = new GridBagLayout();
		gbl_innerHomePanel.columnWidths = new int[]{0, 0, 0};
		gbl_innerHomePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_innerHomePanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_innerHomePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		innerHomePanel.setLayout(gbl_innerHomePanel);
		
	/** Starts fields */
		//filter label
		JLabel homeFilterLabel = new JLabel("Filter:");
		GridBagConstraints gbc_homeFilterLabel = new GridBagConstraints();
		gbc_homeFilterLabel.insets = new Insets(0, 0, 5, 5);
		gbc_homeFilterLabel.anchor = GridBagConstraints.EAST;
		gbc_homeFilterLabel.gridx = 0;
		gbc_homeFilterLabel.gridy = 0;
		innerHomePanel.add(homeFilterLabel, gbc_homeFilterLabel);
		
		//filter combo box (the drop down)
		JComboBox homeFilterCombo = new JComboBox();
		GridBagConstraints gbc_homeFilterCombo = new GridBagConstraints();
		gbc_homeFilterCombo.insets = new Insets(0, 0, 5, 0);
		gbc_homeFilterCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_homeFilterCombo.gridx = 1;
		gbc_homeFilterCombo.gridy = 0;
		homeFilterCombo.addItem("Name");
		homeFilterCombo.addItem("Current Bid");
		homeFilterCombo.addItem("Bid Count");
		homeFilterCombo.addItem("Description");
		homeFilterCombo.addItem("Appraisal");
		innerHomePanel.add(homeFilterCombo, gbc_homeFilterCombo);
		
		//a space
		JLabel space1 = new JLabel(" ");
		GridBagConstraints gbc_space1 = new GridBagConstraints();
		gbc_space1.insets = new Insets(0, 0, 5, 0);
		gbc_space1.gridx = 1;
		gbc_space1.gridy = 1;
		innerHomePanel.add(space1, gbc_space1);
		
		//filter text box
		homeFilterText = new JTextField();
		GridBagConstraints gbc_homeFilterText = new GridBagConstraints();
		gbc_homeFilterText.insets = new Insets(0, 0, 5, 0);
		gbc_homeFilterText.fill = GridBagConstraints.HORIZONTAL;
		gbc_homeFilterText.gridx = 1;
		gbc_homeFilterText.gridy = 2;
		innerHomePanel.add(homeFilterText, gbc_homeFilterText);
		homeFilterText.setColumns(10);
		
		//a space
		JLabel space2 = new JLabel(" ");
		GridBagConstraints gbc_space2 = new GridBagConstraints();
		gbc_space2.insets = new Insets(0, 0, 5, 0);
		gbc_space2.gridx = 1;
		gbc_space2.gridy = 3;
		innerHomePanel.add(space2, gbc_space2);
		
		//filter button
		JButton homeFilterButton = new JButton("Filter");

		GridBagConstraints gbc_homeFilterButton = new GridBagConstraints();
		gbc_homeFilterButton.insets = new Insets(0, 0, 5, 0);
		gbc_homeFilterButton.anchor = GridBagConstraints.EAST;
		gbc_homeFilterButton.gridx = 1;
		gbc_homeFilterButton.gridy = 4;
		innerHomePanel.add(homeFilterButton, gbc_homeFilterButton);
		
		//a space
		JLabel space3 = new JLabel(" ");
		GridBagConstraints gbc_space3 = new GridBagConstraints();
		gbc_space3.insets = new Insets(0, 0, 5, 0);
		gbc_space3.gridx = 1;
		gbc_space3.gridy = 5;
		innerHomePanel.add(space3, gbc_space3);
		
		//items panel
		JPanel homeItemsPanel = new JPanel();
		GridBagConstraints gbc_homeItemsPanel = new GridBagConstraints();
		gbc_homeItemsPanel.insets = new Insets(0, 0, 5, 0);
		gbc_homeItemsPanel.gridwidth = 2;
		gbc_homeItemsPanel.fill = GridBagConstraints.BOTH;
		gbc_homeItemsPanel.gridx = 0;
		gbc_homeItemsPanel.gridy = 6;
		innerHomePanel.add(homeItemsPanel, gbc_homeItemsPanel);
		homeItemsPanel.setLayout(new BorderLayout(0, 0));
		
		//the scroll pane
		homeScrollPane = new JScrollPane();
		homeItemsPanel.add(homeScrollPane, BorderLayout.CENTER);
		
		//items to bid on label
		JLabel homeItemstoBidLabel = new JLabel("Items to Bid On");
		homeScrollPane.setColumnHeaderView(homeItemstoBidLabel);
		
		//Formats the list.
		String[] StringOfItems = new String[items.size()];
		for (int i = 0; i < items.size(); i++)
		{
			StringOfItems[i] = String.format("%d: %s $%2.2f", i, items.get(i).getName(), items.get(i).getCurrentBid());
		}
		homeItemsList = new JList<String>(StringOfItems);
		homeItemsList.setModel(new AbstractListModel()
		{
			String[] values = StringOfItems;
			public int getSize()
			{
				return values.length;
			}
			public Object getElementAt(int index)
			{
				return values[index];
			}
		});
		
		homeItemsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //allows only a single item to be selected
		homeScrollPane.setViewportView(homeItemsList);
		
		//bid button
		JButton homeBidButton = new JButton("Bid on Selected Item");
		GridBagConstraints gbc_homeBidButton = new GridBagConstraints();
		gbc_homeBidButton.anchor = GridBagConstraints.EAST;
		gbc_homeBidButton.gridx = 1;
		gbc_homeBidButton.gridy = 7;
		homeBidButton.setEnabled(false);
		innerHomePanel.add(homeBidButton, gbc_homeBidButton);
	/** End fields */
		
	/** Start listeners */
		//the home filter button
		homeFilterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				homeBidButton.setEnabled(false);
				int type = homeFilterCombo.getSelectedIndex();
				String criteria = homeFilterText.getText();
				items = Page.Auction.filter(type, criteria);
				String[] StringOfItems = new String[items.size()];
				for (int i = 0; i < items.size(); i++)
				{
					StringOfItems[i] = String.format("%d: %s $%.2f", 
					    i, items.get(i).getName(), items.get(i).getCurrentBid());
				}
				
				homeItemsList = new JList<String>(StringOfItems);

				homeItemsList.setModel(new AbstractListModel()
				{
					String[] values = StringOfItems;
					public int getSize()
					{
						return values.length;
					}
					public Object getElementAt(int index)
					{
						return values[index];
					}
				});
				
				homeItemsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	//allows only a single item to be selected
				homeScrollPane.setViewportView(homeItemsList);
				
				homeItemsList.addListSelectionListener(new ListSelectionListener()
				{
					public void valueChanged(ListSelectionEvent e)
					{
						homeBidButton.setEnabled(true);
					}
				});	
			}
		});
		
		//the home bid button listener
		homeBidButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int index = homeItemsList.getSelectedIndex();
				//create new item panel
				Page.itemPanel = new ItemPage(items.get(index));
				Page.contentPane.add(Page.itemPanel);
				homeItemsList.clearSelection();
				homeBidButton.setEnabled(false);
				Page.homePanel.setVisible(false);
				Page.itemPanel.setVisible(true);
			}
		});
		
		//enable bid button if selection is chosen.
		homeItemsList.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				homeBidButton.setEnabled(true);
			}
		});
	}


}
