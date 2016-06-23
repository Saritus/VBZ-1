package se;

import java.util.Date;

/**
 * Date class, that stores day, month and year.
 *
 * @version 1.0 vom 28.01.2016
 * @author Sebastian Mischke
 */

public class MyDate extends Date {

	/**
	 * Constructor
	 * 
	 * @param day
	 *            day of the date
	 * @param month
	 *            month of the date
	 * @param year
	 *            year of the date
	 * @throws Exception
	 */
	public MyDate(int day, int month, int year) throws Exception {
		super(year - 1900, month - 1, day);
		if ((this.getDate() == day) && (this.getMonth() == month - 1) && (this.getYear() == year)) {
			throw new Exception("Invalid date");
		}
	}

	/**
	 * Constructor for the current date
	 */
	public MyDate() {
		super(new Date().getYear(), new Date().getMonth(), new Date().getDate());
	}

	/**
	 * TypeCast-Constructor
	 * 
	 * @param an
	 *            object of java.sql.Date
	 * @throws Exception
	 */
	public MyDate(Date date) throws Exception {
		this(date.getYear() + 1900, date.getMonth(), date.getDate());
	}

	public MyDate(long millisec) {
		super(millisec);
	}

	public int getMonth() {
		return super.getMonth() + 1;
	}

	public String toString() {
		return getYear() + "-" + getMonth() + "-" + getDate();
	}
}
