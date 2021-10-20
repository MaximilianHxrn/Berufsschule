

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class SchuelerTest {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("schule");
		EntityManager em = emf.createEntityManager();
		
		
		Schueler klara = new Schueler();
		klara.setVorname("Klara");
		klara.setNachname("Fall");
		klara.setGeburtstag(new GregorianCalendar(2000, 4, 1));
		klara.setEintritt(new GregorianCalendar(2015, 8, 1));
		klara.setSchulabschluss(Schulabschluss.MITTLERER_SCHULABSCHLUSS);
		
		Schueler gregor = new Schueler();
		gregor.setVorname("Gregor");
		gregor.setNachname("Janisch");
		gregor.setGeburtstag(new GregorianCalendar(1999, 0, 1));
		gregor.setEintritt(new GregorianCalendar(2016, 0, 2));
		gregor.setSchulabschluss(Schulabschluss.FACHHOCHSCHULREIFE_FACHGEBUNDEN);
		
		Schueler ellen = new Schueler();
		ellen.setVorname("Ellen");
		ellen.setNachname("Lang");
		ellen.setGeburtstag(new GregorianCalendar(1989, 11, 24));
		ellen.setEintritt(new GregorianCalendar(2015, 3, 8));
		ellen.setSchulabschluss(Schulabschluss.MITTELSCHULABSCHLUSS_QUALIFIZIEREND);
		
		Klasse kl12f = new Klasse();
		kl12f.setBezeichnung("12F3FA");
		kl12f.addKlassensprecher(klara);
		
		Klasse kl12v = new Klasse();
		kl12v.setBezeichnung("12V3FA");
		
		
		kl12f.addSchueler(klara);
		kl12f.addSchueler(gregor);
		
		Zusatzangebot linux = new Zusatzangebot();
		linux.setName("Linux");
		linux.setBeschreibung("Die LPIC-1 Zertifizierung ist eine distributionsunabhängige Linux-Zertifizierung " + 
		                      "für angehende Systemadministratoren und Entwickler." + 
				              "Sie richtet sich vor allem an Schülerinnen und Schüler mit technischem Hintergrund. "+ 
		                      "Um das LPIC-1 Zertifikat zu erhalten, " + 
				              "müssen die beiden Prüfungen LPI-101 und LPI-102 abgelegt und bestanden werden.");
		
		Zusatzangebot android = new Zusatzangebot();
		android.setName("Android");
		android.setBeschreibung("Der Kurs \"Android-Programmierung\" läuft seit dem Schuljahr 2013/14 " +
		                        "über ein Online-System. Dabei wird den Schülerinnen und Schülern ermöglicht, " + 
		                        "die Zeitplanung individuell zu gestalten.\n" + 
		                        "Trotz unterschiedlichen Vorkenntnissen, Bedürfnissen und Lernfortschritten " +
		                        "kann so jedem Teilnehmer die volle Aufmerksamkeit und Unterstützung gegeben werden.");
		
		linux.addSchueler(klara);
		linux.addSchueler(gregor);
		gregor.addZusatzangebot(android);
		ellen.addZusatzangebot(android);
		
		
		Lehrkraft huber = new Lehrkraft();
		huber.setNachname("Huber");
		huber.setVorname("Jürgen");
		huber.setKuerzel("Hub");
		huber.setGeburtstag(new GregorianCalendar(1972, 7, 26));
		
		Unterricht u1 = new Unterricht(kl12f, huber, Fach.ANWENDUNGSENTWICKLUNG_UND_PROGRAMMIERUNG);
		Unterricht u2 = new Unterricht(kl12f, huber, Fach.ENGLISCH);
		
		
		em.getTransaction().begin();
		em.persist(klara);
		em.persist(gregor);
		em.persist(ellen);
		em.persist(kl12f);
		em.persist(kl12v);
		em.persist(linux);
		em.persist(android);
		em.persist(u1);
		em.persist(u2);
		em.getTransaction().commit();

		
		Lehrkraft bellenbaum = new Lehrkraft();
		bellenbaum.setNachname("Bellenbaum");
		bellenbaum.setVorname("Mira");
		bellenbaum.setKuerzel("Bel");
		bellenbaum.setGeburtstag(new GregorianCalendar(1999, 8, 1));
		
		em.getTransaction().begin();
		em.persist(bellenbaum);
		em.getTransaction().commit();
		
		System.out.println(bellenbaum.getId());
		
		int lId = bellenbaum.getId();
		
		Lehrkraft gesucht = em.find(Lehrkraft.class, lId);
		System.out.println(gesucht.getVorname() + " " + gesucht.getNachname());
		
		for(int i = lId; i >= 1; i--) {
			gesucht = em.find(Lehrkraft.class, i);
			System.out.println(gesucht.getVorname() + " " + gesucht.getNachname());
		}
		
		em.getTransaction().begin();
		gesucht.setNachname("Glodeanu");
		gesucht.setKuerzel("Gol");
		em.getTransaction().commit();
		
		TypedQuery<Lehrkraft> query = em.createQuery("SELECT l FROM Lehrkraft l", Lehrkraft.class);
		List<Lehrkraft> lehrkraefte = query.getResultList();
		for (Lehrkraft l : lehrkraefte) {
			System.out.println(l.getVorname() + " " + l.getNachname());
		}
		
		em.getTransaction().begin();
		em.remove(gesucht);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
