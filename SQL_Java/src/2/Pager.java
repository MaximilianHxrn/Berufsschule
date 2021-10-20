

import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

public class Pager {

	// Attribute:

	/**
	 * Der zu verwendende Entitätsmanager.
	 */
	// TODO Attribut erstellen.

	/**
	 * Name der zu verendenden dynamisch benannten Anfrage.
	 */
	// TODO Attribut erstellen.

	/**
	 * Aktuelle Seite in der Ergebnisliste.
	 */
	// TODO Attribut erstellen.

	/**
	 * Anzahl der Elemente in der Ergebnisliste der benannten Anfrage.
	 */
	// TODO Attribut erstellen.

	/**
	 * Anzahl der Elemente, die auf einer Seite sein sollen.
	 */
	// TODO Attribut erstellen.

	// Methoden

	/**
	 * Erzeugt ein Pager-Objekt. Die Übergabeparameter werden in den entsprechenden
	 * Attributen gespeichert. Außerdem wird die Anzahl der Ergebnisse der
	 * übergebenen (benannten) Anfrage im Attribut maxResults gespeichert. Zuletzt
	 * wird noch die aktuelle Seite auf 0 festgelegt.
	 * 
	 * @param entityManager
	 *            Der zu benutzende Entitätsmanager.
	 * @param pageSize
	 *            Anzahl der Ergebniselemente auf einer Seite.
	 * @param queryName
	 *            Name der dynamisch benannten Anfrage, derne Ergebnisse auf
	 *            "Seiten" dargestellt werden soll.
	 */
	public Pager(EntityManager entityManager, int pageSize, String queryName) {
		// TODO Konstruktor implementieren.
	}

	/**
	 * Gibt die Anzahl der Ergebniselemente auf einer Seite zurück.
	 * 
	 * @return Anzahl der Ergebniselemente auf einer Seite
	 */
	public int getPageSize() {
		// TODO Methode implementieren.
		return 0;
	}

	/**
	 * Gibt die Gesamtanzahl der Seiten zurück.
	 * 
	 * @return Gesamtanzahl der Seiten
	 */
	public int getMaxPages() {
		// TODO Methode implementieren.
		return 0;
	}

	/**
	 * Gibt den Inhalt der aktuellen Seite als Liste zurück.
	 * 
	 * @return Liste mit dem aktuellen Inhalt der Seite
	 */
	@SuppressWarnings("rawtypes")
	public List getCurrentResults() {
		// TODO Methode implementieren.
		return new LinkedList();
	}

	/**
	 * Inkrementiert die aktuelle Seitenzahl, falls sie kleiner als die Gesamtanzahl
	 * der Seiten ist.
	 */
	public void next() {
		// TODO Methode implementieren.
	}

	/**
	 * Dekrementiert die aktuelle Seitenzahl, falls sie größer als 0 ist.
	 */
	public void previous() {
		// TODO Methode implementieren.
	}

	/**
	 * Gibt die aktuelle Seitenanzahl zurück.
	 * 
	 * @return aktuelle Seitenanzahl
	 */
	public int getCurrentPage() {
		// TODO Methode implementieren.
		return 0;
	}

	/**
	 * Setzt die aktuelle Seitenanzahl. Dies geschieht nur, falls die übergebene
	 * Seitennummer größer gleich 0 und kleiner gleich der Gesamtzahl der Seiten
	 * ist.
	 * 
	 * @param currentPage zu setzende aktuelle Seite.
	 */
	public void setCurrentPage(int currentPage) {
		// TODO Methode implementieren.
	}
}