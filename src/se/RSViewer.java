package se;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.print.*;
import java.awt.image.*;
import javax.imageio.*;

/**
 * 
 * Beschreibung
 * 
 * @version 1.0 vom 22.01.2016
 * @author Sebastian Mischke
 */

public class RSViewer extends JPanel {
	// Anfang Attribute
	public MyCanvas canvas;
	private JList jList1 = new JList();
	private DefaultListModel jList1Model = new DefaultListModel();
	private JScrollPane jList1ScrollPane = new JScrollPane(jList1);
	private JButton savebutton = new JButton();
	private JButton selectbutton = new JButton();
	public PersonList personlist;
	private Person selected;

	// Ende Attribute

	public RSViewer() {
		this(new PersonList());
	}

	public RSViewer(PersonList pl) {
		// Frame-Initialisierung
		super();
		Container cp = this;
		cp.setLayout(null);
		personlist = pl;
		// Anfang Komponenten
		canvas = new MyCanvas();
		canvas.setBounds(13, 13, 521, 434);
		canvas.setBackground(Color.WHITE);
		cp.add(canvas);
		jList1.setModel(jList1Model);
		jList1ScrollPane.setBounds(545, 13, 235, 436);
		jList1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {

					// Double-click detected
					int index = jList1.locationToIndex(evt.getPoint());
					System.out.println(index + "");
				} else if (evt.getClickCount() == 3) {

					// Triple-click detected
					int index = jList1.locationToIndex(evt.getPoint());
					System.out.println(index + "");
				}
			}
		});
		cp.add(jList1ScrollPane);
		savebutton.setBounds(13, 460, 160, 25);
		savebutton.setText("Speichern");
		savebutton.setMargin(new Insets(2, 2, 2, 2));
		savebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				saveicon_ActionPerformed(evt);
			}
		});
		cp.add(savebutton);
		selectbutton.setBounds(545, 460, 235, 25);
		selectbutton.setText("Auswählen");
		selectbutton.setMargin(new Insets(2, 2, 2, 2));
		selectbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				selectbutton_ActionPerformed(evt);
			}
		});
		cp.add(selectbutton);
		// Ende Komponenten
		updateList();
		drawBasic();
		setVisible(true);
	} // end of public RSViewer

	public void saveicon_ActionPerformed(ActionEvent evt) {
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			canvas.save(file);
		}
	} // end of saveicon_ActionPerformed

	public void selectbutton_ActionPerformed(ActionEvent evt) {
		if (jList1.getSelectedIndex() != -1) {
			System.out.println(jList1.getSelectedIndex());
			selected = personlist.getList()[jList1.getSelectedIndex()];
			System.out.println(selected.getName());
		}
	} // end of selectbutton_ActionPerformed

	public void updateList() {
		jList1Model.clear();
		String[] infos = personlist.getStringList();
		for (int i = 0; i < personlist.getQuantity(); i++) {
			jList1Model.addElement(infos[i]);
		}
	}

	public int drawBasic() {
		return 3;
	}

	public void setLang(Language l) {
		savebutton.setText(l.SPEICHERN);
		selectbutton.setText(l.AUSWÄHLEN);
	}

	public void setSize(int size) {
		// TODO: Setze neue Schriftgröße
	}

	// Ende Methoden
} // end of class RSViewer