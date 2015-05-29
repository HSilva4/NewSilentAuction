package frontend;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * This class creates the General Statistics 'page' that shows stats for the event itself.
 * 
 * @author The Expendables
 * @version 0.0.0.1
 * @since 20.05.2015
 */
public class GeneralStats extends JPanel
{

//Fields
	
	//The text fields that holds our info.
	private JTextField genStatsNumberText;
	private JTextField genStatsAverageText;
	private JTextField genStatsDurationText;
	
//Constructor
	
	/**
	 * Creates the full general stats page.
	 */
	public GeneralStats()
	{
		
		//Sets the layout to border layout.
		setLayout(new BorderLayout(0, 0));
		
		//Creates the inner panel with gridbag layout.
		JPanel innerGenStatsPanel = new JPanel();
		add(innerGenStatsPanel, BorderLayout.CENTER);
		GridBagLayout gbl_innerGenStatsPanel = new GridBagLayout();
		gbl_innerGenStatsPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_innerGenStatsPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_innerGenStatsPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_innerGenStatsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		innerGenStatsPanel.setLayout(gbl_innerGenStatsPanel);
		
	/** Start fields */
		//total bids number label
		JLabel genStatsNumberLabel = new JLabel("Total Number of Bids Placed During the Event:");
		GridBagConstraints gbc_genStatsNumberLabel = new GridBagConstraints();
		gbc_genStatsNumberLabel.anchor = GridBagConstraints.WEST;
		gbc_genStatsNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_genStatsNumberLabel.gridx = 0;
		gbc_genStatsNumberLabel.gridy = 0;
		innerGenStatsPanel.add(genStatsNumberLabel, gbc_genStatsNumberLabel);
		
		//total bids text field
		genStatsNumberText = new JTextField();
		genStatsNumberText.setEditable(false);
		GridBagConstraints gbc_genStatsNumberText = new GridBagConstraints();
		gbc_genStatsNumberText.insets = new Insets(0, 0, 5, 5);
		gbc_genStatsNumberText.fill = GridBagConstraints.HORIZONTAL;
		gbc_genStatsNumberText.gridx = 2;
		gbc_genStatsNumberText.gridy = 0;
		innerGenStatsPanel.add(genStatsNumberText, gbc_genStatsNumberText);
		genStatsNumberText.setColumns(10);
		
		//a space
		JLabel space_1 = new JLabel(" ");
		GridBagConstraints gbc_space_1 = new GridBagConstraints();
		gbc_space_1.insets = new Insets(0, 0, 5, 5);
		gbc_space_1.gridx = 1;
		gbc_space_1.gridy = 1;
		innerGenStatsPanel.add(space_1, gbc_space_1);
		
		//average bid label
		JLabel genStatsAverageLabel = new JLabel("Average Number of Bids Per Item:");
		GridBagConstraints gbc_genStatsAverageLabel = new GridBagConstraints();
		gbc_genStatsAverageLabel.anchor = GridBagConstraints.WEST;
		gbc_genStatsAverageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_genStatsAverageLabel.gridx = 0;
		gbc_genStatsAverageLabel.gridy = 2;
		innerGenStatsPanel.add(genStatsAverageLabel, gbc_genStatsAverageLabel);
		
		//average bid text
		genStatsAverageText = new JTextField();
		genStatsAverageText.setEditable(false);
		GridBagConstraints gbc_genStatsAverageText = new GridBagConstraints();
		gbc_genStatsAverageText.insets = new Insets(0, 0, 5, 5);
		gbc_genStatsAverageText.fill = GridBagConstraints.HORIZONTAL;
		gbc_genStatsAverageText.gridx = 2;
		gbc_genStatsAverageText.gridy = 2;
		innerGenStatsPanel.add(genStatsAverageText, gbc_genStatsAverageText);
		genStatsAverageText.setColumns(10);
		
		//a space
		JLabel space_2 = new JLabel(" ");
		GridBagConstraints gbc_space_2 = new GridBagConstraints();
		gbc_space_2.insets = new Insets(0, 0, 5, 5);
		gbc_space_2.gridx = 2;
		gbc_space_2.gridy = 3;
		innerGenStatsPanel.add(space_2, gbc_space_2);
		
		//duration label
		JLabel genStatsDurationLabel = new JLabel("Duration of the Event:");
		GridBagConstraints gbc_genStatsDurationLabel = new GridBagConstraints();
		gbc_genStatsDurationLabel.anchor = GridBagConstraints.WEST;
		gbc_genStatsDurationLabel.insets = new Insets(0, 0, 5, 5);
		gbc_genStatsDurationLabel.gridx = 0;
		gbc_genStatsDurationLabel.gridy = 4;
		innerGenStatsPanel.add(genStatsDurationLabel, gbc_genStatsDurationLabel);
		
		//duration field
		genStatsDurationText = new JTextField();
		genStatsDurationText.setEditable(false);
		GridBagConstraints gbc_genStatsDurationText = new GridBagConstraints();
		gbc_genStatsDurationText.insets = new Insets(0, 0, 5, 5);
		gbc_genStatsDurationText.fill = GridBagConstraints.HORIZONTAL;
		gbc_genStatsDurationText.gridx = 2;
		gbc_genStatsDurationText.gridy = 4;
		innerGenStatsPanel.add(genStatsDurationText, gbc_genStatsDurationText);
		genStatsDurationText.setColumns(10);
		
		//a space
		JLabel space_3 = new JLabel(" ");
		GridBagConstraints gbc_space_3 = new GridBagConstraints();
		gbc_space_3.insets = new Insets(0, 0, 5, 5);
		gbc_space_3.gridx = 2;
		gbc_space_3.gridy = 5;
		innerGenStatsPanel.add(space_3, gbc_space_3);
		
		//items panel
		JPanel genStatsItemPanel = new JPanel();
		GridBagConstraints gbc_genStatsItemPanel = new GridBagConstraints();
		gbc_genStatsItemPanel.insets = new Insets(0, 0, 5, 5);
		gbc_genStatsItemPanel.gridwidth = 3;
		gbc_genStatsItemPanel.fill = GridBagConstraints.BOTH;
		gbc_genStatsItemPanel.gridx = 0;
		gbc_genStatsItemPanel.gridy = 6;
		innerGenStatsPanel.add(genStatsItemPanel, gbc_genStatsItemPanel);
		genStatsItemPanel.setLayout(new BorderLayout(0, 0));
		
		//items scroll pane
		JScrollPane genStatsScrollPanel = new JScrollPane();
		genStatsItemPanel.add(genStatsScrollPanel, BorderLayout.CENTER);
		
		//stats list
		JList genStatsList = new JList();
		genStatsScrollPanel.setViewportView(genStatsList);
		
		//stats label
		JLabel genStatsListofLabel = new JLabel("List of All Items");
		genStatsScrollPanel.setColumnHeaderView(genStatsListofLabel);
		
		//get specific button
		JButton genStatsButton = new JButton("Get Specific Stats");
		GridBagConstraints gbc_genStatsButton = new GridBagConstraints();
		gbc_genStatsButton.anchor = GridBagConstraints.EAST;
		gbc_genStatsButton.insets = new Insets(0, 0, 0, 5);
		gbc_genStatsButton.gridx = 2;
		gbc_genStatsButton.gridy = 7;
		innerGenStatsPanel.add(genStatsButton, gbc_genStatsButton);
	/** End fields */
	}
}
