package cz.roman.spanek.courses.hibernate.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kontakt", schema = "public")
public class Kontakt implements java.io.Serializable {

	private String cislo;
	private Firma firma;

	public Kontakt() {
	}


	@Id
	@Column(name = "cislo", unique = true, nullable = false, length = 50)
	public String getCislo() {
		return this.cislo;
	}

	public void setCislo(String cislo) {
		this.cislo = cislo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ico", nullable = false)
	public Firma getFirma() {
		return this.firma;
	}

	public void setFirma(Firma firma) {
		this.firma = firma;
	}

}
