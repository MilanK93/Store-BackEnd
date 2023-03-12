package ftn.jwd59.Prodavnica.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.jwd59.Prodavnica.model.Porudzbina;
import ftn.jwd59.Prodavnica.service.PorudzbinaService;
import ftn.jwd59.Prodavnica.service.ProizvodService;
import ftn.jwd59.Prodavnica.web.dto.PorudzbinaDTO;

@Component
public class PorudzbinaDtoToPorudzbina implements Converter<PorudzbinaDTO, Porudzbina>{

	@Autowired
	PorudzbinaService porudzbinaService;

	@Autowired
	ProizvodService proizvodService;

	@Override
	public Porudzbina convert(PorudzbinaDTO source) {
		Porudzbina porudzbina = null;

		if(source.getId() == null) {
			porudzbina = new Porudzbina();
		}else {
			porudzbina = porudzbinaService.findOneById(source.getId());
		}

		if(porudzbina != null) {
			porudzbina.setId(source.getId());
			porudzbina.setKolicina(source.getKolicina());
			porudzbina.setProizvod(proizvodService.findOneById(source.getProizvodId()));
		}

		return porudzbina;
	}

}
