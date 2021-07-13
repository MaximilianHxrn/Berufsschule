package de.nm.ltxml.core;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import de.nm.ltxml.core.bez.ParteiAbg;

@XmlRootElement(name="baylandtag")
public class BayLandtag {

    @XmlElementWrapper(name="abgeordnete")
    @XmlElement(name="abg")
    ArrayList<Abgeordneter> abgeordnete;
    @XmlElementWrapper(name="familie")
    @XmlElement(name="fam")
    ArrayList<Familienstand> fam;
    @XmlElementWrapper(name="konfession")
    @XmlElement(name="konf")
    ArrayList<Konfession> konf;
    @XmlElementWrapper(name="orden")
    @XmlElement(name="ord")
    ArrayList<Orden> orden;
    @XmlElementWrapper(name="parfkt")
    @XmlElement(name="pf")
    ArrayList<ParFkt> parfkt;
    @XmlElementWrapper(name="partei")
    @XmlElement(name="pa")
    ArrayList<Partei> partei;
    @XmlElementWrapper(name="staatsregierung")
    @XmlElement(name="staat")
    ArrayList<Staatsregierung> staat;
    @XmlElementWrapper(name="kreis")
    @XmlElement(name="kr")
    ArrayList<Kreis> kreise;
    @XmlElementWrapper(name="parteiabg")
    @XmlElement(name="pabg")
    ArrayList<ParteiAbg> parteiabg;

    public BayLandtag() {
        this.abgeordnete = new ArrayList<>();
        this.fam = new ArrayList<>();
        this.konf = new ArrayList<>();
        this.orden = new ArrayList<>();
        this.parfkt = new ArrayList<>();
        this.partei = new ArrayList<>();
        this.staat = new ArrayList<>();
        this.kreise = new ArrayList<>();
        this.parteiabg = new ArrayList<>();
    }

    public void add(Familienstand fam) {
       this.fam.add(fam);
    }

    public void add(Konfession konf) {
        this.konf.add(konf);
    }

    public void add(Abgeordneter abg) {
        this.abgeordnete.add(abg);
    }

    public void add(Orden ord) {
        this.orden.add(ord);
    }

    public void add(Staatsregierung sta) {
        this.staat.add(sta);
    }

    public void add(ParFkt par) {
        this.parfkt.add(par);
    }

    public void add(Partei par) {
        this.partei.add(par);
    }

    public void add(Kreis kre) {
        this.kreise.add(kre);
    }

    public void add(ParteiAbg pabg) {
        this.parteiabg.add(pabg);
    }
}
