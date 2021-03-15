public class GelberWichtel extends Wichtel {

    GelberWichtel(String name) {
        super(name);
    }

    GelberWichtel(Wichtel w) {
        super(w.toString());
    }

    void arbeite(Geschenk g) {
        if (g instanceof Kleidung) {
            super.dauer += g.getSchwierigkeit() + 2;
        }
        else {
            super.dauer += g.getSchwierigkeit() + 1;
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).append("; Farbe: Gelb").toString();
    }
}
