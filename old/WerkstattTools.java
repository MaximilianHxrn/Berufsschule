import java.io.*;
import java.util.*;
public abstract class WerkstattTools {
	

	public static Geschenk[] generiereGeschenke(int anzahlGeschenke) {
		Random r = new Random();
		Geschenk[] temp = new Geschenk[anzahlGeschenke];
		for (int i = 0; i < anzahlGeschenke; i++) {
			int bool = r.nextInt(3);
			switch(bool) {
				case 0: temp[i] = new Spielzeug(); break;
				case 1: temp[i] = new Kleidung(); break;
				case 2: temp[i] = new Essbares(); break;
			}
		}
		return temp;
	}
	
	
	public static Wichtel[] generiereWichtel(int anzahlWichtel) {
		Random r = new Random();
		Wichtel[] temp = new Wichtel[anzahlWichtel];
		for (int i = 0; i < anzahlWichtel; i++) {
			int bool = r.nextInt(3);
			switch(bool) {
				case 0: temp[i] = new RoterWichtel(Zufall.koboldname()); break;
				case 1: temp[i] = new GelberWichtel(Zufall.koboldname()); break;
				case 2: temp[i] = new BlauerWichtel(Zufall.koboldname()); break;
			}
		}
		return temp;
	}
}
