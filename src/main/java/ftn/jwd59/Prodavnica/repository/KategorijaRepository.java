package ftn.jwd59.Prodavnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.jwd59.Prodavnica.model.Kategorija;

@Repository
public interface KategorijaRepository extends JpaRepository<Kategorija, Long>{

	Kategorija findOneById(Long id);

}
