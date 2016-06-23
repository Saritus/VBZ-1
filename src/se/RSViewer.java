package se;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/**
 * Shows the relationship between persons in an image
 * 
 * @version 1.6 vom 22.06.2016
 * @author Sebastian Mischke
 */

public class RSViewer extends JPanel {
	public MyCanvas canvas;
	private JList<String> jList1 = new JList<String>();
	private DefaultListModel<String> jList1Model = new DefaultListModel<String>();
	private JScrollPane jList1ScrollPane = new JScrollPane(jList1);
	private JButton savebutton = new JButton();
	private JButton selectbutton = new JButton();
	public PersonList personlist;
	private Person selected;

	/**
	 * Constructor for a new RSViewer panel
	 * 
	 * @param pl
	 *            list with information of persons
	 */
	public RSViewer(PersonList pl) {
		super();
		Container cp = this;
		cp.setLayout(null);
		personlist = pl;

		canvas = new MyCanvas(personlist);
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

		updateList();
		setVisible(true);
	}

	private void saveicon_ActionPerformed(ActionEvent evt) {
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			canvas.save(file);
		}
	}

	private void selectbutton_ActionPerformed(ActionEvent evt) {
		if (jList1.getSelectedIndex() != -1) {
			System.out.println(jList1.getSelectedIndex());
			selected = personlist.getList()[jList1.getSelectedIndex()];
			System.out.println(selected.getName());
			canvas.id = jList1.getSelectedIndex();
			canvas.repaint();
		}
	}

	/**
	 * Update the lists with the new correct informations from the personlist
	 */
	public void updateList() {
		jList1Model.clear();
		String[] infos = personlist.getStringList();
		for (int i = 0; i < personlist.getQuantity(); i++) {
			jList1Model.addElement(infos[i]);
		}
	}

	/**
	 * Changes the language of the text on the buttons
	 * 
	 * @param l
	 *            object with language information
	 */
	public void setLang(Language l) {
		savebutton.setText(l.SPEICHERN);
		selectbutton.setText(l.AUSWÄHLEN);
	}

	/**
	 * Changes the size of the text on the buttons and the list
	 * 
	 * @param size
	 *            value of the size for the text
	 */
	public void setSize(int size) {
		savebutton.setFont(new Font("Dialog", Font.BOLD, size));
		selectbutton.setFont(new Font("Dialog", Font.BOLD, size));
		jList1.setFont(new Font("Dialog", Font.BOLD, size));
	}
}