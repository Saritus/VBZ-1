package se;

import java.sql.*;

import javax.swing.DefaultListModel;
import javax.swing.JProgressBar;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 28.01.2016
 * @author Sebastian Mischke
 */

public class Database {

	private final String hostname = "sql7.freemysqlhosting.net";
	private final String port = "3306";
	private final String dbname = "sql7114952";
	private final String user = "sql7114952";
	private final String password = "BXxdcZ875Y";

	private String url;
	private Connection conn = null;
	private Statement stmt;

	/**
	 * Creates a new connection between the program and a mysql server
	 */
	Database() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.err.println("Unable to load driver.");
			e.printStackTrace();
		}
		url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname;
	}

	/**
	 * 
	 * @param table
	 *            name of the table where the information shall be stored
	 * @param pl
	 *            list with information of the persons that shall be stored
	 */
	public void save(String table, PersonList pl) {
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();

			try {
				stmt.execute("DROP TABLE " + table + ";");
			} catch (Exception e) {
			}
			stmt.execute("CREATE TABLE " + table + " (id INT PRIMARY KEY," + "firstname VARCHAR(30) NOT NULL,"
					+ "lastname VARCHAR(30) NOT NULL," + "gender VARCHAR(10)," + "birthday DATE," + "fatherid INT,"
					+ "motherid INT," + "spouseid INT);");
			for (int i = 0; i < pl.getQuantity(); i++) {
				Person p = pl.getPerson(i);
				String insertstatement = "INSERT INTO " + table + " VALUES (" + p.getId() + ", \"" + p.getVorname()
						+ "\", \"" + p.getNachname() + "\", \'" + p.getGeschlecht() + "\', " + p.getGebdatString()
						+ ", " + p.getVaterid() + ", " + p.getMutterid() + ", " + p.getEhepartnerid() + ");";
				stmt.execute(insertstatement);
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param table
	 *            name of the table where the information are stored
	 * @param pl
	 *            a list where the loaded information shall be stored
	 */
	public void load(String table, PersonList pl) {
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(
					"SELECT id, firstname, lastname, gender, birthday, fatherid, motherid, spouseid FROM " + table);
			while (rs.next()) {
				int id = rs.getInt(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				char gender = rs.getString(4).charAt(0);
				MyDate birthday = rs.getDate(5) == null ? null : new MyDate(rs.getDate(5));
				int fatherid = rs.getInt(6);
				int motherid = rs.getInt(7);
				int spouseid = rs.getInt(8);

				Person p = new Person(id, lastname, firstname, gender, birthday, fatherid, motherid, spouseid);
				pl.addPerson(p);
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param table
	 *            name of the table that shall be deleted
	 */
	public void delete(String table) {
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			stmt.execute("DROP TABLE " + table);
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param jList1Model
	 *            a listmodel where the loaded tablenames shall be stored
	 */
	public void getTables(DefaultListModel jList1Model) {
		try {
			conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();

			jList1Model.clear();
			ResultSet rs = stmt.executeQuery("SHOW TABLES");
			while (rs.next()) {
				String table = rs.getString(1);
				jList1Model.addElement(table);
			}

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
