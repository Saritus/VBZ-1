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

	// TODO: Tests hinzufügen
}
