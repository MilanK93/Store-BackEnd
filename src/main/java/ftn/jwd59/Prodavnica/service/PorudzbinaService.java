package ftn.jwd59.Prodavnica.service;

import java.util.List;

import ftn.jwd59.Prodavnica.model.Porudzbina;

public interface PorudzbinaService {

	Porudzbina findOneById(Long id);

	Porudzbina save(Porudzbina porudzbina);

	List<Porudzbina> findAll();

}
