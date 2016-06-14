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
	private JRadioButton deutschrb = new JRadioButton();
	private JRadioButton englishrb = new JRadioButton();
	private ButtonGroup buttonGroup1 = new ButtonGroup();
	private JSlider jSlider1 = new JSlider();
	private JLabel textsizelabel = new JLabel();
	private JLabel languagelabel = new JLabel();
	public Main mainw;
	private JButton acceptbutton = new JButton();

	/**
	 * 
	 * @param m
	 *            main window of the program
	 */
	public Settings(Main m) {
		super();
		Container cp = this;
		cp.setLayout(null);
		mainw = m;

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
		jSlider1.setBounds(253, 232, 300, 60);
		jSlider1.setMinorTickSpacing(1);
		jSlider1.setMajorTickSpacing(1);
		jSlider1.setPaintTicks(true);
		jSlider1.setPaintLabels(true);
		jSlider1.setSnapToTicks(true);
		jSlider1.setMaximum(3);
		jSlider1.setMinimum(1);
		jSlider1.setValue(1);
		cp.add(jSlider1);
		textsizelabel.setBounds(253, 208, 300, 25);
		textsizelabel.setText("Textgröße");
		textsizelabel.setHorizontalAlignment(SwingConstants.CENTER);
		textsizelabel.setHorizontalTextPosition(SwingConstants.CENTER);
		cp.add(textsizelabel);
		languagelabel.setBounds(346, 90, 150, 25);
		languagelabel.setText("Sprache");
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

		setVisible(true);
	}

	/**
	 * 
	 * @return text of the selected radio button
	 */
	public String buttonGroup1_getSelectedRadioButtonLabel() {
		for (java.util.Enumeration<AbstractButton> e = buttonGroup1.getElements(); e.hasMoreElements();) {
			AbstractButton b = e.nextElement();
			if (b.isSelected())
				return b.getText();
		}
		return "";
	}

	/**
	 * Sets the language for all panles
	 * 
	 * @param lang
	 *            object with language information
	 */
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

	/**
	 * Sets the font of all buttons and labels of all panels
	 * 
	 * @param size
	 *            font size
	 */
	public void setSize(int size) {
		acceptbutton.setFont(new Font("Dialog", Font.BOLD, size));
		textsizelabel.setFont(new Font("Dialog", Font.BOLD, size));
		languagelabel.setFont(new Font("Dialog", Font.BOLD, size));
		deutschrb.setFont(new Font("Dialog", Font.BOLD, size));
		englishrb.setFont(new Font("Dialog", Font.BOLD, size));
		jSlider1.setFont(new Font("Dialog", Font.BOLD, size));
		mainw.setSize(size);
	}

	private void jButton1_ActionPerformed(ActionEvent evt) {
		String selectedButton = buttonGroup1_getSelectedRadioButtonLabel();
		setLang(selectedButton);
		int selectedSize = jSlider1.getValue();
		setSize(9 + 3 * selectedSize);
	}
}
