package test;

import org.junit.Assert;
import org.junit.Test;

import se.Person;
import se.PersonList;

public class testPersonList {
	@Test
	public void testKonstruktor() {
		PersonList pl = new PersonList();
		Assert.assertArrayEquals(new Person[0], pl.getList());
		Assert.assertEquals(0, pl.getQuantity());
	}

	// TODO: Tests hinzufügen
}
