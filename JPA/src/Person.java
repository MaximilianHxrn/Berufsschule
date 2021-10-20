

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "t_person",
indexes = {@Index(columnList = "vname,nname"),
           @Index(columnList = "vname"),
           @Index(columnList = "nname")})
public abstract class Person implements Serializable {
	
	private final static int LAENGE_VORNAME  = 30;
	private final static int LAENGE_NACHNAME = 30;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "vname",
	        length = LAENGE_VORNAME,
	        nullable = false)
	private String vorname;

	
	@Column(name = "nname",
	        length = LAENGE_NACHNAME,
	        nullable = false)
	private String nachname;
	
	@Temporal(TemporalType.DATE)
	private Calendar geburtstag;
	
	
	
	public int getId() {
		return id;
	}

	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = Util.truncateString(vorname, LAENGE_VORNAME);
	}

	
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = Util.truncateString(nachname, LAENGE_NACHNAME);
	}


	public Calendar getGeburtstag() {
		return geburtstag;
	}
	public void setGeburtstag(Calendar geburtstag) {
		this.geburtstag = geburtstag;
	}

}
