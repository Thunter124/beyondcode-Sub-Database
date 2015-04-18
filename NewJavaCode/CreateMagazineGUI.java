import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CreateMagazineGUI extends JFrame{

	private static final long serialVersionUID = 8396454331021655953L;
	
	protected JTextField tfTitle;
	protected JTextField tfVolumeNum;
	protected JTextField tfIssueNum;
	
	protected JButton btnApply;
	protected JButton btnCancel;
	
	protected JLabel lblTitle;
	protected JLabel lblVolume;
	protected JLabel lblIssue;
	
	public CreateMagazineGUI() {
		
		initWindow();
		initButtons();
		initLabels();
		initTextFields();
	}
	
	private void initButtons(){

		btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(tfTitle.getText().equals("") || tfIssueNum.getText().equals("") || tfVolumeNum.getText().equals(""))){
					try{
						int issueNum = Integer.parseInt(tfIssueNum.getText());
						int volumeNum = Integer.parseInt(tfVolumeNum.getText());
						if(issueNum < 1 || volumeNum < 1)
							throw new NumberFormatException();
						String magTitle = tfTitle.getText();
						
						Magazine mag = new Magazine(magTitle, volumeNum, issueNum);
						Main.getInstance().getDatabase().passNewMagazine(mag);
						dispose();
					}catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null, "Volume and Issue fields must be a number, and greater than 0!", "Error!", JOptionPane.WARNING_MESSAGE);
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "No fields may be blank!", "Error!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnApply.setBounds(137, 225, 89, 23);
		getContentPane().add(btnApply);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(236, 225, 89, 23);
		getContentPane().add(btnCancel);
	}
	
	private void initLabels(){
		lblTitle = new JLabel("Title:");
		lblTitle.setBounds(20, 80, 56, 16);
		getContentPane().add(lblTitle);
	
		lblVolume = new JLabel("Volume:");
		lblVolume.setBounds(179, 80, 56, 16);
		getContentPane().add(lblVolume);
		
		lblIssue = new JLabel("Issue:");
		lblIssue.setBounds(322, 80, 56, 16);
		getContentPane().add(lblIssue);
	}
	
	private void initTextFields(){
		tfTitle = new JTextField();
		tfTitle.setBounds(20, 100, 86, 20);
		getContentPane().add(tfTitle);
		tfTitle.setColumns(10);
		
		tfVolumeNum = new JTextField();
		tfVolumeNum.setBounds(179, 100, 86, 20);
		getContentPane().add(tfVolumeNum);
		tfVolumeNum.setColumns(10);
		
		tfIssueNum = new JTextField();
		tfIssueNum.setBounds(322, 100, 86, 20);
		getContentPane().add(tfIssueNum);
		tfIssueNum.setColumns(10);
		
	}
	
	
	private void initWindow(){
		setTitle("Magazine Information");
		setSize(450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();	//set window in center of screen, regardless of screen resolution
		this.setLocation(dim.width/2 - this.getWidth()/2, dim.height/2 - this.getHeight()/2);
	}
}
