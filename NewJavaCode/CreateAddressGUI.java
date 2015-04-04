import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class CreateAddressGUI extends JFrame {
	int numAddressesLeft;
	int currentAddressNum;
	boolean validTextFields = false;

	private JTextField tfName;
	private JTextField tfStreetAddress;
	private JTextField tfState;
	private JTextField tfZipCode;
	private JTextField tfCopiesPerIssue;
	private Subscriber newSub;
	private CreateSubscriberGUI csGUI;

	public CreateAddressGUI(int currentAddressNum, int numAddresses, Subscriber newSub, CreateSubscriberGUI csGUI) {
		numAddressesLeft = numAddresses;
		this.currentAddressNum = currentAddressNum;
		this.csGUI = csGUI;
		
		this.newSub = newSub;
		initWindow();
		initButtons();
		initLabels();
		initTextFields();
		
		this.setTitle("Subscriber Address: " + currentAddressNum + "/" + numAddresses);
	}

	private void initWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setSize(450, 300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2
				- this.getHeight() / 2);
	}

	private void initButtons() {
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(tfName.getText().equals("")
						|| tfStreetAddress.getText().equals("")
						|| tfZipCode.getText().equals("")
						|| tfState.getText().equals("") 
						|| tfCopiesPerIssue.equals(""))) {

					int copiesPerIssue = 0;
					try {
						copiesPerIssue = Integer.parseInt(tfCopiesPerIssue.getText());
						if(copiesPerIssue < 1)
							throw new NumberFormatException();
						else{
							String name = tfName.getText();
							String address = tfStreetAddress.getText() + " " + tfState.getText() + " " + tfZipCode.getText();
							
							ShippingAddress newAddress = new ShippingAddress(name, address, copiesPerIssue);
							newSub.addAddress(newAddress);
							if(currentAddressNum == numAddressesLeft){
								csGUI.enableApplyButton(newSub);
								dispose();
							}else{
								CreateAddressGUI caGUI = new CreateAddressGUI(++currentAddressNum, numAddressesLeft, newSub, csGUI);
								caGUI.setVisible(true);
								dispose();
							}
								
							
						}
						
						
						
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,
								"The number of copies per issue must be a number, and greater"
										+ " than zero!", "Error!",
								JOptionPane.WARNING_MESSAGE);
						validTextFields = false;
					}

				} else {
					JOptionPane.showMessageDialog(null,
							"No fields may be blank!", "Error!",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNext.setBounds(117, 228, 89, 23);
		getContentPane().add(btnNext);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setBounds(216, 228, 89, 23);
		getContentPane().add(btnCancel);

	}

	private void initLabels() {
		JLabel lblName = DefaultComponentFactory.getInstance().createLabel(
				"Name or Title:");
		lblName.setBounds(26, 28, 81, 14);
		getContentPane().add(lblName);

		JLabel lblStreetAddress = DefaultComponentFactory.getInstance()
				.createLabel("Street Address:");
		lblStreetAddress.setBounds(250, 28, 92, 14);
		getContentPane().add(lblStreetAddress);

		JLabel lblState = DefaultComponentFactory.getInstance().createLabel(
				"City, State:");
		lblState.setBounds(250, 73, 92, 14);
		getContentPane().add(lblState);

		JLabel lblZipCode = DefaultComponentFactory.getInstance().createLabel(
				"Zip Code:");
		lblZipCode.setBounds(250, 122, 92, 14);
		getContentPane().add(lblZipCode);

		JLabel lblStartingCopies = DefaultComponentFactory.getInstance()
				.createLabel("Copies Per Issue:");
		lblStartingCopies.setBounds(26, 73, 110, 14);
		getContentPane().add(lblStartingCopies);
	}

	private void initTextFields() {
		tfName = new JTextField();
		tfName.setBounds(26, 42, 135, 20);
		getContentPane().add(tfName);
		tfName.setColumns(10);

		tfStreetAddress = new JTextField();
		tfStreetAddress.setBounds(250, 42, 153, 20);
		getContentPane().add(tfStreetAddress);
		tfStreetAddress.setColumns(10);

		tfState = new JTextField();
		tfState.setBounds(250, 87, 153, 20);
		getContentPane().add(tfState);
		tfState.setColumns(10);

		tfZipCode = new JTextField();
		tfZipCode.setBounds(250, 137, 153, 20);
		getContentPane().add(tfZipCode);
		tfZipCode.setColumns(10);

		tfCopiesPerIssue = new JTextField();
		tfCopiesPerIssue.setBounds(26, 87, 40, 20);
		getContentPane().add(tfCopiesPerIssue);
		tfCopiesPerIssue.setColumns(10);

	}

}
