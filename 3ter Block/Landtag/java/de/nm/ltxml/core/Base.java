package de.nm.ltxml.core;

import javax.xml.bind.annotation.XmlAttribute;

public abstract class Base {
    @XmlAttribute
    protected String id;

    public Base() {
        this.id = "??";
    }

    public Base(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }
}
