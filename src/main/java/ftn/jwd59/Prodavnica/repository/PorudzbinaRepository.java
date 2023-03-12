package ftn.jwd59.Prodavnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.jwd59.Prodavnica.model.Porudzbina;

@Repository
public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Long>{

	Porudzbina findOneById(Long id);
}
