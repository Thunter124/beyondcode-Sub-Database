package com.beyondcode.gui;

import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import com.beyondcode.core.AdCompany;
import com.beyondcode.core.Author;
import com.beyondcode.core.Magazine;
import com.beyondcode.core.Subscriber;
import com.beyondcode.databases.AdCompanyDatabase;
import com.beyondcode.databases.MagazineDatabase;
import com.beyondcode.databases.SubscriberDatabase;
import com.beyondcode.main.Main;

public class MainGUI extends JFrame {

	private static final long serialVersionUID = 6411499808530678723L;

	JList selectionList;
	JScrollPane jsp;
	ButtonGroup bg;

	JButton btnSave;
	JButton btnLoad;
	JButton btnAddSubscriber;
	JButton btnAddMagazine;

	JRadioButton rbInProgressMagazines;
	JRadioButton rbPublishedMagazines;
	JRadioButton rbActiveSubscribers;
	JRadioButton rbInactiveSubscribers;
	JRadioButton rbDoNotMailSubscribers;
	JRadioButton rbAdCompanies;
	JRadioButton rbAuthors;

	ArrayList<Magazine> publishedMagazines;
	ArrayList<Magazine> inProgressMagazines;
	ArrayList<Subscriber> activeSubscribers;
	ArrayList<Subscriber> inactiveSubscribers;
	ArrayList<Subscriber> doNotMailSubscribers;
	ArrayList<AdCompany> adCompanies;
	ArrayList<Author> authors;

	private JTextField textField;
	private JButton btnAddAuthor;

	public MainGUI() {
		initWindow();
		initButtons();
		initLists();
		initMisc();

	}

	private void initWindow() {
		// basic window attributes
		setTitle("Beyond Code");
		getContentPane().setBackground(SystemColor.control);
		this.setSize(540, 340);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// start window in the center of the screen, regardless of screen
		// resolution
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2
				- this.getHeight() / 2 - dim.height / 8);
	}

	private void initButtons() {
		// save button
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.getInstance().getDatabase().save();
			}
		});
		btnSave.setBounds(10, 257, 89, 23);
		getContentPane().add(btnSave);

		// load button
		btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.getInstance().getDatabase().load();
			}
		});
		btnLoad.setBounds(10, 279, 89, 23);
		getContentPane().add(btnLoad);

		// add subscriber
		btnAddSubscriber = new JButton("Add Subscriber");
		btnAddSubscriber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateSubscriberGUI csGui = new CreateSubscriberGUI();
				csGui.setVisible(true);
			}
		});
		btnAddSubscriber.setBounds(390, 221, 134, 23);
		getContentPane().add(btnAddSubscriber);
		// add magazine
		btnAddMagazine = new JButton("Add Magazine");
		btnAddMagazine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateMagazineGUI cmGui = new CreateMagazineGUI();
				cmGui.setVisible(true);
			}
		});
		btnAddMagazine.setBounds(390, 274, 134, 23);
		getContentPane().add(btnAddMagazine);

		rbPublishedMagazines = new JRadioButton("Published Magazines");
		rbPublishedMagazines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshSelectionList();
			}
		});
		rbPublishedMagazines.setBounds(308, 5, 161, 15);
		getContentPane().add(rbPublishedMagazines);

		rbInProgressMagazines = new JRadioButton("Magazines In Progress");
		rbInProgressMagazines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshSelectionList();
			}
		});
		rbInProgressMagazines.setBounds(308, 25, 161, 23);
		getContentPane().add(rbInProgressMagazines);

		rbActiveSubscribers = new JRadioButton("Active Subscribers");
		rbActiveSubscribers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshSelectionList();
			}
		});
		rbActiveSubscribers.setSelected(true);
		rbActiveSubscribers.setBounds(308, 45, 161, 23);
		getContentPane().add(rbActiveSubscribers);

		rbInactiveSubscribers = new JRadioButton("Inactive Subscribers");
		rbInactiveSubscribers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshSelectionList();
			}
		});
		rbInactiveSubscribers.setBounds(308, 65, 161, 23);
		getContentPane().add(rbInactiveSubscribers);

		rbDoNotMailSubscribers = new JRadioButton("Do Not Mail Subscribers");
		rbDoNotMailSubscribers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshSelectionList();
			}
		});
		rbDoNotMailSubscribers.setBounds(308, 85, 190, 23);
		getContentPane().add(rbDoNotMailSubscribers);

		rbAdCompanies = new JRadioButton("Ad Companies");
		rbAdCompanies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshSelectionList();
			}
		});
		rbAdCompanies.setBounds(308, 105, 161, 23);
		getContentPane().add(rbAdCompanies);

		rbAuthors = new JRadioButton("Authors");
		rbAuthors.setBounds(308, 124, 127, 25);
		rbAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshSelectionList();
			}
		});
		getContentPane().add(rbAuthors);

		bg = new ButtonGroup();
		bg.add(rbInProgressMagazines);
		bg.add(rbPublishedMagazines);
		bg.add(rbInactiveSubscribers);
		bg.add(rbDoNotMailSubscribers);
		bg.add(rbActiveSubscribers);
		bg.add(rbAdCompanies);
		bg.add(rbAuthors);

	}

	private void initLists() {

		MagazineDatabase mdb = Main.getInstance().getDatabase()
				.getMagazineDatabase();
		SubscriberDatabase sdb = Main.getInstance().getDatabase()
				.getSubscriberDatabase();
		AdCompanyDatabase adb = Main.getInstance().getDatabase()
				.getAdCompanyDatabase();

		publishedMagazines = mdb.getPublishedMagazines();
		inProgressMagazines = mdb.getInProgressMagazines();
		activeSubscribers = sdb.getActiveSubscribers();
		inactiveSubscribers = sdb.getInactiveSubscribers();
		doNotMailSubscribers = sdb.getDoNotMailSubscribers();
		adCompanies = adb.getAdCompanies();
		authors = sdb.getAuthors();
	}

	public void refreshLists() {
		MagazineDatabase mdb = Main.getInstance().getDatabase()
				.getMagazineDatabase();
		SubscriberDatabase sdb = Main.getInstance().getDatabase()
				.getSubscriberDatabase();
		AdCompanyDatabase adb = Main.getInstance().getDatabase()
				.getAdCompanyDatabase();

		publishedMagazines = mdb.getPublishedMagazines();
		inProgressMagazines = mdb.getInProgressMagazines();
		activeSubscribers = sdb.getActiveSubscribers();
		inactiveSubscribers = sdb.getInactiveSubscribers();
		doNotMailSubscribers = sdb.getDoNotMailSubscribers();
		adCompanies = adb.getAdCompanies();
		authors = sdb.getAuthors();

		refreshSelectionList();
	}

	@SuppressWarnings({ "unchecked" })
	private void refreshSelectionList() {

		if (rbActiveSubscribers.isSelected()) {
			selectionList.setListData(activeSubscribers.toArray());
		} else if (rbInactiveSubscribers.isSelected()) {
			selectionList.setListData(inactiveSubscribers.toArray());
		} else if (rbDoNotMailSubscribers.isSelected()) {
			selectionList.setListData(doNotMailSubscribers.toArray());
		} else if (rbInProgressMagazines.isSelected()) {
			selectionList.setListData(inProgressMagazines.toArray());
		} else if (rbPublishedMagazines.isSelected()) {
			selectionList.setListData(publishedMagazines.toArray());
		} else if (rbAdCompanies.isSelected()) {
			selectionList.setListData(adCompanies.toArray());
		} else if (rbAuthors.isSelected()) {
			selectionList.setListData(authors.toArray());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initMisc(){
		jsp = new JScrollPane();
		jsp.setLocation(10, 40);
		jsp.setSize(250, 150);
		jsp.setEnabled(true);
	
		getContentPane().add(jsp);
		selectionList = new JList();
		jsp.setViewportView(selectionList);
		selectionList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					if(rbInProgressMagazines.isSelected()){
						Magazine mag = Main.getInstance().getDatabase().getMagazineDatabase().getInProgressMagazines()
								.get(selectionList.getSelectedIndex());
						EditMagazineGUI emGUI = new EditMagazineGUI(mag);
						emGUI.setVisible(true);
					}
					else if(rbActiveSubscribers.isSelected() || rbInactiveSubscribers.isSelected() 
							|| rbDoNotMailSubscribers.isSelected()){
						Subscriber sub = null;
						
						if(rbActiveSubscribers.isSelected())
							sub = Main.getInstance().getDatabase().getSubscriberDatabase().getActiveSubscribers().get(selectionList.getSelectedIndex());
						else if(rbInactiveSubscribers.isSelected())
							sub = Main.getInstance().getDatabase().getSubscriberDatabase().getInactiveSubscribers().get(selectionList.getSelectedIndex());
						else
							sub = Main.getInstance().getDatabase().getSubscriberDatabase().getDoNotMailSubscribers().get(selectionList.getSelectedIndex());
						
						EditSubscriberGUI esGUI = new EditSubscriberGUI(sub);
						esGUI.setVisible(true);
					}else if(rbAdCompanies.isSelected()){
						AdCompany company = Main.getInstance().getDatabase().getAdCompanyDatabase().getAdCompanies().get(selectionList.getSelectedIndex());
						EditAdCompanyGUI eaGUI = new EditAdCompanyGUI(company);
						eaGUI.setVisible(true);
					}
				}
			}
		});
		selectionList.setListData(activeSubscribers.toArray());
		selectionList.setVisibleRowCount(-1);
		selectionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnAddAdCompany = new JButton("Add Ad Company");
		btnAddAdCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAdCompanyGUI caGUI = new CreateAdCompanyGUI();
				caGUI.setVisible(true);
			}
		});
		btnAddAdCompany.setBounds(390, 247, 134, 25);
		getContentPane().add(btnAddAdCompany);
		
		textField = new JTextField();
		textField.setBounds(10, 8, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(134, 8, 97, 22);
		getContentPane().add(btnSearch);
		
		btnAddAuthor = new JButton("Add Author");
		btnAddAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAuthorGUI caGUI = new CreateAuthorGUI();
				caGUI.setVisible(true);
			
				
			}
		});
		btnAddAuthor.setBounds(390, 196, 134, 25);
		getContentPane().add(btnAddAuthor);
		
	
		
		
	}
}
