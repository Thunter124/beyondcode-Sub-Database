package com.beyondcode.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.beyondcode.core.ShippingAddress;
import com.beyondcode.core.Subscriber;

public class EditSubscriberGUI extends CreateSubscriberGUI {

	private static final long serialVersionUID = -9178519994879968565L;
	
	protected Subscriber sub;
	private JTextField tfNumToAdd;
	private JLabel lblSubTime;
	private JList selectionList;
	private List<Integer> addressIndexesToDelete; //stores indexes to delete once "apply" is clicked
	private List<ShippingAddress> tempAddresses;
	protected EditSubscriberGUI _this;
	
	public EditSubscriberGUI(Subscriber sub){
		setTitle("Edit Subscriber Information");
		_this = this;
		addressIndexesToDelete = new ArrayList<Integer>();
		tempAddresses = new ArrayList<ShippingAddress>();
		this.sub = sub;
		
		initScrollPane();
		overrideParentComponents();
		initTextFields();
		
	}
	
	private void overrideParentComponents(){
		lblNumAddresses.setSize(49, 6);
		lblStartingCopies.setSize(40, 6);
		lblStreetAddress.setSize(40, 1);
		tfCopiesPerAddressSingle.setSize(1, 1);
		tfCopiesPerAddressSingle.setLocation(-12, 250);
		tfCityState.setSize(40, 20);
		lblNumAddresses.setLocation(-58, 243);
		lblStartingCopies.setLocation(-58, 243);
		tfStartingCopies.setLocation(-48, 231);
		btnCancel.setLocation(331, 225);
		btnApply.setLocation(331, 200);
		lblName.setLocation(289, 13);
		tfName.setLocation(289, 30);
		lblStreetAddress.setLocation(-58, 248);
		tfStreetAddress.setSize(1, 6);
		tfStreetAddress.setVisible(false);
		lblStreetAddress.setVisible(false);
		tfStreetAddress.setLocation(56, 245);
		tfNumAddresses.setBounds(49, 151, -30, 6);
		btnNext.setSize(1, 20);
		lblCopiesPerAddress.setBounds(26, 212, 7, 16);
		lblZipCode.setSize(1, 11);
		lblCityState.setSize(-7, 6);
		cbSameAddress.setBounds(26, 187, 1, 16);
		lblSameAddress.setBounds(49, 170, -30, 16);
		tfZipCode.setSize(7, 20);
		btnNext.setLocation(18, 231);
		lblCityState.setLocation(26, 222);
		tfCityState.setLocation(-39, 229);
		lblZipCode.setLocation(36, 202);
		tfZipCode.setLocation(0, 195);
		//take out this crap later ^
		
		
		cbSameAddress.setEnabled(false);
		cbSameAddress.setVisible(false);
		btnNext.setEnabled(false);
		btnNext.setVisible(false);
		lblSameAddress.setVisible(false);
		lblCopiesPerAddress.setVisible(false);
		lblCityState.setVisible(false);
		lblNumAddresses.setVisible(false);
		lblZipCode.setVisible(false);
		tfCityState.setEnabled(false);
		tfCityState.setVisible(false);
		tfZipCode.setVisible(false);
		tfZipCode.setEnabled(false);
		tfCopiesPerAddressSingle.setVisible(false);
		
		btnApply.setEnabled(true);
		btnApply.removeActionListener(btnApply.getActionListeners()[0]);
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sub.setBillingName(tfName.getText());
				sub.getAddresses().clear();
				for(int i = 0; i < selectionList.getModel().getSize(); ++i){
					sub.addAddress((ShippingAddress)selectionList.getModel().getElementAt(i));
				}
				dispose();
			}
		});
		
		
		
	}

	private void initTextFields(){
		tfName.setText(sub.getBillingName());
		
		JButton btnNewButton = new JButton("Add Subscription Time");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					NumberFormatException up = new NumberFormatException();
					int val = Integer.parseInt(tfNumToAdd.getText());
					if(val < 0)
						throw up; // heh heh
					sub.increaseCopiesRemainingBy(val);
					lblSubTime.setText(Integer.toString(sub.getCopiesRemaining()));
					tfNumToAdd.setText("0");
						
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null, "Subscription time must be a number, and positive!");
				}
				
			}
		});
		btnNewButton.setBounds(12, 225, 183, 25);
		getContentPane().add(btnNewButton);
		
		tfNumToAdd = new JTextField();
		tfNumToAdd.setBounds(12, 200, 30, 22);
		getContentPane().add(tfNumToAdd);
		tfNumToAdd.setColumns(10);
		tfNumToAdd.setText("0");
		
		JLabel lblIssuesToAdd = new JLabel("Issues to Add:");
		lblIssuesToAdd.setBounds(12, 185, 89, 16);
		getContentPane().add(lblIssuesToAdd);
		
		JButton btnDeleteAddress = new JButton("Delete Address");
		btnDeleteAddress.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				if(selectionList.getSelectedIndex() != -1){
					boolean found = false;
					for(int i = 0; i < addressIndexesToDelete.size(); ++i){
						if(selectionList.getSelectedIndex() == addressIndexesToDelete.get(i).intValue()){
							found = true;
							break;
						}
					}
					if(!found){
						addressIndexesToDelete.add(selectionList.getSelectedIndex());
						tempAddresses.addAll(sub.getAddresses());
						tempAddresses.remove(selectionList.getSelectedIndex());
						selectionList.setListData(tempAddresses.toArray());
					}
					
				}
			}
		});
		btnDeleteAddress.setBounds(147, 138, 135, 25);
		getContentPane().add(btnDeleteAddress);
		
		JButton btnCreateAddress = new JButton("Create Address");
		btnCreateAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAddressGUI caGUI = new CreateAddressGUI(1, 1, sub, null, false);
				caGUI.setESGUI(_this);
				caGUI.setVisible(true);
				
			}
		});
		btnCreateAddress.setBounds(147, 110, 135, 25);
		getContentPane().add(btnCreateAddress);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initScrollPane(){
		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(10, 30, 125, 140);
		
		selectionList = new JList();
		selectionList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2 && selectionList.getSelectedIndex() != -1){
					EditAddressGUI eaGUI = new EditAddressGUI(sub.getAddresses().get(selectionList.getSelectedIndex()));
					eaGUI.setVisible(true);
				}
			}
		});
		selectionList.setListData(sub.getAddresses().toArray());
		
		
		jsp.setViewportView(selectionList);
		selectionList.setVisibleRowCount(-1);
		selectionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		getContentPane().add(jsp);
		
		JLabel lblAddresses = new JLabel("Addresses:");
		lblAddresses.setBounds(12, 13, 71, 16);
		getContentPane().add(lblAddresses);
		
		JLabel lblCurrentSubscriptiontime = new JLabel("Current SubscriptionTime:");
		lblCurrentSubscriptiontime.setBounds(264, 63, 156, 16);
		getContentPane().add(lblCurrentSubscriptiontime);
		
		lblSubTime = new JLabel(Integer.toString(sub.getCopiesRemaining()));
		lblSubTime.setBounds(364, 82, 56, 16);
		getContentPane().add(lblSubTime);
	}
	
	public void refreshSelectionList(){
		selectionList.setListData(sub.getAddresses().toArray());
	}
}
