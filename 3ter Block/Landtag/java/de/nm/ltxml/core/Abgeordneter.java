package de.nm.ltxml.core;

import java.util.Date;
import java.util.HashSet;

import javax.xml.bind.annotation.XmlAttribute;

import de.nm.ltxml.core.bez.KreisAbg;
import de.nm.ltxml.core.bez.OrdenAbg;
import de.nm.ltxml.core.bez.ParFktAbg;
import de.nm.ltxml.core.bez.ParteiAbg;
import de.nm.ltxml.core.bez.StaatAbg;

public class Abgeordneter extends Base {
    String vorname;
    @XmlAttribute
    String name;
    String titel;
    String beruf;
    Date gebam;
    String gebin;
    Date gesam;
    String gesin;
    Familienstand fam;
    Konfession konf;
    byte[] bild;
    HashSet<ParteiAbg> parteiAbgs;
    HashSet<KreisAbg> kreisAbgs;
    HashSet<StaatAbg> staatAbgs;
    HashSet<ParFktAbg> parFktAbgs;
    HashSet<OrdenAbg> ordenAbgs;

    Abgeordneter() {
        super();
        this.vorname = "??";
        this.name = "??";
        this.titel = "??";
        this.beruf = "??";
        this.gebin = "??";
        this.gesin = "??";
        this.parteiAbgs = new HashSet<ParteiAbg>();
        this.kreisAbgs = new HashSet<KreisAbg>();
        this.staatAbgs = new HashSet<StaatAbg>();
        this.parFktAbgs = new HashSet<ParFktAbg>();
        this.ordenAbgs = new HashSet<OrdenAbg>();
    }

    public Abgeordneter(String id, String name, String vorname) {
        super();
        super.id = id;
        this.vorname = vorname;
        this.name = name;
        this.titel = "??";
        this.beruf = "??";
        this.gebin = "??";
        this.gesin = "??";
        this.parteiAbgs = new HashSet<ParteiAbg>();
        this.kreisAbgs = new HashSet<KreisAbg>();
        this.staatAbgs = new HashSet<StaatAbg>();
        this.parFktAbgs = new HashSet<ParFktAbg>();
        this.ordenAbgs = new HashSet<OrdenAbg>();
    }

    String getName() {
        return name;
    }

    String getVorname() {
        return vorname;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setBeruf(String beruf) {
        this.beruf = beruf;
    }

    public void setGebam(Date d) {
        this.gebam = d;
    }

    public void setGebin(String gebin) {
        this.gebin = gebin;
    }

    public void setGesam(Date d) {
        this.gesam = d;
    }

    public void setGesin(String gesin) {
        this.gesin = gesin;
    }

    public String getTitel() {
        return titel;
    }

    public String getBeruf() {
        return beruf;
    }

    public Date getGebam() {
        return gebam;
    }

    public String getGebin() {
        return gebin;
    }

    public Date getGesam() {
        return gesam;
    }

    public String getGesin() {
        return gesin;
    }

    public String toString() {
        return new StringBuilder()
                   .append("Abgeordneter: id=" + super.id)
                   .append(", name=" + this.name)
                   .append(", vorname=" + this.vorname)
                   .append(", titel=" + this.titel)
                   .append(", beruf=" + this.beruf)
                   .append(", gebam=" + this.gebam)
                   .append(", gebin=" + this.gebin)
                   .append(", gesam=" + this.gesam)
                   .append(", gesin=" + this.gesin)
                   .append(", konf=" + konf)
                   .append(", fam=" + fam)
                   .toString();
    }

    public void setFam(Familienstand fam) {
        this.fam = fam;
    }

    public void setKonf(Konfession konf) {
        this.konf = konf;
    }

    public HashSet<ParteiAbg> getSetParteiAbg() {
        return parteiAbgs;
    }

    public void setBild(byte[] bild) {
        this.bild = bild;
    }

    public byte[] getBild() {
        return bild;
    }

    public HashSet<KreisAbg> getSetKreisAbg() {
        return kreisAbgs;
    }

    public HashSet<ParFktAbg> getSetParFktAbg() {
        return parFktAbgs;
    }

    public HashSet<StaatAbg> getSetStaatAbg() {
        return staatAbgs;
    }

    public HashSet<OrdenAbg> getSetOrdenAbg() {
        return ordenAbgs;
    }
}
