package geschenk;

import util.Util;

public class Essbares extends Geschenk{

	private boolean gesund;
	
	public Essbares() {
		name = ESSBARES[Util.getZufallszahl(ESSBARES.length)-1];
		schwierigkeit = Util.getZufallszahl(10);
		gesund = schwierigkeit % 2 == 0;
	}
	
	@Override
	public String toString() {
		return Util.createWithSpace(super.toString(), "Gesund:", (gesund ? "Ja" : "Nein"));
	}
}
