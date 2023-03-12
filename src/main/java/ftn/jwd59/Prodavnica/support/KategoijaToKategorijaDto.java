package ftn.jwd59.Prodavnica.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.jwd59.Prodavnica.model.Kategorija;
import ftn.jwd59.Prodavnica.web.dto.KategorijaDTO;

@Component
public class KategoijaToKategorijaDto implements Converter<Kategorija, KategorijaDTO>{

	@Override
	public KategorijaDTO convert(Kategorija source) {
		KategorijaDTO dto = new KategorijaDTO();

		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());

		return dto;
	}

	public List<KategorijaDTO> convert (List<Kategorija> kategorije) {
		List<KategorijaDTO> dto = new ArrayList<>();
		for(Kategorija itKat: kategorije) {
			dto.add(convert(itKat));
		}

		return dto;
	}
}
