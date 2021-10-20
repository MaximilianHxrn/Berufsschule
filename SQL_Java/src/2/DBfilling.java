import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

public class DBfilling {

	private static List<Zusatzangebot> ZUSATZANGEBOTE;
	private static List<Schueler> SCHUELERS;
	private static List<Klasse> KLASSEN;
	private static List<Lehrkraft> LEHRKRAEFTE;
	private static List<Unterricht> UNTERRICHTE;
	private static int HEUER;

	public static void fillDB(EntityManager em) {
		/*
		 * Quelle für Personendaten: http://www.fakenamegenerator.com/
		 * https://www.behindthename.com/random/
		 * http://www.aberwitzig.com/lustige-namen.php
		 * http://www.unmoralische.de/namen/dumme_namen.htm Daten sind teilweise
		 * abgeändert.
		 */

		HEUER = new GregorianCalendar().get(Calendar.YEAR);

		em.getTransaction().begin();
		em.createQuery("DELETE FROM Zusatzangebot AS z").executeUpdate();
		em.createQuery("DELETE FROM Schueler      AS s").executeUpdate();
		em.createQuery("DELETE FROM Klasse        AS k").executeUpdate();
		em.createQuery("DELETE FROM Lehrkraft     AS l").executeUpdate();
		em.createQuery("DELETE FROM Unterricht    AS u").executeUpdate();
		em.getTransaction().commit();

		fillZusatzangebot(em);
		fillSchueler(em);
		fillKlasse(em);
		fillLehrkraft(em);
		fillUnterricht(em);
		setSchuelerKlasse(em);
		setSchuelerZusatzangebot(em);
	}

	private static void fillZusatzangebot(EntityManager em) {
		/*
		 * Quelle für Zusatzangebote: https://www.bsinfo.eu/index.php/aus/zus.html,
		 * Stand: 02.12.2017
		 */
		if (ZUSATZANGEBOTE == null) {
			ZUSATZANGEBOTE = new ArrayList<>(4); // Anfängliche Kapazität ggf. anpassen.
			ZUSATZANGEBOTE.add(new Zusatzangebot("Android-Programmierung",
					"Der Kurs \"Android-Programmierung\" läuft seit dem Schuljahr "
							+ "2013/14 über ein Online-System. Dabei wird den Schülerinnen und "
							+ "Schülern ermöglicht, die Zeitplanung individuell zu gestalten." + "\n"
							+ "Trotz unterschiedlichen Vorkenntnissen, Bedürfnissen und "
							+ "Lernfortschritten kann so jedem Teilnehmer die volle "
							+ "Aufmerksamkeit und Unterstützung gegeben werden."));
			ZUSATZANGEBOTE.add(new Zusatzangebot("CISCO-Zertifizierung",
					"Die Schule ist seit dem 07.07.2000 offizielle Cisco Academy. "
							+ "Derzeit bieten zwei Cisco Certified Academy Instruktoren (CCAI) "
							+ "interessierten, leistungswilligen SchülerInnen die Möglichkeit, "
							+ "sich auf die Zertifikatsprüfungen CCENT und CCNA Routing und "
							+ "Switching vorzubereiten."));
			ZUSATZANGEBOTE.add(new Zusatzangebot("Crimpen und Löten",
					"Ziel des Kurses:" + "\n" + "Im ersten Teil konfektionieren einer flexiblen "
							+ "Verlängerungsleitung." + "\n"
							+ "Im zweiten Teil löten einer Leiterplatine für einen akustischen "
							+ "Durchgangsprüfer. Verlängerung und Durchgangsprüfer dürfen " + "behalten werden."));
			ZUSATZANGEBOTE.add(new Zusatzangebot("Linux-Zertifizierung",
					"Die LPIC-1 Zertifizierung ist eine distributionsunabhängige "
							+ "Linux-Zertifizierung für angehende Systemadministratoren und "
							+ "Entwickler. Sie richtet sich vor allem an Schülerinnen und Schüler "
							+ "mit technischem Hintergrund. Um das LPIC-1 Zertifikat zu erhalten, "
							+ "müssen die beiden Prüfungen LPI-101 und LPI-102 abgelegt und " + "bestanden werden."));
		}

		fill(em, ZUSATZANGEBOTE);
	}

	private static void fillSchueler(EntityManager em) {
		if (SCHUELERS == null) {

			SCHUELERS = new ArrayList<>(51);
			// Klasse 3FA063
			SCHUELERS.add(new Schueler("Klara", "Fall", new GregorianCalendar(HEUER - 17, 4, 1),
					new GregorianCalendar(HEUER - 2, 8, 1), Schulabschluss.MITTLERER_SCHULABSCHLUSS));
			SCHUELERS.add(new Schueler("Gregor", "Janisch", new GregorianCalendar(HEUER - 18, 0, 1),
					new GregorianCalendar(HEUER - 1, 0, 2), Schulabschluss.FACHHOCHSCHULREIFE_FACHGEBUNDEN));
			SCHUELERS.add(new Schueler("Ellen", "Lang", new GregorianCalendar(HEUER - 28, 11, 24),
					new GregorianCalendar(HEUER - 2, 3, 8), Schulabschluss.MITTELSCHULABSCHLUSS_QUALIFIZIEREND));
			SCHUELERS.add(new Schueler("Mark", "Graf", new GregorianCalendar(HEUER - 16, 1, 27),
					new GregorianCalendar(HEUER - 3, 3, 8), Schulabschluss.MITTELSCHULABSCHLUSS));
			SCHUELERS.add(new Schueler("Johannes", "Beer", new GregorianCalendar(HEUER - 20, 11, 24),
					new GregorianCalendar(HEUER - 2, 8, 1), Schulabschluss.MITTLERER_SCHULABSCHLUSS));
			SCHUELERS.add(new Schueler("Roy", "Beer", new GregorianCalendar(HEUER - 21, 6, 4),
					new GregorianCalendar(HEUER - 2, 8, 1), Schulabschluss.FACHHOCHSCHULREIFE_FACHGEBUNDEN));
			SCHUELERS.add(new Schueler("Theo", "Dohr", new GregorianCalendar(HEUER - 27, 10, 23),
					new GregorianCalendar(HEUER - 2, 3, 1), Schulabschluss.MITTLERER_SCHULABSCHLUSS));
			SCHUELERS.add(new Schueler("Heinz", "Ellmann", new GregorianCalendar(HEUER - 19, 8, 21),
					new GregorianCalendar(HEUER - 2, 8, 1), Schulabschluss.MITTLERER_SCHULABSCHLUSS));
			SCHUELERS.add(new Schueler("Johannes", "Kraut", new GregorianCalendar(HEUER - 17, 10, 26),
					new GregorianCalendar(HEUER - 2, 8, 1), Schulabschluss.HOCHSCHULREIFE_FACHGEBUNDEN));
			SCHUELERS.add(new Schueler("Andreas", "Kreuz", new GregorianCalendar(HEUER - 16, 1, 12),
					new GregorianCalendar(HEUER - 2, 8, 1), Schulabschluss.MITTELSCHULABSCHLUSS_QUALIFIZIEREND));
			SCHUELERS.add(new Schueler("Ernst", "Lustig", new GregorianCalendar(HEUER - 18, 8, 29),
					new GregorianCalendar(HEUER - 2, 8, 1), Schulabschluss.MITTLERER_SCHULABSCHLUSS));
			SCHUELERS.add(new Schueler("Gerd", "Nehr", new GregorianCalendar(HEUER - 21, 10, 21),
					new GregorianCalendar(HEUER - 2, 8, 1), Schulabschluss.MITTELSCHULABSCHLUSS_QUALIFIZIEREND));
			SCHUELERS.add(new Schueler("Vural", "Demirci", new GregorianCalendar(HEUER - 25, 1, 2),
					new GregorianCalendar(HEUER - 3, 8, 1), Schulabschluss.HOCHSCHULREIFE_FACHGEBUNDEN));
			SCHUELERS.add(new Schueler("Emre", "Uzun", new GregorianCalendar(HEUER - 19, 6, 13),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.MITTLERER_SCHULABSCHLUSS));
			SCHUELERS.add(new Schueler("Erhan", "Demir", new GregorianCalendar(HEUER - 18, 3, 25),
					new GregorianCalendar(HEUER - 2, 7, 1), Schulabschluss.MITTLERER_SCHULABSCHLUSS));
			SCHUELERS.add(new Schueler("Cemile", "Aslan", new GregorianCalendar(HEUER - 20, 5, 15),
					new GregorianCalendar(HEUER - 2, 10, 1), Schulabschluss.HOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Wu", "Liu", new GregorianCalendar(HEUER - 17, 4, 23),
					new GregorianCalendar(HEUER - 2, 8, 1), Schulabschluss.MITTLERER_SCHULABSCHLUSS));
			SCHUELERS.add(new Schueler("Simona", "Zelenka", new GregorianCalendar(HEUER - 17, 1, 8),
					new GregorianCalendar(HEUER - 2, 8, 15), Schulabschluss.MITTLERER_SCHULABSCHLUSS));
			SCHUELERS.add(new Schueler("Sergine", "Romilly", new GregorianCalendar(HEUER - 17, 3, 2),
					new GregorianCalendar(HEUER - 2, 8, 1), Schulabschluss.FACHHOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Uberto", "Columbo", new GregorianCalendar(HEUER - 18, 4, 12),
					new GregorianCalendar(HEUER - 2, 11, 1), Schulabschluss.FACHHOCHSCHULREIFE_FACHGEBUNDEN));
			SCHUELERS.add(new Schueler("Rina", "Shimizu", new GregorianCalendar(HEUER - 19, 7, 8),
					new GregorianCalendar(HEUER - 2, 8, 1), Schulabschluss.HOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Seong", "Lee", new GregorianCalendar(HEUER - 18, 4, 31),
					new GregorianCalendar(HEUER - 2, 8, 1), Schulabschluss.MITTLERER_SCHULABSCHLUSS));
			SCHUELERS.add(new Schueler("Katja", "Koch", new GregorianCalendar(HEUER - 18, 3, 18),
					new GregorianCalendar(HEUER - 2, 7, 1), Schulabschluss.HOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Leonie", "Ebersbach", new GregorianCalendar(HEUER - 18, 7, 21),
					new GregorianCalendar(HEUER - 2, 8, 1), Schulabschluss.MITTELSCHULABSCHLUSS_QUALIFIZIEREND));
			SCHUELERS.add(new Schueler("Petra", "Müller", new GregorianCalendar(HEUER - 16, 3, 16),
					new GregorianCalendar(HEUER - 2, 8, 1), Schulabschluss.MITTELSCHULABSCHLUSS));
			// Klasse 4FA02W
			SCHUELERS.add(new Schueler("Dirk", "Berg", new GregorianCalendar(HEUER - 25, 0, 22),
					new GregorianCalendar(HEUER - 2, 8, 1), Schulabschluss.FACHHOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Markus", "Fischer", new GregorianCalendar(HEUER - 21, 3, 16),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.HOCHSCHULREIFE_FACHGEBUNDEN));
			SCHUELERS.add(new Schueler("Stephanie", "Hirsch", new GregorianCalendar(HEUER - 22, 7, 11),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.HOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Angela", "Engel", new GregorianCalendar(HEUER - 20, 0, 24),
					new GregorianCalendar(HEUER - 2, 8, 1), Schulabschluss.HOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Mathias", "Scholz", new GregorianCalendar(HEUER - 27, 10, 27),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.FACHHOCHSCHULREIFE_FACHGEBUNDEN));
			SCHUELERS.add(new Schueler("Ulrich", "Schroder", new GregorianCalendar(HEUER - 22, 11, 6),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.HOCHSCHULREIFE_FACHGEBUNDEN));
			SCHUELERS.add(new Schueler("Silke", "Herrmann", new GregorianCalendar(HEUER - 23, 9, 30),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.FACHHOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Markus", "Grünewald", new GregorianCalendar(HEUER - 19, 11, 10),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.FACHHOCHSCHULREIFE_FACHGEBUNDEN));
			SCHUELERS.add(new Schueler("Steffen", "Eichelberger", new GregorianCalendar(HEUER - 26, 2, 18),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.HOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Wolfgang", "Gerste", new GregorianCalendar(HEUER - 20, 1, 5),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.FACHHOCHSCHULREIFE_FACHGEBUNDEN));
			SCHUELERS.add(new Schueler("Jörg", "Wagner", new GregorianCalendar(HEUER - 24, 2, 23),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.FACHHOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Robert", "Brandt", new GregorianCalendar(HEUER - 20, 8, 30),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.HOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Egemen", "Tiryaki", new GregorianCalendar(HEUER - 23, 2, 21),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.HOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Adnan", "Demirci", new GregorianCalendar(HEUER - 22, 4, 22),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.HOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Dmitry", "Bogdanov", new GregorianCalendar(HEUER - 19, 7, 4),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.HOCHSCHULREIFE_FACHGEBUNDEN));
			SCHUELERS.add(new Schueler("Anh", "Nguyen", new GregorianCalendar(HEUER - 25, 10, 21),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.HOCHSCHULREIFE_FACHGEBUNDEN));
			SCHUELERS.add(new Schueler("Emanuel Zapata", "Alonzo", new GregorianCalendar(HEUER - 22, 4, 4),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.HOCHSCHULREIFE_FACHGEBUNDEN));
			SCHUELERS.add(new Schueler("Petr", "Buben", new GregorianCalendar(HEUER - 19, 8, 13),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.FACHHOCHSCHULREIFE_FACHGEBUNDEN));
			SCHUELERS.add(new Schueler("Hana", "Petkovic", new GregorianCalendar(HEUER - 21, 1, 20),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.FACHHOCHSCHULREIFE_FACHGEBUNDEN));
			SCHUELERS.add(new Schueler("Roberto", "Fallaci", new GregorianCalendar(HEUER - 27, 8, 27),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.FACHHOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Sun", "Tsao", new GregorianCalendar(HEUER - 20, 9, 28),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.FACHHOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Erik", "Meister", new GregorianCalendar(HEUER - 27, 7, 26),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.HOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Jürgen", "Osterhagen", new GregorianCalendar(HEUER - 24, 9, 25),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.FACHHOCHSCHULREIFE_FACHGEBUNDEN));
			SCHUELERS.add(new Schueler("Lisa", "Eichmann", new GregorianCalendar(HEUER - 26, 6, 26),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.FACHHOCHSCHULREIFE_ALLGEMEIN));
			SCHUELERS.add(new Schueler("Matthias", "Osterhagen", new GregorianCalendar(HEUER - 21, 2, 6),
					new GregorianCalendar(HEUER - 1, 8, 1), Schulabschluss.FACHHOCHSCHULREIFE_ALLGEMEIN));
			// Pumuckl, der Kobold. Liebt Unordnung
			SCHUELERS.add(new Schueler("Pumuckl", "Kobold", new GregorianCalendar(HEUER - 6, 7, 8),
					new GregorianCalendar(HEUER - 9, 8, 7), Schulabschluss.MITTELSCHULABSCHLUSS_QUALIFIZIEREND));
		}
		for (Schueler s : SCHUELERS) {
			System.out.println(s.getVorname() + " " + s.getNachname());
		}
		fill(em, SCHUELERS);
	}

	private static void fillKlasse(EntityManager em) {
		// Verwendung des Namenssschemas der Städtischen Berufsschule für
		// Informationstechnik, München
		if (KLASSEN == null) {
			KLASSEN = new ArrayList<>(2); // Anfängliche Kapazität ggf. anpassen.
			KLASSEN.add(new Klasse("3FA063", SCHUELERS.get(0)));
			KLASSEN.add(new Klasse("4FA02W", SCHUELERS.get(25)));
		}
		fill(em, KLASSEN);
	}

	private static void fillLehrkraft(EntityManager em) {
		if (LEHRKRAEFTE == null) {
			LEHRKRAEFTE = new ArrayList<>(6);
			LEHRKRAEFTE.add(new Lehrkraft("Jürgen", "Huber", new GregorianCalendar(HEUER - 45, 7, 26), "Hub"));
			LEHRKRAEFTE.add(new Lehrkraft("Mira", "Bellenbaum", new GregorianCalendar(HEUER - 27, 8, 10), "Bel"));
			LEHRKRAEFTE.add(new Lehrkraft("Christin", "Egger", new GregorianCalendar(HEUER - 55, 5, 17), "Egg"));
			LEHRKRAEFTE.add(new Lehrkraft("Kristian", "Lehmann", new GregorianCalendar(HEUER - 35, 2, 4), "Leh"));
			LEHRKRAEFTE.add(new Lehrkraft("Ralph", "Zweig", new GregorianCalendar(HEUER - 43, 1, 22), "Zwe"));
			// Meister Eder
			LEHRKRAEFTE.add(new Lehrkraft("Franz", "Eder", new GregorianCalendar(HEUER - 62, 5, 3), "Ede"));
		}
		fill(em, LEHRKRAEFTE);
	}

	private static void fillUnterricht(EntityManager em) {
		/*
		 * Quelle für Unterrichtende Fächer:
		 * https://www.bsinfo.eu/index.php/aus/inh.html, Stand: 02.12.2017
		 */
		if (UNTERRICHTE == null) {
			UNTERRICHTE = new ArrayList<>(19);

			// Bellenbaum in 3FA063
			UNTERRICHTE.add(new Unterricht(KLASSEN.get(0), LEHRKRAEFTE.get(1), Fach.BETRIEBSWIRTSCHAFTLICHE_PROZESSE));
			UNTERRICHTE.add(new Unterricht(KLASSEN.get(0), LEHRKRAEFTE.get(1), Fach.IT_SYSTEME));
			UNTERRICHTE.add(
					new Unterricht(KLASSEN.get(0), LEHRKRAEFTE.get(1), Fach.ANWENDUNGSENTWICKLUNG_UND_PROGRAMMIERUNG));
			// Huber in 3FA063
			UNTERRICHTE.add(new Unterricht(KLASSEN.get(0), LEHRKRAEFTE.get(0), Fach.BETRIEBSWIRTSCHAFTLICHE_PROZESSE));
			UNTERRICHTE.add(new Unterricht(KLASSEN.get(0), LEHRKRAEFTE.get(0), Fach.ENGLISCH));
			UNTERRICHTE.add(new Unterricht(KLASSEN.get(0), LEHRKRAEFTE.get(0), Fach.DEUTSCH));
			// Egger in 3FA063
			UNTERRICHTE.add(new Unterricht(KLASSEN.get(0), LEHRKRAEFTE.get(2), Fach.SOZIALKUNDE));
			UNTERRICHTE.add(new Unterricht(KLASSEN.get(0), LEHRKRAEFTE.get(2), Fach.IT_SYSTEME));
			// Lehmann in 3FA063
			UNTERRICHTE.add(
					new Unterricht(KLASSEN.get(0), LEHRKRAEFTE.get(3), Fach.ANWENDUNGSENTWICKLUNG_UND_PROGRAMMIERUNG));
			UNTERRICHTE.add(new Unterricht(KLASSEN.get(0), LEHRKRAEFTE.get(3), Fach.RELIGION_RK));
			// Zweig in 3FA063
			UNTERRICHTE.add(new Unterricht(KLASSEN.get(0), LEHRKRAEFTE.get(4), Fach.RELIGION_RK));

			// Bellenbaum in 4FA02W
			UNTERRICHTE.add(new Unterricht(KLASSEN.get(1), LEHRKRAEFTE.get(1), Fach.BETRIEBSWIRTSCHAFTLICHE_PROZESSE));
			UNTERRICHTE.add(new Unterricht(KLASSEN.get(1), LEHRKRAEFTE.get(1), Fach.IT_SYSTEME));
			UNTERRICHTE.add(
					new Unterricht(KLASSEN.get(1), LEHRKRAEFTE.get(1), Fach.ANWENDUNGSENTWICKLUNG_UND_PROGRAMMIERUNG));
			// Huber in 4FA02W
			UNTERRICHTE.add(new Unterricht(KLASSEN.get(1), LEHRKRAEFTE.get(0), Fach.BETRIEBSWIRTSCHAFTLICHE_PROZESSE));
			UNTERRICHTE.add(new Unterricht(KLASSEN.get(1), LEHRKRAEFTE.get(0), Fach.ENGLISCH));
			// Egger in 12V3FA
			UNTERRICHTE.add(new Unterricht(KLASSEN.get(1), LEHRKRAEFTE.get(2), Fach.SOZIALKUNDE));
			UNTERRICHTE.add(new Unterricht(KLASSEN.get(1), LEHRKRAEFTE.get(2), Fach.IT_SYSTEME));
			// Lehmann in 4FA02W
			UNTERRICHTE.add(
					new Unterricht(KLASSEN.get(1), LEHRKRAEFTE.get(3), Fach.ANWENDUNGSENTWICKLUNG_UND_PROGRAMMIERUNG));
		}
		fill(em, UNTERRICHTE);
	}

	private static void setSchuelerKlasse(EntityManager em) {
		em.getTransaction().begin();
		for (Schueler s : SCHUELERS.subList(0, 25)) {
			s.addKlasse(KLASSEN.get(0));
			em.persist(s);
		}
		for (Schueler s : SCHUELERS.subList(25, 50)) {
			s.addKlasse(KLASSEN.get(1));
			em.persist(s);
		}
		em.getTransaction().commit();
	}

	private static void setSchuelerZusatzangebot(EntityManager em) {
		em.getTransaction().begin();
		Zusatzangebot tmpZusatzangebot;
		for (int i = 0; i < ZUSATZANGEBOTE.size(); i++) {
			for (int j = i; j < SCHUELERS.size(); j = j + 7 + i) {
				tmpZusatzangebot = ZUSATZANGEBOTE.get(i);
				tmpZusatzangebot.addSchueler(SCHUELERS.get(j));
				em.persist(tmpZusatzangebot);
			}
		}
		em.getTransaction().commit();
	}

	private static <T> void fill(EntityManager em, List<T> list) {
		em.getTransaction().begin();
		for (T t : list) {
			em.persist(t);
		}
		em.getTransaction().commit();
	}

	// private static <T> void generate(List<T> list, int anzahlElemente) {
	// 	list = (list == null) ? new ArrayList<T>(anzahlElemente) : list;
	// }
}