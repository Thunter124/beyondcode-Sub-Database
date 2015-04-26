package com.beyondcode.databases;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.beyondcode.core.AdCompany;
import com.beyondcode.core.Author;
import com.beyondcode.core.Magazine;
import com.beyondcode.core.Subscriber;
import com.beyondcode.gui.MainGUI;


public class Database {
	
	MagazineDatabase mdb;
	SubscriberDatabase sdb;
	AdCompanyDatabase adb;
	MainGUI gui;
	
	public Database(){
		mdb = new MagazineDatabase();
		sdb = new SubscriberDatabase();
		adb = new AdCompanyDatabase();
	}
	
	public void setGUI(MainGUI gui){
		this.gui = gui;
	}
	
	public void passNewSubscriber(Subscriber sub){
		sdb.addNewSubscriber(sub);
		gui.refreshLists();
	}
	
	public void passNewMagazine(Magazine mag){
		mdb.addMagazineToInProgress(mag);
		gui.refreshLists();
	}
	
	public void passNewAdCompany(AdCompany ac){
		adb.addNewCompany(ac);
		gui.refreshLists();
	}
	
	public void passNewAuthor(Author author){
		sdb.addNewAuthor(author);
		gui.refreshLists();
	}
	
	

	public MagazineDatabase getMagazineDatabase(){
		return mdb;
	}
	
	public SubscriberDatabase getSubscriberDatabase(){
		return sdb;
	}
	
	public AdCompanyDatabase getAdCompanyDatabase(){
		return adb;
	}
	
	public void printShippingLabels(){
	
	}
	

	public void save(){
		File dir = new File("Databases");
		dir.mkdir();
		
		try {
			FileOutputStream fos = new FileOutputStream(dir.toString() + "/MagazineDatabase.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(mdb);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
			
			fos = new FileOutputStream(dir.toString() + "/SubscriberDatabase.bin");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(sdb);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
			
			fos = new FileOutputStream(dir.toString() + "/AdCompanyDatabase.bin");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(adb);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
		} catch (IOException e) {
			System.out.println("Failed to open file!");
			e.printStackTrace();
		}
	}
	

	public void load(){
		File dir = new File("Databases");
		dir.mkdir();
		
		try {
			FileInputStream fis = new FileInputStream(dir.toString() + "/MagazineDatabase.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			mdb = (MagazineDatabase) ois.readObject();
			ois.close();
			fis.close();
			
			fis = new FileInputStream(dir.toString() + "/SubscriberDatabase.bin");
			ois = new ObjectInputStream(fis);
			sdb = (SubscriberDatabase) ois.readObject();
			ois.close();
			fis.close();
			
			fis = new FileInputStream(dir.toString() + "/AdCompanyDatabase.bin");
			ois = new ObjectInputStream(fis);
			adb = (AdCompanyDatabase) ois.readObject();
			ois.close();
			fis.close();
			
			gui.refreshLists();
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Failed to load file!");
			e.printStackTrace();
		} 
		
	}	

}
