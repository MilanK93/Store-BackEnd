package ftn.jwd59.Prodavnica.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ftn.jwd59.Prodavnica.model.Kategorija;
import ftn.jwd59.Prodavnica.repository.KategorijaRepository;
import ftn.jwd59.Prodavnica.service.KategorijaService;

@Service
public class JpaKategorijaService implements KategorijaService{

	@Autowired
	KategorijaRepository kategorijaRepository;

	@Override
	public Kategorija findOneById(Long id) {
		return kategorijaRepository.findOneById(id);
	}

	@Override
	public List<Kategorija> findAll() {
		return kategorijaRepository.findAll();
	}

}
