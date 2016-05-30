package se;

/*
 *
 * Beschreibung
 *
 * @version 1.0 vom 24.03.2016
 * @author Sebastian Mischke
 */

import java.util.*;

public class Person {

	// Anfang Attribute
	private int id;
	private String nachname;
	private String vorname;
	private char geschlecht;
	private MyDate gebdat;
	private Person vater;
	private int vaterid;
	private Person mutter;
	private int mutterid;
	private Person ehepartner;
	private int ehepartnerid;

	// Ende Attribute

	public Person(int id, String nachname, String vorname, char geschlecht,
			MyDate gebdat, Person vater, int vaterid, Person mutter,
			int mutterid, Person ehepartner, int ehepartnerid) {
		this.id = id;
		this.nachname = nachname;
		this.vorname = vorname;
		this.geschlecht = geschlecht;
		this.gebdat = gebdat;
		this.vater = vater;
		this.vaterid = vaterid;
		this.mutter = mutter;
		this.mutterid = mutterid;
		this.ehepartner = ehepartner;
		this.ehepartnerid = ehepartnerid;
	}

	public Person(int id, String nachname, String vorname, char geschlecht,
			MyDate gebdat, int vaterid, int mutterid, int ehepartnerid) {
		this(id, nachname, vorname, geschlecht, gebdat, null, vaterid, null,
				mutterid, null, ehepartnerid);
	}

	public Person(int id, String nachname, String vorname, char geschlecht,
			MyDate gebdat, int vaterid, int mutterid) {
		this(id, nachname, vorname, geschlecht, gebdat, null, vaterid, null,
				mutterid, null, -1);
	}

	public Person(int id, String nachname, String vorname, char geschlecht,
			MyDate gebdat) {
		this(id, nachname, vorname, geschlecht, gebdat, null, -1, null, -1,
				null, -1);
	}

	public Person(int id, String nachname, String vorname, char geschlecht) {
		this(id, nachname, vorname, geschlecht, null, null, -1, null, -1, null,
				-1);
	}

	public Person(int id, String nachname, String vorname) {
		this(id, nachname, vorname, 'u', null, null, -1, null, -1, null, -1);
	}

	public Person(String nachname, String vorname, char geschlecht,
			MyDate gebdat, int vaterid, int mutterid, int ehepartnerid) {
		this(-1, nachname, vorname, geschlecht, gebdat, null, vaterid, null,
				mutterid, null, ehepartnerid);
	}

	public Person(String nachname, String vorname, char geschlecht,
			MyDate gebdat, int vaterid, int mutterid) {
		this(-1, nachname, vorname, geschlecht, gebdat, null, vaterid, null,
				mutterid, null, -1);
	}

	public Person(String nachname, String vorname, char geschlecht,
			MyDate gebdat) {
		this(-1, nachname, vorname, geschlecht, gebdat, null, -1, null, -1,
				null, -1);
	}

	public Person(String nachname, String vorname, char geschlecht) {
		this(-1, nachname, vorname, geschlecht, null, null, -1, null, -1, null,
				-1);
	}

	public Person(String nachname, String vorname) {
		this(-1, nachname, vorname, 'u', null, null, -1, null, -1, null, -1);
	}

	// Anfang Methoden
	public String getName() {
		return vorname + " " + nachname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public MyDate getGebdat() {
		return gebdat;
	}
	
	public String getGebdatString() {
		if(gebdat==null) {
			return "null";
		}
		return "\'" + this.gebdat.toString() + "\'";
	}

	public void setGebdat(MyDate gebdat) {
		this.gebdat = gebdat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getVater() {
		return vater;
	}

	public void setVater(Person vater) {
		this.vater = vater;
	}

	public Person getMutter() {
		return mutter;
	}

	public void setMutter(Person mutter) {
		this.mutter = mutter;
	}

	public Person getEhepartner() {
		return ehepartner;
	}

	public void setEhepartner(Person ehepartner) {
		this.ehepartner = ehepartner;
	}

	public int getAlter() {
		// TODO: Calculate age
		return 18;
	}

	public int getVaterid() {
		return vaterid;
	}

	public void setVaterid(int vaterid) {
		this.vaterid = vaterid;
	}

	public int getMutterid() {
		return mutterid;
	}

	public void setMutterid(int mutterid) {
		this.mutterid = mutterid;
	}

	public int getEhepartnerid() {
		return ehepartnerid;
	}

	public void setEhepartnerid(int ehepartnerid) {
		this.ehepartnerid = ehepartnerid;
	}

	public char getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(char geschlecht) {
		this.geschlecht = geschlecht;
	}

	public String getAhnenziffer() {
		// TODO: return tree section
		return "";
	}

	public void updateIDs() {
		if (vater != null) {
			vaterid = vater.id;
		} // end of if
		if (mutter != null) {
			mutterid = mutter.id;
		} // end of if
		if (ehepartner != null) {
			ehepartnerid = ehepartner.id;
		} // end of if
	}

	// Ende Methoden
} // end of Person
