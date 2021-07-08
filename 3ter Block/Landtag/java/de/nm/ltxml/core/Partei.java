package de.nm.ltxml.core;

public class Partei extends Bezeichnung {
    String name;

    Partei() {
        super.id = "??";
        super.name = "??";
        this.name = "??";
    }

    public Partei(String id, String name1, String name2) {
        super.id = id;
        this.name = name1;
        super.name = name2;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return new StringBuilder()
                   .append("Partei: name=" + this.name)
                   .append(", id=" + super.id)
                   .append(", bezeichnung=" + super.name)
                   .toString();
    }
}
