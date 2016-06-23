package se;

import java.util.Date;

/**
 * Date class, that stores day, month and year.
 *
 * @version 1.6 vom 22.06.2016
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
	 */
	@SuppressWarnings("deprecation")
	public MyDate(int day, int month, int year) {
		super(year - 1900, month - 1, day);
		/*
		 * if ((this.getDate() == day) && (this.getMonth() == month - 1) &&
		 * (this.getYear() == year)) { throw new Exception("Invalid date"); }
		 */
	}

	/**
	 * Constructor for the current date
	 */
	@SuppressWarnings("deprecation")
	public MyDate() {
		super(new Date().getYear(), new Date().getMonth(), new Date().getDate());
	}

	/**
	 * TypeCast-Constructor
	 * 
	 * @param date
	 *            object of java.util.Date
	 * 
	 */
	@SuppressWarnings("deprecation")
	public MyDate(Date date) {
		this(date.getDate(), date.getMonth() + 1, date.getYear() + 1900);
	}

	public MyDate(long millisec) {
		super(millisec);
	}

	@SuppressWarnings("deprecation")
	public int getDate() {
		return super.getDate();
	}

	@SuppressWarnings("deprecation")
	public int getMonth() {
		return super.getMonth() + 1;
	}

	@SuppressWarnings("deprecation")
	public int getYear() {
		return super.getYear() + 1900;
	}

	public String toString() {
		return getYear() + "-" + getMonth() + "-" + getDate();
	}

	public String toFormatString() {
		return convert(getDate(), 2) + "." + convert(getMonth(), 2) + "." + convert(getYear(), 4);
	}

	private String convert(int number, int digit) {
		String buffer = String.valueOf(number);
		while (buffer.length() != digit)
			buffer = "0" + buffer;
		return buffer;
	}
}
