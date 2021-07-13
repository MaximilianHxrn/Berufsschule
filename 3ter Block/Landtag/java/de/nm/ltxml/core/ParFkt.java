package de.nm.ltxml.core;

public class ParFkt extends Bezeichnung {
    ParFkt() {
        super();
    }

    public ParFkt(String id, String name) {
        super();
        super.id = id;
        super.bezeichnung = name;
    }

    public String toString() {
        return new StringBuilder()
                   .append("ParFkt: id=" + super.id)
                   .append(", bezeichnung=" + super.bezeichnung)
                   .toString();
    }
}
