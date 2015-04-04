import javax.swing.JFrame;


public class Main {
	MagazineDatabase mdb;
	SubscriberDatabase sdb;
	AdCompanyDatabase adb;
	
	
	
	private Main(){
		mdb = new MagazineDatabase();
		sdb = new SubscriberDatabase();
		adb = new AdCompanyDatabase();
		
		initGUI();
	}
	
	
	private void initGUI(){
		MainGUI gui = new MainGUI(this);
		gui.setVisible(true);		
	}
	
	public void passNewSubscriber(Subscriber sub){
		sdb.addNewSubscriber(sub);
	}
	
	public static void main(String[] args){
		new Main();	
	}
	
	

}
