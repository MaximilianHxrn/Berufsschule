package wichtel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import geschenk.IGeschenk;
import util.Util;

public abstract class Wichtel implements IWichtel{
	
	private static final Random RAND = new Random();
	private final String name;
	private int anzahlGeschenke;
	private int zeitGearbeitet;
	protected int dauer;
	
	public Wichtel() {
		name = koboldname();
		anzahlGeschenke = 0;
		dauer = 0;
		zeitGearbeitet = 0;
	}
	
	public Wichtel(IWichtel wichtel) {
		name = wichtel.getName();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public boolean arbeiteNoch() {
		return dauer > 0;
	}
	
	@Override
	public void arbeiteWeiter() {
		if(arbeiteNoch()) {
			dauer --;
			zeitGearbeitet++;
			if(dauer == 0) {
				anzahlGeschenke++;
			}
		}
	}
	
	/**
	 * Gibt einen zufaelligen Vornamen zurueck, der bei Wichteln beliebt ist.
	 * 
	 * @return Der Name.
	 */
	public static String koboldname() {
		StringBuilder builder = new StringBuilder(100);
		int length;
		while (builder.length() == 0) {
			length = RAND.nextInt(2) + 2;
			for (int i = 0; i < length; i++) {
				builder.append(LEXICON[RAND.nextInt(LEXICON.length)]);
			}
		}
		return builder.toString();
	}
	
	public abstract void arbeite(IGeschenk g);
	
	@Override
	public String toString() {
		return name;
	}
	
	public static List<IWichtel> generiereWichtel(int anzahlWichtel){
		ArrayList<IWichtel> ergebnis = new ArrayList<IWichtel>();
		WichtelType[] wichtelTypes = WichtelType.values();
		
		for(int i = 0; i<anzahlWichtel;i++) {
			WichtelType randomType = wichtelTypes[Util.getZufallszahl(wichtelTypes.length)-1];
			IWichtel geschenk = createWichtel(randomType);
			ergebnis.add(geschenk);
		}
		
		return ergebnis;

	}

	private static IWichtel createWichtel(WichtelType randomType) {
		switch(randomType) {
		case BLAUER_WICHTEL:
			return new BlauerWichtel();
		case GELBER_WICHTEL:
			return new GelberWichtel();
		case ROTER_WICHTEL:
			return new RoterWichtel();
		default:
			return null;
		}
	}
	
	@Override
	public double effizienz() {
		if(zeitGearbeitet == 0) {
			return 0;
		}
		return (double)(anzahlGeschenke) / zeitGearbeitet;
	}
	
	@Override
	public int compareTo(IWichtel o) {
		double diff = this.effizienz() - o.effizienz();
		if(diff>0) {
			return 1;
		}
		if(diff == 0) {
			return 0;
		}
		else {
			return -1;
		}
	}

}
