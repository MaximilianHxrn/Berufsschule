package de.nm.ltxml.core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BayLandtag {

    @XmlElement
    Abgeordneter abgeordnete;/*

    public void add(Familienstand fam) {
        for (Abgeordneter abg : abgeordnete) {
            if (abg.id.equals(fam.id)) {
                abg.setFam(fam);
            }
        }
    }

    public void add(Konfession konf) {
        for (Abgeordneter abg : abgeordnete) {
            if (abg.id.equals(konf.id)) {
                abg.setKonf(konf);
            }
        }
    }

    public void add(Abgeordneter abg) {
        abgeordnete.add(abg);
    }*/

    // TODO

}
