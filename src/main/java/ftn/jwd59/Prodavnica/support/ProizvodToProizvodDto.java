package ftn.jwd59.Prodavnica.support;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ftn.jwd59.Prodavnica.model.Proizvod;
import ftn.jwd59.Prodavnica.web.dto.ProizvodDTO;

@Component
public class ProizvodToProizvodDto implements Converter<Proizvod, ProizvodDTO>{

	@Override
	public ProizvodDTO convert(Proizvod source) {
		ProizvodDTO dto = new ProizvodDTO();

		dto.setId(source.getId());;
		dto.setNaziv(source.getNaziv());
		dto.setCena(source.getCena());
		dto.setStanje(source.getStanje());

		dto.setKategorijaId(source.getKategorija().getId());
		dto.setKategorijaNaziv(source.getKategorija().getNaziv());

		return dto;
	}

	public List<ProizvodDTO> convert(List<Proizvod> proizvodi) {
		List<ProizvodDTO> dto = new ArrayList<>();

		for(Proizvod itPro: proizvodi) {
			dto.add(convert(itPro));
		}

		return dto;
	}
}
