package se;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Panel for the administration of the MySQL tables
 * 
 * @version 1.6 vom 22.06.2016
 * @author Sebastian Mischke
 */

public class SQL extends JPanel {
	private JList<String> jList1 = new JList<String>();
	private DefaultListModel<String> jList1Model = new DefaultListModel<String>();
	private JScrollPane jList1ScrollPane = new JScrollPane(jList1);
	private JButton savebutton = new JButton();
	private JButton loadbutton = new JButton();
	private JButton deletebutton = new JButton();
	public Database database;
	public PersonList personlist;
	private JTextField jTextField1 = new JTextField();
	public Main main;

	/**
	 * 
	 * @param pl
	 *            the personlist with all the data for the program
	 * @param db
	 *            the database object for the connection to the mysql server
	 * @param m
	 *            the main window of the program
	 */
	public SQL(PersonList pl, Database db, Main m) {
		super();
		Container cp = this;
		cp.setLayout(null);
		personlist = pl;
		database = db;
		main = m;

		jList1.setModel(jList1Model);
		jList1ScrollPane.setBounds(13, 13, 235, 442);
		jList1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				if (jList1.getSelectedValue() == null)
					jTextField1.setText("");
				else {
					jTextField1.setText(jList1.getSelectedValue().toString());
				}
			}
		});
		cp.add(jList1ScrollPane);
		savebutton.setBounds(580, 13, 200, 25);
		savebutton.setText("Speichern");
		savebutton.setMargin(new Insets(2, 2, 2, 2));
		savebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				savebutton_ActionPerformed(evt);
			}
		});
		cp.add(savebutton);
		loadbutton.setBounds(580, 64, 200, 25);
		loadbutton.setText("Laden");
		loadbutton.setMargin(new Insets(2, 2, 2, 2));
		loadbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				loadbutton_ActionPerformed(evt);
			}
		});
		cp.add(loadbutton);
		deletebutton.setBounds(580, 115, 200, 25);
		deletebutton.setText("Löschen");
		deletebutton.setMargin(new Insets(2, 2, 2, 2));
		deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				deletebutton_ActionPerformed(evt);
			}
		});
		cp.add(deletebutton);
		jTextField1.setBounds(13, 464, 235, 25);
		cp.add(jTextField1);
		fillDatabaseList();

		setVisible(true);
	}

	private void savebutton_ActionPerformed(ActionEvent evt) {
		personlist.fillPersonInfo();
		database.save(jTextField1.getText(), personlist);
		fillDatabaseList();
	}

	private void loadbutton_ActionPerformed(ActionEvent evt) {
		personlist.clear();
		database.load(jTextField1.getText(), personlist);
		personlist.fillPersonInfo();
		main.updatePanels();
	}

	private void deletebutton_ActionPerformed(ActionEvent evt) {
		int i = jList1.getSelectedIndex();
		database.delete(jTextField1.getText());
		fillDatabaseList();
		jList1.setSelectedIndex(i);
	}

	/**
	 * Changes the language of the text on the buttons
	 * 
	 * @param l
	 *            object with language information
	 */
	public void setLang(Language l) {
		savebutton.setText(l.SPEICHERN);
		loadbutton.setText(l.LADEN);
		deletebutton.setText(l.LÖSCHEN);
	}

	/**
	 * Changes the size of the text on the buttons and the list
	 * 
	 * @param size
	 *            value of the size for the text
	 */
	public void setSize(int size) {
		savebutton.setFont(new Font("Dialog", Font.BOLD, size));
		loadbutton.setFont(new Font("Dialog", Font.BOLD, size));
		deletebutton.setFont(new Font("Dialog", Font.BOLD, size));
		jList1.setFont(new Font("Dialog", Font.BOLD, size));
	}

	/**
	 * 
	 */
	public void fillDatabaseList() {
		database.getTables(jList1Model);
	}
}
