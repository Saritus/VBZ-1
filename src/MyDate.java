import java.sql.Date;

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
	 */
	MyDate(int day, int month, int year) {
		super(day, month, year - 1900);
	}

	/**
	 * Constructor for an empty date (01.01.0001)
	 */
	MyDate() {
		this(1, 1, 0);
	}

	/**
	 * TypeCast-Constructor
	 * 
	 * @param an
	 *            object of java.sql.Date
	 */
	MyDate(Date date) {
		this(date.getDate(), date.getMonth(), date.getYear());
	}
}
