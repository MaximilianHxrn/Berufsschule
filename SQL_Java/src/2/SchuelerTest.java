import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class SchuelerTest {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(args[0]);
		EntityManager em = emf.createEntityManager();

		// Datenbank mit Werten befüllen
		DBfilling.fillDB(em);
		em.getTransaction().begin();
		TypedQuery<Schueler> schuelerQuery = em.createQuery("SELECT s " + "FROM Schueler AS s", Schueler.class);
		List<Schueler> schuelerList = schuelerQuery.getResultList();
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		for (Schueler s : schuelerList) {
			System.out.println(s.getId() + "\t" + s.getVorname() + "\t" + s.getNachname() + "\t"
					+ df.format(s.getGeburtstag().getTime()) + "\t" + df.format(s.getEintritt().getTime()) + "\t"
					+ s.getSchulabschluss().name());
		}
		em.getTransaction().commit();

		String alleSchueler = "SELECT s " + "FROM Schueler AS s";
		Util.executeSelectAndPrintResult(em, alleSchueler, Schueler.class);

		em.getTransaction().begin();
		Query lehrkraftQuery = em
				.createQuery("SELECT l.id,         " + "       l.vorname,    " + "       l.nachname,   "
						+ "       l.geburtstag, " + "       l.kuerzel     " + "FROM Lehrkraft AS l  ");
		List<Object[]> lehrkraftList = lehrkraftQuery.getResultList();
		df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		for (Object[] o : lehrkraftList) {
			System.out.println(
					o[0] + "\t" + o[1] + "\t" + o[2] + "\t" + df.format(((Calendar) o[3]).getTime()) + "\t" + o[4]);
		}
		em.getTransaction().commit();

		{
			String allePropertysVonSchueler = "SELECT l.id,         " + "       l.vorname,    "
					+ "       l.nachname,   " + "       l.geburtstag, " + "       l.kuerzel     "
					+ "FROM Lehrkraft AS l  ";
			Util.executeSelectAndPrintResult(em, allePropertysVonSchueler);
		}

		// Änderung eines Elements einer ResultList und Persistierung
		// {
		schuelerQuery = em.createQuery("SELECT s " + "FROM Schueler AS s", Schueler.class);
		schuelerList = schuelerQuery.getResultList();
		System.out.println(schuelerList.get(0).getVorname() + " " + schuelerList.get(0).getNachname());
		schuelerList.get(0).setVorname("Ernst");
		// Änderungen auch außerhalb einer Transaktion möglich,
		// da noch im Persistenzkontext des Entitätsmanagers.
		em.getTransaction().begin();
		em.getTransaction().commit();

		alleSchueler = "SELECT s " + "FROM Schueler AS s";
		List<Schueler> schuelers = Util.executeSelect(em, alleSchueler, Schueler.class);
		Schueler s = schuelers.get(0);
		s.setVorname("Ernst");
		System.out.println(s.getVorname() + " " + s.getNachname());
		// Änderungen auch außerhalb einer Transaktion möglich,
		// da noch im Persistenzkontext des Entitätsmanagers.
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.getTransaction().begin();
		Query schuelerDelete = em.createQuery("DELETE FROM Schueler AS s " + "WHERE s.id > 30           ");
		System.out.println("Anzahl gelöschter Schüler: " + schuelerDelete.executeUpdate());
		em.getTransaction().commit();

		String schuelerLoeschen = "DELETE FROM Schueler AS s " + "WHERE s.id > 30           ";
		System.out.println("Anzahl gelöschter Schüler: " + Util.executeDelete(em, schuelerLoeschen));

		// Änderung des Nachnamens aller Lehrkraft-Entitäten auf 'foo'
		// {
		em.getTransaction().begin();
		Query lehrkraftUpdate = em.createQuery("UPDATE Lehrkraft AS l    " + "SET    l.nachname = 'Foo'");
		System.out.println("Anzahl der Geänderten Lehrkräfte: " + lehrkraftUpdate.executeUpdate());
		em.getTransaction().commit();
		String LehrkraftFooUpdate = "UPDATE Lehrkraft AS l    " + "SET    l.nachname = 'Foo'";
		System.out.println("Anzahl der Geänderten Lehrkräfte: " + Util.executeUpdate(em, LehrkraftFooUpdate));

		em.close();
		emf.close();
	}
}