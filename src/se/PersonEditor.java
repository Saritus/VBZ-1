package se;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.text.*;

/**
 * Edit information about persons
 *
 * @author Sebastian Mischke
 * @version 1.0 vom 21.01.2016
 */
public class PersonEditor extends JPanel {
	private JLabel lnamelabel = new JLabel();
	private JLabel fnamelabel = new JLabel();
	private JLabel genderlabel = new JLabel();
	private JLabel bdaylabel = new JLabel();
	private JButton newbutton = new JButton();
	private JTextField lnametf = new JTextField();
	private JTextField fnametf = new JTextField();
	private JComboBox<String> genderbox = new JComboBox<String>();
	private DefaultComboBoxModel<String> genderboxModel = new DefaultComboBoxModel<String>();
	private JLabel fatherlabel = new JLabel();
	private JComboBox<Person> fatherbox = new JComboBox<Person>();
	private DefaultComboBoxModel<Person> fatherboxModel = new DefaultComboBoxModel<Person>();
	private JLabel motherlabel = new JLabel();
	private JComboBox<Person> motherbox = new JComboBox<Person>();
	private DefaultComboBoxModel<Person> motherboxModel = new DefaultComboBoxModel<Person>();
	private JLabel spouselabel = new JLabel();
	private JComboBox<Person> spousebox = new JComboBox<Person>();
	private DefaultComboBoxModel<Person> spouseboxModel = new DefaultComboBoxModel<Person>();
	private JButton acceptbutton = new JButton();
	private JButton cancelbutton = new JButton();
	private JList<String> jList1 = new JList<String>();
	private DefaultListModel<String> jList1Model = new DefaultListModel<String>();
	private JScrollPane jList1ScrollPane = new JScrollPane(jList1);
	private JButton selectbutton = new JButton();
	private JLabel lnamelabel1 = new JLabel();
	private JLabel fnamelabel1 = new JLabel();
	private JLabel genderlabel1 = new JLabel();
	private JLabel bdaylabel1 = new JLabel();
	private JLabel fatherlabel1 = new JLabel();
	private JLabel motherlabel1 = new JLabel();
	private JLabel spouselabel1 = new JLabel();
	private JFormattedTextField gebdattf = new JFormattedTextField(createFormatter("##.##.####"));
	public Main mainw;
	public PersonList personlist;
	private Person selected;

	/**
	 * @param pl
	 *            the personlist with all the data for the program
	 * @param m
	 *            the main window of the program
	 */
	public PersonEditor(PersonList pl, Main m) {
		super();
		Container cp = this;
		cp.setLayout(null);
		personlist = pl;
		mainw = m;
		selected = new Person("", "");

		lnamelabel.setBounds(13, 13, 150, 25);
		lnamelabel.setText("Nachname");
		cp.add(lnamelabel);
		fnamelabel.setBounds(13, 59, 150, 25);
		fnamelabel.setText("Vorname");
		cp.add(fnamelabel);
		genderlabel.setBounds(13, 151, 150, 25);
		genderlabel.setText("Geschlecht");
		cp.add(genderlabel);
		bdaylabel.setBounds(13, 105, 150, 25);
		bdaylabel.setText("Geburtsdatum");
		cp.add(bdaylabel);
		newbutton.setBounds(13, 460, 135, 25);
		newbutton.setText("Neu");
		newbutton.setMargin(new Insets(2, 2, 2, 2));
		newbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				newbutton_ActionPerformed(evt);
			}
		});
		cp.add(newbutton);
		lnametf.setBounds(163, 13, 150, 25);
		cp.add(lnametf);
		fnametf.setBounds(163, 59, 150, 25);
		cp.add(fnametf);
		genderbox.setModel(genderboxModel);
		genderbox.setBounds(163, 151, 150, 25);
		genderbox.addItem("M�nnlich");
		genderbox.addItem("Weiblich");
		cp.add(genderbox);
		fatherlabel.setBounds(13, 197, 150, 25);
		fatherlabel.setText("Vater");
		cp.add(fatherlabel);
		fatherbox.setModel(fatherboxModel);
		fatherbox.setBounds(163, 197, 150, 25);
		cp.add(fatherbox);
		motherlabel.setBounds(13, 243, 150, 25);
		motherlabel.setText("Mutter");
		cp.add(motherlabel);
		motherbox.setModel(motherboxModel);
		motherbox.setBounds(163, 243, 150, 25);
		cp.add(motherbox);
		spouselabel.setBounds(13, 289, 150, 25);
		spouselabel.setText("Ehepartner");
		cp.add(spouselabel);
		spousebox.setModel(spouseboxModel);
		spousebox.setBounds(163, 289, 150, 25);
		cp.add(spousebox);
		acceptbutton.setBounds(166, 460, 135, 25);
		acceptbutton.setText("�bernehmen");
		acceptbutton.setMargin(new Insets(2, 2, 2, 2));
		acceptbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				acceptbutton_ActionPerformed(evt);
			}
		});
		cp.add(acceptbutton);
		cancelbutton.setBounds(320, 460, 135, 25);
		cancelbutton.setText("L�schen");
		cancelbutton.setMargin(new Insets(2, 2, 2, 2));
		cancelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cancelbutton_ActionPerformed(evt);
			}
		});
		cp.add(cancelbutton);
		jList1.setModel(jList1Model);
		jList1ScrollPane.setBounds(545, 13, 235, 436);
		cp.add(jList1ScrollPane);
		selectbutton.setBounds(545, 460, 235, 25);
		selectbutton.setText("Ausw�hlen");
		selectbutton.setMargin(new Insets(2, 2, 2, 2));
		selectbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				selectbutton_ActionPerformed(evt);
			}
		});
		selectbutton.setRolloverEnabled(true);
		cp.add(selectbutton);
		lnamelabel1.setBounds(326, 13, 180, 25);
		lnamelabel1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lnamelabel1.setForeground(Color.RED);
		cp.add(lnamelabel1);
		fnamelabel1.setBounds(326, 59, 180, 25);
		fnamelabel1.setFont(new Font("Dialog", Font.PLAIN, 12));
		fnamelabel1.setForeground(Color.RED);
		cp.add(fnamelabel1);
		genderlabel1.setBounds(326, 151, 180, 25);
		genderlabel1.setFont(new Font("Dialog", Font.PLAIN, 12));
		genderlabel1.setForeground(Color.RED);
		cp.add(genderlabel1);
		bdaylabel1.setBounds(326, 105, 180, 25);
		bdaylabel1.setFont(new Font("Dialog", Font.PLAIN, 12));
		bdaylabel1.setForeground(Color.RED);
		cp.add(bdaylabel1);
		fatherlabel1.setBounds(326, 197, 180, 25);
		fatherlabel1.setFont(new Font("Dialog", Font.PLAIN, 12));
		fatherlabel1.setForeground(Color.RED);
		cp.add(fatherlabel1);
		motherlabel1.setBounds(326, 243, 180, 25);
		motherlabel1.setFont(new Font("Dialog", Font.PLAIN, 12));
		motherlabel1.setForeground(Color.RED);
		cp.add(motherlabel1);
		spouselabel1.setBounds(326, 289, 180, 25);
		spouselabel1.setFont(new Font("Dialog", Font.PLAIN, 12));
		spouselabel1.setForeground(Color.RED);
		cp.add(spouselabel1);
		gebdattf.setBounds(163, 105, 150, 25);
		gebdattf.setText("01.01.1990");
		cp.add(gebdattf);

		updateList();
		setVisible(true);
	}

	private void cancelbutton_ActionPerformed(ActionEvent evt) {
		// TODO Ausgew�hlte Person l�schen
	}

	private void newbutton_ActionPerformed(ActionEvent evt) {
		// TODO Neue Person erstellen
		// Person p = new Person(lnametf.getText(), fnametf.getText(),
		// geschlecht, gebdat, vater, mutter, ehepartner);

		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		MyDate geb;
		try {
			geb = (new MyDate(formatter.parse(gebdattf.getText())));
		} catch (ParseException e) {
			bdaylabel1.setText("Ung�ltiges Datum");
			return;
		}
		char gen;
		switch (genderbox.getSelectedItem().toString()) {
		case "M�nnlich":
			gen = 'm';
			break;
		case "Weiblich":
			gen = 'w';
			break;
		default:
			gen = 'u';
			break;
		}
		Person p = new Person(lnametf.getText(), fnametf.getText(), gen, geb);
		personlist.addPerson(p);

		mainw.updatePanels();
	}

	private void selectbutton_ActionPerformed(ActionEvent evt) {
		if (jList1.getSelectedIndex() != -1) {
			selected = personlist.getList()[jList1.getSelectedIndex()];
		}
		lnametf.setText(selected.getNachname());
		fnametf.setText(selected.getVorname());
		gebdattf.setText(selected.getGebdat().toFormatString());
		switch (selected.getGeschlecht()) {
		case 'm':
			genderbox.setSelectedIndex(0);
			break;
		case 'w':
			genderbox.setSelectedIndex(1);
			break;
		}
		// TODO: Alle Informationen der Person in die Felder eintragen
	}

	private void acceptbutton_ActionPerformed(ActionEvent evt) {
		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		try {
			selected.setGebdat(new MyDate(formatter.parse(gebdattf.getText())));
		} catch (ParseException e) {
			bdaylabel1.setText("Ung�ltiges Datum");
			gebdattf.setText(selected.getGebdat().toFormatString());
			return;
		}
		selected.setNachname(lnametf.getText());
		selected.setVorname(fnametf.getText());
		switch (genderbox.getSelectedItem().toString()) {
		case "M�nnlich":
			selected.setGeschlecht('m');
			break;
		case "Weiblich":
			selected.setGeschlecht('w');
			break;
		}
		selected.setVater((Person) fatherbox.getSelectedItem());
		mainw.updatePanels();

	}

	protected MaskFormatter createFormatter(String s) {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter(s);
		} catch (java.text.ParseException exc) {
		}
		return formatter;
	}

	public void updateList() {
		jList1Model.clear();
		fatherboxModel.removeAllElements();
		motherboxModel.removeAllElements();
		spouseboxModel.removeAllElements();
		String[] infos = personlist.getStringList();
		for (int i = 0; i < personlist.getQuantity(); i++) {
			jList1Model.addElement(infos[i]);
		}

		fatherboxModel.addElement(null);
		for (Person name : personlist.getMales().getList())
			fatherboxModel.addElement(name);

		motherboxModel.addElement(null);
		for (Person name : personlist.getFemales().getList())
			motherboxModel.addElement(name);

		spouseboxModel.addElement(null);
		for (Person name : personlist.getList())
			spouseboxModel.addElement(name);
	}

	/**
	 * Changes the size of the text on the buttons and the labels
	 * 
	 * @param size
	 *            value of the size for the text
	 */
	public void setSize(int size) {
		acceptbutton.setFont(new Font("Dialog", Font.BOLD, size));
		selectbutton.setFont(new Font("Dialog", Font.BOLD, size));
		newbutton.setFont(new Font("Dialog", Font.BOLD, size));
		cancelbutton.setFont(new Font("Dialog", Font.BOLD, size));

		lnamelabel.setFont(new Font("Dialog", Font.BOLD, size));
		fnamelabel.setFont(new Font("Dialog", Font.BOLD, size));
		bdaylabel.setFont(new Font("Dialog", Font.BOLD, size));
		genderlabel.setFont(new Font("Dialog", Font.BOLD, size));
		fatherlabel.setFont(new Font("Dialog", Font.BOLD, size));
		motherlabel.setFont(new Font("Dialog", Font.BOLD, size));
		spouselabel.setFont(new Font("Dialog", Font.BOLD, size));

		jList1.setFont(new Font("Dialog", Font.BOLD, size));
	}

	/**
	 * Changes the language of the text on the labels
	 * 
	 * @param l
	 *            object with language information
	 */
	public void setLang(Language l) {
		acceptbutton.setText(l.�BERNEHMEN);
		selectbutton.setText(l.AUSW�HLEN);
		newbutton.setText(l.NEU);
		cancelbutton.setText(l.L�SCHEN);

		lnamelabel.setText(l.NACHNAME);
		fnamelabel.setText(l.VORNAME);
		bdaylabel.setText(l.GEBURTSDATUM);
		genderlabel.setText(l.GESCHLECHT);
		fatherlabel.setText(l.VATER);
		motherlabel.setText(l.MUTTER);
		spouselabel.setText(l.EHEPARTNER);
	}
}
