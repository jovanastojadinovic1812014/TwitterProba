package com.twitter;

import java.util.LinkedList;

import com.twitter.poruke.TwitterPoruka;

/**
 * Ova klasa sadrzi metode za upravljanje twitter porukama.
 * 
 * @author Jovana Stojadinovic
 * @version 1.0
 *
 */
public class Twitter {
	/**
	 * Inicijalizacija liste objekata klase TwitterPoruka.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Metoda koja vraca sve poruke iz liste poruka
	 * 
	 * @return listu poruka
	 */

	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Metoda za pravljenje nove poruke, koja se puni podacima
	 * 
	 * @param korisnik
	 *            nova vrednost atributa korisnik
	 * @param poruka
	 *            nova vrednost atributa poruka
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	/**
	 * Metoda vraca niz objekata klase TwitterPoruka koji u svojoj poruci imaju
	 * tag prosledjen kao parametar
	 * 
	 * @param maxBroj
	 *            kapacitet niza koji metoda vraca
	 * @param tag
	 *            tag koji je sadrzan u porukama
	 * @return niz objekata klase TwitterPoruka
	 */

	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}
