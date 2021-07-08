package de.nm.ltxml.core;

public class Kreis extends Bezeichnung {

    String type;

    Kreis() {
        super();
        type = "?";
    }

    public Kreis(String id, String name) {
        super();
        super.id = id;
        super.name = name;
    }

    public Kreis(String id, String type, String name) {
        super.id = id;
        this.type = type;
        super.name = name;
    }

    String getType() {
        return type;
    }

    public String toString() {
        return new StringBuilder()
                   .append("Kreis: type=" + this.type)
                   .append(", id=" + super.id)
                   .append(", bezeichnung=" + super.name)
                   .toString();
    }
}
