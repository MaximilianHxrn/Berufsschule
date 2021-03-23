class Abschluss extends Listenelement {
   
   public Listenelement naechsterGeben(){
      return this;
   }
   public Scheibe inhaltGeben(){
      return null;
   }
   public Datenknoten hintenEinfuegen(Scheibe knoteninhalt) { // nur für Warteschlange und Liste notwendig
      return new Datenknoten(this,knoteninhalt);
   }
   public Scheibe inhaltLetzterGeben(Scheibe aktuellerInhalt){ // optional
      return aktuellerInhalt;
   }
   public Listenelement entfernen(Scheibe suchinhalt){ // nur für die Liste notwendig
        return this;
    }
    public Datenknoten datenknotenGeben(Scheibe suchinhalt) { // nur für die Liste notwendig
        return null;
   }
   public int anzahlScheibenGeben(){
      return 0;
   }
   public void listendatenAusgeben(){
   }
   public void reiheZeichnen(int xpos, int ypos){
   }
}
