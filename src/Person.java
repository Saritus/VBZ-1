/**
 * Stores the information about a person
 *
 * @version 1.0 vom 28.01.2016
 * @author Sebastian Mischke
 */

public class Person {

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

	/**
	 * 
	 * @param id
	 *            identification number
	 * @param nachname
	 *            lastname
	 * @param vorname
	 *            surname
	 * @param geschlecht
	 *            gender
	 * @param gebdat
	 *            bithday
	 * @param vater
	 *            father
	 * @param vaterid
	 *            identification number of the father
	 * @param mutter
	 *            mother
	 * @param mutterid
	 *            identification number of the mother
	 * @param ehepartner
	 *            spouse
	 * @param ehepartnerid
	 *            identification number of the spouse
	 */
	public Person(int id, String nachname, String vorname, char geschlecht, MyDate gebdat, Person vater, int vaterid,
			Person mutter, int mutterid, Person ehepartner, int ehepartnerid) {
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

	/**
	 * 
	 * @param id
	 *            identification number
	 * @param nachname
	 *            lastname
	 * @param vorname
	 *            surname
	 * @param geschlecht
	 *            gender
	 * @param gebdat
	 *            bithday
	 * @param vaterid
	 *            identification number of the father
	 * @param mutterid
	 *            identification number of the mother
	 * @param ehepartnerid
	 *            identification number of the spouse
	 */
	public Person(int id, String nachname, String vorname, char geschlecht, MyDate gebdat, int vaterid, int mutterid,
			int ehepartnerid) {
		this(id, nachname, vorname, geschlecht, gebdat, null, vaterid, null, mutterid, null, ehepartnerid);
	}

	/**
	 * 
	 * @param id
	 *            identification number
	 * @param nachname
	 *            lastname
	 * @param vorname
	 *            surname
	 * @param geschlecht
	 *            gender
	 * @param gebdat
	 *            bithday
	 * @param vaterid
	 *            identification number of the father
	 * @param mutterid
	 *            identification number of the mother
	 */
	public Person(int id, String nachname, String vorname, char geschlecht, MyDate gebdat, int vaterid, int mutterid) {
		this(id, nachname, vorname, geschlecht, gebdat, null, vaterid, null, mutterid, null, -1);
	}

	/**
	 * 
	 * @param id
	 *            identification number
	 * @param nachname
	 *            lastname
	 * @param vorname
	 *            surname
	 * @param geschlecht
	 *            gender
	 * @param gebdat
	 *            bithday
	 */
	public Person(int id, String nachname, String vorname, char geschlecht, MyDate gebdat) {
		this(id, nachname, vorname, geschlecht, gebdat, null, -1, null, -1, null, -1);
	}

	/**
	 * 
	 * @param id
	 *            identification number
	 * @param nachname
	 *            lastname
	 * @param vorname
	 *            surname
	 * @param geschlecht
	 *            gender
	 */
	public Person(int id, String nachname, String vorname, char geschlecht) {
		this(id, nachname, vorname, geschlecht, null, null, -1, null, -1, null, -1);
	}

	/**
	 * 
	 * @param id
	 *            identification number
	 * @param nachname
	 *            lastname
	 * @param vorname
	 *            surname
	 */
	public Person(int id, String nachname, String vorname) {
		this(id, nachname, vorname, 'u', null, null, -1, null, -1, null, -1);
	}

	/**
	 * 
	 * @param nachname
	 *            lastname
	 * @param vorname
	 *            surname
	 * @param geschlecht
	 *            gender
	 * @param gebdat
	 *            bithday
	 * @param vaterid
	 *            identification number of the father
	 * @param mutterid
	 *            identification number of the mother
	 * @param ehepartnerid
	 *            identification number of the spouse
	 */
	public Person(String nachname, String vorname, char geschlecht, MyDate gebdat, int vaterid, int mutterid,
			int ehepartnerid) {
		this(-1, nachname, vorname, geschlecht, gebdat, null, vaterid, null, mutterid, null, ehepartnerid);
	}

	/**
	 * 
	 * @param nachname
	 *            lastname
	 * @param vorname
	 *            surname
	 * @param geschlecht
	 *            gender
	 * @param gebdat
	 *            bithday
	 * @param vaterid
	 *            identification number of the father
	 * @param mutterid
	 *            identification number of the mother
	 */
	public Person(String nachname, String vorname, char geschlecht, MyDate gebdat, int vaterid, int mutterid) {
		this(-1, nachname, vorname, geschlecht, gebdat, null, vaterid, null, mutterid, null, -1);
	}

	/**
	 * 
	 * @param nachname
	 *            lastname
	 * @param vorname
	 *            surname
	 * @param geschlecht
	 *            gender
	 * @param gebdat
	 *            bithday
	 */
	public Person(String nachname, String vorname, char geschlecht, MyDate gebdat) {
		this(-1, nachname, vorname, geschlecht, gebdat, null, -1, null, -1, null, -1);
	}

	/**
	 * 
	 * @param nachname
	 *            lastname
	 * @param vorname
	 *            surname
	 * @param geschlecht
	 *            gender
	 */
	public Person(String nachname, String vorname, char geschlecht) {
		this(-1, nachname, vorname, geschlecht, null, null, -1, null, -1, null, -1);
	}

	/**
	 * 
	 * @param nachname
	 *            lastname
	 * @param vorname
	 *            surname
	 */
	public Person(String nachname, String vorname) {
		this(-1, nachname, vorname, 'u', null, null, -1, null, -1, null, -1);
	}

	/**
	 * Formated output of a persons name
	 * 
	 * @return surname and lastname
	 */
	public String getName() {
		return vorname + " " + nachname;
	}

	/**
	 * 
	 * @return lastname
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * Sets the lastname
	 * 
	 * @param nachname
	 *            lastname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * 
	 * @return surname
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * Sets the surname
	 * 
	 * @param vorname
	 *            surname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * Returns birthday as MyDate
	 * 
	 * @return birthday
	 */
	public MyDate getGebdat() {
		return gebdat;
	}

	/**
	 * Returns birthday as String
	 * 
	 * @return birthday
	 */
	public String getGebdatString() {
		if (gebdat == null) {
			return "null";
		}
		return "\'" + this.gebdat.toString() + "\'";
	}

	/**
	 * Sets the birthday
	 * 
	 * @param gebdat
	 *            birthday
	 */
	public void setGebdat(MyDate gebdat) {
		this.gebdat = gebdat;
	}

	/**
	 * 
	 * @return identification number
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            identification number
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return father
	 */
	public Person getVater() {
		return vater;
	}

	/**
	 * Sets the father
	 * 
	 * @param vater
	 *            father
	 */
	public void setVater(Person vater) {
		this.vater = vater;
	}

	/**
	 * 
	 * @return mother
	 */
	public Person getMutter() {
		return mutter;
	}

	/**
	 * Sets the mother
	 * 
	 * @param mutter
	 *            mother
	 */
	public void setMutter(Person mutter) {
		this.mutter = mutter;
	}

	/**
	 * 
	 * @return spouse
	 */
	public Person getEhepartner() {
		return ehepartner;
	}

	/**
	 * Sets the spouse
	 * 
	 * @param ehepartner
	 *            spouse
	 */
	public void setEhepartner(Person ehepartner) {
		this.ehepartner = ehepartner;
	}

	/**
	 * 
	 * @return age of the person
	 */
	public int getAlter() {
		// TODO: Calculate age
		return 18;
	}

	/**
	 * 
	 * @return identification number of the father
	 */
	public int getVaterid() {
		return vaterid;
	}

	/**
	 * Sets the ID of the father
	 * 
	 * @param vaterid
	 *            identification number of the father
	 */
	public void setVaterid(int vaterid) {
		this.vaterid = vaterid;
	}

	/**
	 * 
	 * @return identification number of the mother
	 */
	public int getMutterid() {
		return mutterid;
	}

	/**
	 * Sets the ID of the mother
	 * 
	 * @param mutterid
	 *            identification number of the mother
	 */
	public void setMutterid(int mutterid) {
		this.mutterid = mutterid;
	}

	/**
	 * 
	 * @return identification number of the spouse
	 */
	public int getEhepartnerid() {
		return ehepartnerid;
	}

	/**
	 * Sets the ID of the spouse
	 * 
	 * @param ehepartnerid
	 *            identification number of the spouse
	 */
	public void setEhepartnerid(int ehepartnerid) {
		this.ehepartnerid = ehepartnerid;
	}

	/**
	 * 
	 * @return gender
	 */
	public char getGeschlecht() {
		return geschlecht;
	}

	/**
	 * 
	 * @param geschlecht
	 *            gender
	 */
	public void setGeschlecht(char geschlecht) {
		this.geschlecht = geschlecht;
	}

	/**
	 * The tree section is the unique formated id of a person
	 * 
	 * @return tree section
	 */
	public String getAhnenziffer() {
		// TODO: return tree section
		return "";
	}

	/**
	 * update the stored ids of father, mother and spouse
	 */
	public void updateIDs() {
		if (vater != null) {
			vaterid = vater.id;
		}
		if (mutter != null) {
			mutterid = mutter.id;
		}
		if (ehepartner != null) {
			ehepartnerid = ehepartner.id;
		}
	}

}
