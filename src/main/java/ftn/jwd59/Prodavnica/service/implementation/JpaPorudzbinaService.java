package ftn.jwd59.Prodavnica.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ftn.jwd59.Prodavnica.model.Porudzbina;
import ftn.jwd59.Prodavnica.repository.PorudzbinaRepository;
import ftn.jwd59.Prodavnica.service.PorudzbinaService;

@Service
public class JpaPorudzbinaService implements PorudzbinaService{

	@Autowired
	PorudzbinaRepository porudzbinaRepository;

	@Override
	public Porudzbina findOneById(Long id) {
		return porudzbinaRepository.findOneById(id);
	}

	@Override
	public Porudzbina save(Porudzbina porudzbina) {
		return porudzbinaRepository.save(porudzbina);
	}

	@Override
	public List<Porudzbina> findAll() {
		return porudzbinaRepository.findAll();
	}

}
