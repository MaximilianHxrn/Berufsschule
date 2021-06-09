package geschenk;

import util.Util;

public class Kleidung extends Geschenk{
	
	private int eleganz;
	
	public Kleidung() {
		name = KLEIDUNG[Util.getZufallszahl(KLEIDUNG.length)-1];
		schwierigkeit = Util.getZufallszahl(5);
		eleganz = name.length();
	}
	
	@Override
	public String toString() {
		return Util.createWithSpace(super.toString(), "Eleganz: ", eleganz);
	}
	

}
