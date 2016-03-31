package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	Twitter t;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testVratiSvePoruke() {
		t.vratiSvePoruke();
	}

	@Test
	public void testUnesiSveOk() {
		String korisnik = "Jovana";
		String poruka = "Grmi FON!";

		t.unesi(korisnik, poruka);
		assertEquals(korisnik, t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals(poruka, t.vratiSvePoruke().getLast().getPoruka());
	}

	@Test
	public void testVratiPoruke() {
		fail("Not yet implemented");
	}

}
