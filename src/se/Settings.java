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

public class Settings extends JPanel {
	// Anfang Attribute
	private JRadioButton deutschrb = new JRadioButton();
	private JRadioButton englishrb = new JRadioButton();
	private ButtonGroup buttonGroup1 = new ButtonGroup();
	private JSlider jSlider1 = new JSlider();
	private JLabel textsizelabel = new JLabel();
	private JLabel languagelabel = new JLabel();
	public Main mainw;
	private JButton acceptbutton = new JButton();

	// Ende Attribute

	public Settings() {
		this(new Main());
	}

	public Settings(Main m) {
		// Frame-Initialisierung
		super();
		Container cp = this;
		cp.setLayout(null);
		mainw = m;
		// Anfang Komponenten
		deutschrb.setBounds(346, 120, 100, 25);
		deutschrb.setText("Deutsch");
		deutschrb.setOpaque(false);
		cp.add(deutschrb);
		englishrb.setBounds(346, 150, 100, 25);
		englishrb.setText("English");
		englishrb.setOpaque(false);
		buttonGroup1.add(deutschrb);
		buttonGroup1.add(englishrb);
		deutschrb.setSelected(true);
		cp.add(englishrb);
		jSlider1.setBounds(253, 232, 300, 50);
		jSlider1.setMinorTickSpacing(1);
		jSlider1.setMajorTickSpacing(1);
		jSlider1.setPaintTicks(true);
		jSlider1.setPaintLabels(true);
		jSlider1.setSnapToTicks(true);
		jSlider1.setMaximum(3);
		jSlider1.setMinimum(1);
		cp.add(jSlider1);
		textsizelabel.setBounds(253, 208, 300, 25);
		textsizelabel.setText("Textgröße");
		textsizelabel.setHorizontalAlignment(SwingConstants.CENTER);
		textsizelabel.setHorizontalTextPosition(SwingConstants.CENTER);
		cp.add(textsizelabel);
		languagelabel.setBounds(346, 90, 150, 25);
		languagelabel.setText("Sprache:");
		cp.add(languagelabel);
		acceptbutton.setBounds(328, 368, 129, 33);
		acceptbutton.setText("Übernehmen");
		acceptbutton.setMargin(new Insets(2, 2, 2, 2));
		acceptbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1_ActionPerformed(evt);
			}
		});
		cp.add(acceptbutton);
		// Ende Komponenten

		setVisible(true);
	} // end of public Settings

	// Anfang Methoden
	public String buttonGroup1_getSelectedRadioButtonLabel() {
		for (java.util.Enumeration<AbstractButton> e = buttonGroup1
				.getElements(); e.hasMoreElements();) {
			AbstractButton b = e.nextElement();
			if (b.isSelected())
				return b.getText();
		}
		return "";
	}

	public void setLang(String lang) {
		Language l;
		switch (lang) {
		case "Deutsch":
			l = new LanguageDE();
			break;
		case "English":
			l = new LanguageEN();
			break;
		default:
			l = new LanguageEN();
			break;
		}
		textsizelabel.setText(l.TEXTGRÖSSE);
		languagelabel.setText(l.SPRACHE);
		acceptbutton.setText(l.ÜBERNEHMEN);
		mainw.setLang(l);
	}

	public void setSize(int size) {
		mainw.setSize(size);
	}

	public void jButton1_ActionPerformed(ActionEvent evt) {
		String selectedButton = buttonGroup1_getSelectedRadioButtonLabel();
		setLang(selectedButton);
	} // end of jButton1_ActionPerformed

	// Ende Methoden
} // end of class Settings
