package ftn.jwd59.Prodavnica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kategorija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String naziv;
	
	@OneToMany(mappedBy="kategorija",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Proizvod> proizvodi = new ArrayList<>();

	public Kategorija() {
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

	public List<Proizvod> getProizvodi() {
		return proizvodi;
	}

	public void setProizvodi(List<Proizvod> proizvodi) {
		this.proizvodi = proizvodi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, naziv, proizvodi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kategorija other = (Kategorija) obj;
		return Objects.equals(id, other.id) && Objects.equals(naziv, other.naziv)
				&& Objects.equals(proizvodi, other.proizvodi);
	}

	@Override
	public String toString() {
		return "Kategorija [id=" + id + ", naziv=" + naziv + ", proizvodi=" + proizvodi + "]";
	}

}
