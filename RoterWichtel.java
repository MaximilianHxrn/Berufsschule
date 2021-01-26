public class RoterWichtel extends Wichtel {

    RoterWichtel(String name) {
        super(name);
    }

    RoterWichtel(Wichtel w) {
        super(w.toString());
    }

    void arbeite(Geschenk g) {
        if (g instanceof Spielzeug) {
            super.dauer += (g.getSchwierigkeit() / 2);
        }
        else {
            super.dauer += g.getSchwierigkeit();
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Name: " + super.toString()).append("; Farbe: Rot").toString();
    }
}
