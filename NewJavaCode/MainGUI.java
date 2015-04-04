import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;


public class MainGUI extends JFrame {
	
	private static final long serialVersionUID = 6411499808530678723L;
	JButton btnSave;
	JButton btnLoad;
	JButton btnAddSubscriber;
	JButton btnAddMagazine;
	Main main;
	
	public MainGUI(Main main) {
		initWindow();
		initButtons();
		this.main = main;
	}
	
	
	private void initWindow(){
		//basic windows attributes
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
				System.out.println("Saved!");
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
		btnAddSubscriber.setBounds(391, 28, 134, 23);
		getContentPane().add(btnAddSubscriber);
	//add magazine
		btnAddMagazine = new JButton("Add Magazine");
		btnAddMagazine.setBounds(391, 61, 134, 23);
		getContentPane().add(btnAddMagazine);
	}
	
	
	
}
