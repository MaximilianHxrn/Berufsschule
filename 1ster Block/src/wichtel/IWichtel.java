package wichtel;


import geschenk.IGeschenk;

public interface IWichtel extends Comparable<IWichtel>{

	public String toString();

	public boolean arbeiteNoch();

	public void arbeiteWeiter();

	public void arbeite(IGeschenk g);
	
	public String getName();
	
	public final String[] LEXICON = { "ARI", "BOR", "CAR", "DUR", "EORL", "FRI", "GEROS", "HATI", "IOTI",
			"JOLA", "KO", "LE", "MU", "NOR", "OPO", "ROMI", "SETI", "TAZ", "UMA", "VAR", "WEL", "XUL", "YIFI", "ZOTO" };


	public double effizienz();
}
