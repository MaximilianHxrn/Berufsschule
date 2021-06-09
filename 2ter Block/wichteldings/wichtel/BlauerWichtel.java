package wichtel;

import geschenk.*;
import util.Util;

public class BlauerWichtel extends Wichtel{
	
	public BlauerWichtel() {
		super();
	}
	
	public BlauerWichtel(IWichtel wichtel) {
		super(wichtel);
	}

	public void arbeite(IGeschenk g) {
		if (g instanceof Essbares) {
			this.dauer = (int) Math.round(g.getSchwierigkeit() / 2.0);
		} else {
			this.dauer = g.getSchwierigkeit() + 3;
		}
	}
	
	@Override
	public String toString() {
		return Util.createWithSpace(WichtelType.BLAUER_WICHTEL.toString(), super.toString());
	}


}
