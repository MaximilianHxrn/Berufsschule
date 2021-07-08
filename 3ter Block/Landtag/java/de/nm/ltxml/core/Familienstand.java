package de.nm.ltxml.core;

public class Familienstand extends Bezeichnung {
    Familienstand() {
        super.id = "??";
        super.name = "??";
    }

    Familienstand(String id, String name) {
        super.id = id;
        super.name = name;
    }

    public String toString() {
        return new StringBuilder()
                   .append("Familienstand: id=" + super.id)
                   .append(", bezeichnung=" + super.name)
                   .toString();
    }
}
