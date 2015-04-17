import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAdCompanyGUI extends JFrame {

	private static final long serialVersionUID = 27638576650944154L;
	private JTextField tfZipCode;
	private JTextField tfCityState;
	private JTextField tfStreetAddress;
	private JTextField tfName;

	public CreateAdCompanyGUI() {
		setTitle("Ad Company Information");
		initWindow();
		initTextFields();
		initLabels();
		initButtons();
	}

	private void initLabels() {

		JLabel label_1 = new JLabel("City, State:");
		label_1.setBounds(12, 77, 97, 16);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Street Address:");
		label_2.setBounds(236, 28, 97, 16);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("Zip Code:");
		label_3.setBounds(236, 78, 56, 16);
		getContentPane().add(label_3);
	}
	
	private void initButtons(){
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(tfName.getText().equals("") || tfStreetAddress.getText().equals("") 
					|| tfCityState.getText().equals("") || tfZipCode.getText().equals(""))){
					String name = tfName.getText();
					String address = tfStreetAddress.getText() + "\n" + tfCityState.getText() + ". " 
									+ tfZipCode.getText();
					AdCompany ac = new AdCompany(name, new ShippingAddress(name, address, 1));
					Main.getInstance().getDatabase().passNewAdCompany(ac);
					dispose();
					
				}else{
					JOptionPane.showMessageDialog(null, "No text fields can be blank!", 
							"Error!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnApply.setBounds(252, 217, 89, 23);
		getContentPane().add(btnApply);

		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(76, 217, 89, 23);
		getContentPane().add(btnCancel);
		
	
	}
	
	private void initTextFields() {
		tfZipCode = new JTextField();
		tfZipCode.setColumns(10);
		tfZipCode.setBounds(236, 95, 153, 20);
		getContentPane().add(tfZipCode);

		tfCityState = new JTextField();
		tfCityState.setColumns(10);
		tfCityState.setBounds(12, 96, 135, 20);
		getContentPane().add(tfCityState);

		tfStreetAddress = new JTextField();
		tfStreetAddress.setColumns(10);
		tfStreetAddress.setBounds(236, 45, 153, 20);
		getContentPane().add(tfStreetAddress);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(12, 44, 135, 20);
		getContentPane().add(tfName);
	}

	private void initWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblCompanyName = new JLabel("Company Name:");
		lblCompanyName.setBounds(12, 28, 97, 16);
		getContentPane().add(lblCompanyName);

		
		this.setSize(450, 300);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2
				- this.getHeight() / 2);
	}
}
