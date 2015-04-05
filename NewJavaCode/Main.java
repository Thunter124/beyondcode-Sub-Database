import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Main {
	MagazineDatabase mdb = new MagazineDatabase();
	SubscriberDatabase sdb = new SubscriberDatabase();
	AdCompanyDatabase adb = new AdCompanyDatabase();
	MainGUI gui;
	
	
	private Main(){
		mdb = new MagazineDatabase();
		sdb = new SubscriberDatabase();
		adb = new AdCompanyDatabase();
		
		initGUI();
	}
	
	
	private void initGUI(){
		gui = new MainGUI(this);
		gui.setVisible(true);
	}
	
	public void passNewSubscriber(Subscriber sub){
		sdb.addNewSubscriber(sub);
		gui.refreshLists();
	}
	
	public void passNewMagazine(Magazine mag){
		mdb.addMagazineToInProgress(mag);
		gui.refreshLists();
	}
	
	public static void main(String[] args){
		new Main();	
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
