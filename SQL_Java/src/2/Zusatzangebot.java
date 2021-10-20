

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_zusatzangebot")
public class Zusatzangebot implements Serializable {
	
	private final static int LAENGE_NAME = 25;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = LAENGE_NAME)
	private String name;

	@Lob
	private String beschreibung;
	
	@ManyToMany(mappedBy = "zusatzangebote")
	private Set<Schueler> schuelers = new HashSet<>();
	
	
	
	public Zusatzangebot() {
		super();
	}
	public Zusatzangebot(String name, String beschreibung) {
		super();
		this.name = name;
		this.beschreibung = beschreibung;
	}



	public int getId() {
		return id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = Util.truncateString(name, LAENGE_NAME);
	}
	
	
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}


	public Set<Schueler> getSchuelers() {
		return schuelers;
	}
	public void setSchuelers(Set<Schueler> schuelers) {
		this.schuelers = schuelers;
	}
	public void addSchueler(Schueler schueler) {
		schuelers.add(schueler);
		schueler.getZusatzangebote().add(this);
	}

}