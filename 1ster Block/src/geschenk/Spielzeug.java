package geschenk;

import util.Util;

public class Spielzeug extends Geschenk{
	
	private double spannung;
	
	public Spielzeug() {
		name = SPIELZEUG[Util.getZufallszahl(SPIELZEUG.length)-1];
		schwierigkeit = Util.getZufallszahl(10);
		spannung = schwierigkeit * name.length() / 10.0;
	}
	
	@Override
	public String toString() {
		return Util.createWithSpace(super.toString(), "Spannung:", spannung);
	}

}
