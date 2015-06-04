package frontend;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import backend.Bid;
import backend.Item;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class creates the item 'page' where you can see some info and bid.
 * 
 * @author The Expendables
 * @version 0.0.0.1
 * @since 20.05.2015
 */
@SuppressWarnings("serial")
public class ItemPage extends JPanel
{

//Fields
	
	//Holds the information in text fields.
	private JTextField ItemNameField;
	private JTextField ItemCurrentBidText;
	private JTextField itemDescriptionText;
	private JTextField itemBidderIDText;
	private JTextField itemNewBidField;
	
	//holds the current item.
	private Item currentItem;
	

//Constructor	
	
	/**
	 * Creates an item page with an item
	 */
	public ItemPage(Item item)
	{
		currentItem = item;
		
		//Sets the panel to border layout.
		setLayout(new BorderLayout(0, 0));
		
		//Creates an inner panel with gridbag layout.
		JPanel innerItemPanel = new JPanel();
		add(innerItemPanel, BorderLayout.CENTER);
		GridBagLayout gbl_innerItemPanel = new GridBagLayout();
		gbl_innerItemPanel.columnWidths = new int[]{0, 0, 0};
		gbl_innerItemPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_innerItemPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_innerItemPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		innerItemPanel.setLayout(gbl_innerItemPanel);
		
	/** Start fields */
		//name label
		JLabel itemNameLabel = new JLabel("Item Name:");
		GridBagConstraints gbc_itemNameLabel = new GridBagConstraints();
		gbc_itemNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_itemNameLabel.anchor = GridBagConstraints.WEST;
		gbc_itemNameLabel.gridx = 0;
		gbc_itemNameLabel.gridy = 0;
		innerItemPanel.add(itemNameLabel, gbc_itemNameLabel);
		
		//name text
		ItemNameField = new JTextField();
		ItemNameField.setEditable(false);
		GridBagConstraints gbc_ItemNameField = new GridBagConstraints();
		gbc_ItemNameField.insets = new Insets(0, 0, 5, 0);
		gbc_ItemNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ItemNameField.gridx = 1;
		gbc_ItemNameField.gridy = 0;
		ItemNameField.setText(currentItem.getName());	//Sets the  name field
		innerItemPanel.add(ItemNameField, gbc_ItemNameField);
		ItemNameField.setColumns(10);
		
		//a space
		JLabel space___1 = new JLabel(" ");
		GridBagConstraints gbc_space___1 = new GridBagConstraints();
		gbc_space___1.insets = new Insets(0, 0, 5, 0);
		gbc_space___1.gridx = 1;
		gbc_space___1.gridy = 1;
		innerItemPanel.add(space___1, gbc_space___1);
		
		//current bid label
		JLabel itemCurrentBidLabel = new JLabel("Current Bid:");
		GridBagConstraints gbc_itemCurrentBidLabel = new GridBagConstraints();
		gbc_itemCurrentBidLabel.anchor = GridBagConstraints.WEST;
		gbc_itemCurrentBidLabel.insets = new Insets(0, 0, 5, 5);
		gbc_itemCurrentBidLabel.gridx = 0;
		gbc_itemCurrentBidLabel.gridy = 2;
		innerItemPanel.add(itemCurrentBidLabel, gbc_itemCurrentBidLabel);
		
		//current bid text
		ItemCurrentBidText = new JTextField();
		ItemCurrentBidText.setEditable(false);
		GridBagConstraints gbc_ItemCurrentBidText = new GridBagConstraints();
		gbc_ItemCurrentBidText.insets = new Insets(0, 0, 5, 0);
		gbc_ItemCurrentBidText.fill = GridBagConstraints.HORIZONTAL;
		gbc_ItemCurrentBidText.gridx = 1;
		gbc_ItemCurrentBidText.gridy = 2;
		ItemCurrentBidText.setText("$" + currentItem.getCurrentBid());
		innerItemPanel.add(ItemCurrentBidText, gbc_ItemCurrentBidText);
		ItemCurrentBidText.setColumns(10);
		
		//a space
		JLabel space___2 = new JLabel(" ");
		GridBagConstraints gbc_space___2 = new GridBagConstraints();
		gbc_space___2.insets = new Insets(0, 0, 5, 0);
		gbc_space___2.gridx = 1;
		gbc_space___2.gridy = 3;
		innerItemPanel.add(space___2, gbc_space___2);
		
		//description label
		JLabel itemDescriptionLabel = new JLabel("Item Description:");
		GridBagConstraints gbc_itemDescriptionLabel = new GridBagConstraints();
		gbc_itemDescriptionLabel.anchor = GridBagConstraints.WEST;
		gbc_itemDescriptionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_itemDescriptionLabel.gridx = 0;
		gbc_itemDescriptionLabel.gridy = 4;
		innerItemPanel.add(itemDescriptionLabel, gbc_itemDescriptionLabel);
		
		//description text
		itemDescriptionText = new JTextField();
		itemDescriptionText.setEditable(false);
		GridBagConstraints gbc_itemDescriptionText = new GridBagConstraints();
		gbc_itemDescriptionText.insets = new Insets(0, 0, 5, 0);
		gbc_itemDescriptionText.fill = GridBagConstraints.HORIZONTAL;
		gbc_itemDescriptionText.gridx = 1;
		gbc_itemDescriptionText.gridy = 4;
		itemDescriptionText.setText(currentItem.getDescription());
		innerItemPanel.add(itemDescriptionText, gbc_itemDescriptionText);
		itemDescriptionText.setColumns(10);
		
		//a space
		JLabel space___3 = new JLabel(" ");
		GridBagConstraints gbc_space___3 = new GridBagConstraints();
		gbc_space___3.insets = new Insets(0, 0, 5, 0);
		gbc_space___3.gridx = 1;
		gbc_space___3.gridy = 5;
		innerItemPanel.add(space___3, gbc_space___3);
		
		//a separator
		JSeparator itemSeparator = new JSeparator();
		GridBagConstraints gbc_itemSeparator = new GridBagConstraints();
		gbc_itemSeparator.gridwidth = 2;
		gbc_itemSeparator.insets = new Insets(0, 0, 5, 0);
		gbc_itemSeparator.gridx = 0;
		gbc_itemSeparator.gridy = 6;
		innerItemPanel.add(itemSeparator, gbc_itemSeparator);
		
		//a space
		JLabel space___4 = new JLabel(" ");
		GridBagConstraints gbc_space___4 = new GridBagConstraints();
		gbc_space___4.insets = new Insets(0, 0, 5, 0);
		gbc_space___4.gridx = 1;
		gbc_space___4.gridy = 7;
		innerItemPanel.add(space___4, gbc_space___4);
		
		//bidder it label
		JLabel itemBidderIDLabel = new JLabel("Your Bidder ID:");
		GridBagConstraints gbc_itemBidderIDLabel = new GridBagConstraints();
		gbc_itemBidderIDLabel.anchor = GridBagConstraints.WEST;
		gbc_itemBidderIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_itemBidderIDLabel.gridx = 0;
		gbc_itemBidderIDLabel.gridy = 8;
		innerItemPanel.add(itemBidderIDLabel, gbc_itemBidderIDLabel);
		
		//bidder id text
		itemBidderIDText = new JTextField();
		GridBagConstraints gbc_itemBidderIDText = new GridBagConstraints();
		gbc_itemBidderIDText.insets = new Insets(0, 0, 5, 0);
		gbc_itemBidderIDText.fill = GridBagConstraints.HORIZONTAL;
		gbc_itemBidderIDText.gridx = 1;
		gbc_itemBidderIDText.gridy = 8;
		innerItemPanel.add(itemBidderIDText, gbc_itemBidderIDText);
		itemBidderIDText.setColumns(10);
		
		//a space
		JLabel space___5 = new JLabel(" ");
		GridBagConstraints gbc_space___5 = new GridBagConstraints();
		gbc_space___5.insets = new Insets(0, 0, 5, 0);
		gbc_space___5.gridx = 1;
		gbc_space___5.gridy = 9;
		innerItemPanel.add(space___5, gbc_space___5);
		
		//new bid label
		JLabel itemNewBidLabel = new JLabel("Your New Bid:");
		GridBagConstraints gbc_itemNewBidLabel = new GridBagConstraints();
		gbc_itemNewBidLabel.anchor = GridBagConstraints.WEST;
		gbc_itemNewBidLabel.insets = new Insets(0, 0, 5, 5);
		gbc_itemNewBidLabel.gridx = 0;
		gbc_itemNewBidLabel.gridy = 10;
		innerItemPanel.add(itemNewBidLabel, gbc_itemNewBidLabel);
		
		//new bid text
		itemNewBidField = new JTextField();
		GridBagConstraints gbc_itemNewBidField = new GridBagConstraints();
		gbc_itemNewBidField.insets = new Insets(0, 0, 5, 0);
		gbc_itemNewBidField.fill = GridBagConstraints.HORIZONTAL;
		gbc_itemNewBidField.gridx = 1;
		gbc_itemNewBidField.gridy = 10;
		innerItemPanel.add(itemNewBidField, gbc_itemNewBidField);
		itemNewBidField.setColumns(10);
		
		//a space
		JLabel space___6 = new JLabel(" ");
		GridBagConstraints gbc_space___6 = new GridBagConstraints();
		gbc_space___6.insets = new Insets(0, 0, 5, 0);
		gbc_space___6.gridx = 1;
		gbc_space___6.gridy = 11;
		innerItemPanel.add(space___6, gbc_space___6);
		
		//back button
		JButton itemBackButton = new JButton("Back");
		GridBagConstraints gbc_itemBackButton = new GridBagConstraints();
		gbc_itemBackButton.anchor = GridBagConstraints.WEST;
		gbc_itemBackButton.insets = new Insets(0, 0, 0, 5);
		gbc_itemBackButton.gridx = 0;
		gbc_itemBackButton.gridy = 12;
		innerItemPanel.add(itemBackButton, gbc_itemBackButton);
		
		//new bid button
		JButton itemNewBidButton = new JButton("Enter New Bid");
		GridBagConstraints gbc_itemNewBidButton = new GridBagConstraints();
		gbc_itemNewBidButton.anchor = GridBagConstraints.EAST;
		gbc_itemNewBidButton.gridx = 1;
		gbc_itemNewBidButton.gridy = 12;
		itemNewBidButton.setEnabled(false);
		innerItemPanel.add(itemNewBidButton, gbc_itemNewBidButton);
	/** End fields */
		
	/** Start listeners */
		//Item back button goes to home
		itemBackButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				resetPanel();
				
				Page.itemPanel.setVisible(false);
				
				Page.homePanel = new Home();
				Page.contentPane.add(Page.homePanel);
				Page.homePanel.setVisible(true);
				
			}
		});
		
		//Item new bid button
		itemNewBidButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (!itemNewBidField.getText().matches("[0-9]+([,.][0-9]{1,2})?"))
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid bid.");
				}
				else
				{
					if (!itemBidderIDText.getText().matches("[0-9]+"))
					{
						JOptionPane.showMessageDialog(null, "Please enter a valid ID number. "
								+ "If you do not have one, you can register by going to the registration menu item");
					}
					else
					{
						double bidAmount = Double.parseDouble(itemNewBidField.getText());
						int bidderID = Integer.parseInt(itemBidderIDText.getText());
						if (!Page.Auction.users.containsKey(bidderID))
						{
							JOptionPane.showMessageDialog(null, "This ID is not currently registered. To register, "
									+ "please visit the registration page.");
						}
						else if (currentItem.getCurrentBid() >= bidAmount)
						{
							JOptionPane.showMessageDialog(null, "You must enter in a bid that is greater than the "
									+ "current bid.");
						}
						else
						{
							Bid bid = new Bid(bidderID, bidAmount);
							currentItem.addBid(bid);

							JOptionPane.showMessageDialog(null, "Thank you for placing your bid value of: $" + bidAmount);
							itemNewBidButton.setEnabled(false);
							resetPanel();
							Page.itemPanel.setVisible(false);
							Page.homePanel = new Home();
							Page.contentPane.add(Page.homePanel);
							Page.homePanel.setVisible(true);
						}
					}
				}
			}
		});
		
		//only enables the bid button if all fields are filled out.
		itemBidderIDText.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
		           if(itemNewBidField.getText().length() == 0 || itemBidderIDText.getText().length() == 0)
		                itemNewBidButton.setEnabled(false);
		            else
		            {
		                itemNewBidButton.setEnabled(true);
		            }
			}
		});
		
		//same for the bid field
		itemNewBidField.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e) 
			{
		           if(itemNewBidField.getText().length() == 0 || itemBidderIDText.getText().length() == 0)
		                itemNewBidButton.setEnabled(false);
		            else
		            {
		                itemNewBidButton.setEnabled(true);
		            }
			}
		});	
	/** End listeners */
	}
	
//Methods
	
	/**
	 * This method will reset the panel upon leaving.
	 */
	void resetPanel()
	{
		ItemNameField.setText(null);
		ItemCurrentBidText.setText(null);
		itemDescriptionText.setText(null);
		itemNewBidField.setText(null);
		itemBidderIDText.setText(null);
	}
}
