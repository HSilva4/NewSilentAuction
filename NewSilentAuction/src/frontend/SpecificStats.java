package frontend;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class creates the specific stats 'page' that shows stats for one single item.
 * 
 * @author The Expendables
 * @version 0.0.0.1
 * @since 20.05.2015
 */
public class SpecificStats extends JPanel
{

//Fields
	
	//Text fields that hold all of our info.
	private JTextField specItemNameText;
	private JTextField specCurrentBidText;
	private JTextField specDonorField;
	private JTextField specStartingBidText;
	
//Constructor
	
	/**
	 * Creates the specific stats page.
	 */
	public SpecificStats()
	{
		
		//Set the layout to border layout.
		setLayout(new BorderLayout(0, 0));
		
		//Creates the inner panel with gridbag layout.
		JPanel innerSpecPanel = new JPanel();
		add(innerSpecPanel, BorderLayout.CENTER);
		GridBagLayout gbl_innerSpecPanel = new GridBagLayout();
		gbl_innerSpecPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_innerSpecPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_innerSpecPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_innerSpecPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		innerSpecPanel.setLayout(gbl_innerSpecPanel);
		
	/** Start fields */
		//item name label
		JLabel specItemNameLabel = new JLabel("Item Name:");
		GridBagConstraints gbc_specItemNameLabel = new GridBagConstraints();
		gbc_specItemNameLabel.anchor = GridBagConstraints.WEST;
		gbc_specItemNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_specItemNameLabel.gridx = 0;
		gbc_specItemNameLabel.gridy = 0;
		innerSpecPanel.add(specItemNameLabel, gbc_specItemNameLabel);
		
		//item name text
		specItemNameText = new JTextField();
		specItemNameText.setEditable(false);
		GridBagConstraints gbc_specItemNameText = new GridBagConstraints();
		gbc_specItemNameText.insets = new Insets(0, 0, 5, 5);
		gbc_specItemNameText.fill = GridBagConstraints.HORIZONTAL;
		gbc_specItemNameText.gridx = 1;
		gbc_specItemNameText.gridy = 0;
		innerSpecPanel.add(specItemNameText, gbc_specItemNameText);
		specItemNameText.setColumns(10);
		
		//a space
		JLabel space__1 = new JLabel(" ");
		GridBagConstraints gbc_space__1 = new GridBagConstraints();
		gbc_space__1.insets = new Insets(0, 0, 5, 5);
		gbc_space__1.gridx = 1;
		gbc_space__1.gridy = 1;
		innerSpecPanel.add(space__1, gbc_space__1);
		
		//current bid label
		JLabel specCurrentBidLabel = new JLabel("Current Bid:");
		GridBagConstraints gbc_specCurrentBidLabel = new GridBagConstraints();
		gbc_specCurrentBidLabel.anchor = GridBagConstraints.WEST;
		gbc_specCurrentBidLabel.insets = new Insets(0, 0, 5, 5);
		gbc_specCurrentBidLabel.gridx = 0;
		gbc_specCurrentBidLabel.gridy = 2;
		innerSpecPanel.add(specCurrentBidLabel, gbc_specCurrentBidLabel);
		
		//current bid text
		specCurrentBidText = new JTextField();
		specCurrentBidText.setEditable(false);
		GridBagConstraints gbc_spaceCurrentBidText = new GridBagConstraints();
		gbc_spaceCurrentBidText.insets = new Insets(0, 0, 5, 5);
		gbc_spaceCurrentBidText.fill = GridBagConstraints.HORIZONTAL;
		gbc_spaceCurrentBidText.gridx = 1;
		gbc_spaceCurrentBidText.gridy = 2;
		innerSpecPanel.add(specCurrentBidText, gbc_spaceCurrentBidText);
		specCurrentBidText.setColumns(10);
		
		//a space
		JLabel space__2 = new JLabel(" ");
		GridBagConstraints gbc_space__2 = new GridBagConstraints();
		gbc_space__2.insets = new Insets(0, 0, 5, 5);
		gbc_space__2.gridx = 1;
		gbc_space__2.gridy = 3;
		innerSpecPanel.add(space__2, gbc_space__2);
		
		//donor label
		JLabel specDonorLabel = new JLabel("Total Number of bids:");
		GridBagConstraints gbc_specDonorLabel = new GridBagConstraints();
		gbc_specDonorLabel.anchor = GridBagConstraints.WEST;
		gbc_specDonorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_specDonorLabel.gridx = 0;
		gbc_specDonorLabel.gridy = 4;
		innerSpecPanel.add(specDonorLabel, gbc_specDonorLabel);
		
		//donor text
		specDonorField = new JTextField();
		specDonorField.setEditable(false);
		GridBagConstraints gbc_specDonorField = new GridBagConstraints();
		gbc_specDonorField.insets = new Insets(0, 0, 5, 5);
		gbc_specDonorField.fill = GridBagConstraints.HORIZONTAL;
		gbc_specDonorField.gridx = 1;
		gbc_specDonorField.gridy = 4;
		innerSpecPanel.add(specDonorField, gbc_specDonorField);
		specDonorField.setColumns(10);
		
		//a space
		JLabel space__3 = new JLabel(" ");
		GridBagConstraints gbc_space__3 = new GridBagConstraints();
		gbc_space__3.insets = new Insets(0, 0, 5, 5);
		gbc_space__3.gridx = 1;
		gbc_space__3.gridy = 5;
		innerSpecPanel.add(space__3, gbc_space__3);
		
		//starting bid label
		JLabel specStartingBidLabel = new JLabel("Starting Bid:");
		GridBagConstraints gbc_specStartingBidLabel = new GridBagConstraints();
		gbc_specStartingBidLabel.anchor = GridBagConstraints.WEST;
		gbc_specStartingBidLabel.insets = new Insets(0, 0, 5, 5);
		gbc_specStartingBidLabel.gridx = 0;
		gbc_specStartingBidLabel.gridy = 6;
		innerSpecPanel.add(specStartingBidLabel, gbc_specStartingBidLabel);
		
		// starting bid text
		specStartingBidText = new JTextField();
		specStartingBidText.setEditable(false);
		GridBagConstraints gbc_specStartingBidText = new GridBagConstraints();
		gbc_specStartingBidText.insets = new Insets(0, 0, 5, 5);
		gbc_specStartingBidText.fill = GridBagConstraints.HORIZONTAL;
		gbc_specStartingBidText.gridx = 1;
		gbc_specStartingBidText.gridy = 6;
		innerSpecPanel.add(specStartingBidText, gbc_specStartingBidText);
		specStartingBidText.setColumns(10);
		
		//a space
		JLabel space__4 = new JLabel(" ");
		GridBagConstraints gbc_space__4 = new GridBagConstraints();
		gbc_space__4.insets = new Insets(0, 0, 5, 5);
		gbc_space__4.gridx = 1;
		gbc_space__4.gridy = 7;
		innerSpecPanel.add(space__4, gbc_space__4);
		
		//back button
		JButton specBackButton = new JButton("Back");
		GridBagConstraints gbc_specBackButton = new GridBagConstraints();
		gbc_specBackButton.anchor = GridBagConstraints.WEST;
		gbc_specBackButton.insets = new Insets(0, 0, 0, 5);
		gbc_specBackButton.gridx = 0;
		gbc_specBackButton.gridy = 8;
		innerSpecPanel.add(specBackButton, gbc_specBackButton);
	/** End fields */
	}
}
