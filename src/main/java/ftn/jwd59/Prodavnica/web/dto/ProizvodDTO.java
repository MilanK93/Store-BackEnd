package ftn.jwd59.Prodavnica.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

public class ProizvodDTO {

	Long id;

	@NotBlank 
	@Length(max=15)
	String naziv;

	@Positive
	int cena;

	@Positive
	int stanje;

	Long kategorijaId;

	String kategorijaNaziv;

	public ProizvodDTO() {
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

	public String getKategorijaNaziv() {
		return kategorijaNaziv;
	}

	public void setKategorijaNaziv(String kategorijaNaziv) {
		this.kategorijaNaziv = kategorijaNaziv;
	}

	public Long getKategorijaId() {
		return kategorijaId;
	}

	public void setKategorijaId(Long kategorijaId) {
		this.kategorijaId = kategorijaId;
	}

}
