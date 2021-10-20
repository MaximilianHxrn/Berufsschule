

import java.io.Serializable;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(UnterrichtId.class)
@Table(name = "zt_unterricht")
public class Unterricht implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "klasse")
	private Klasse klasse;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "lehrkraft")
	private Lehrkraft lehrkraft;
	
	@Id
	@Enumerated(EnumType.ORDINAL)
	private Fach fach;
	
	
	
	public Unterricht() {
		super();
	}
	public Unterricht(Klasse    klasse,
	                  Lehrkraft lehrkraft,
	                  Fach      fach) {
		this.klasse = klasse;
		klasse.getUnterrichte().add(this);
		this.lehrkraft = lehrkraft;
		lehrkraft.getUnterrichte().add(this);
		this.fach = fach;
	}
	
	
	public Klasse getKlasse() {
		return klasse;
	}
	
	public Lehrkraft getLehrkraft() {
		return lehrkraft;
	}
	
	public Fach getFach() {
		return fach;
	}
	
}