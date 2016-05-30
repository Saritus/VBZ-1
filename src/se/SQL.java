package se;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * 
 * Beschreibung
 * 
 * @version 1.0 vom 28.01.2016
 * @author Sebastian Mischke
 */

public class SQL extends JPanel {
	// Anfang Attribute
	private JList jList1 = new JList();
	private DefaultListModel jList1Model = new DefaultListModel();
	private JScrollPane jList1ScrollPane = new JScrollPane(jList1);
	private JButton savebutton = new JButton();
	private JButton loadbutton = new JButton();
	private JButton deletebutton = new JButton();
	public Database database;
	public PersonList personlist;
	private JTextField jTextField1 = new JTextField();
	public Main main;

	// Ende Attribute

	public SQL() {
		this(new PersonList(), new Database(), new Main());
	}

	public SQL(PersonList pl, Database db, Main m) {
		// Frame-Initialisierung
		super();
		Container cp = this;
		cp.setLayout(null);
		personlist = pl;
		database = db;
		main = m;
		// Anfang Komponenten

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
		// Ende Komponenten

		setVisible(true);
	} // end of public Database

	// Anfang Methoden

	public static void main(String[] args) {
		JFrame f = new JFrame("SQL");
		f.add(new SQL(), BorderLayout.CENTER);
		f.setSize(809, 537);
		f.setVisible(true);
	} // end of main

	public void savebutton_ActionPerformed(ActionEvent evt) {
		personlist.fillPersonInfo();
		database.save(jTextField1.getText(), personlist);
		fillDatabaseList();
	} // end of savebutton_ActionPerformed

	public void loadbutton_ActionPerformed(ActionEvent evt) {
		personlist.clear();
		database.load(jTextField1.getText(), personlist);
		personlist.fillPersonInfo();
		main.updatePanels();
	} // end of loadbutton_ActionPerformed

	public void deletebutton_ActionPerformed(ActionEvent evt) {
		int i = jList1.getSelectedIndex();
		database.delete(jTextField1.getText());
		fillDatabaseList();
		jList1.setSelectedIndex(i);
	} // end of deletebutton_ActionPerformed

	public void setLang(Language l) {
		// TODO: Setze neue Sprache
		savebutton.setText(l.SPEICHERN);
		loadbutton.setText(l.LADEN);
		deletebutton.setText(l.LÖSCHEN);
	}

	public void setSize(int size) {
		// TODO: Setze neue Schriftgröße
	}

	public void fillDatabaseList() {
		database.getTables(jList1Model);
	}
	// Ende Methoden
} // end of class Database
