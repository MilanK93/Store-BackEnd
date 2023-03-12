package ftn.jwd59.Prodavnica.service;

import org.springframework.data.domain.Page;
import ftn.jwd59.Prodavnica.model.Proizvod;

public interface ProizvodService {

	Proizvod findOneById(Long id);

	Proizvod save(Proizvod proizvod);

	Proizvod update(Proizvod proizvod);

	Proizvod delete(Long id);

	Page<Proizvod> find(Long kategorijaId, Integer minCena, Integer maxCena, Integer pageNo);

	Proizvod findOne(Long id);

}
