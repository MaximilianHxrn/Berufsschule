package wichtel;

import geschenk.IGeschenk;
import geschenk.Spielzeug;
import util.Util;

public class RoterWichtel extends Wichtel{

	public RoterWichtel(IWichtel wichtel) {
		super(wichtel);
	}
	
	public  RoterWichtel() {
		super();
	}

	@Override
	public void arbeite(IGeschenk g) {
		if(g instanceof Spielzeug) {
			this.dauer = g.getSchwierigkeit();
		}
		else {
			this.dauer = g.getSchwierigkeit()-2;
			if(this.dauer <= 0) {
				dauer = 1;
			}
		}
	}
	
	@Override
	public String toString() {
		return Util.createWithSpace(WichtelType.ROTER_WICHTEL.toString(), super.toString());
	}

}
