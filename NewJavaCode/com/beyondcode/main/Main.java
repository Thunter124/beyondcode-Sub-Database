package com.beyondcode.main;
import com.beyondcode.databases.Database;
import com.beyondcode.gui.MainGUI;


public class Main {
	
	MainGUI gui;
	private static Main instance;
	private Database database;
	
	private Main(){
		instance = this;
		database = new Database();
		initGUI();
		database.setGUI(gui);
		database.load();
	}
	
	public static Main getInstance(){
		return instance;
	}
	
	public Database getDatabase(){
		return database;
	}
	
	public static void main(String[] args){
		new Main();	
	}

	private void initGUI(){
		gui = new MainGUI();
		gui.setVisible(true);
	}
	
	public void refreshGUILists(){
		gui.refreshLists();
	}
}
