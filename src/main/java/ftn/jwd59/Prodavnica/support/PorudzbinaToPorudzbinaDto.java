package ftn.jwd59.Prodavnica.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.jwd59.Prodavnica.model.Porudzbina;
import ftn.jwd59.Prodavnica.web.dto.PorudzbinaDTO;

@Component
public class PorudzbinaToPorudzbinaDto implements Converter<Porudzbina, PorudzbinaDTO>{

	@Override
	public PorudzbinaDTO convert(Porudzbina source) {
		PorudzbinaDTO dto = new PorudzbinaDTO();

		dto.setId(source.getId());
		dto.setKolicina(source.getKolicina());
		dto.setProizvodId(source.getProizvod().getId());
		dto.setProizvodNaziv(source.getProizvod().getNaziv());

		return dto;
	}

	public List<PorudzbinaDTO> convert (List<Porudzbina> porudzbine) {
		List<PorudzbinaDTO> dto = new ArrayList<>();
		for(Porudzbina itPor: porudzbine) {
			dto.add(convert(itPor));
		}

		return dto;
	}

}
