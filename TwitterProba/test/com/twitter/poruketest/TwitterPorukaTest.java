package com.twitter.poruketest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterPorukaTest {
	TwitterPoruka poruka;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		poruka = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		poruka = null;
	}

	@Test
	public void testSetKorisnikSveOk() {
		String korisnik = "Jovana";
		poruka.setKorisnik(korisnik);
		assertEquals(korisnik, poruka.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		poruka.setKorisnik(null);

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		poruka.setKorisnik("");

	}

	@Test
	public void testSetPorukaSveOk() {
		String p = "Poslednji dan marta!";
		poruka.setPoruka(p);
		assertEquals(p, poruka.getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		poruka.setPoruka(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaLength() {
		String p = "";
		for (int i = 0; i < 150; i++) {
			p += "j";
		}
		poruka.setPoruka(p);
		assertEquals(p, poruka.getPoruka());
	}

	@Test
	public void testToString() {
		String k = "Jovana";
		String p = "Poslednji dan marta!";
		poruka.setKorisnik(k);
		poruka.setPoruka(p);
		assertEquals("KORISNIK:" + k + " PORUKA:" + p, poruka.toString());
	}

}
