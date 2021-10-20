

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_klasse",
       indexes = @Index(columnList = "bezeichnung"))
public class Klasse implements Serializable {
	
	private final static int LAENGE_BEZEICHNUNG  = 7;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(length = LAENGE_BEZEICHNUNG)
	private String bezeichnung;
	
	
	@OneToOne(optional = false)
	@JoinColumn(nullable = false)
	private Schueler klassensprecher;
	
	
	@OneToMany(mappedBy = "klasse")
	private Set<Schueler> schuelers = new HashSet<>();
	
	
	@OneToMany(mappedBy = "klasse")
	private Set<Unterricht> unterrichte = new HashSet<>();
	
	
	
	public int getId() {
		return id;
	}

	
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = Util.truncateString(bezeichnung, LAENGE_BEZEICHNUNG);
	}


	public Schueler getKlassensprecher() {
		return klassensprecher;
	}
	public void setKlassensprecher(Schueler klassensprecher) {
		this.klassensprecher = klassensprecher;
	}
	public void addKlassensprecher(Schueler klassensprecher) {
		setKlassensprecher(klassensprecher);
		klassensprecher.setKlassensprecherKlasse(this);
	}


	public Set<Schueler> getSchuelers() {
		return schuelers;
	}
	public void setSchuelers(Set<Schueler> schuelers) {
		this.schuelers = schuelers;
	}
	public void addSchueler(Schueler schueler) {
		schuelers.add(schueler);
		schueler.setKlasse(this);
	}


	public Set<Unterricht> getUnterrichte() {
		return unterrichte;
	}
	public void setUnterrichte(Set<Unterricht> unterrichte) {
		this.unterrichte = unterrichte;
	}
}