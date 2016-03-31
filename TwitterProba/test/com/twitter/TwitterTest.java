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

	/*
	 * @Test (expected = java.lang.RuntimeException.class) public void
	 * testUnesiNullKorisnik() { String korisnik = null; String poruka =
	 * "Grmi FON!";
	 * 
	 * t.unesi(korisnik, poruka); assertEquals(korisnik,
	 * t.vratiSvePoruke().getLast().getKorisnik()); assertEquals(poruka,
	 * t.vratiSvePoruke().getLast().getPoruka()); }
	 * 
	 * @Test (expected = java.lang.RuntimeException.class) public void
	 * testUnesiNullPoruka() { String korisnik = "Jovana"; String poruka = null;
	 * 
	 * t.unesi(korisnik, poruka); assertEquals(korisnik,
	 * t.vratiSvePoruke().getLast().getKorisnik()); assertEquals(poruka,
	 * t.vratiSvePoruke().getLast().getPoruka()); }
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiNull() {
		String korisnik = null;
		String poruka = null;

		t.unesi(korisnik, poruka);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiPrazanString() {
		String korisnik = "";
		String poruka = "";

		t.unesi(korisnik, poruka);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiPredugaPoruka() {
		String korisnik = "Jovana";
		String poruka = "";

		while (poruka.length() < 150) {
			poruka += "j";
		}

		t.unesi(korisnik, poruka);
	}

	@Test
	public void testVratiPorukeSveOk() {

		TwitterPoruka[] nizTviterPoruka = new TwitterPoruka[3];

		for (int i = 0; i < nizTviterPoruka.length; i++) {
			nizTviterPoruka[i] = new TwitterPoruka();
		}
		
		nizTviterPoruka[0].setKorisnik("Jovana");
		nizTviterPoruka[0].setPoruka("#bg");
		
		nizTviterPoruka[1].setKorisnik("Tamara");
		nizTviterPoruka[1].setPoruka("#kg");
		
		nizTviterPoruka[2].setKorisnik("Uros");
		nizTviterPoruka[2].setPoruka("#bg");
		
		t.unesi("Jovana", "#bg");
		t.unesi("Uros", "#bg");

		TwitterPoruka[] nizTviterPoruka2 = t.vratiPoruke(3, "#bg");

		assertArrayEquals(nizTviterPoruka, nizTviterPoruka2);

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		int maxBroj = 20;
		String tag = null;

		t.vratiPoruke(maxBroj, tag);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazanString() {
		int maxBroj = 20;
		String tag = "";

		t.vratiPoruke(maxBroj, tag);
	}

	@Test
	public void testVratiPorukeKapacitetManjiJednakNuli() {
		int maxBroj = 0;
		String tag = "fon";

		t.vratiPoruke(maxBroj, tag);
	}
}