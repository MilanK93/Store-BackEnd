package ftn.jwd59.Prodavnica.web.dto;

public class PorudzbinaDTO {

	private Long id;

	private int kolicina;

	private Long proizvodId;

	private String proizvodNaziv;

	public PorudzbinaDTO() {
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

	public Long getProizvodId() {
		return proizvodId;
	}

	public void setProizvodId(Long proizvodId) {
		this.proizvodId = proizvodId;
	}

	public String getProizvodNaziv() {
		return proizvodNaziv;
	}

	public void setProizvodNaziv(String proizvodNaziv) {
		this.proizvodNaziv = proizvodNaziv;
	}

}
