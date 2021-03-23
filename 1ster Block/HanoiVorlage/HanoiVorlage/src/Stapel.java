class Stapel {
    private Listenelement erster;
    public Stapel() {
        erster=new Abschluss();
    }
    // fügt einen neuen Knoten mit dem übergebenen Datenelement vorne ein
    public void einfuegen(Scheibe knoteninhalt){  
        Datenknoten neuerKnoten=new Datenknoten(erster,knoteninhalt);
        erster=neuerKnoten;
    }
    // entnimmt das vordere Datenelement und löscht den entsprechenden Knoten
    public Scheibe entnehmen(){  
        Scheibe alterKnoteninhalt=erster.inhaltGeben();
        erster=erster.naechsterGeben();
        return alterKnoteninhalt;
    }
    // prüft, ob der Stapel leer ist
    public boolean istLeer(){
        return (anzahlScheibenGeben()==0);    
    }
    // gibt die Anzahl der Datenelemente (Datenknoten) zurück
    public int anzahlScheibenGeben(){
      return erster.anzahlScheibenGeben();
    }
    // gibt eine Liste der Informationen aller Daten des Stapels aus
    public void alleDatenAusgeben(){
        erster.listendatenAusgeben();
    }
    public void reiheZeichnen(int xpos, int ypos){
       Rechteck r1= new Rechteck();
       Rechteck r2= new Rechteck();
       r1.setzeFarbe("grau");
       r2.setzeFarbe("grau");
       r1.setzeGroesse(2,65); // senkrechte Stange
       r2.setzeGroesse(80,2); // Boden
       r1.setzePosition(xpos-1,ypos-65+10*anzahlScheibenGeben());
       r2.setzePosition(xpos-40,ypos+10*anzahlScheibenGeben());
       r1.sichtbarMachen();
       r2.sichtbarMachen();
       erster.reiheZeichnen(xpos,ypos);
    }
}
