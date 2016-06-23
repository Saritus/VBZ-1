package se;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

/**
 * Canvas object for the display of persons, their parents and their children
 *
 * @version 1.0 vom 28.01.2016
 * @author Sebastian Mischke
 */
class MyCanvas extends Canvas {

	public PersonList personlist;
	public int id = -1;

	/**
	 * Constructor
	 */
	public MyCanvas(PersonList pl) {
		super();
		personlist = pl;
	}

	/**
	 * 
	 */
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		if (id != -1) {
			// Vertikal height:434
			// Horizontal width:521
			g.setColor(Color.BLACK);
			g.setFont(new Font("Times New Roman", 1, 17));
			// Main
			drawPerson(g, personlist.getPerson(id).getVorname(), personlist.getPerson(id).getNachname(), 200, 185);
			// Father
			if (personlist.getPerson(id).getVater() != null) {
				drawPerson(g, personlist.getPerson(id).getVater().getVorname(),
						personlist.getPerson(id).getVater().getNachname(), 13, 13);
			}
			// Mother
			if (personlist.getPerson(id).getMutter() != null) {
				drawPerson(g, personlist.getPerson(id).getMutter().getVorname(),
						personlist.getPerson(id).getMutter().getNachname(), 388, 13);
			}

			int index = 0;
			for (Person p : personlist.getChildren(id).getList()) {
				System.out.println(p.getNachname());
				drawPerson(g, p.getVorname(), p.getNachname(), 133 * index + 13, 358);
				index++;
			}
			// Connections
			// g.drawLine(260, (217 - y / 2) - (13 + y / 2), 260, 279 - (int)
			// 1.5 * y);
			// g.drawLine(13 + x / 2, (217 - y / 2) - (13 + y), (508 - x / 2),
			// (217 - y / 2) - (13 + y));
		}
	}

	private void drawPerson(Graphics g, String vorname, String nachname, int x, int y) {
		g.drawRect(x, y, 120, 63);
		g.drawString(vorname, x + 13, y + 23);
		g.drawString(nachname, x + 13, y + 43);
	}

	/**
	 * 
	 * @param file
	 *            file to save the image
	 */
	public void save(File file) {
		BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		paint(g2);
		try {
			ImageIO.write(image, "png", file);
		} catch (Exception e) {
		}
	}

}