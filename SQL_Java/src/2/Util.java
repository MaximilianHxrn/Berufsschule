import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

public class Util {
	
	private static final DateFormat DF = DateFormat.getDateInstance(DateFormat.MEDIUM);

	/**
	 * Stutzt einen String auf die übergebene Länge. Wenn der String kurzer ist, als
	 * die übergebene Länge, wird der String unverändert zurückgegeben.
	 * 
	 * @param s
	 *            zu stutzender String
	 * @param length
	 *            Länge auf die der String gestutzt werden soll.
	 * @return gestutzter String
	 */
	public static String truncateString(String s, int length) {
		if (s.length() <= length) {
			return s;
		} else {
			return s.substring(0, length);
		}
	}

	/**
	 * Führt innerhalb einer Transaktion ein SELECT-Statement (in JPQL) aus und gibt
	 * eine typisierte Liste der Ergebnisse zurück.
	 * 
	 * @param em
	 *            Entitätsmanager in dessen Persistenzkontext das SELECT-Statement
	 *            ausgeführt werden soll.
	 * @param s
	 *            SELECT-Statement in JPQL
	 * @param t
	 *            Typ des Abfrageergebnisses
	 * @return Abfrageergebnisse als typisierte Liste.
	 */
	public static <T> List<T> executeSelect(EntityManager em, String s, Class<T> t) {
		em.getTransaction().begin();
		List<T> resultList = em.createQuery(s, t).getResultList();
		em.getTransaction().commit();
		return resultList;
	}

	/**
	 * Führt innerhalb einer Transaktion ein SELECT-Statement (in JPQL) aus und gibt
	 * eine mit Object[] typisierte Liste der Ergebnisse zurück.
	 * 
	 * @param em
	 *            Entitätsmanager in dessen Persistenzkontext das SELECT-Statement
	 *            ausgeführt werden soll.
	 * @param s
	 *            SELECT-Statement in JPQL
	 * @return Abfrageergebnisse als typisierte Liste.
	 */
	public static List<Object[]> executeSelect(EntityManager em, String s) {
		return executeSelect(em, s, Object[].class);
	}

	/**
	 * Führt innerhalb einer Transaktion ein DELETE-Statement (in JPQL) aus und gibt
	 * die anzahl der betroffenen Entitäten als int zurück.
	 * 
	 * @param em
	 *            Entitätsmanager in dessen Persistenzkontext das DELETE-Statement
	 * @param s
	 *            DELETE-Statement in JPQL
	 * @return
	 */
	public static int executeDelete(EntityManager em, String s) {
		return executeUpdate(em, s);
	}

	/**
	 * Führt innerhalb einer Transaktion ein UPDATE-Statement (in JPQL) aus und gibt
	 * die anzahl der betroffenen Entitäten als int zurück.
	 * 
	 * @param em
	 *            Entitätsmanager in dessen Persistenzkontext das UPDATE-Statement
	 *            ausgeführt werden soll.
	 * @param s
	 *            UPDATE-Statement in JPQL
	 * @return
	 */
	public static int executeUpdate(EntityManager em, String s) {
		em.getTransaction().begin();
		int result = em.createQuery(s).executeUpdate();
		em.getTransaction().commit();
		return result;
	}

	/**
	 * Gibt eine parameterisierte Liste auf der Standardausgabe aus.
	 * 
	 * @param list
	 *            auszugebende Liste
	 */
	public static <T> void printResultList(List<T> list) {
		for (T listElem : list) {
			if (listElem.getClass().isArray()) {
				@SuppressWarnings("unchecked")
				T[] elemArray = (T[]) listElem;
				for (T elem : elemArray) {
					System.out.print(formatDate(elem) + "\t");
				}
			} else {
				System.out.print(formatDate(listElem));
			}
			System.out.println("\n" + "------------------------------------");
		}
	}

	/**
	 * Führt innerhalb einer Transaktion ein SELECT-Statement (in JPQL) aus und gibt
	 * eine die Ergebnisse auf der Standardausgabe aus.
	 * 
	 * @param em
	 *            Entitätsmanager in dessen Persistenzkontext das SELECT-Statement
	 *            ausgeführt werden soll.
	 * @param s
	 *            SELECT-Statement in JPQL
	 * @param t
	 *            Typ des Abfrageergebnisses
	 */
	public static <T> void executeSelectAndPrintResult(EntityManager em, String s, Class<T> t) {
		printResultList(executeSelect(em, s, t));
	}

	/**
	 * Führt innerhalb einer Transaktion ein SELECT-Statement (in JPQL) aus und gibt
	 * eine die Ergebnisse auf der Standardausgabe aus.
	 * 
	 * @param em
	 *            Entitätsmanager in dessen Persistenzkontext das SELECT-Statement
	 *            ausgeführt werden soll.
	 * @param s
	 *            SELECT-Statement in JPQL
	 */
	public static <T> void executeSelectAndPrintResult(EntityManager em, String s) {
		printResultList(executeSelect(em, s));
	}

	/**
	 * Führt innerhalb einer Transaktion ein DELETE-Statement (in JPQL) aus und gibt
	 * die anzahl der betroffenen Entitäten auf der Standardausgabe aus.
	 * 
	 * @param em
	 *            Entitätsmanager in dessen Persistenzkontext das DELETE-Statement
	 *            ausgeführt werden soll.
	 * @param s
	 *            DELETE-Statement in JPQL
	 */
	public static void executeDeleteAndPrintResult(EntityManager em, String s) {
		executeUpdateAndPrintResult(em, s);
	}

	/**
	 * Führt innerhalb einer Transaktion ein UPDATE-Statement (in JPQL) aus und gibt
	 * die anzahl der betroffenen Entitäten auf der Standardausgabe aus.
	 * 
	 * @param em
	 *            Entitätsmanager in dessen Persistenzkontext das UPDATE-Statement
	 *            ausgeführt werden soll.
	 * @param s
	 *            UPDATE-Statement in JPQL
	 */
	public static void executeUpdateAndPrintResult(EntityManager em, String s) {
		System.out.println(executeUpdate(em, s));
	}
	
	private static Object formatDate(Object o) {
		if (o instanceof Calendar) {
			return DF.format(((Calendar) o).getTime());
		}
		return o;
	}
}