class Scheibe {
   int radius;
   String farbe;
         
   public Scheibe(int r, String f){
       radius=r;
       farbe=f;
   }
   public int breiteGeben(){
       return radius*2;
   }
   public void datenAusgeben() {
       System.out.println("             |"+radius+"|"+farbe+"|");
   }
   public void scheibeZeichnen(int xpos,int ypos){
       Rechteck r1= new Rechteck();
       Rechteck r2= new Rechteck();
       r1.setzeFarbe(farbe);
       r2.setzeFarbe(farbe);
       r1.setzeGroesse(radius,10);
       r2.setzeGroesse(radius,10);
       r1.setzePosition(xpos-radius,ypos);
       r2.setzePosition(xpos,ypos);
       r1.sichtbarMachen();
       r2.sichtbarMachen();
   }
 }