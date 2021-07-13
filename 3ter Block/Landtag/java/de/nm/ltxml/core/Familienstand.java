package de.nm.ltxml.core;

public class Familienstand extends Bezeichnung {
    Familienstand() {
        super.id = "??";
        super.bezeichnung = "??";
    }

    Familienstand(String id, String name) {
        super.id = id;
        super.bezeichnung = name;
    }

    public String toString() {
        return new StringBuilder()
                   .append("Familienstand: id=" + super.id)
                   .append(", bezeichnung=" + super.bezeichnung)
                   .toString();
    }
}
