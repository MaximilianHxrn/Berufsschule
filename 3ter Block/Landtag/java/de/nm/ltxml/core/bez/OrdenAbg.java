package de.nm.ltxml.core.bez;

import java.util.HashSet;

import de.nm.ltxml.core.Abgeordneter;
import de.nm.ltxml.core.Bezeichnung;
import de.nm.ltxml.core.Kreis;
import de.nm.ltxml.core.Orden;
import de.nm.ltxml.core.ParFkt;
import de.nm.ltxml.core.Partei;
import de.nm.ltxml.core.Staatsregierung;

public class OrdenAbg extends Bezeichnung {

    HashSet<Abgeordneter> abgeordnete;
    HashSet<Partei> parteien;
    HashSet<Kreis> kreise;
    HashSet<ParFkt> parFkts;
    HashSet<Staatsregierung> staatsregierungen;
    HashSet<Orden> orden;

    public OrdenAbg(String string) {
        super(string);
        abgeordnete = new HashSet<>();
        parteien = new HashSet<>();
        kreise = new HashSet<>();
        parFkts = new HashSet<>();
        staatsregierungen = new HashSet<>();
        orden = new HashSet<>();
    }

    public OrdenAbg() {
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

    public void setOrden(Orden ord) {
        orden.add(ord);
    }
    
}
