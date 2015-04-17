import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


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
	

	public MagazineDatabase getMagazineDatabase(){
		return mdb;
	}
	
	public SubscriberDatabase getSubscriberDatabase(){
		return sdb;
	}
	
	public AdCompanyDatabase getAdCompanyDatabase(){
		return adb;
	}
	
	


	public void save(){
		File dir = new File("Databases");
		dir.mkdir();
		
		try {
			FileOutputStream fos = new FileOutputStream(dir.toString() + "/MagazineDatabase.bin" );
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
		
	}	

}
