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

	private Person[] list;
	private int quantity;

	/**
	 * Constructor
	 * 
	 * @param list
	 *            array of person-objects
	 * @param quantity
	 *            amount of persons that are in the list
	 */
	public PersonList(Person[] list, int quantity) {
		this.list = list;
		this.quantity = quantity;
		for (int i = 0; i < list.length; i++) {
			list[i].setId(i);
		}
	}

	/**
	 * Constructor
	 * 
	 * @param list
	 *            array of person-objects
	 */
	public PersonList(Person[] list) {
		this(list, list.length);
	}

	/**
	 * Constructor for an empty personlist
	 */
	public PersonList() {
		this(null, 0);
	}

	/**
	 * 
	 * @return array of person-objects in the list
	 */
	public Person[] getList() {
		return list;
	}

	/**
	 * Sets the list to another list of person-object
	 * 
	 * @param list
	 *            array of person-objects
	 */
	public void setList(Person[] list) {
		this.list = list;
		this.quantity = list.length;
	}

	/**
	 * 
	 * @return amount of elements in the list
	 */
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 
	 * @param id
	 *            identification number of the person you are looking for
	 * @return object of the person you've looked for
	 */
	public Person getPerson(int id) {
		// TODO: search and return Person with id, if not found, return null
		return list[id];
	}

	/**
	 * 
	 * @param id
	 *            identification number of the person you are looking for
	 * @return array of strings with the information of the person you've looked
	 *         for
	 */
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

	/**
	 * Adds a person to the personlist
	 * 
	 * @param add
	 *            object of the person that shall be added
	 */
	public void addPerson(Person add) {
		// TODO: insert new Person into list
		Person[] plist = new Person[quantity + 1];
		for (int i = 0; i < quantity; i++) {
			plist[i] = list[i];
		}
		plist[quantity] = add;
		quantity++;
		list = plist;
	}

	/**
	 * 
	 * @param p
	 *            person you are looking for
	 * @return the information wether the person is on the personlist or not
	 */
	public boolean isPersonInList(Person p) {
		// TODO: Check if person is already in list
		return false;
	}

	/**
	 * update the ids of every father, mother and spouse for the persons in the
	 * personlist
	 */
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

	/**
	 * 
	 * @return array with all the names of male persons in the personlist
	 */
	public String[] getMales() {
		// TODO: return all males in list
		return null;
	}

	/**
	 * 
	 * @return array with all the names of female persons in the personlist
	 */
	public String[] getFemales() {
		// TODO: return all females in list
		return null;
	}

	/**
	 * 
	 * @return array of all the names of persons in the personlist that do not
	 *         have a information about their father nor mother
	 */
	public String[] getForefather() {
		// TODO: return all forefathers
		return null;
	}

	public String[] getStringList() {
		String[] stringlist = new String[quantity];
		for (int i = 0; i < quantity; i++) {
			stringlist[i] = i + ". " + list[i].getVorname() + " " + list[i].getNachname() + " ("
					+ list[i].getGeschlecht() + ")";
		}
		return stringlist;
	}

	/**
	 * resets the personlist to an empty personlist
	 */
	public void clear() {
		list = new Person[0];
		quantity = 0;
	}
}
