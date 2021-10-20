

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_lehrkraft")
public class Lehrkraft extends Person {
	
	private final static int LAENGE_KUERZEL = 3;
	
	@Column(length = LAENGE_KUERZEL)
	private String kuerzel;
	
	
	@OneToMany(mappedBy = "lehrkraft")
	private Set<Unterricht> unterrichte = new HashSet<>();
	
	
	
	public Lehrkraft() {
		super();
	}
	public Lehrkraft(String vorname,
	                 String nachname,
	                 Calendar geburtstag,
	                 String kuerzel) {
		super(vorname, nachname, geburtstag);
		this.kuerzel = kuerzel;
	}


	public String getKuerzel() {
		return kuerzel;
	}
	public void setKuerzel(String kuerzel) {
		this.kuerzel = Util.truncateString(kuerzel, LAENGE_KUERZEL);
	}


	public Set<Unterricht> getUnterrichte() {
		return unterrichte;
	}
	public void setUnterrichte(Set<Unterricht> unterrichte) {
		this.unterrichte = unterrichte;
	}

}