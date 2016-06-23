package test;

import org.junit.*;
import se.*;

public class testPerson {
	@Test
	public void testKonstruktor() {
		Person p = new Person("nachname", "vorname");
		Assert.assertEquals(p.getNachname(), "nachname");
		Assert.assertEquals(p.getVorname(), "vorname");
	}

	@Test
	public void testGetter() throws Exception {
		Person p = new Person("nachname", "vorname", 'm', new MyDate(9, 11, 1995));
		Assert.assertEquals(20, p.getAlter());
		Assert.assertEquals("'1995-11-9'", p.getGebdatString());
	}

	@Test
	public void testSetter() {
		Person p = new Person("nachname", "vorname");
		p.setGebdat(19, 9, 2005);
		Assert.assertEquals(19, p.getGebdat().getDate());
		Assert.assertEquals(9, p.getGebdat().getMonth());
		Assert.assertEquals(2005, p.getGebdat().getYear());

	}
}
