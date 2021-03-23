class Hanoi {
    Stapel quelle, hilf, ziel;
    Scheibe[] slice;
    int anzahl;
    int k = 1;

    public Hanoi(int n) {
        anzahl = n;
        slice = new Scheibe[10];
        slice[0] = new Scheibe(40, "rot");
        slice[1] = new Scheibe(36, "blau");
        slice[2] = new Scheibe(32, "gruen");
        slice[3] = new Scheibe(28, "gelb");
        slice[4] = new Scheibe(24, "pink");
        slice[5] = new Scheibe(20, "magenta");
        slice[6] = new Scheibe(16, "rot");
        slice[7] = new Scheibe(12, "blau");
        slice[8] = new Scheibe(8, "gruen");
        slice[9] = new Scheibe(4, "gelb");

        quelle = new Stapel();
        hilf = new Stapel();
        ziel = new Stapel();
        for (int i = 0; i < anzahl; i++) {
            quelle.einfuegen(slice[i]);
        }
    }

    /**
     * Verschiebt n Scheiben von einem Stapel quelle zu einem Stapel ziel und
     * verwendet für das Verschieben den Stapel hilfe. Die Stapel besitzen jeweils
     * die Methode einfuegen und entnehmen (gibt das entnommene Element zurück). Um
     * den aktuellen Stand der Verschiebung zeichnen zu lassen, folgenden Code
     * vewerden: k = k + 1; hanoiZeichnen(100*k);
     * 
     * @param n : Anzahl der Scheiben
     * @param q : Quelle: Datentyp Stapel
     * @param h : Hilfe: Datentyp Stapel
     * @param z : Ziel: Datentyp Stapel
     */
    private void turmVerschieben(int n, Stapel quelle, Stapel hilfe, Stapel ziel) {
        if (n > 0) {
            turmVerschieben(n - 1, quelle, ziel, hilfe);
            ziel.einfuegen(quelle.entnehmen());
            k = k + 1;
            hanoiZeichnen(100 * k);
            if (hilfe.anzahlScheibenGeben() > 0) {
                turmVerschieben(n - 1, hilfe, quelle, ziel);
            }
        }
    }

    public void hanoiturmUmstapeln() {
        datenAusgeben();
        hanoiZeichnen(100); // Teilaufgabe d)
        turmVerschieben(anzahl, quelle, hilf, ziel);
    }

    private void datenAusgeben() {
        System.out.println("----------------------------------------");
        System.out.println("Quellstapel");
        quelle.alleDatenAusgeben();
        System.out.println("Hilfsstapel");
        hilf.alleDatenAusgeben();
        System.out.println("Zielstapel");
        ziel.alleDatenAusgeben();
    }

    private void hanoiZeichnen(int ypos) {
        new Ausgabe("(" + k + ")", 400, ypos - 60, 200, 100);
        quelle.reiheZeichnen(100, ypos - 10 * quelle.anzahlScheibenGeben());
        hilf.reiheZeichnen(200, ypos - 10 * hilf.anzahlScheibenGeben());
        ziel.reiheZeichnen(300, ypos - 10 * ziel.anzahlScheibenGeben());
    }

}
