package de.nm.ltxml.core.bez;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

import de.nm.ltxml.core.Abgeordneter;
import de.nm.ltxml.core.Bezeichnung;
import de.nm.ltxml.core.Partei;

public class ParteiAbg extends Bezeichnung {

    @XmlElement
    Abgeordneter abg;
    @XmlElement
    Partei partei;
    Date von;
    Date bis;

    public ParteiAbg(String bez) {
        super();
        super.bezeichnung = bez;
    }

    public void setAbg(Abgeordneter abg) {
        this.abg = abg;
    }

    public void setPartei(Partei partei) {
        this.partei = partei;
    }

    public void setVon(Date von) {
        this.von = von;
    }

    public void setBis(Date bis) {
        this.bis = bis;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                   .append("abg=" + abg.toString())
                   .append("partei=" + partei.toString())
                   .toString();
    }
}