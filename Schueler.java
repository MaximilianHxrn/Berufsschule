import java.util.Arrays;

public class Schueler {
    private final String name;
    private String adresse;
    private int anzahl_Kurse;
    private String[] kurse = { "" };
    private int[] noten = { 0 };
    private static int anzahlSchueler = 0;

    public Schueler(String name, String adresse) {
        this.name = name;
        this.adresse = adresse;
        anzahl_Kurse = 0;
        kurse = new String[1];
        noten = new int[1];
        anzahlSchueler++;
    }

    public int gebAnzahl() {
        return anzahlSchueler;
    }

    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Name: " + name + " \nAdresse: " + adresse;
    }

    public void addKursNote(String kurs, int note) {
        anzahl_Kurse++;
        String[] temp_kurse = new String[anzahl_Kurse];
        int[] temp_noten = new int[anzahl_Kurse];
        temp_kurse = Arrays.copyOf(kurse, anzahl_Kurse);
        temp_noten = Arrays.copyOf(noten, anzahl_Kurse);
        temp_kurse[anzahl_Kurse - 1] = kurs;
        temp_noten[anzahl_Kurse - 1] = note;
        kurse = temp_kurse.clone();
        noten = temp_noten.clone();
    }

    public void druckeNoten() {
        for (int i = 0; i < noten.length; i++) {
            System.out.println(kurse[i] + ": " + noten[i]);
        }
    }

    public double getDurchschnitstsnote() {
        double temp_sum = 0.0;
        for (int n : noten) {
            temp_sum += n;
        }
        return temp_sum / noten.length;
    }
}
