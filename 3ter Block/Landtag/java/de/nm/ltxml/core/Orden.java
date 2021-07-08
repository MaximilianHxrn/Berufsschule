package de.nm.ltxml.core;

public class Orden extends Bezeichnung {
    
    Orden() {
        super();
    }

    public Orden(String id, String name) {
        super();
        super.id = id;
        super.name = name;
    }

    public String toString() {
        return new StringBuilder()
                   .append("Orden: id=" + super.id)
                   .append(", bezeichnung=" + super.name)
                   .toString();
    }
}
