package geschenk;

import java.util.ArrayList;
import java.util.List;

import util.Util;

public class Geschenk implements IGeschenk{
	
	protected String name;

	protected int schwierigkeit;
	
	public Geschenk() {
		name = GESCHENKE[Util.getZufallszahl(GESCHENKE.length)-1];
		schwierigkeit = Util.getZufallszahl(25);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSchwierigkeit() {
		return schwierigkeit;
	}
	
	@Override
	public String toString() {
		return Util.createWithSpace(name, "Schwierigkeit:", schwierigkeit);
	}
	
	public static List<IGeschenk> generiereGeschenke(int anzahlGeschenke){
		ArrayList<IGeschenk> ergebnis = new ArrayList<IGeschenk>();
		GeschenkType[] geschenkTypes = GeschenkType.values();
		
		for(int i = 0; i<anzahlGeschenke;i++) {
			GeschenkType randomType = geschenkTypes[Util.getZufallszahl(geschenkTypes.length)-1];
			IGeschenk geschenk = createGeschenk(randomType);
			ergebnis.add(geschenk);
		}
		
		return ergebnis;
	}

	private static IGeschenk createGeschenk(GeschenkType randomType) {
		switch(randomType) {
		case ESSBARES:
			return new Essbares();
		case GESCHENK:
			return new Geschenk();
		case KLEIDUNG:
			return new Kleidung();
		case SPIELZEUG:
			return new Spielzeug();
		default:
			return null;
		
		}
	}

	@Override
	public GeschenkType geschenkType() {
		return GeschenkType.GESCHENK;
	}
	

}
