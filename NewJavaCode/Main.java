import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Main {
	
	MainGUI gui;
	private static Main main;
	private Database database;
	
	private Main(){
		main = this;
		database = new Database();
		initGUI();
		database.setGUI(gui);
	}
	
	public static Main getInstance(){
		return main;
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
