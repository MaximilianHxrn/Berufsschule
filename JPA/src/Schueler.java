

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_schueler")
public class Schueler extends Person {
	
	@OneToOne(mappedBy = "klassensprecher")
	private Klasse klassensprecherKlasse;
	
	@ManyToOne
	private Klasse klasse;
	
	@ManyToMany
	@JoinTable(name = "zt_zusatzangebot_schueler")
	private Set<Zusatzangebot> zusatzangebote = new HashSet<>();
	
	@Temporal(TemporalType.DATE)
	private Calendar eintritt;
	
	@Enumerated(EnumType.ORDINAL)
	private Schulabschluss schulabschluss;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] bild;
	
	
	
	public Klasse getKlassensprecherKlasse() {
		return klassensprecherKlasse;
	}
	public void setKlassensprecherKlasse(Klasse klassensprecherKlasse) {
		this.klassensprecherKlasse = klassensprecherKlasse;
	}
	public void addKlassensprecherKlasse(Klasse klassensprecherKlasse) {
		setKlassensprecherKlasse(klassensprecherKlasse);
		klassensprecherKlasse.setKlassensprecher(this);
	}


	public Klasse getKlasse() {
		return klasse;
	}
	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}
	public void addKlasse(Klasse klasse) {
		this.klasse = klasse;
		klasse.getSchuelers().add(this);
	}


	public Set<Zusatzangebot> getZusatzangebote() {
		return zusatzangebote;
	}
	public void setZusatzangebote(Set<Zusatzangebot> zusatzangebote) {
		this.zusatzangebote = zusatzangebote;
	}
	public void addZusatzangebot(Zusatzangebot zusatzangebot) {
		zusatzangebote.add(zusatzangebot);
		zusatzangebot.getSchuelers().add(this);
	}
	
	
	public Calendar getEintritt() {
		return eintritt;
	}
	public void setEintritt(Calendar eintritt) {
		this.eintritt = eintritt;
	}
	
	
	public Schulabschluss getSchulabschluss() {
		return schulabschluss;
	}
	public void setSchulabschluss(Schulabschluss schulabschluss) {
		this.schulabschluss = schulabschluss;
	}
	
	
	public byte[] getBild() {
		return bild;
	}
	public void setBild(byte[] bild) {
		this.bild = bild;
	}
}