package com.beyondcode.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.beyondcode.core.ShippingAddress;
import com.beyondcode.core.Subscriber;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditAddressGUI extends JFrame{

	private static final long serialVersionUID = -7634282066793835735L;
	private Subscriber sub;
	private ShippingAddress address;
	private JTextField tfName;
	private JTextField tfAddress;
	private JTextField tfCopiesPerIssue;
	
	
	public EditAddressGUI(ShippingAddress address){
		
		this.address = address;
		
		initWindow();
		initTextFields();
		initButtons();
		initLabels();
		
		tfName.setText(address.getName());
		tfAddress.setText(address.getAddress());
		tfCopiesPerIssue.setText(Integer.toString(address.getCopiesPerIssue()));
	}

	private void initWindow(){
		setTitle("Edit Address Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		
		
		
		
		
		
		this.setSize(450, 300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();	//set window in center of screen, regardless of screen resolution
		this.setLocation(dim.width/2 - this.getWidth()/2, dim.height/2 - this.getHeight()/2);
	}
	
	private void initTextFields(){

		tfName = new JTextField();
		tfName.setBounds(12, 42, 116, 22);
		getContentPane().add(tfName);
		tfName.setColumns(10);
		
		tfCopiesPerIssue = new JTextField();
		tfCopiesPerIssue.setBounds(12, 109, 116, 22);
		getContentPane().add(tfCopiesPerIssue);
		tfCopiesPerIssue.setColumns(10);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(198, 41, 222, 22);
		getContentPane().add(tfAddress);
		tfAddress.setColumns(10);
		
	}
	
	private void initButtons(){
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(214, 215, 97, 25);
		getContentPane().add(btnCancel);
		
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tfName.getText().equals("") || !tfAddress.getText().equals("") || !tfCopiesPerIssue.equals("")){
					try{
						int val = Integer.parseInt(tfCopiesPerIssue.getText());
						if(val < 1)
							throw new NumberFormatException();
						address.setName(tfName.getText());
						address.setAddress(tfAddress.getText());
						address.setCopiesPerIssue(val);
						dispose();
						
					}catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null, "Copies Per Issue must be a number greater than 0!");
					}
				}else
					JOptionPane.showMessageDialog(null, "No fields may be blank!");
				
			}
		});
		btnApply.setBounds(323, 215, 97, 25);
		getContentPane().add(btnApply);
	}
	
	private void initLabels(){
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(12, 23, 56, 16);
		getContentPane().add(lblName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(198, 23, 56, 16);
		getContentPane().add(lblAddress);

		JLabel lblCopiesPerIssue = new JLabel("Copies Per Issue:");
		lblCopiesPerIssue.setBounds(12, 91, 126, 16);
		getContentPane().add(lblCopiesPerIssue);
	}
	
	
	
}
