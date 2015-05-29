package frontend;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class creates the registration 'page' so that users can register to be a new user.
 * 
 * @author The Expendables
 * @version 0.0.0.1
 * @since 20.05.2015
 */
public class Registration extends JPanel
{

//Fields
	
	//Text fields to get the information from the user.
	private JTextField nameField;
	private JTextField emailField;
	private JTextField phoneField;
	
	/**
	 * Create the panel.
	 */
	public Registration()
	{

		//Set the layout to border layout.
		setLayout(new BorderLayout(0, 0));
		
		//An inner pannel to have the gridbag layout.
		JPanel innerRegPanel = new JPanel();
		add(innerRegPanel, BorderLayout.CENTER);
		
		//Creating the layout.
		GridBagLayout gbl_innerRegPanel = new GridBagLayout();
		gbl_innerRegPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_innerRegPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_innerRegPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_innerRegPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		innerRegPanel.setLayout(gbl_innerRegPanel);
		
	/** Start Fields */
		//name label
		JLabel nameLabel = new JLabel("Enter your name:");
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.WEST;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 3;
		gbc_nameLabel.gridy = 0;
		innerRegPanel.add(nameLabel, gbc_nameLabel);
		
		//name text box
		nameField = new JTextField();

		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(0, 0, 5, 0);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 5;
		gbc_nameField.gridy = 0;
		innerRegPanel.add(nameField, gbc_nameField);
		nameField.setColumns(10);
		
		//a space
		JLabel label = new JLabel(" ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 5;
		gbc_label.gridy = 1;
		innerRegPanel.add(label, gbc_label);
		
		//email label
		JLabel emailLabel = new JLabel("Enter your email:");
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.WEST;
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridx = 3;
		gbc_emailLabel.gridy = 2;
		innerRegPanel.add(emailLabel, gbc_emailLabel);
		
		//email text box
		emailField = new JTextField();
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.insets = new Insets(0, 0, 5, 0);
		gbc_emailField.gridx = 5;
		gbc_emailField.gridy = 2;
		innerRegPanel.add(emailField, gbc_emailField);
		emailField.setColumns(10);
		
		//a space
		JLabel label_1 = new JLabel(" ");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 5;
		gbc_label_1.gridy = 3;
		innerRegPanel.add(label_1, gbc_label_1);
		
		//phone number label
		JLabel phoneLabel = new JLabel("Enter your phone number:");
		GridBagConstraints gbc_phoneLabel = new GridBagConstraints();
		gbc_phoneLabel.anchor = GridBagConstraints.WEST;
		gbc_phoneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_phoneLabel.gridx = 3;
		gbc_phoneLabel.gridy = 4;
		innerRegPanel.add(phoneLabel, gbc_phoneLabel);
		
		//phone number text box
		phoneField = new JTextField();
		GridBagConstraints gbc_phoneField = new GridBagConstraints();
		gbc_phoneField.insets = new Insets(0, 0, 5, 0);
		gbc_phoneField.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneField.gridx = 5;
		gbc_phoneField.gridy = 4;
		innerRegPanel.add(phoneField, gbc_phoneField);
		phoneField.setColumns(10);
		
		//a space
		JLabel label_2 = new JLabel(" ");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 5;
		gbc_label_2.gridy = 5;
		innerRegPanel.add(label_2, gbc_label_2);
				
		//the register button
		JButton btnRegister = new JButton("Register");
		btnRegister.setEnabled(false);

	/** End fields */
		
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.insets = new Insets(0, 0, 5, 0);
		gbc_btnRegister.anchor = GridBagConstraints.EAST;
		gbc_btnRegister.gridx = 5;
		gbc_btnRegister.gridy = 6;
		innerRegPanel.add(btnRegister, gbc_btnRegister);
		
	/** Start listeners */
		//register button
		btnRegister.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//TODO Create a new user with ID
				
				String name = nameField.getText();
				String email = emailField.getText();
				String phoneNumber = phoneField.getText();
				if (phoneNumber.length() != 10 || !phoneNumber.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Please enter a valid phone number");
				}
				else {
					JOptionPane.showMessageDialog(null, "Thank you for registering, " + name);
					Page.registrationPanel.setVisible(false);
					Page.homePanel.setVisible(true);
				}
					
				
			}
		});
		
		nameField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
		           if(emailField.getText().length() == 0 || phoneField.getText().length() == 0 
		        		   || nameField.getText().length() == 0)
		                btnRegister.setEnabled(false);
		            else
		            {
		                btnRegister.setEnabled(true);
		            }
			}
		});
		
		emailField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
		           if(emailField.getText().length() == 0 || phoneField.getText().length() == 0 
		        		   || nameField.getText().length() == 0)
		                btnRegister.setEnabled(false);
		            else
		            {
		                btnRegister.setEnabled(true);
		            }
			}
		});
		
		phoneField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
		           if(emailField.getText().length() == 0 || phoneField.getText().length() == 0 
		        		   || nameField.getText().length() == 0)
		                btnRegister.setEnabled(false);
		            else
		            {
		                btnRegister.setEnabled(true);
		            }
			}
		});
	}
}
