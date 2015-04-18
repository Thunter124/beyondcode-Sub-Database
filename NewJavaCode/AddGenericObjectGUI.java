import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddGenericObjectGUI extends JFrame {

	private static final long serialVersionUID = -9026479955595405192L;
	
	protected JScrollPane jsp;
	protected JList selectionList;
	protected JButton btnApply;
	
	public AddGenericObjectGUI(){
		initWindow();
		initMisc();
	}
	
	private void initWindow(){
		setSize(450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();	//set window in center of screen, regardless of screen resolution
		this.setLocation(dim.width/2 - this.getWidth()/2, dim.height/2 - this.getHeight()/2);
	}
	
	@SuppressWarnings("rawtypes")
	private void initMisc(){
		jsp = new JScrollPane();
		jsp.setLocation(10, 10);
		jsp.setSize(170, 140);
		jsp.setEnabled(true);
	
		getContentPane().add(jsp);
		selectionList = new JList();
		jsp.setViewportView(selectionList);
		
		selectionList.setVisibleRowCount(-1);
		selectionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		btnApply = new JButton("Apply");
		btnApply.setBounds(335, 227, 97, 25);
		getContentPane().add(btnApply);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(226, 227, 97, 25);
		getContentPane().add(btnCancel);
	}

}
