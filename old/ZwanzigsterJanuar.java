import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class ZwanzigsterJanuar {

	private static int counter = 0;

	public static void main(String[] args) {
		Temperatur();
	}

	@SuppressWarnings("unused")
	private static void Schaltjahr() {
		Scanner eingabe = new Scanner(System.in);
		System.out.println("Bitte gib ein Jahr ein:");
		int jahr = eingabe.nextInt();
		boolean istSchaltjahr = false;
		if (jahr % 4 == 0 && (jahr % 100 != 0) || jahr % 400 == 0) {
			istSchaltjahr = true;
		}
		if (istSchaltjahr) {
			System.out.println("Das eingebebene Jahr " + jahr + " ist ein Schaltjahr.");
		} else {
			System.out.println("Das eingebene Jahr " + jahr + " ist kein Schaltjahr.");
		}
		eingabe.close();
	}

	@SuppressWarnings("unused")
	private static void UngeradeGerade() {
		System.out.println("Bitte gib eine Zahl ein:");
		Scanner eingabe = new Scanner(System.in);
		int zahl = eingabe.nextInt();
		boolean istGerade = false;
		if (zahl % 2 == 0) {
			istGerade = true;
		} else {
			istGerade = false;
		}
		if (istGerade) {
			System.out.println("Das eingebene Jahr " + zahl + " ist eine gerade Zahl.");
		} else {
			System.out.println("Das eingebene Jahr " + zahl + " ist keine gerade Zahl.");
		}
		eingabe.close();
	}

	@SuppressWarnings("unused")
	private static void Wuerfel() {
		System.out.println("Gib eine Obergrenze an: ");
		Scanner eingabe = new Scanner(System.in);
		int obergrenze = eingabe.nextInt();
		for (int i = 0; i < obergrenze; i++) {
			int ersteZahl = wuerfeln();
			int zweiteZahl = wuerfeln();
			if (ersteZahl == zweiteZahl && ersteZahl == 6 && zweiteZahl == 6) {
				System.out.println("War ein Pasch");
				System.exit(0);
			}
		}
		System.out.println("Es wurden " + counter + " Gewinne erzielt.");
		eingabe.close();
	}

	private static int wuerfeln() {
		Random r = new Random();
		int geworfeneZahl = (r.nextInt(6) + 1);
		if (geworfeneZahl <= 5) {
			System.out.println("Niete");
		} else {
			System.out.println("Gewinn");
			counter++;
		}
		return geworfeneZahl;
	}

	@SuppressWarnings("unused")
	private static void Raten() {
		Random r = new Random();
		int ziel = (r.nextInt(10) + 1);
		Scanner eingabe = new Scanner(System.in);
		while (counter < 4) {
			System.out.println("Bitte gib eine Zahl von 1 bis 10 ein: ");
			int versuch = eingabe.nextInt();
			if (versuch == ziel) {
				System.out.println("Richtig");
				System.exit(0);
			} else {
				System.out.println("\n\n\n\n\n\n");
				if (versuch < ziel) {
					System.out.println("Die Zahl ist kleiner als die Gesuchte.");
				} else {
					System.out.println("Die Zahl ist gr��er als die Gesuchte");
				}
				counter++;
				System.out.println("Niete");
			}
		}
		System.out.println("Verloren; Alle Versuche verbraucht!");
		eingabe.close();
	}

	@SuppressWarnings("unused")
	private static void NichtAergern() {
		Random r = new Random();
		int geworfeneZahl = (r.nextInt(6) + 1);
		if (geworfeneZahl == 6) {
			System.out.println("Ist ne 6, darfst nochmal w�rfeln...");
			geworfeneZahl = (r.nextInt(6) + 1);
			System.out.println("Die zweite geworfene Zahl war " + geworfeneZahl + ".");
			System.out.println("Du hast " + counter + " mal geworfen.");
		} else {
			System.out.println("War keine 6");
			counter++;
			NichtAergern();
		}
	}

	@SuppressWarnings("unused")
	private static void RatenAdvanced() {
		boolean helper = true;
		Random r = new Random();
		Scanner eingabe = new Scanner(System.in);
		System.out.println("Bitte gib eine Obergrenze an: ");
		int obergrenze = eingabe.nextInt();
		int gesuchteZahl = (r.nextInt(obergrenze) + 1);
		counter = 1;
		while (helper) {
			System.out.println("Bitte gib deinen Tipp ab: ");
			int zahl = eingabe.nextInt();
			if (gesuchteZahl == zahl) {
				System.out.println("Richtig!");
				System.out.println("Du hast die Zahl mit " + counter + " Versuch(en) erraten.");
				System.exit(0);
			} else {
				System.out.println("Falsch");
				if (gesuchteZahl < zahl) {
					System.out.println("Die gesuchte Zahl ist kleiner.");
				} else {
					System.out.println("Die gesuchte Zahl ist gr��er.");
				}
				counter++;
			}
		}
		eingabe.close();
	}

	@SuppressWarnings("unused")
	private static void Hangman() {
		String[] woerter = { "Hallo", "Test" };
		Random r = new Random();
		boolean eingabecloser = true;
		boolean buchstabeGefunden = false;
		String gesuchteWortTemp = woerter[r.nextInt()];
		String gesuchteWort = gesuchteWortTemp;
		gesuchteWortTemp = gesuchteWortTemp.toLowerCase();
		Scanner eingabe = new Scanner(System.in);

		System.out.println("Das Spiel beginnt... \n\n");
		System.out.println("      --------");
		System.out.println("      |      |");
		System.out.println("      |");
		System.out.println("      |");
		System.out.println("      |");
		System.out.println("      |");
		System.out.println("  ____|______________");
		System.out.println(" /    |             /|");
		System.out.println("/__________________/ |");
		System.out.println("|                  |/");
		System.out.println("|__________________|");

		while (eingabecloser) {
			System.out.println("Bitte gib eine Buchstaben ein: ");
			char buchstabe = eingabe.next().charAt(0);
			buchstabe = Character.toLowerCase(buchstabe);
			for (int i = 0; i < gesuchteWort.length(); i++) {
				if (buchstabe == gesuchteWort.charAt(i)) {
					buchstabeGefunden = true;
					System.out.println(buchstabe + " war richtig.");
				}
			}
			if (!buchstabeGefunden) {
				counter++;
				if (counter == 6) {
					System.out.println("Verloren. Das Wort w�re" + gesuchteWort + " gewesen.");
				}
				System.out.println(buchstabe + " war falsch.");
				ausgabe(counter);
			} else {
				gesuchteWortTemp = gesuchteWortTemp.replace(Character.toString(buchstabe), "");
			}
			if (gesuchteWortTemp.equals("")) {
				System.out.println("Du hast das Wort " + gesuchteWort + " gefunden.");
				System.exit(0);
			}
			buchstabeGefunden = false;
		}
		eingabe.close();
	}

	private static void ausgabe(int zaehler) {
		System.out.println("      --------");
		System.out.println("      |      |");
		switch (zaehler) {
			case 1: {
				System.out.println("      |      @");
				System.out.println("      |");
				System.out.println("      |");
				System.out.println("      |");
				break;
			}
			case 2: {
				System.out.println("      |      @");
				System.out.println("      |      |");
				System.out.println("      |");
				System.out.println("      |");
				break;
			}
			case 3: {
				System.out.println("      |      @");
				System.out.println("      |     /|");
				System.out.println("      |");
				System.out.println("      |");
				break;
			}
			case 4: {
				System.out.println("      |      @");
				System.out.println("      |     /|\\");
				System.out.println("      |");
				System.out.println("      |");
				break;
			}
			case 5: {
				System.out.println("      |      @");
				System.out.println("      |     /|\\");
				System.out.println("      |      |");
				System.out.println("      |     /");
				break;
			}
			case 6: {
				System.out.println("      |      @");
				System.out.println("      |     /|\\");
				System.out.println("      |      |");
				System.out.println("      |     / \\");
				break;
			}
		}
		System.out.println("  ____|______________");
		System.out.println(" /    |             /|");
		System.out.println("/__________________/ |");
		System.out.println("|                  |/");
		System.out.println("|__________________|");
	}

	@SuppressWarnings("unused")
	private static void Lager() {
		String[][] lager = new String[3][4];
		Scanner eingabe = new Scanner(System.in);
		System.out.println("Bitte bef�llen sie jetzt das Lager: ");

		for (int i = 0; i < 3; i++) {
			switch (i) {
				case 0: {
					System.out.println("Zeile 1:");
					break;
				}
				case 1: {
					System.out.println("Zeile 2:");
					break;
				}
				case 2: {
					System.out.println("Zeile 3:");
					break;
				}
			}
			for (int j = 0; j < 4; j++) {
				lager[i][j] = eingabe.nextLine();
			}
		}
		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				System.out.println("Produkte im Angebot");
			}
			for (int j = 0; j < 4; j++) {
				System.out.print(lager[i][j] + " ");
			}
			System.out.println("");
		}
		eingabe.close();
	}

	@SuppressWarnings("unused")
	private static void Chaos() {
		String[][][] lager = new String[3][3][4];
		Scanner eingabe = new Scanner(System.in);
		while (lager[2][2][3] == null) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 4; k++) {
						System.out.println("Bitte geben sie einen Artikel an: ");
						lager[i][j][k] = eingabe.nextLine();
						System.out.println("Der Artikel \"" + lager[i][j][k] + "\" wurde in: " + "Lager[" + i + "][" + j
								+ "][" + k + "]" + "abgelegt.");
					}
				}
			}
		} /*
			 * for (int i = 0; i < 3; i++) { for (int j = 0; j < 3; j++) { for(int k = 0; k
			 * < 4; k++) { System.out.println("Lager[" + i + "][" + j + "][" + k + "] = " +
			 * lager[i][j][k]); } } }
			 */
		eingabe.close();
	}

	@SuppressWarnings("unused")
	private static void Roommate() {
		double[] temparaturen = { 22.5, 22.4, 22.3, 22.1, 21.9, 21.8, 21.5, 21.4, 21.6, 21.5, 21.5, 21.6, 21.5, 22.5 };
		double ergebnis = 0.0;
		DecimalFormat df = new DecimalFormat("#.##");
		for (int i = 0; i < temparaturen.length - 1; i++) {
			if (temparaturen[i] < 21.5 || temparaturen[i] > 22.5) {
				System.out.println("Die Temperatur am " + (i + 1) + "ten Tag passt nicht zu 22°.");
			}
			if ((temparaturen[i + 1] - temparaturen[i] > 0.7) || (temparaturen[i + 1] - 0.7 >= temparaturen[i])) {
				System.out.println(
						"Die Temperatur am " + (i + 1) + "ten Tag und am " + (i + 2) + "ten Tag passt nicht zu 22°.");
			}
			ergebnis += temparaturen[i];
		}
		System.out.println("Durchschnittliche Temparatur über 2 Wochen: " + df.format(ergebnis / temparaturen.length));

		if (ergebnis / temparaturen.length < 21.5 || ergebnis / temparaturen.length > 22.5) {
			System.out.println("Die durschnittliche Temperatur von 22° C wurde nicht eingehalten.");
		}
	}

	@SuppressWarnings("unused")
	private static void Laenge() {
		for (int i = 1; i < 10000; i++) {
			BigInteger zahl1 = new BigInteger("2");
			zahl1 = zahl1.pow(i);
			int length = zahl1.toString().length();

			// System.out.println("Die Zahl " + zahl1 + " hat eine L�nge von " + length);
			// System.out.println("Bin�r w�re das " + zahl1.toString(2).length());
			if (zahl1.toString(2).length() < length) {
				System.out.println(zahl1.toString(2));
			} else {
				System.out.println("Dezimal war besser " + zahl1);
			}
		}
	}

	@SuppressWarnings("unused")
	private static void Florian() {

		String[] florian = new String[10];

		String[] flo = { "Hallo", "Hallo1" };

		for (String i : flo) {
			System.out.println(i);
		}

	}

	@SuppressWarnings("unused")
	private static void Pruefung() {
		// String nummer = "2718281828458567";
		String nummer = "5490017330499716";
		int[] nummer_to_array = new int[nummer.length()];
		int zwischenergebnis = 0;
		int zwischenergebnis_temp = 0;
		for (int i = 0; i < nummer.length(); i++) {
			char temp = nummer.charAt(i);
			String temp_string = Character.toString(temp);
			nummer_to_array[i] = Integer.parseInt(temp_string);
		}
		for (int i = 0; i < nummer_to_array.length; i++) {
			if (i % 2 == 0) {
				nummer_to_array[i] = nummer_to_array[i] * 2;
			} else {
				nummer_to_array[i] = nummer_to_array[i];
			}
		}
		for (int i = 0; i < nummer_to_array.length - 1; i++) {
			if (nummer_to_array[i] >= 10) {
				String temp_string = Integer.toString(nummer_to_array[i]);
				int temp_length = temp_string.length();
				int[] temp_array = new int[temp_length];
				for (int j = 0; j < temp_length; j++) {
					char temp_Char = temp_string.charAt(j);
					temp_array[j] = Integer.parseInt(Character.toString(temp_Char));
				}
				nummer_to_array[i] = 0;
				for (int k = 0; k < temp_array.length; k++) {
					nummer_to_array[i] += temp_array[k];
				}
			}
		}
		for (int i = 0; i < nummer_to_array.length - 1; i++) {
			zwischenergebnis += nummer_to_array[i];
		}
		zwischenergebnis_temp = zwischenergebnis;
		if (!(zwischenergebnis % 10 == 0)) {
			zwischenergebnis /= 10;
			zwischenergebnis = (zwischenergebnis + 1) * 10;
			zwischenergebnis -= zwischenergebnis_temp;
		}
		char temp_char = nummer.charAt(nummer.length() - 1);
		if (zwischenergebnis == Integer.parseInt(Character.toString(temp_char))) {
			System.out.println("Die Pr�fziffer ist: " + zwischenergebnis + " -> Passt :)");
		} else {
			System.out.println("Passt nicht " + zwischenergebnis + " und " + nummer.charAt(nummer.length() - 1));
		}
	}

	private static void Temperatur() {
		int[] server_no = { 2586, 2588, 2544, 2576, 2596, 2583, 2526, 2593, 2555 };
		int[][] temps = { { 23, 23, 35, 32, 35, 43, 26, 54, 25 }, { 34, 23, 43, 23, 25, 23, 35, 43, 43 },
				{ 21, 35, 43, 36, 43, 43, 42, 34, 34 }, { 36, 27, 41, 43, 23, 32, 38, 39, 32 },
				{ 23, 28, 36, 41, 25, 41, 39, 27, 32 }, { 18, 36, 21, 23, 28, 31, 42, 45, 35 },
				{ 43, 27, 35, 25, 36, 37, 43, 45, 43 } };

		for (int i = 0; i < server_no.length; i++) {
			int counter = 0;
			for (int j = 0; j < 7; j++) {
				if (temps[j][i] > 40) {
					counter++;
				}
				if (counter == 3) {
					System.out.println("Der Server " + server_no[i] + " ist zu heiß gelaufen.");
					break;
				}
			}
		}
	}
}