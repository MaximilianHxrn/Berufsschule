package de.nm.ltxml.core;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;

import de.nm.ltxml.core.bez.ParteiAbg;

public class Partei extends Bezeichnung {
    @XmlAttribute
    String name;
    @XmlElementWrapper(name="parteiabg")
    ArrayList<ParteiAbg> parteiabg;

    Partei() {
        super.id = "??";
        super.bezeichnung = "??";
        this.name = "??";
    }

    public Partei(String id, String name1, String name2) {
        super.id = id;
        this.name = name1;
        super.bezeichnung = name2;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return new StringBuilder()
                   .append("Partei: name=" + this.name)
                   .append(", id=" + super.id)
                   .append(", bezeichnung=" + super.bezeichnung)
                   .toString();
    }

    public Object getSetParteiAbg() {
        return null;
    }
}
