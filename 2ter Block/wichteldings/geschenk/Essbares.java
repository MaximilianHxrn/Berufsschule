package geschenk;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import util.Util;

public class Essbares extends Geschenk{

	private boolean gesund;
	
	public Essbares() {
		name = ESSBARES[Util.getZufallszahl(ESSBARES.length)-1];
		schwierigkeit = Util.getZufallszahl(10);
		gesund = schwierigkeit % 2 == 0;
		ArrayList<String> test = new ArrayList<String>();
		ListIterator<String> t = test.listIterator();
	}
	
	@Override
	public String toString() {
		return Util.createWithSpace(super.toString(), "Gesund:", (gesund ? "Ja" : "Nein"));
	}
	
}
