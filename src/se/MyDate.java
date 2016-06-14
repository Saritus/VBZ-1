package se;

import java.sql.Date;

/**
*
* Beschreibung
*
* @version 1.0 vom 28.01.2016
* @author Sebastian Mischke
*/

public class MyDate extends Date {
	MyDate(int day, int month, int year) {
		super(day, month, year - 1900);
	}

	MyDate() {
		this(1, 1, 0);
	}

	MyDate(Date date) {
		this(date.getDate(), date.getMonth(), date.getYear());
	}
}
