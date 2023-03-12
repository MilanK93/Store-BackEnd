package ftn.jwd59.Prodavnica.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Proizvod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String naziv;
	
	@Column(nullable = false)
	private int cena;
	
	@Column(nullable = false)
	private int stanje;
	
	@ManyToOne
	private Kategorija kategorija;
	
	public Proizvod() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getStanje() {
		return stanje;
	}

	public void setStanje(int stanje) {
		this.stanje = stanje;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cena, id, kategorija, naziv, stanje);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proizvod other = (Proizvod) obj;
		return cena == other.cena && Objects.equals(id, other.id) && Objects.equals(kategorija, other.kategorija)
				&& Objects.equals(naziv, other.naziv) && stanje == other.stanje;
	}

	@Override
	public String toString() {
		return "Proizvod [id=" + id + ", naziv=" + naziv + ", cena=" + cena + ", stanje=" + stanje + ", kategorija="
				+ kategorija + "]";
	}
	
}
