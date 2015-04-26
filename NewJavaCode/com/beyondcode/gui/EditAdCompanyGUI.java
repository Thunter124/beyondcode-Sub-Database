package com.beyondcode.gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.beyondcode.core.AdCompany;

public class EditAdCompanyGUI extends CreateAdCompanyGUI {
	
	private static final long serialVersionUID = 4536825836315875097L;
	protected AdCompany company;
	
	public EditAdCompanyGUI(final AdCompany ac){
		super();
		overrideParentComponents();
		tfZipCode.setVisible(false);
		tfCityState.setVisible(false);
		company = ac;
		
		tfName.setText(ac.getBillingName());
		tfStreetAddress.setText(ac.getBillingAddress());
		
		btnApply.removeActionListener(btnApply.getActionListeners()[0]);
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tfName.getText().equals("") || !tfStreetAddress.getText().equals(""))
					ac.setBillingAddress(tfStreetAddress.getText());
					ac.setBillingName(tfName.getText());
					dispose();
			}
		});
		
		
	}
	
	private void overrideParentComponents(){
		lblZipCode.setVisible(false);
		lblCityState.setVisible(false);
		
	}
}
