package com.beyondcode.gui;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.beyondcode.core.Author;
import com.beyondcode.core.ShippingAddress;
import com.beyondcode.main.Main;

public class CreateAuthorGUI extends CreateSubscriberGUI{

	private static final long serialVersionUID = 970425803480876677L;
	private Author author;
	
	public CreateAuthorGUI(){
		setTitle("Create Author");
		
		btnApply.removeActionListener(btnApply.getActionListeners()[0]);
		
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try{
						
						int startingCopies = Integer.parseInt(tfStartingCopies.getText());
						if(startingCopies < 0)
							throw new NumberFormatException();
						ShippingAddress sa = new ShippingAddress(tfName.getText(), tfStreetAddress.getText() + " " + tfCityState.getText() + " " + tfZipCode.getText(), 1);
						author = new Author(tfName.getText(), tfStreetAddress.getText() + " " + tfCityState.getText() + " " + tfZipCode.getText(), startingCopies);
						author.addAddress(sa);
						
						Main.getInstance().getDatabase().passNewAuthor(author);
						System.out.println(Main.getInstance().getDatabase().getSubscriberDatabase().getAuthors().size());
						dispose();
					}catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null, "The starting copies must be greater than or equal to -1!", "Error!", JOptionPane.WARNING_MESSAGE);
					}
			}
		});
		btnApply.setEnabled(true);
		
		lblCopiesPerAddress.setVisible(false);
		lblSameAddress.setVisible(false);
		lblNumAddresses.setVisible(false);
		tfNumAddresses.setVisible(false);
		tfNumAddresses.setEnabled(false);
		tfCopiesPerAddressSingle.setVisible(false);
		tfCopiesPerAddressSingle.setEnabled(false);
		cbSameAddress.setVisible(false);
		btnNext.setEnabled(false);
		btnNext.setVisible(false);

	}
	

}
