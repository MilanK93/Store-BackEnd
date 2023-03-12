package ftn.jwd59.Prodavnica.service;

import java.util.List;

import ftn.jwd59.Prodavnica.model.Kategorija;

public interface KategorijaService {

	Kategorija findOneById(Long id);

	List<Kategorija> findAll();

}
