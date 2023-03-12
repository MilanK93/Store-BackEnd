package ftn.jwd59.Prodavnica.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ftn.jwd59.Prodavnica.model.Kategorija;
import ftn.jwd59.Prodavnica.service.KategorijaService;
import ftn.jwd59.Prodavnica.support.KategoijaToKategorijaDto;
import ftn.jwd59.Prodavnica.web.dto.KategorijaDTO;

@RestController
@RequestMapping(value = "/api/kategorije")
@Validated
public class KategorijaController {

	@Autowired
	KategorijaService kategorijaService;

	@Autowired
	KategoijaToKategorijaDto toDto;

	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<KategorijaDTO>> getAll() {

		List<Kategorija> kategorije = kategorijaService.findAll();

		return new ResponseEntity<>(toDto.convert(kategorije), HttpStatus.OK);
	}
}
