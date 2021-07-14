package de.nm.ltxml.core.bez;

import java.util.Date;
import java.util.HashSet;

import de.nm.ltxml.core.Abgeordneter;
import de.nm.ltxml.core.Bezeichnung;
import de.nm.ltxml.core.Kreis;
import de.nm.ltxml.core.Orden;
import de.nm.ltxml.core.ParFkt;
import de.nm.ltxml.core.Partei;
import de.nm.ltxml.core.Staatsregierung;

public class StaatAbg extends Bezeichnung {

    Date von;
    Date bis;
    HashSet<Abgeordneter> abgeordnete;
    HashSet<Partei> parteien;
    HashSet<Kreis> kreise;
    HashSet<ParFkt> parFkts;
    HashSet<Staatsregierung> staatsregierungen;
    HashSet<Orden> orden;

    public StaatAbg(String string) {
        super(string);
        abgeordnete = new HashSet<>();
        parteien = new HashSet<>();
        kreise = new HashSet<>();
        parFkts = new HashSet<>();
        staatsregierungen = new HashSet<>();
        orden = new HashSet<>();
    }

    public StaatAbg() {
        super();
        abgeordnete = new HashSet<>();
        parteien = new HashSet<>();
        kreise = new HashSet<>();
        parFkts = new HashSet<>();
        staatsregierungen = new HashSet<>();
        orden = new HashSet<>();
    }

    public void setAbg(Abgeordneter abg) {
        abgeordnete.add(abg);
    }

    public void setStaat(Staatsregierung staat) {
    }

    public void setVon(Date von) {
        this.von = von;
    }

    public void setBis(Date bis) {
        this.bis = bis;
    }

}
