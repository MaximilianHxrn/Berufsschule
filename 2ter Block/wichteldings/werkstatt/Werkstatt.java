package werkstatt;

import java.io.*;
import java.util.*;

import geschenk.*;
import wichtel.*;


public class Werkstatt {

	private final int anzahlGeschenke = 1000;
	private final int anzahlWichtel = 30;

	private List<IGeschenk> geschenke; // Die gesamte Wunschliste

	private int geschenknummer = 0; // derzeitig bearbeitetes Geschenk

	private List<IWichtel> wichtel; // Alle arbeitenden Wichtel

	// Basiszeiteinheit der Wichtel
	private int runde = 1;

	public Werkstatt() {
		// Wir leiten die ganze Ausgabe in eine Datei um.
//		try {
//			System.setOut(new PrintStream(new FileOutputStream("target/Werkstattlog.txt")));
//		} catch (Exception e) {
//			System.out.println(e);
//		}

		geschenke = Geschenk.generiereGeschenke(anzahlGeschenke);
		wichtel = Wichtel.generiereWichtel(anzahlWichtel);
	}

	private IGeschenk naechstesGeschenk() {
		if (geschenknummer < geschenke.size())
			return geschenke.get(geschenknummer++);
		return null;
	}

	private boolean sindAlleFertig() {
		if (geschenknummer < geschenke.size())
			return false;
		else
			for (int i = 0; i < wichtel.size(); i++) {
				if (wichtel.get(i).arbeiteNoch())
					return false;
			}
		return true;
	}

	private boolean arbeit() {
		System.out.println("----------------------------------------");
		System.out.println("Runde " + runde++);
		for (int i = 0; i < wichtel.size(); i++) {
			IWichtel w = wichtel.get(i);
			if (w.arbeiteNoch())
				w.arbeiteWeiter();
			else {
				int gNr = geschenknummer;
				IGeschenk g = naechstesGeschenk();
				if (g != null) {
					System.out.println(w + " bearbeitet nun #" + gNr + " \n --> " + g);
					w.arbeite(g);
				}
			}
		}
		return !sindAlleFertig();
	}

	private void zeigeLeistungen() {
		System.out.println("----------------------------------------");
		System.out.println("Leistungsindex: ");
		for (int i = wichtel.size() - 1; i >= 0; i--) {
			if (i == wichtel.size() - 4)
				System.out.println("----------------------------------------");
			IWichtel w = wichtel.get(i);
			System.out.println(wichtel.size() - i + ". Platz: " + w + " mit einer Effizienz von " + w.effizienz()
					+ " Geschenke pro Runde.");
		}
	}

	private void sortiere() {
		Collections.sort(wichtel);
	}

	// Eine Werkstatt wird angelegt, dann werden alle Geschenke bearbeitet,
	// bis die Liste durch ist. Dann sortieren wir die Wichtel nach Effizienz
	// und geben sie entsprechend aus.
	// Momentan auskommentiert, sollte am Schluss alles kompilieren und dem Logfile
	// gleichen.
	// Erstellen Sie bis dahin eigenen Testaufrufe von Methoden.
	public static void main(String[] args) {
		Werkstatt werkstatt = new Werkstatt();
		while (werkstatt.arbeit())
			;
		werkstatt.sortiere();
		werkstatt.zeigeLeistungen();

		// TODO Aufgabe 5): Klonen der drei besten Wichtel
		Wichtel roterSuperWichtel = null;
		Wichtel blauerSuperWichtel = null;
		Wichtel gelberSuperWichtel = null;
		
		for(int i = werkstatt.wichtel.size()-1;i>=0;i--) {
			IWichtel wichtel = werkstatt.wichtel.get(i);
			if(roterSuperWichtel == null && wichtel instanceof RoterWichtel) {
				roterSuperWichtel = new RoterWichtel(wichtel);
			}
			else if(gelberSuperWichtel == null && wichtel instanceof GelberWichtel) {
				gelberSuperWichtel = new GelberWichtel(wichtel);
			}
			else if(blauerSuperWichtel == null && wichtel instanceof BlauerWichtel) {
				blauerSuperWichtel = new BlauerWichtel(wichtel);
			}
		}
		System.out.println("Folgende Wichtel wurden geklont:" + roterSuperWichtel + " " + blauerSuperWichtel + " "
				+ gelberSuperWichtel);
	}
}