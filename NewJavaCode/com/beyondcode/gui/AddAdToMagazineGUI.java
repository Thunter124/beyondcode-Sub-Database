package com.beyondcode.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.beyondcode.core.Ad;
import com.beyondcode.core.AdCompany;
import com.beyondcode.databases.AdCompanyDatabase;
import com.beyondcode.core.Magazine;
import com.beyondcode.main.Main;

public class AddAdToMagazineGUI extends AddGenericObjectGUI{


	private static final long serialVersionUID = -5907594926536454724L;
	private JTextField tfTitle;
	private Magazine mag;
	EditMagazineGUI emGUI;
	
	@SuppressWarnings("unchecked")
	public AddAdToMagazineGUI(final Magazine mag, final EditMagazineGUI emGUI){
		jsp.setLocation(10, 25);
		this.emGUI = emGUI;
		this.mag = mag;
		
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!tfTitle.getText().equals("")){
					Ad ad = new Ad(Main.getInstance().getDatabase().getAdCompanyDatabase()
							.getAdCompanies().get(selectionList.getSelectedIndex()), tfTitle.getText());
					mag.addAd(ad);
					emGUI.refreshSelectionList();
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Title cannot be blank!");
				}
			}
		});
		setTitle("Add Ad to Magazine");
		
		AdCompanyDatabase db = Main.getInstance().getDatabase().getAdCompanyDatabase();
		List<AdCompany> companies = new ArrayList<AdCompany>();
		
		companies = db.getAdCompanies();
		selectionList.setListData(companies.toArray());
		if(companies != null)
			selectionList.setSelectedIndex(0);
		
		tfTitle = new JTextField();
		tfTitle.setBounds(316, 28, 116, 22);
		getContentPane().add(tfTitle);
		tfTitle.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(316, 12, 56, 16);
		getContentPane().add(lblTitle);
		
		JLabel lblSelectAdCompany = new JLabel("Select Ad Company:");
		lblSelectAdCompany.setBounds(10, 8, 130, 16);
		getContentPane().add(lblSelectAdCompany);
	}
}
