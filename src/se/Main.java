package se;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 28.01.2016
 * @author Sebastian Mischke
 */

public class Main extends JPanel {

	public Database database;
	public PersonList personlist;

	public PersonEditor personeditor;
	public RSViewer rsviewer;
	public PersonTable persontable;
	public Settings settings;
	public SQL sql;
	public JComponent help;

	public Language lang;

	public Main() {
		super(new GridLayout(1, 1));

		JTabbedPane tabbedPane = new JTabbedPane();

		personlist = new PersonList();
		database = new Database();

		settings = new Settings(this);
		tabbedPane.addTab("", createImageIcon("../icons/opt.gif"), settings);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		rsviewer = new RSViewer(personlist);
		tabbedPane.addTab("", createImageIcon("../icons/rsv.gif"), rsviewer);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		personeditor = new PersonEditor(personlist, this);
		tabbedPane.addTab("", createImageIcon("../icons/pe.gif"), personeditor);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		persontable = new PersonTable(personlist);
		tabbedPane.addTab("", createImageIcon("../icons/pt.gif"), persontable);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		sql = new SQL(personlist, database, this);
		tabbedPane.addTab("", createImageIcon("../icons/sql.gif"), sql);
		tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);

		sql.setPreferredSize(new Dimension(783, 490));

		add(tabbedPane);

		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
	}

	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = Main.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("VBZ-Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Main(), BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - frame.getSize().width) / 2;
		int y = (d.height - frame.getSize().height) / 2;
		frame.setLocation(x, y);
	}

	public static PersonList createExamplePersonList() {
		Person eins = new Person("Meier", "Hans", 'm', new MyDate(9, 11, 1995));
		Person zwei = new Person("M�ller", "Lisa", 'w', new MyDate(1, 11, 1991));
		Person drei = new Person("Test", "Der", 'm', new MyDate(16, 11, 1992));
		zwei.setEhepartner(eins);
		drei.setVater(eins);
		Person al = new Person("Lindgren", "Astrid", 'w');
		Person ws = new Person("Shakespeare", "William", 'm');
		Person jg = new Person("Goethe", "Johann", 'm');
		Person ja = new Person("Austen", "Jane", 'w');
		Person jt = new Person("Tolkien", "John", 'm', new MyDate());
		Person fk = new Person("Kafka", "Franz", 'm');
		Person cd = new Person("Dickens", "Charles", 'm');
		Person ek = new Person("K�stner", "Erich", 'm');
		Person hh = new Person("Hesse", "Hermann", 'm');
		Person fs = new Person("Schiller", "Friedrich", 'm');
		Person ow = new Person("Wilde", "Oscar", 'm');
		Person[] parray = { eins, zwei, drei, al, ws, jg, ja, jt, fk, cd, ek, hh, fs, ow };
		PersonList plist = new PersonList(parray);
		return plist;
	}

	public void setLang(Language l) {
		lang = l;
		rsviewer.setLang(l);
		sql.setLang(l);
		personeditor.setLang(l);
		persontable.setLang(l);
	}

	public void setSize(int size) {
		rsviewer.setSize(size);
		sql.setSize(size);
		personeditor.setSize(size);
		persontable.setSize(size);
	}

	public void updatePanels() {
		// TODO: update aller panels
		personeditor.updateList();
		rsviewer.updateList();
		persontable.updateTable();
	}

}