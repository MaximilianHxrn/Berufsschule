package geschenkkatalog_Vorlage;

import java.util.List;

import geschenk.IGeschenk;


public interface IKatalog {
	
	/**
	 * Fügt dem Katalog einen weiteren Eintrag hinzu
	 * Gibt es diesen Eintrag schon (gleicher Geschenkname und Geschenktyp), soll
	 * das Attribut anzahl angepasst werden.
	 * @param entry
	 * @return die neue Anzahl 
	 */
	int add(KatalogEntry entry);
	
	/**
	 * Sucht nach einem bestimmten Geschenk und gibt den entsprechenden Katalogeintrag
	 * zurück. Falls dieses Geschenk nicht im Katalog vorhanden ist, wird null zurück-
	 * gegeben.
	 * @param geschenk
	 * @return
	 */
	KatalogEntry search(IGeschenk geschenk);
	
	/**
	 * Gibt alle Geschenke in alphabetischer Reihenfolge aus (sortiert nach Name,
	 * dann nach Geschenktyp)
	 * @return
	 */
	String toString();
	
	/**
	 * Gibt alle Geschenke in umgekehrter alphabetischer Reihenfolge aus (sortiert
	 * nach Name, dann nach Geschenktyp
	 * @return
	 */
	String toStringReverse();
	
	
	/**
	 * Gibt alle Katalogeinträge als Liste zurück, die diesen Geschenknamen besitzen
	 * @param name
	 * @return
	 */
	List<KatalogEntry> search(String name);
	
	
	/**
	 * Gibt die Anzahl aller gespeicherten Geschenke zurück
	 * @return
	 */
	int getGeschenkanzahl();
	
	/**
	 * Reduziert die Anzahl eines Katalogeintrags um die entsprechende Anzahl.
	 * Würde die Anzahl dadruch negativ werden, wird eine entsprechende Medlung
	 * ausgegeben und die Anzahl nicht verändert.
	 * Fällt die Anzahl auf 0, so soll dieser Eintrag entfernt werden.
	 * @param entry
	 * @return Gibt die aktualisierte Anzahl des Geschenks zurück.
	 * 		   Wird der Eintrag nicht gefunden, so soll -1 zurückgegeben werden.
	 *         	
	 */
	int remove(KatalogEntry entry);
}
