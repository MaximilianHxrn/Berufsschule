package wichtel;

import geschenk.IGeschenk;
import geschenk.Kleidung;
import util.Util;

public class GelberWichtel extends Wichtel{
	
	public GelberWichtel() {
		super();
	}
	
	public GelberWichtel(IWichtel wichtel) {
		super(wichtel);
	}

	@Override
	public void arbeite(IGeschenk g) {
		if(g instanceof Kleidung) {
			this.dauer = g.getSchwierigkeit()+2;
		}
		else 
			this.dauer = g.getSchwierigkeit()+1;
	}	
	
	
	@Override
	public String toString() {
		return Util.createWithSpace(WichtelType.GELBER_WICHTEL.toString(), super.toString());
	}
}
