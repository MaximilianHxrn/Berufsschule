package test.katalogTest;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import geschenk.GeschenkType;
import geschenkKatalog.Katalog;
import geschenkKatalog.KatalogEntry;

public class KatalogTest {

	private ArrayList<TestGeschenk> test;
	private Katalog kat;
	private String[] alphabet = { "Socke", "Apfel", "Schnelles Auto", "Kaktus", "Thermounterwäsche", "Jacke", "Socke" };
	SecureRandom r = new SecureRandom();

	@org.junit.jupiter.api.BeforeEach
	public void setUp() {
		test = new ArrayList<TestGeschenk>();
		kat = new Katalog();
		for (int i = 0; i < 100; i++) {
			test.add(new TestGeschenk(alphabet[r.nextInt(alphabet.length)], randomType()));
		}
		for (TestGeschenk g : test) {
			kat.add(new KatalogEntry(g));
		}
		kat.printDotFile("TreeTest");
	}

	private GeschenkType randomType() {
		int temp = r.nextInt(3);
		switch (temp) {
			case 0:
				return GeschenkType.ESSBARES;
			case 1:
				return GeschenkType.SPIELZEUG;
			case 2:
				return GeschenkType.KLEIDUNG;
		}
		return null;
	}

	@Test
	public void searchTest1() {
		TestGeschenk toSearch = new TestGeschenk("Jacke", GeschenkType.KLEIDUNG);
		KatalogEntry result = kat.search(toSearch);
		assertEquals("Jacke", result.getName());
	}

	@Test
	public void searchTest2() {
		TestGeschenk toSearch = new TestGeschenk("NotInKatalog", GeschenkType.KLEIDUNG);
		KatalogEntry result = kat.search(toSearch);
		assertNull(result);
	}

	@Test
	public void toStringTest() {
		System.out.println("--------");
		System.out.println(kat.toString());
		System.out.println("--------");
	}

	@Test
	public void toStringReverseTest() {
		System.out.println("--------");
		System.out.println(kat.toStringReverse());
		System.out.println("--------");
	}

	@Test
	public void getAnzahlTest() {
		assertEquals(10, kat.getGeschenkanzahl());
	}

	@Test
	public void inexactSerachTest() {
		setUp();
		List<KatalogEntry> result = kat.search("Schnelles Auto");
		assertEquals(3, result.size());
	}

	@Test
	public void removeTest() {
		for (int i = 0; i < 5; i++) {
			setUp();
			System.out.println("Vorher:");
			System.out.println(kat.toString());
			kat.remove(new KatalogEntry(test.get(i)));
			System.out.println("Nachher:");
			System.out.println(kat.toString());
		}
	}
}
