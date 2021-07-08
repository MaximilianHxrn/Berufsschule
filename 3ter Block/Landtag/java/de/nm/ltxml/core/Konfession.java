package de.nm.ltxml.core;

public class Konfession extends Bezeichnung {
    
    public Konfession(String id, String name) {
        super();
        super.id = id;
        super.name = name;
    }

    public Konfession() {
        super();
    }

    public String toString() {
        return new StringBuilder()
                   .append("Konfession: id=" + super.getId())
                   .append(", bezeichnung=" + this.name)
                   .toString();
    }
}
