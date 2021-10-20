

import java.io.Serializable;

public class UnterrichtId implements Serializable {
	
	private int lehrkraft;
	
	private int klasse;
	
	private Fach fach;
	
	
	public UnterrichtId() {super();}
	public UnterrichtId(Lehrkraft lehrkraft, Klasse klasse, Fach fach) {
		this.klasse = klasse.getId();
		this.lehrkraft = lehrkraft.getId();
		this.fach = fach;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UnterrichtId) {
			UnterrichtId unterrichtId = (UnterrichtId) obj;
			return (klasse == unterrichtId.getKlasse()) && 
			       (lehrkraft == unterrichtId.getLehrkraft()) &&
			       (fach == unterrichtId.getFach());
		}
		return false;
	}
	
	
	@Override
	public int hashCode() {
		long l = klasse * 100000 + lehrkraft + fach.ordinal() * 100000000;
		while (l > Integer.MAX_VALUE) {
			l = (long) (l / 2);
		}
		return (int)l;
	}
	
	
	public int getLehrkraft() {
		return lehrkraft;
	}
	public void setLehrkraft(int lehrkraft) {
		this.lehrkraft = lehrkraft;
	}

	
	public int getKlasse() {
		return klasse;
	}
	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}
	
	
	public Fach getFach() {
		return fach;
	}
	public void setFach(Fach fach) {
		this.fach = fach;
	}
}
