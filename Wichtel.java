public abstract class Wichtel {	

    private final String name;
    private int zeitGearbeitet;
    private int anzahlGeschenke;
    protected int dauer;

    Wichtel(String name) {
        this.name = name;
        this.zeitGearbeitet = 0;
        this.anzahlGeschenke = 0;
        dauer = 0;
    }

    public String toString() {
        return new StringBuilder().append(this.name).toString();
    }

    boolean arbeitetNoch() {
        return this.dauer > 0;
    }

    void arbeiteWeiter() {
        if (dauer > 0) {
            dauer--;
            zeitGearbeitet++;
            if (this.dauer == 0) {
                this.anzahlGeschenke++;
            }
        }
    }

    double effizienz() {
        return this.anzahlGeschenke / this.zeitGearbeitet;
    }

    abstract void arbeite(Geschenk g);
}
