class Datenknoten extends Listenelement {
   private Listenelement naechster;
   private Scheibe inhalt;
 
   public Datenknoten(Listenelement n, Scheibe i){
      naechster=n;
      inhalt=i;
   }
   public void naechsterSetzen(Listenelement n){
      naechster=n;
   }
   public void inhaltSetzen(Scheibe i){
      inhalt=i;
   }
   public Listenelement naechsterGeben(){
      return naechster;
   }
   public Scheibe inhaltGeben(){
      return inhalt;
   }
     
   /////////////rekursive Listenmethoden////////////////////
   public int anzahlScheibenGeben(){
      return 1+naechster.anzahlScheibenGeben();
   }
   public void listendatenAusgeben(){
      inhalt.datenAusgeben();
      naechster.listendatenAusgeben();
   }
   public void reiheZeichnen(int xpos, int ypos){ // rekursiv
       inhalt.scheibeZeichnen(xpos,ypos); 
       naechster.reiheZeichnen(xpos, ypos+10);
   }
}
