import java.util.ArrayList;

public class Text {
    private ArrayList<Wort> characters;

    public Text() {
        characters = new ArrayList<Wort>();
    }

    public void initWoerter() {
        addWort(new Nicht());
        addWort(new Gut());
    }

    public void addWort(Wort w) {
        characters.add(w);
    }

    public void print() {
        for (Wort c : characters) {
            System.out.println(c.toString() + " ");
        }
    }
}
