package de.nm.ltxml.core;

import javax.xml.bind.annotation.XmlAttribute;

public abstract class Bezeichnung extends Base {
    @XmlAttribute
    protected String bezeichnung;

    public Bezeichnung() {
        super();
        super.id = "??";
        this.bezeichnung = "??";    
    }

    protected Bezeichnung(String id) {
        super();
        super.id = id;
        this.bezeichnung = "??";
    }

    Bezeichnung(String id, String name) {
        super();
        super.id = id;
        this.bezeichnung = name;
    }

    String getBezeichnung() {
        return bezeichnung;
    }

    void setBezeichnung(String name) {
        this.bezeichnung = name;
    }

    public String toString() {
        return new StringBuilder()
                   .append("ID: " + super.getId())
                   .append(" Name: " + this.bezeichnung)
                   .toString();
    }
}
