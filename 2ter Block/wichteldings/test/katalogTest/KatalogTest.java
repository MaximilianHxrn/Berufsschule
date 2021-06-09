package test.katalogTest;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import geschenk.GeschenkType;
import geschenkKatalog.Katalog;
import geschenkKatalog.KatalogEntry;

public class KatalogTest {
	
	private ArrayList<TestGeschenk> test;
	private Katalog kat;
	
	@BeforeEach
	public void setUp() {
		test = new ArrayList<TestGeschenk>();
		kat = new Katalog();
		test.add(new TestGeschenk("Socke", GeschenkType.KLEIDUNG));
		test.add(new TestGeschenk("Apfel", GeschenkType.ESSBARES));
		test.add(new TestGeschenk("Schnelles Auto", GeschenkType.GESCHENK));
		test.add(new TestGeschenk("Kaktus", GeschenkType.GESCHENK));
		test.add(new TestGeschenk("Thermounterwäsche", GeschenkType.KLEIDUNG));
		test.add(new TestGeschenk("Schnelles Auto", GeschenkType.SPIELZEUG));
		test.add(new TestGeschenk("Jacke", GeschenkType.KLEIDUNG));
		test.add(new TestGeschenk("Socke", GeschenkType.KLEIDUNG));
		test.add(new TestGeschenk("Kaktus", GeschenkType.GESCHENK));
		test.add(new TestGeschenk("Schnelles Auto", GeschenkType.ESSBARES));
		
		for(TestGeschenk g : test) {
			kat.add(new KatalogEntry(g));
		}
		
		kat.printDotFile("TreeTest");
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
		List<KatalogEntry> result = kat.search("Schnelles Auto");
		assertEquals(3, result.size());
	}
	
	
	
}
