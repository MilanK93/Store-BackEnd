package ftn.jwd59.Prodavnica.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ftn.jwd59.Prodavnica.model.Proizvod;
import ftn.jwd59.Prodavnica.repository.ProizvodRepository;
import ftn.jwd59.Prodavnica.service.ProizvodService;

@Service
public class JpaProizvodService implements ProizvodService{

	@Autowired
	ProizvodRepository proizvodRepository;

	@Override
	public Proizvod findOne(Long id) {
		return proizvodRepository.findOneById(id);
	}

	@Override
	public Proizvod findOneById(Long id) {
		return proizvodRepository.findOneById(id);
	}

	@Override
	public Proizvod save(Proizvod proizvod) {
		return proizvodRepository.save(proizvod);
	}

	@Override
	public Proizvod update(Proizvod proizvod) {
		return proizvodRepository.save(proizvod);
	}

	@Override
	public Proizvod delete(Long id) {
		Proizvod proizvod = proizvodRepository.findOneById(id);
		if(proizvod != null){
			proizvod.getKategorija().getProizvodi().remove(proizvod);
			proizvodRepository.deleteById(id);
			return proizvod;
		}
		return null;
	}

	@Override
	public Page<Proizvod> find(Long kategorijaId, Integer minCena, Integer maxCena, Integer pageNo) {
		if(minCena == null) {
			minCena = 0;
		}
		if(maxCena == null) {
			maxCena = Integer.MAX_VALUE;
		}
		if(kategorijaId == null) {
			return proizvodRepository.findByCenaBetween(minCena, maxCena, PageRequest.of(pageNo, 3));
		}

		return proizvodRepository.findByKategorijaIdAndCenaBetween(kategorijaId, minCena, maxCena, PageRequest.of(pageNo, 3));
	}

}
