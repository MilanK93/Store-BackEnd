package ftn.jwd59.Prodavnica.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Porudzbina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int kolicina;
	
	@OneToOne
	Proizvod proizvod;

	public Porudzbina() {
	}

	public Porudzbina(Long id, int kolicina, Proizvod proizvod) {
		this.id = id;
		this.kolicina = kolicina;
		this.proizvod = proizvod;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public Proizvod getProizvod() {
		return proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, kolicina, proizvod);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Porudzbina other = (Porudzbina) obj;
		return Objects.equals(id, other.id) && kolicina == other.kolicina && Objects.equals(proizvod, other.proizvod);
	}

	@Override
	public String toString() {
		return "Porudzbina [id=" + id + ", kolicina=" + kolicina + ", proizvod=" + proizvod + "]";
	}
	
}
