package wichtelTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import geschenk.Essbares;
import geschenk.Geschenk;
import geschenk.Kleidung;
import geschenk.Spielzeug;
import wichtel.BlauerWichtel;
import wichtel.GelberWichtel;
import wichtel.RoterWichtel;

class WichtelTest {

	private RoterWichtel rot;
	private GelberWichtel gelb;
	private BlauerWichtel blau;
	private Geschenk allgemeinesGeschenk;
	private Essbares essbar;
	private Kleidung kleidung;
	private Spielzeug spielzeug;
	
	@BeforeEach
	public void setUp() {
		rot = new RoterWichtel();
		gelb = new GelberWichtel();
		blau = new BlauerWichtel();
		allgemeinesGeschenk = new Geschenk();
		essbar = new Essbares();
		kleidung = new Kleidung();
		spielzeug = new Spielzeug();
	}
	
	@Test
	public void roterWichtelWorksCorrect() {
		assertFalse(rot.arbeiteNoch());
		rot.arbeite(spielzeug);
		for(int i = 0; i< spielzeug.getSchwierigkeit();i++) {
			assertTrue(rot.arbeiteNoch());
			rot.arbeiteWeiter();
		}
		assertFalse(rot.arbeiteNoch());
		
		rot.arbeite(kleidung);
		if(kleidung.getSchwierigkeit()-2<=0) {
			assertTrue(rot.arbeiteNoch());
			rot.arbeiteWeiter();
		}
		else {
			for(int i = 0; i< kleidung.getSchwierigkeit()-2;i++) {
				assertTrue(rot.arbeiteNoch());
				rot.arbeiteWeiter();
			}
		}
		assertFalse(rot.arbeiteNoch());
	}
	
	@Test
	public void gelberWichtelWorksCorrect() {
		assertFalse(gelb.arbeiteNoch());
		gelb.arbeite(kleidung);
		for(int i = 0; i< kleidung.getSchwierigkeit()+2;i++) {
			assertTrue(gelb.arbeiteNoch());
			gelb.arbeiteWeiter();
		}
		assertFalse(gelb.arbeiteNoch());
		
		gelb.arbeite(allgemeinesGeschenk);
		for(int i = 0; i< allgemeinesGeschenk.getSchwierigkeit()+1;i++) {
			assertTrue(gelb.arbeiteNoch());
			gelb.arbeiteWeiter();
		}
		assertFalse(gelb.arbeiteNoch());
	}
	
	@Test
	public void blauerWichtelWorksCorrect() {
		assertFalse(blau.arbeiteNoch());
		blau.arbeite(essbar);
		int dauer = (int)Math.round(essbar.getSchwierigkeit()/2.0);
		for(int i = 0; i< dauer;i++) {
			assertTrue(blau.arbeiteNoch());
			blau.arbeiteWeiter();
		}
		assertFalse(blau.arbeiteNoch());
		
		blau.arbeite(allgemeinesGeschenk);
		for(int i = 0; i< allgemeinesGeschenk.getSchwierigkeit()+3;i++) {
			assertTrue(blau.arbeiteNoch());
			blau.arbeiteWeiter();
		}
		assertFalse(blau.arbeiteNoch());
	}
	
	@Test
	public void roterWichtelWorksMinimum() {
		TestGeschenk g = new TestGeschenk();
		rot.arbeite(g);
		assertTrue(rot.arbeiteNoch());
		rot.arbeiteWeiter();
		assertFalse(rot.arbeiteNoch());
	}

}
