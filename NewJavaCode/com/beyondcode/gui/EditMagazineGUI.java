package com.beyondcode.gui;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import com.beyondcode.core.Magazine;
import com.beyondcode.main.Main;

public class EditMagazineGUI extends CreateMagazineGUI{

	private static final long serialVersionUID = -7357317373283343126L;
	
	JButton btnAddAd;
	JButton btnAddArticle;
	Magazine mag;
	JScrollPane jsp;
	JList selectionList;
	JRadioButton rdbtnArticles;
	JRadioButton rdbtnAds;
	private EditMagazineGUI _this;
	private JButton btnPublishMagazine;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EditMagazineGUI(Magazine mag){
			super();
			_this = this;
			this.mag = mag;
			initButtons();
			
			
			setTitle("Edit Magazine Information");
			tfVolumeNum.setLocation(343, 86);
			lblVolume.setLocation(343, 66);
			tfIssueNum.setLocation(343, 139);
			lblIssue.setLocation(343, 119);
			tfTitle.setLocation(343, 33);
			lblTitle.setLocation(343, 13);
			btnApply.setLocation(343, 204);
			btnCancel.setLocation(343, 229);
			tfTitle.setText(mag.getTitle());
			
			tfVolumeNum.setText(Integer.toString(mag.getVolumeNum()));
			tfIssueNum.setText(Integer.toString(mag.getIssueNum()));
			
			rdbtnArticles = new JRadioButton("Articles");
			rdbtnArticles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					refreshSelectionList();
				}
			});
			rdbtnArticles.setBounds(189, 43, 127, 25);
			getContentPane().add(rdbtnArticles);
			
			
			rdbtnAds = new JRadioButton("Ads");
			rdbtnAds.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					refreshSelectionList();
				}
			});
			rdbtnAds.setBounds(189, 13, 127, 25);
			getContentPane().add(rdbtnAds);
			rdbtnAds.setSelected(true);
			
			ButtonGroup bg = new ButtonGroup();
			bg.add(rdbtnAds);
			bg.add(rdbtnArticles);
			
			jsp = new JScrollPane();
			jsp.setLocation(10, 10);
			jsp.setSize(170, 140);
			jsp.setEnabled(true);
		
			getContentPane().add(jsp);
			selectionList = new JList();
			jsp.setViewportView(selectionList);
			selectionList.setListData(mag.getAds().toArray());
			selectionList.setVisibleRowCount(-1);
			selectionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			btnPublishMagazine = new JButton("Publish Magazine");
			btnPublishMagazine.setBounds(140, 199, 141, 25);
			getContentPane().add(btnPublishMagazine);
			
	}
	
	private void initButtons(){
		btnAddAd = new JButton("Add Ad");
		btnAddAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAdToMagazineGUI aatmGUI = new AddAdToMagazineGUI(mag, _this);
				aatmGUI.setVisible(true);
			}
		});
		btnAddAd.setBounds(12, 199, 97, 25);
		getContentPane().add(btnAddAd);
		
		btnAddArticle = new JButton("Add Article");
		btnAddArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddArticleToMagazineGUI aatm = new AddArticleToMagazineGUI(mag);
				aatm.setVisible(true);
				aatm.setTitle("Add Article to Magazine");
			}
		});
		btnAddArticle.setBounds(12, 227, 97, 25);
		getContentPane().add(btnAddArticle);
		
		btnApply.removeActionListener(btnApply.getActionListeners()[0]);
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(tfTitle.getText().equals("") || tfVolumeNum.getText().equals("") || tfIssueNum.equals(""))){
					
					try{
						int vol = Integer.parseInt(tfVolumeNum.getText());
						int iss = Integer.parseInt(tfIssueNum.getText());
						
						if(vol <= 0 || iss <=0)
							throw new NumberFormatException();
						mag.setIssueNum(iss);
						mag.setVolumeNum(vol);
						mag.setTitle(tfTitle.getText());
						dispose();
					}catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "Volume Num and Issue Num must be greater than 0!");
					}
				}else{
					JOptionPane.showMessageDialog(null, "No fields may be blank!");
				}
			}
		});
		
		JButton btnDeleteMagazine = new JButton("Delete Magazine");
		btnDeleteMagazine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.getInstance().getDatabase().getMagazineDatabase().removeMagazineFrominProgress(mag);
				Main.getInstance().refreshGUILists();
				dispose();
			}
		});
		btnDeleteMagazine.setBounds(140, 227, 141, 25);
		getContentPane().add(btnDeleteMagazine);
	}
	
	@SuppressWarnings("unchecked")
	public void refreshSelectionList(){
		if(rdbtnAds.isSelected())
			selectionList.setListData(mag.getAds().toArray());
		else if(rdbtnArticles.isSelected())
			selectionList.setListData(mag.getArticles().toArray());
	}
	
	
}
