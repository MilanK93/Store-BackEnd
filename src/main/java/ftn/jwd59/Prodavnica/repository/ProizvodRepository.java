package ftn.jwd59.Prodavnica.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.jwd59.Prodavnica.model.Proizvod;

@Repository
public interface ProizvodRepository extends JpaRepository<Proizvod, Long>{

	Proizvod findOneById(Long id);

	Page<Proizvod> findByKategorijaIdAndCenaBetween(Long kategorijaId, Integer minCena, Integer maxCena, Pageable p);

	Page<Proizvod> findByCenaBetween(Integer minCena, Integer maxCena, Pageable p);



}
