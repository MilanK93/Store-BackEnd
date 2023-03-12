package ftn.jwd59.Prodavnica.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ftn.jwd59.Prodavnica.model.Proizvod;
import ftn.jwd59.Prodavnica.service.KategorijaService;
import ftn.jwd59.Prodavnica.service.ProizvodService;
import ftn.jwd59.Prodavnica.web.dto.ProizvodDTO;

@Component
public class ProizvodDtoToProizvod implements Converter<ProizvodDTO, Proizvod>{

	@Autowired
	ProizvodService proizvodService;

	@Autowired
	KategorijaService kategorijaService;

	@Override
	public Proizvod convert(ProizvodDTO source) {

		Proizvod pro = null;

		if(source.getId() == null) {
			pro = new Proizvod();
		}else {
			pro = proizvodService.findOneById(source.getId());
		}

		if(pro != null) {

			pro.setId(source.getId());
			pro.setNaziv(source.getNaziv());
			pro.setCena(source.getCena());
			pro.setStanje(source.getStanje());

			pro.setKategorija(kategorijaService.findOneById(source.getKategorijaId()));

		}

		return pro;
	}

}
