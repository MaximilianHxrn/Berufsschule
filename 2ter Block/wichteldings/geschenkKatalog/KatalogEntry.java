package geschenkKatalog;

import java.text.Collator;
import java.util.Locale;

import geschenk.IGeschenk;

public class KatalogEntry implements Comparable<KatalogEntry>{
	
	private final IGeschenk geschenk;
	private int anzahl;
	
	public KatalogEntry(IGeschenk geschenk) {
		this.geschenk = geschenk;
		anzahl = 1;
	}
	
	public KatalogEntry(IGeschenk geschenk, int anzahl) {
		this.geschenk = geschenk;
		this.anzahl = anzahl;
	}
	
	public int getAnzahl() {
		return anzahl;
	}
	
	public String getName() {
		return geschenk.getName();
	}
	
	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append("Name: ").append(geschenk.getName());
		build.append(", Typ: ").append(geschenk.geschenkType());
		build.append(", Anzahl: ").append(anzahl);
		return build.toString();
	}

	@Override
	public int compareTo(KatalogEntry o) {
		Collator col = Collator.getInstance(Locale.GERMAN);
		col.setStrength(Collator.SECONDARY);
		
		int compare = col.compare(getName(), o.getName());
		
		if(compare != 0) {
			return compare;
		}
		return col.compare(geschenk.geschenkType().getType().toString(), o.geschenk.geschenkType().getType().toString());
	}

	public int erhoehe(int anzahl) {
		this.anzahl += anzahl;
		return this.anzahl;
	}

}
