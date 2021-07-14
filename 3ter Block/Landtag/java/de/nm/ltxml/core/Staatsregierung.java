package de.nm.ltxml.core;

public class Staatsregierung extends Bezeichnung {
    Staatsregierung() {
        super();
    }

    public Staatsregierung(String id, String name) {
        super();
        super.id = id;
        super.bezeichnung = name;
    }

    public String toString() {
        return new StringBuilder()
                   .append("Staatsregierung: id=" + super.id)
                   .append(", bezeichnung=" + super.bezeichnung)
                   .toString();
    }

    public Object getSetStaatAbg() {
        return null;
    }
}
