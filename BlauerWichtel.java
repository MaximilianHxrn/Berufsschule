public class BlauerWichtel extends Wichtel {

    BlauerWichtel(String name) {
        super(name);
    }
    
    BlauerWichtel(Wichtel w) {
        super(w.toString());
    }

    void arbeite(Geschenk g) {
        if (g instanceof Essbares) {
            super.dauer += (g.getSchwierigkeit() / 2);
        }
        else {
            super.dauer += g.getSchwierigkeit() + 3;
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).append("; Farbe: Blau").toString();
    }
}
 