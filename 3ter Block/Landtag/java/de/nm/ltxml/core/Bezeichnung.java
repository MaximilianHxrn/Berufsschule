package de.nm.ltxml.core;

public abstract class Bezeichnung extends Base {
    protected String name;

    Bezeichnung() {
        super();
        super.id = "??";
        this.name = "??";    
    }

    Bezeichnung(String id) {
        super();
        super.id = id;
        this.name = "??";
    }

    Bezeichnung(String id, String name) {
        super();
        super.id = id;
        this.name = name;
    }

    String getBezeichnung() {
        return name;
    }

    void setBezeichnung(String name) {
        this.name = name;
    }

    public String toString() {
        return new StringBuilder()
                   .append("ID: " + super.getId())
                   .append(" Name: " + this.name)
                   .toString();
    }
}
