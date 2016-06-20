import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.awt.print.*;

/**
 * Shows all stored information about the persons in a table
 * 
 * @version 1.0 vom 28.01.2016
 * @author Sebastian Mischke
 */

public class PersonTable extends JPanel {
	private JTable jTable1 = new JTable(30, 6);
	private DefaultTableModel jTable1Model = (DefaultTableModel) jTable1.getModel();
	private JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
	private JButton savebutton = new JButton();
	private JButton printbutton = new JButton();
	public PersonList personlist;

	/**
	 * Constructor for a new PersonTable panel
	 * 
	 * @param pl
	 *            list with information about persons
	 */
	public PersonTable(PersonList pl) {
		super();
		Container cp = this;
		cp.setLayout(null);
		personlist = pl;

		jTable1ScrollPane.setBounds(13, 13, 768, 435);
		jTable1.setDragEnabled(false);
		jTable1.setRowSelectionAllowed(false);
		jTable1.getColumnModel().getColumn(0).setHeaderValue("Nachname");
		jTable1.getColumnModel().getColumn(1).setHeaderValue("Vorname");
		jTable1.getColumnModel().getColumn(2).setHeaderValue("Geburtsdatum");
		jTable1.getColumnModel().getColumn(3).setHeaderValue("Vater");
		jTable1.getColumnModel().getColumn(4).setHeaderValue("Mutter");
		jTable1.getColumnModel().getColumn(5).setHeaderValue("Ehepartner");
		jTable1Model.setRowCount(0);
		cp.add(jTable1ScrollPane);
		savebutton.setBounds(13, 458, 160, 25);
		savebutton.setText("Speichern");
		savebutton.setMargin(new Insets(2, 2, 2, 2));
		savebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1_ActionPerformed(evt);
			}
		});
		cp.add(savebutton);
		printbutton.setBounds(186, 458, 160, 25);
		printbutton.setText("Drucken");
		printbutton.setMargin(new Insets(2, 2, 2, 2));
		printbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton2_ActionPerformed(evt);
			}
		});
		cp.add(printbutton);

		updateTable();
		setVisible(true);
	}

	private void jButton1_ActionPerformed(ActionEvent evt) {
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fileChooser.getSelectedFile();
				PrintWriter os = new PrintWriter(file);
				for (int col = 0; col < jTable1.getColumnCount(); col++) {
					os.format("%-20s", jTable1.getColumnModel().getColumn(col).getHeaderValue());
				}

				os.println("");
				os.println("");

				for (int i = 0; i < jTable1.getRowCount(); i++) {
					for (int j = 0; j < jTable1.getColumnCount(); j++) {
						os.format("%-20s", jTable1.getValueAt(i, j).toString());

					}
					os.println("");
				}
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void jButton2_ActionPerformed(ActionEvent evt) {

		//PrinterJob pj = PrinterJob.getPrinterJob();
		//PageFormat pf = pj.pageDialog(pj.defaultPage());
		try {
			jTable1.print();
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update the table with the new correct informations from the personlist
	 */
	public void updateTable() {
		for (int i = jTable1Model.getRowCount() - 1; i >= 0; i--) {
			jTable1Model.removeRow(i);
		}
		for (int i = 0; i < personlist.getQuantity(); i++) {
			jTable1Model.addRow(personlist.getPersonInfo(i));
		}
	}

	/**
	 * Changes the language of the text on the buttons and the headers of the
	 * table
	 * 
	 * @param l
	 *            object with language information
	 */
	public void setLang(Language l) {
		savebutton.setText(l.SPEICHERN);
		printbutton.setText(l.DRUCKEN);
		jTable1.getColumnModel().getColumn(0).setHeaderValue(l.NACHNAME);
		jTable1.getColumnModel().getColumn(1).setHeaderValue(l.VORNAME);
		jTable1.getColumnModel().getColumn(2).setHeaderValue(l.GEBURTSDATUM);
		jTable1.getColumnModel().getColumn(3).setHeaderValue(l.VATER);
		jTable1.getColumnModel().getColumn(4).setHeaderValue(l.MUTTER);
		jTable1.getColumnModel().getColumn(5).setHeaderValue(l.EHEPARTNER);
	}

	/**
	 * Changes the size of the text on the buttons and the table
	 * 
	 * @param size
	 *            value of the size for the text
	 */
	public void setSize(int size) {
		savebutton.setFont(new Font("Dialog", Font.BOLD, size));
		printbutton.setFont(new Font("Dialog", Font.BOLD, size));
		jTable1.setFont(new Font("Dialog", Font.PLAIN, size));
		jTable1.getTableHeader().setFont(new Font("Dialog", Font.PLAIN, size));
	}
}