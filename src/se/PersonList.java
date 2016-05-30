package se;

import java.text.*;

/**
 * 
 * Beschreibung
 * 
 * @version 1.0 vom 24.03.2016
 * @author Sebastian Mischke
 */

public class PersonList {

	// Anfang Attribute
	private Person[] list;
	private int quantity;

	// Ende Attribute

	// Anfang Methoden
	public PersonList(Person[] list, int quantity) {
		this.list = list;
		this.quantity = quantity;
	}

	public PersonList(Person[] list) {
		this(list, list.length);
		for (int i = 0; i < list.length; i++) {
			list[i].setId(i);
		}
	}

	public PersonList() {
		this(null, 0);
	}

	public Person[] getList() {
		return list;
	}

	public void setList(Person[] list) {
		this.list = list;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Person getPerson(int id) {
		// TODO: search and return Person with id, if not found, return null
		return list[id];
		// return null;
	}

	public String[] getPersonInfo(int id) {
		String[] info = new String[6];
		info[0] = list[id].getNachname();
		info[1] = list[id].getVorname();
		if (list[id].getGebdat() != null) {
			DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
			info[2] = df.format(list[id].getGebdat());
		} else {
			info[2] = "";
		}
		if (list[id].getVater() != null) {
			info[3] = list[id].getVater().getName();
		} else {
			info[3] = "";
		}
		if (list[id].getMutter() != null) {
			info[4] = list[id].getMutter().getName();
		} else {
			info[4] = "";
		}
		if (list[id].getEhepartner() != null) {
			info[5] = list[id].getEhepartner().getName();
		} else {
			info[5] = "";
		}
		return info;
	}

	public boolean addPerson(Person add) {
		// TODO: insert new Person into list
		Person[] plist = new Person[quantity + 1];
		for (int i = 0; i < quantity; i++) {
			plist[i] = list[i];
		} // end of for
		plist[quantity] = add;
		quantity++;
		list = plist;
		return true;
	}

	public boolean isPersonInList(Person p) {
		// TODO: Check if person is already in list
		return false;
	}

	public void fillPersonInfo() {
		for (int i = 0; i < quantity; i++) {
			// Vater
			if (list[i].getVater() != null)
				list[i].setVaterid(list[i].getVater().getId());
			if (list[i].getVaterid() != -1)
				list[i].setVater(list[list[i].getVaterid()]);

			// Mutter
			if (list[i].getMutter() != null)
				list[i].setMutterid(list[i].getMutter().getId());
			if (list[i].getMutterid() != -1)
				list[i].setMutter(list[list[i].getMutterid()]);

			// Ehepartner
			if (list[i].getEhepartner() != null)
				list[i].setEhepartnerid(list[i].getEhepartner().getId());
			if (list[i].getEhepartnerid() != -1)
				list[i].setEhepartner(list[list[i].getEhepartnerid()]);
		}
	}

	public String[] getMales() {
		// TODO: return all males in list
		return null;
	}

	public String[] getFemales() {
		// TODO: return all females in list
		return null;
	}

	public String[] getForefather() {
		// TODO: return all forefathers
		return null;
	}

	public String[] getStringList() {
		String[] stringlist = new String[quantity];
		for (int i = 0; i < quantity; i++) {
			stringlist[i] = i + ". " + list[i].getVorname() + " "
					+ list[i].getNachname() + " (" + list[i].getGeschlecht()
					+ ")";
		} // end of for
		return stringlist;
	}

	public void clear() {
		list = new Person[0];
		quantity = 0;
	}
	// Ende Methoden
} // end of PersonList
