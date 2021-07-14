package de.nm.ltxml.core;

import javax.xml.bind.annotation.XmlAttribute;

public class Kreis extends Bezeichnung {
    @XmlAttribute
    String type;

    Kreis() {
        super();
        type = "?";
    }

    public Kreis(String id, String name) {
        super();
        super.id = id;
        super.bezeichnung = name;
    }

    public Kreis(String id, String type, String name) {
        super.id = id;
        this.type = type;
        super.bezeichnung = name;
    }

    String getType() {
        return type;
    }

    public String toString() {
        return new StringBuilder()
                   .append("Kreis: type=" + this.type)
                   .append(", id=" + super.id)
                   .append(", bezeichnung=" + super.bezeichnung)
                   .toString();
    }

    public Object getSetKreisAbg() {
        return null;
    }
}
