package com.beyondcode.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.beyondcode.core.Article;
import com.beyondcode.core.Author;
import com.beyondcode.core.Magazine;
import com.beyondcode.main.Main;

public class AddArticleToMagazineGUI extends AddGenericObjectGUI{

	private static final long serialVersionUID = 89500056267695619L;
	private JTextField tfTitle;
	
	private JScrollPane jspCurrentAuthors;
	private JList authorSelection;
	private ArrayList<Author> tempAuthors;
	
	
	
	@SuppressWarnings("unchecked")
	public AddArticleToMagazineGUI(final Magazine mag){
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(authorSelection.getModel().getSize() == 0)
					JOptionPane.showMessageDialog(null, "There must be at least one author for the article!");
				else if(tfTitle.getText().equals(""))
					JOptionPane.showMessageDialog(null, "The article must have a title!");
				else{
					Article a = new Article(tfTitle.getText());
					for(int i = 0; i < authorSelection.getModel().getSize(); ++i)
						a.addAuthor((Author)authorSelection.getModel().getElementAt(i));
					mag.addArticle(a);
					dispose();
					
				}
				
					
				
					
					
			}
		});
		tempAuthors = new ArrayList<Author>();
				
		
		jspCurrentAuthors = new JScrollPane();
		authorSelection = new JList();
		getContentPane().add(jspCurrentAuthors);
		
		jspCurrentAuthors.setBounds(280, 28, 150, 120);
		jspCurrentAuthors.setViewportView(authorSelection);
		jspCurrentAuthors.setEnabled(true);
		
		authorSelection.setVisibleRowCount(-1);
		authorSelection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		authorSelection.setEnabled(true);
		final ArrayList<Author> authors = Main.getInstance().getDatabase().getSubscriberDatabase().getAuthors();
		if(authors != null){
			selectionList.setListData(authors.toArray());
			selectionList.setSelectedIndex(0);
		}
		
		
		
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
				
				boolean found = false;
				for(int i = 0; i < authorSelection.getModel().getSize(); ++i){
					
					if(authorSelection.getModel().getElementAt(i).equals(authors.get(selectionList.getSelectedIndex()))){
						found = true;
						break;
					}
				}
				if(!found)
					authorSelection.setListData(tempAuthors.toArray());
				else
					tempAuthors.remove(tempAuthors.size() - 1);
			}
		});
		btnAdd.setBounds(172, 62, 96, 25);
		getContentPane().add(btnAdd);
		
		JButton button = new JButton("<- Remove");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(authorSelection.getSelectedIndex() != -1){
					tempAuthors.remove(authorSelection.getSelectedIndex());
					authorSelection.setListData(tempAuthors.toArray());
				}
			}
		});
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
