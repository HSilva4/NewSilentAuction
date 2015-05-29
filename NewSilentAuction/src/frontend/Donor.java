package frontend;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class creates the donor 'page' which holds the fields for a person to become a donor.
 * 
 * @author The Expendables
 * @version 0.0.0.1
 * @since 20.05.2015
 */
public class Donor extends JPanel
{
	
//Fields
	
	//Text fields for all the information we need.
	private JTextField donateNameField;
	private JTextField donateEmailField;
	private JTextField donatePhoneField;
	private JTextField donateCompanyField;
	private JTextField donateItemField;
	private JTextField donateBidField;
	
//Constructor
	
	/**
	 * Create the donor panel.
	 */
	public Donor()
	{

		//Make the panel a border layout.
		setLayout(new BorderLayout(0, 0));
		
		//Create the inner panel that has gridbag layout.
		JPanel innerDonPanel = new JPanel();
		add(innerDonPanel, BorderLayout.CENTER);
		GridBagLayout gbl_innerDonPanel = new GridBagLayout();
		gbl_innerDonPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_innerDonPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_innerDonPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_innerDonPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		innerDonPanel.setLayout(gbl_innerDonPanel);
		
	/** Start fields */
		//name label
		JLabel doanteNameLabel = new JLabel("Enter your name:");
		GridBagConstraints gbc_doanteNameLabel = new GridBagConstraints();
		gbc_doanteNameLabel.anchor = GridBagConstraints.WEST;
		gbc_doanteNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_doanteNameLabel.gridx = 3;
		gbc_doanteNameLabel.gridy = 0;
		innerDonPanel.add(doanteNameLabel, gbc_doanteNameLabel);
		
		//name text box
		donateNameField = new JTextField();

		donateNameField.setColumns(10);
		GridBagConstraints gbc_donateNameField = new GridBagConstraints();
		gbc_donateNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_donateNameField.insets = new Insets(0, 0, 5, 0);
		gbc_donateNameField.gridx = 5;
		gbc_donateNameField.gridy = 0;
		innerDonPanel.add(donateNameField, gbc_donateNameField);
		
		//a space to format
		JLabel space1 = new JLabel(" ");
		GridBagConstraints gbc_space1 = new GridBagConstraints();
		gbc_space1.insets = new Insets(0, 0, 5, 0);
		gbc_space1.gridx = 5;
		gbc_space1.gridy = 1;
		innerDonPanel.add(space1, gbc_space1);
		
		//email label
		JLabel donateEmailLabel = new JLabel("Enter your email:");
		GridBagConstraints gbc_donateEmailLabel = new GridBagConstraints();
		gbc_donateEmailLabel.anchor = GridBagConstraints.WEST;
		gbc_donateEmailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_donateEmailLabel.gridx = 3;
		gbc_donateEmailLabel.gridy = 2;
		innerDonPanel.add(donateEmailLabel, gbc_donateEmailLabel);
		
		//email text box
		donateEmailField = new JTextField();
		donateEmailField.setColumns(10);
		GridBagConstraints gbc_donateEmailField = new GridBagConstraints();
		gbc_donateEmailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_donateEmailField.insets = new Insets(0, 0, 5, 0);
		gbc_donateEmailField.gridx = 5;
		gbc_donateEmailField.gridy = 2;
		innerDonPanel.add(donateEmailField, gbc_donateEmailField);
		
		//a space
		JLabel space2 = new JLabel(" ");
		GridBagConstraints gbc_space2 = new GridBagConstraints();
		gbc_space2.insets = new Insets(0, 0, 5, 0);
		gbc_space2.gridx = 5;
		gbc_space2.gridy = 3;
		innerDonPanel.add(space2, gbc_space2);
		
		//company label
		JLabel donateCompanyLabel = new JLabel("Enter your company:");
		GridBagConstraints gbc_donateCompanyLabel = new GridBagConstraints();
		gbc_donateCompanyLabel.anchor = GridBagConstraints.WEST;
		gbc_donateCompanyLabel.insets = new Insets(0, 0, 5, 5);
		gbc_donateCompanyLabel.gridx = 3;
		gbc_donateCompanyLabel.gridy = 4;
		innerDonPanel.add(donateCompanyLabel, gbc_donateCompanyLabel);
		
		//company text box
		donateCompanyField = new JTextField();
		GridBagConstraints gbc_donateCompanyField = new GridBagConstraints();
		gbc_donateCompanyField.insets = new Insets(0, 0, 5, 0);
		gbc_donateCompanyField.fill = GridBagConstraints.HORIZONTAL;
		gbc_donateCompanyField.gridx = 5;
		gbc_donateCompanyField.gridy = 4;
		innerDonPanel.add(donateCompanyField, gbc_donateCompanyField);
		donateCompanyField.setColumns(10);
		
		//a space
		JLabel space3 = new JLabel(" ");
		GridBagConstraints gbc_space3 = new GridBagConstraints();
		gbc_space3.insets = new Insets(0, 0, 5, 0);
		gbc_space3.gridx = 5;
		gbc_space3.gridy = 5;
		innerDonPanel.add(space3, gbc_space3);
		
		//phone number label
		JLabel donateNumberLabel = new JLabel("Enter your phone number:");
		GridBagConstraints gbc_donateNumberLabel = new GridBagConstraints();
		gbc_donateNumberLabel.anchor = GridBagConstraints.WEST;
		gbc_donateNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_donateNumberLabel.gridx = 3;
		gbc_donateNumberLabel.gridy = 6;
		innerDonPanel.add(donateNumberLabel, gbc_donateNumberLabel);
		
		//phone number text box
		donatePhoneField = new JTextField();
		donatePhoneField.setColumns(10);
		GridBagConstraints gbc_donatePhoneField = new GridBagConstraints();
		gbc_donatePhoneField.fill = GridBagConstraints.HORIZONTAL;
		gbc_donatePhoneField.insets = new Insets(0, 0, 5, 0);
		gbc_donatePhoneField.gridx = 5;
		gbc_donatePhoneField.gridy = 6;
		innerDonPanel.add(donatePhoneField, gbc_donatePhoneField);
		
		//a space
		JLabel space4 = new JLabel(" ");
		GridBagConstraints gbc_space4 = new GridBagConstraints();
		gbc_space4.insets = new Insets(0, 0, 5, 0);
		gbc_space4.gridx = 5;
		gbc_space4.gridy = 7;
		innerDonPanel.add(space4, gbc_space4);
		
		//item label
		JLabel donateItemLabel = new JLabel("Enter your item name:");
		GridBagConstraints gbc_donateItemLabel = new GridBagConstraints();
		gbc_donateItemLabel.anchor = GridBagConstraints.WEST;
		gbc_donateItemLabel.insets = new Insets(0, 0, 5, 5);
		gbc_donateItemLabel.gridx = 3;
		gbc_donateItemLabel.gridy = 8;
		innerDonPanel.add(donateItemLabel, gbc_donateItemLabel);
		
		//item text box
		donateItemField = new JTextField();
		GridBagConstraints gbc_donateItemField = new GridBagConstraints();
		gbc_donateItemField.insets = new Insets(0, 0, 5, 0);
		gbc_donateItemField.fill = GridBagConstraints.HORIZONTAL;
		gbc_donateItemField.gridx = 5;
		gbc_donateItemField.gridy = 8;
		innerDonPanel.add(donateItemField, gbc_donateItemField);
		donateItemField.setColumns(10);
		
		//space
		JLabel space5 = new JLabel(" ");
		GridBagConstraints gbc_space5 = new GridBagConstraints();
		gbc_space5.insets = new Insets(0, 0, 5, 0);
		gbc_space5.gridx = 5;
		gbc_space5.gridy = 9;
		innerDonPanel.add(space5, gbc_space5);
		
		//minimum bid label
		JLabel donateBidLabel = new JLabel("Enter starting bid:");
		GridBagConstraints gbc_donateBidLabel = new GridBagConstraints();
		gbc_donateBidLabel.anchor = GridBagConstraints.WEST;
		gbc_donateBidLabel.insets = new Insets(0, 0, 5, 5);
		gbc_donateBidLabel.gridx = 3;
		gbc_donateBidLabel.gridy = 10;
		innerDonPanel.add(donateBidLabel, gbc_donateBidLabel);
		
		//minimum bid text box
		donateBidField = new JTextField();
		GridBagConstraints gbc_donateBidField = new GridBagConstraints();
		gbc_donateBidField.insets = new Insets(0, 0, 5, 0);
		gbc_donateBidField.fill = GridBagConstraints.HORIZONTAL;
		gbc_donateBidField.gridx = 5;
		gbc_donateBidField.gridy = 10;
		innerDonPanel.add(donateBidField, gbc_donateBidField);
		donateBidField.setColumns(10);
		
		//a space
		JLabel space6 = new JLabel(" ");
		GridBagConstraints gbc_space6 = new GridBagConstraints();
		gbc_space6.insets = new Insets(0, 0, 5, 0);
		gbc_space6.gridx = 5;
		gbc_space6.gridy = 11;
		innerDonPanel.add(space6, gbc_space6);
		
		//the donate button
		JButton donateButton = new JButton("Donate");
		GridBagConstraints gbc_donateButton = new GridBagConstraints();
		gbc_donateButton.anchor = GridBagConstraints.EAST;
		gbc_donateButton.gridx = 5;
		gbc_donateButton.gridy = 12;
		donateButton.setEnabled(false);
		innerDonPanel.add(donateButton, gbc_donateButton);
	/** End fields */
		
	/** Start listeners */
		//donate button
		donateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				
				String name = donateNameField.getText();
				String email = donateEmailField.getText();
				String phoneNumber = donatePhoneField.getText();
				String companyName = donateCompanyField.getText();
				String itemName = donateItemField.getText();
				double bid;
				if (phoneNumber.length() != 10 || !phoneNumber.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Please enter a valid phone number");
				}
				else {
					if (!donateBidField.getText().matches("[0-9]+")) {
						JOptionPane.showMessageDialog(null, "Please enter a valid price for your bid.");
					}
					else {
						bid = Double.parseDouble(donateBidField.getText());
						//TODO: create a new donor with the information
						//make sure to do error checking.
						JOptionPane.showMessageDialog(null, "Thank you for donating your item: " + itemName);
					}
				}
			}
		});
		
		donateNameField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
		           if(donateNameField.getText().length() == 0 || donateEmailField.getText().length() == 0 
		        		   || donatePhoneField.getText().length() == 0 || donateCompanyField.getText().length() == 0 
		        		   || donateItemField.getText().length() == 0 || donateBidField.getText().length() == 0)
		                donateButton.setEnabled(false);
		            else
		            {
		                donateButton.setEnabled(true);
		            }
			}
		});
		
		donateEmailField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
		           if(donateNameField.getText().length() == 0 || donateEmailField.getText().length() == 0 
		        		   || donatePhoneField.getText().length() == 0 || donateCompanyField.getText().length() == 0 
		        		   || donateItemField.getText().length() == 0 || donateBidField.getText().length() == 0)
		                donateButton.setEnabled(false);
		            else
		            {
		                donateButton.setEnabled(true);
		            }
			}
		});
		
		donatePhoneField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
		           if(donateNameField.getText().length() == 0 || donateEmailField.getText().length() == 0 
		        		   || donatePhoneField.getText().length() == 0 || donateCompanyField.getText().length() == 0 
		        		   || donateItemField.getText().length() == 0 || donateBidField.getText().length() == 0)
		                donateButton.setEnabled(false);
		            else
		            {
		                donateButton.setEnabled(true);
		            }
			}
		});
		
		donateCompanyField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
		           if(donateNameField.getText().length() == 0 || donateEmailField.getText().length() == 0 
		        		   || donatePhoneField.getText().length() == 0 || donateCompanyField.getText().length() == 0 
		        		   || donateItemField.getText().length() == 0 || donateBidField.getText().length() == 0)
		                donateButton.setEnabled(false);
		            else
		            {
		                donateButton.setEnabled(true);
		            }
			}
		});
		
		donateItemField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
		           if(donateNameField.getText().length() == 0 || donateEmailField.getText().length() == 0 
		        		   || donatePhoneField.getText().length() == 0 || donateCompanyField.getText().length() == 0 
		        		   || donateItemField.getText().length() == 0 || donateBidField.getText().length() == 0)
		                donateButton.setEnabled(false);
		            else
		            {
		                donateButton.setEnabled(true);
		            }
			}
		});
		
		donateBidField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
		           if(donateNameField.getText().length() == 0 || donateEmailField.getText().length() == 0 
		        		   || donatePhoneField.getText().length() == 0 || donateCompanyField.getText().length() == 0 
		        		   || donateItemField.getText().length() == 0 || donateBidField.getText().length() == 0)
		                donateButton.setEnabled(false);
		            else
		            {
		                donateButton.setEnabled(true);
		            }
			}
		});
	}	

}