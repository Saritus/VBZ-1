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

	/**
	 * Constructor
	 */
	public MyCanvas() {
		super();
	}

	/**
	 * 
	 */
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.YELLOW);
		g.drawLine(260, 0, 260, 434); // Vertikal
		g.drawLine(0, 217, 521, 217); // Horizontal
		g.setColor(Color.BLACK);
		g.setFont(new Font("Times New Roman", 1, 17));
		int x = 120, y = 63;
		// Main
		g.drawRect(260 - x / 2, 217 - y / 2, x, y); // Main
		g.drawString("Vorname", 273 - x / 2, 243 - y / 2);
		g.drawString("Nachname", 273 - x / 2, 263 - y / 2);
		// Father
		g.drawRect(13, 13, x, y);
		g.drawString("Vorname", 26, 39);
		g.drawString("Nachname", 26, 59);
		// Mother
		g.drawRect(508 - x, 13, x, y);
		g.drawString("Vorname", 521 - x, 39);
		g.drawString("Nachname", 521 - x, 59);
		// Connections
		g.drawLine(260, (217 - y / 2) - (13 + y / 2), 260, 279 - (int) 1.5 * y);
		g.drawLine(13 + x / 2, (217 - y / 2) - (13 + y), (508 - x / 2), (217 - y / 2) - (13 + y));
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