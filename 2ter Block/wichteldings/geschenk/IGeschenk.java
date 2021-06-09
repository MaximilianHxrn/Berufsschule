package geschenk;

public interface IGeschenk {

	String getName();

	int getSchwierigkeit();

	String toString();
		
	 final String[] GESCHENKE = { "Spannendes Buch", "Robuster Nussknacker", "Schnelles Auto",
				"Stacheliger Kaktus", "Duftende Badesalze", "Leckerer Essensgutschein" };

	 final String[] ESSBARES = { "Schoko-Nikolaus", "Knusprige Kekse", "Aromatischer Tee",
				"Selbstgemachtes Pesto", "Leckere Papaya", "Saftige Kekse" };

	 final String[] KLEIDUNG = { "Kuscheliger Schal", "Rote Unterbuxe", "Thermo-Ski-Unterwaesche",
				"Warme Socken", "Lange Struempfe", "Dicker Pullover", "Zipfelige Muetze", "Bequeme Hose" };

	 final String[] SPIELZEUG = { "Niedliche Puppe", "Interessantes Brettspiel", "Schnelles Auto",
				"Grosser Bagger", "Schnelles Kartenspiel", "Rasende Eisenbahn", "Gemaltes Memory" };

	GeschenkType geschenkType();
}
