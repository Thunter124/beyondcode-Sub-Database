package com.beyondcode.gui;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import com.beyondcode.core.ShippingAddress;
import com.beyondcode.core.Subscriber;
import com.beyondcode.main.Main;

public class CreateSubscriberGUI extends JFrame {

	private static final long serialVersionUID = 3805890009759996908L;
	
	protected JTextField tfName;
	protected JTextField tfStreetAddress;
	protected JTextField tfCityState;
	protected JTextField tfZipCode;
	protected JTextField tfStartingCopies;
	protected JTextField tfNumAddresses;
	protected JTextField tfCopiesPerAddressSingle;
	
	protected JButton btnApply;
	protected JButton btnNext;
	protected JButton btnCancel;
	protected JCheckBox cbSameAddress;
	
	protected boolean validTextFields = false;
	protected Subscriber sub = null;
	Main main;
	protected CreateSubscriberGUI _this;
	protected JLabel lblName;
	protected JLabel lblStreetAddress;
	protected JLabel lblStartingCopies;
	protected JLabel lblNumAddresses;
	protected JLabel lblCityState;
	protected JLabel lblZipCode;
	protected JLabel lblSameAddress;
	protected JLabel lblCopiesPerAddress;
	
	
	public CreateSubscriberGUI() {
		initWindow();
		initButtons();
		initLabels();
		initTextFields();
		initMisc();
		
		_this = this;
	}

	private void initMisc(){
		//init check box for same address
				cbSameAddress = new JCheckBox("");
				cbSameAddress.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent arg0) {
						if(cbSameAddress.isEnabled() && cbSameAddress.isSelected()){
							if(!(tfName.getText().equals("") 
									|| tfCityState.getText().equals("")
									|| tfZipCode.getText().equals("")
									|| tfStartingCopies.getText().equals("")
									|| tfStreetAddress.getText().equals("")
									|| tfNumAddresses.getText().equals(""))){
								btnApply.setEnabled(true);
								tfCopiesPerAddressSingle.setEnabled(true);
							}
								
						}else{
							btnApply.setEnabled(false);
						}
					}
				});
				cbSameAddress.setEnabled(false);
				cbSameAddress.setBounds(26, 189, 97, 14);
				getContentPane().add(cbSameAddress);	
				
				lblName = new JLabel("Name:");
				lblName.setBounds(26, 25, 56, 16);
				getContentPane().add(lblName);
				
				lblStreetAddress = new JLabel("Street Address:");
				lblStreetAddress.setBounds(250, 25, 97, 16);
				getContentPane().add(lblStreetAddress);
				
				lblStartingCopies = new JLabel("Starting Issues:");
				lblStartingCopies.setBounds(26, 68, 97, 16);
				getContentPane().add(lblStartingCopies);
				
				lblNumAddresses = new JLabel("Num Addresses:");
				lblNumAddresses.setBounds(26, 120, 97, 16);
				getContentPane().add(lblNumAddresses);
				
				lblCityState = new JLabel("City, State:");
				lblCityState.setBounds(250, 68, 97, 16);
				getContentPane().add(lblCityState);
				
				lblZipCode = new JLabel("Zip Code:");
				lblZipCode.setBounds(250, 120, 56, 16);
				getContentPane().add(lblZipCode);
				
				lblSameAddress = new JLabel("Same Address?");
				lblSameAddress.setBounds(26, 170, 107, 16);
				getContentPane().add(lblSameAddress);
				
				lblCopiesPerAddress = new JLabel("Copies Per Issue:");
				lblCopiesPerAddress.setBounds(26, 212, 107, 16);
				getContentPane().add(lblCopiesPerAddress);
				

	}

	private void initWindow(){
	//basic window attributes	
		setTitle("Subscriber Billing Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setSize(450, 300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();	//set window in center of screen, regardless of screen resolution
		this.setLocation(dim.width/2 - this.getWidth()/2, dim.height/2 - this.getHeight()/2);
	}
	
	private void initButtons(){
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(tfName.getText().equals("") || tfStreetAddress.getText().equals("") || tfZipCode.getText().equals("") || 
						tfCityState.getText().equals("") || tfStartingCopies.equals("") || tfNumAddresses.equals(""))){
					
					int numAddresses = 0;
					validTextFields = false;
					try{
						numAddresses = Integer.parseInt(tfNumAddresses.getText());
						validTextFields = true;
					}catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "The number of subscriber addresses must be a number, and greater"
								+ " than zero!", "Error!", JOptionPane.WARNING_MESSAGE);
						validTextFields = false;
					}
					int startingCopies = 0;
					try{
						startingCopies = Integer.parseInt(tfStartingCopies.getText());
					}catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "The number of starting copies must be a number, and greater"
								+ " than or equal to zero!", "Error!", JOptionPane.WARNING_MESSAGE);
						validTextFields = false;
					}
					
					String billingName = tfName.getText();
					String streetAddress = tfStreetAddress.getText();
					String zipCode = tfZipCode.getText();
					String cityState = tfCityState.getText();
					
					if(!cbSameAddress.isEnabled() || !cbSameAddress.isSelected() || numAddresses != 1){
						
						if(validTextFields){
							Subscriber newSub = new Subscriber(billingName, streetAddress + " " + cityState + " " +  zipCode, startingCopies);
							CreateAddressGUI addressGUI = new CreateAddressGUI(1, numAddresses, newSub, _this, true);
							addressGUI.setVisible(true);
						
						}
					}	
				}else{
					JOptionPane.showMessageDialog(null, "No fields may be blank!", "Error!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNext.setBounds(117, 228, 89, 23);
		getContentPane().add(btnNext);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setBounds(216, 228, 89, 23);
		getContentPane().add(btnCancel);
		

		btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cbSameAddress.isSelected() && cbSameAddress.isEnabled()){
					
					try{
						int copiesPerAddress = Integer.parseInt(tfCopiesPerAddressSingle.getText());
						int startingCopies = Integer.parseInt(tfStartingCopies.getText());
						if(copiesPerAddress < 1)
							throw new NumberFormatException();
						ShippingAddress sa = new ShippingAddress(tfName.getText(), tfStreetAddress.getText() + " " + tfCityState.getText() + " " + tfZipCode.getText(), copiesPerAddress);
						sub = new Subscriber(tfName.getText(), tfStreetAddress.getText() + " " + tfCityState.getText() + " " + tfZipCode.getText(), startingCopies);
						sub.addAddress(sa);
						Main.getInstance().getDatabase().passNewSubscriber(sub);
						dispose();
					}catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "The copies per issue of the single address must be a number, and greater than 0!", "Error!", JOptionPane.WARNING_MESSAGE);
					}
						
					
				}else{
					Main.getInstance().getDatabase().passNewSubscriber(sub);
					dispose();
				}
			}
		});
		btnApply.setEnabled(false);
		btnApply.setBounds(335, 228, 89, 23);
		getContentPane().add(btnApply);
	}
	
	private void initLabels(){

		
	}
	
	private void initTextFields(){
	//name text field	
		tfName = new JTextField();
		tfName.setBounds(26, 42, 135, 20);
		getContentPane().add(tfName);
		tfName.setColumns(10);
		
	//street address text field
		tfStreetAddress = new JTextField();
		tfStreetAddress.setBounds(250, 42, 153, 20);
		getContentPane().add(tfStreetAddress);
		tfStreetAddress.setColumns(10);
	
	//city, state text field
		tfCityState = new JTextField();
		tfCityState.setBounds(250, 87, 153, 20);
		getContentPane().add(tfCityState);
		tfCityState.setColumns(10);
		
	//zip code text field
		tfZipCode = new JTextField();
		tfZipCode.setBounds(250, 137, 153, 20);
		getContentPane().add(tfZipCode);
		tfZipCode.setColumns(10);

	//starting copies text field
		tfStartingCopies = new JTextField();
		tfStartingCopies.setBounds(26, 87, 40, 20);
		getContentPane().add(tfStartingCopies);
		tfStartingCopies.setColumns(10);
		
	//number of addresses text field	
		tfNumAddresses = new JTextField();
		tfNumAddresses.addKeyListener(new KeyAdapter() { //listener for text field
			@Override
			public void keyReleased(KeyEvent e) {
				int addresses;
				try{
					addresses = Integer.parseInt(tfNumAddresses.getText());  //parse the string to an int
					if(addresses == 1){
						cbSameAddress.setEnabled(true);		//if address == 1, "same address" check box is eneabled
					}else{
						cbSameAddress.setEnabled(false);	//else, not enabled
					}
				}catch(NumberFormatException a){
					cbSameAddress.setEnabled(false);		//if not an int, not enabled
				}
			}
		});
		tfNumAddresses.setBounds(26, 137, 40, 20);
		getContentPane().add(tfNumAddresses);
		tfNumAddresses.setColumns(10);
		

		tfCopiesPerAddressSingle = new JTextField();
		tfCopiesPerAddressSingle.setEnabled(false);
		tfCopiesPerAddressSingle.setBounds(26, 229, 40, 20);
		getContentPane().add(tfCopiesPerAddressSingle);
		tfCopiesPerAddressSingle.setColumns(10);
		
	}
	
	//called by the final CreateAddressGUI window when the subscriber's info is complete
	public void enableApplyButton(Subscriber sub){
		this.sub = sub;
		btnApply.setEnabled(true);
	}
}
