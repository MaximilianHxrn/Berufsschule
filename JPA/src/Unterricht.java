

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
	@Enumerated(EnumType.STRING)
	private Fach fach;
	
	
	
	public Unterricht() {super();}
	public Unterricht(Klasse k, Lehrkraft l, Fach f) {
		klasse = k;
		k.getUnterrichte().add(this);
		lehrkraft = l;
		l.getUnterrichte().add(this);
		fach = f;
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
