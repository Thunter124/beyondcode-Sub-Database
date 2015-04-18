import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class AddArticleToMagazineGUI extends AddGenericObjectGUI{

	private static final long serialVersionUID = 89500056267695619L;
	private JTextField tfTitle;
	
	private JScrollPane jspCurrentAuthors;
	private JList<Author> authorSelection;
	private ArrayList<Author> tempAuthors;
	
	
	
	@SuppressWarnings("unchecked")
	public AddArticleToMagazineGUI(Magazine mag){
		tempAuthors = new ArrayList<Author>();
				
		
		jspCurrentAuthors = new JScrollPane();
		authorSelection = new JList<Author>();
		getContentPane().add(jspCurrentAuthors);
		
		jspCurrentAuthors.setBounds(280, 28, 150, 120);
		jspCurrentAuthors.setViewportView(authorSelection);
		jspCurrentAuthors.setEnabled(true);
		
		authorSelection.setVisibleRowCount(-1);
		authorSelection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		authorSelection.setEnabled(true);
		final ArrayList<Author> authors = Main.getInstance().getDatabase().getSubscriberDatabase().getAuthors();
		if(authors != null)
			selectionList.setListData(authors.toArray());
		
		
		
		jsp.setBounds(10, 28, 150, 120);
		
		
		
		tfTitle = new JTextField();
		tfTitle.setBounds(10, 190, 116, 22);
		getContentPane().add(tfTitle);
		tfTitle.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(10, 174, 56, 16);
		getContentPane().add(lblTitle);
		
		JButton btnAdd = new JButton(" Add ->");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempAuthors.add(authors.get(selectionList.getSelectedIndex()));
			}
		});
		btnAdd.setBounds(172, 62, 96, 25);
		getContentPane().add(btnAdd);
		
		JButton button = new JButton("<- Remove");
		button.setBounds(172, 88, 96, 25);
		getContentPane().add(button);
		
		JLabel lblAuthors = new JLabel("Authors:");
		lblAuthors.setBounds(10, 13, 56, 16);
		getContentPane().add(lblAuthors);
		
		JLabel lblCurrentAuthors = new JLabel("Current Authors:");
		lblCurrentAuthors.setBounds(280, 13, 97, 16);
		getContentPane().add(lblCurrentAuthors);
		
		
		
	}
}
