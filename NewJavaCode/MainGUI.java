import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import com.jgoodies.forms.factories.DefaultComponentFactory;


public class MainGUI extends JFrame {
	
	private static final long serialVersionUID = 6411499808530678723L;
	
	JList selectionList;
	DefaultListModel dlm;
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
	JRadioButton rbActiveAdCompanies;
	JRadioButton rbInactiveAdCompanies;
	JRadioButton rbDoNotMailCompanies;
	
	
	Main main;
	
	ArrayList<Magazine> publishedMagazines;
	ArrayList<Magazine> inProgressMagazines;
	ArrayList<Subscriber> activeSubscribers;
	ArrayList<Subscriber> inactiveSubscribers;
	ArrayList<Subscriber> doNotMailSubscribers;
	ArrayList<AdCompany> activeAdCompanies;
	ArrayList<AdCompany> inactiveAdCompanies;
	ArrayList<AdCompany> doNotMailAdCompanies;
	
	
	
	public MainGUI(Main main) {
		
		this.main = main;
		initWindow();
		initButtons();
		initLabels();
		initLists();
		initMisc();
		
		
	}
	
	
	private void initWindow(){
	//basic window attributes
		setTitle("Beyond Code"); 
		getContentPane().setBackground(SystemColor.control); 
		this.setSize(540, 340); 
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//start window in the center of the screen, regardless of screen resolution
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2 - this.getWidth()/2, dim.height/2 - this.getHeight()/2 - dim.height/8);
	}
	
	private void initButtons(){
	//save button
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.save();
			}
		});
		btnSave.setBounds(10, 257, 89, 23);
		getContentPane().add(btnSave);
	
	//load button
		btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Loaded!");
			}
		});
		btnLoad.setBounds(10, 279, 89, 23);
		getContentPane().add(btnLoad);
		
	//add subscriber
		btnAddSubscriber = new JButton("Add Subscriber");
		btnAddSubscriber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateSubscriberGUI csGui = new CreateSubscriberGUI(main);
				csGui.setVisible(true);
			}
		});
		btnAddSubscriber.setBounds(390, 246, 134, 23);
		getContentPane().add(btnAddSubscriber);
	//add magazine
		btnAddMagazine = new JButton("Add Magazine");
		btnAddMagazine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateMagazineGUI cmGui = new CreateMagazineGUI(main);
				cmGui.setVisible(true);
			}
		});
		btnAddMagazine.setBounds(390, 279, 134, 23);
		getContentPane().add(btnAddMagazine);
		
		rbPublishedMagazines = new JRadioButton("");
		rbPublishedMagazines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshSelectionList();
			}
		});
		rbPublishedMagazines.setBounds(308, 5, 21, 15);
		getContentPane().add(rbPublishedMagazines);
		
		rbInProgressMagazines = new JRadioButton("");
		rbInProgressMagazines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshSelectionList();
			}
		});
		rbInProgressMagazines.setBounds(308, 25, 21, 23);
		getContentPane().add(rbInProgressMagazines);
		
		rbActiveSubscribers = new JRadioButton("");
		rbActiveSubscribers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshSelectionList();
			}
		});
		rbActiveSubscribers.setSelected(true);
		rbActiveSubscribers.setBounds(308, 45, 21, 23);
		getContentPane().add(rbActiveSubscribers);
		
		rbInactiveSubscribers = new JRadioButton("");
		rbInactiveSubscribers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshSelectionList();
			}
		});
		rbInactiveSubscribers.setBounds(308, 65, 21, 23);
		getContentPane().add(rbInactiveSubscribers);
		
		rbDoNotMailSubscribers = new JRadioButton("");
		rbDoNotMailSubscribers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshSelectionList();
			}
		});
		rbDoNotMailSubscribers.setBounds(308, 85, 21, 23);
		getContentPane().add(rbDoNotMailSubscribers);
		
		rbActiveAdCompanies = new JRadioButton("");
		rbActiveAdCompanies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshSelectionList();
			}
		});
		rbActiveAdCompanies.setBounds(308, 105, 21, 23);
		getContentPane().add(rbActiveAdCompanies);
		
		rbInactiveAdCompanies = new JRadioButton("");
		rbInactiveAdCompanies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshSelectionList();
			}
		});
		rbInactiveAdCompanies.setBounds(308, 125, 21, 23);
		getContentPane().add(rbInactiveAdCompanies);
		
		rbDoNotMailCompanies = new JRadioButton("");
		rbDoNotMailCompanies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshSelectionList();
			}
		});
		rbDoNotMailCompanies.setBounds(308, 145, 21, 23);
		getContentPane().add(rbDoNotMailCompanies);
		
		
		
		bg = new ButtonGroup();
		bg.add(rbInProgressMagazines);
		bg.add(rbPublishedMagazines);
		bg.add(rbInactiveSubscribers);
		bg.add(rbDoNotMailSubscribers);
		bg.add(rbActiveSubscribers);
		bg.add(rbActiveAdCompanies);
		bg.add(rbInactiveAdCompanies);
		bg.add(rbDoNotMailCompanies);
		
		
	}
	
	private void initLabels(){
		JLabel lblPublishedMagazines = DefaultComponentFactory.getInstance().createLabel("Published Magazines");
		lblPublishedMagazines.setBounds(335, 5, 139, 15);
		getContentPane().add(lblPublishedMagazines);
		
		JLabel lblMagazinesinprogress = DefaultComponentFactory.getInstance().createLabel("Magazines-In-Progress");
		lblMagazinesinprogress.setBounds(335, 25, 162, 23);
		getContentPane().add(lblMagazinesinprogress);
		
		JLabel lblActiveSubscribers = DefaultComponentFactory.getInstance().createLabel("Active Subscribers");
		lblActiveSubscribers.setBounds(335, 45, 162, 23);
		getContentPane().add(lblActiveSubscribers);
		
		JLabel lblInactiveSubscribers = DefaultComponentFactory.getInstance().createLabel("Inactive Subscribers");
		lblInactiveSubscribers.setBounds(335, 65, 162, 23);
		getContentPane().add(lblInactiveSubscribers);
		
		JLabel lblDoNotMailSubscribers = DefaultComponentFactory.getInstance().createLabel("Do-Not-Mail Subscribers");
		lblDoNotMailSubscribers.setBounds(335, 85, 162, 23);
		getContentPane().add(lblDoNotMailSubscribers);
		
		JLabel lblActiveAdCompanies = DefaultComponentFactory.getInstance().createLabel("Active Ad Companies");
		lblActiveAdCompanies.setBounds(335, 105, 162, 23);
		getContentPane().add(lblActiveAdCompanies);
		
		JLabel lblInactiveAdCompanies = DefaultComponentFactory.getInstance().createLabel("Inactive Ad Companies");
		lblInactiveAdCompanies.setBounds(335, 125, 162, 23);
		getContentPane().add(lblInactiveAdCompanies);
		
		JLabel lblDoNotMailAdCompanies = DefaultComponentFactory.getInstance().createLabel("Do-Not-Mail Ad Companies");
		lblDoNotMailAdCompanies.setBounds(335, 145, 162, 23);
		getContentPane().add(lblDoNotMailAdCompanies);
	
		
		
		
	}

	private void initLists(){
		
		MagazineDatabase mdb = main.getMagazineDatabase();
		SubscriberDatabase sdb = main.getSubscriberDatabase();
		AdCompanyDatabase adb = main.getAdCompanyDatabase();
		
		publishedMagazines = mdb.getPublishedMagazines();
		inProgressMagazines = mdb.getInProgressMagazines();
		activeSubscribers = sdb.getActiveSubscribers();
		inactiveSubscribers = sdb.getInactiveSubscribers();
		doNotMailSubscribers = sdb.getDoNotMailSubscribers();
		activeAdCompanies = adb.getActiveCompanies();
		inactiveAdCompanies = adb.getInactiveCompanies();
		doNotMailAdCompanies = adb.getDoNotMailCompanies();
		
		
	}
	
	public void refreshLists(){
		MagazineDatabase mdb = main.getMagazineDatabase();
		SubscriberDatabase sdb = main.getSubscriberDatabase();
		AdCompanyDatabase adb = main.getAdCompanyDatabase();
		
		publishedMagazines = mdb.getPublishedMagazines();
		inProgressMagazines = mdb.getInProgressMagazines();
		activeSubscribers = sdb.getActiveSubscribers();
		inactiveSubscribers = sdb.getInactiveSubscribers();
		doNotMailSubscribers = sdb.getDoNotMailSubscribers();
		activeAdCompanies = adb.getActiveCompanies();
		inactiveAdCompanies = adb.getInactiveCompanies();
		doNotMailAdCompanies = adb.getDoNotMailCompanies();
		
		refreshSelectionList();
	}

	@SuppressWarnings({"unchecked" })
	private void refreshSelectionList(){
		
		if(rbActiveSubscribers.isSelected()){
			selectionList.setListData(activeSubscribers.toArray());	
		}else if(rbInactiveSubscribers.isSelected()){
			selectionList.setListData(inactiveSubscribers.toArray());	
		}else if(rbDoNotMailSubscribers.isSelected()){
			selectionList.setListData(doNotMailSubscribers.toArray());	
		}else if(rbInProgressMagazines.isSelected()){
			selectionList.setListData(inProgressMagazines.toArray());	
		}else if(rbPublishedMagazines.isSelected()){
			selectionList.setListData(publishedMagazines.toArray());	
		}else if(rbActiveAdCompanies.isSelected()){
			selectionList.setListData(activeAdCompanies.toArray());	
		}else if(rbInactiveAdCompanies.isSelected()){
			selectionList.setListData(inactiveAdCompanies.toArray());	
		}else if(rbDoNotMailCompanies.isSelected()){
			selectionList.setListData(doNotMailAdCompanies.toArray());	
		}	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initMisc(){
		selectionList = new JList();
		selectionList.setListData(activeSubscribers.toArray());
		selectionList.setVisibleRowCount(-1);
		selectionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		jsp = new JScrollPane(selectionList);
		jsp.setLocation(10, 10);
		jsp.setSize(250, 150);
		jsp.setEnabled(true);
	
		getContentPane().add(jsp);
		
		
	}

	


}
