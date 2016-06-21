package test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import se.MyDate;

public class testMyDate {
	@Test
	public void testKonstruktor() throws Exception {
		MyDate dmy = new MyDate(20, 12, 2016);
		Assert.assertEquals(20, dmy.getDate());
		Assert.assertEquals(12, dmy.getMonth());
		Assert.assertEquals(2016, dmy.getYear());

		MyDate now = new MyDate();
		Assert.assertEquals(21, now.getDate());
		Assert.assertEquals(6, now.getMonth());
		Assert.assertEquals(2016, now.getYear());
	}
}
