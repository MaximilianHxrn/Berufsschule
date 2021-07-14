package de.nm.ltxml.core.bez;

import java.util.Date;
import java.util.HashSet;

import javax.xml.bind.annotation.XmlElement;

import de.nm.ltxml.core.Abgeordneter;
import de.nm.ltxml.core.Bezeichnung;
import de.nm.ltxml.core.Kreis;
import de.nm.ltxml.core.Orden;
import de.nm.ltxml.core.ParFkt;
import de.nm.ltxml.core.Partei;
import de.nm.ltxml.core.Staatsregierung;

public class ParteiAbg extends Bezeichnung {

    @XmlElement
    HashSet<Abgeordneter> abgeordnete;
    @XmlElement
    Partei partei;
    Date von;
    Date bis;
    Kreis kreis;
    ParFkt parFkt;
    Staatsregierung staatsregierung;
    Orden orden;

    public ParteiAbg(String bez) {
        super(bez);
        this.abgeordnete = new HashSet<>();
    }

    public ParteiAbg() {
        super();
        this.abgeordnete = new HashSet<>();
    }

    public void setAbg(Abgeordneter abg) {
        abgeordnete.add(abg);
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
                   .append("ParteiAbg: id=" + this.id)
                   .append(", abg=" + abgeordnete.toString())
                   .append(", partei=" + partei.toString())
                   .append(", von=" + this.von)
                   .append(", bis=" + this.bis)
                   .toString();
    }
}