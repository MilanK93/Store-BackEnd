package ftn.jwd59.Prodavnica.web.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ftn.jwd59.Prodavnica.model.Porudzbina;
import ftn.jwd59.Prodavnica.service.PorudzbinaService;
import ftn.jwd59.Prodavnica.support.PorudzbinaDtoToPorudzbina;
import ftn.jwd59.Prodavnica.support.PorudzbinaToPorudzbinaDto;
import ftn.jwd59.Prodavnica.web.dto.PorudzbinaDTO;


@RestController
@RequestMapping(value = "/api/porudzbine")
@Validated
public class PorudzbinaController {

	@Autowired
	PorudzbinaService porudzbinaService;

	@Autowired
	PorudzbinaToPorudzbinaDto toDto;

	@Autowired
	PorudzbinaDtoToPorudzbina toPorudzbina;

	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<PorudzbinaDTO>> getAll() {

		List<Porudzbina> porudzbine = porudzbinaService.findAll();

		return new ResponseEntity<>(toDto.convert(porudzbine), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PorudzbinaDTO> create(@Valid @RequestBody PorudzbinaDTO dto){
		Porudzbina p = toPorudzbina.convert(dto);
		Porudzbina saved = porudzbinaService.save(p);

		return new ResponseEntity<>(toDto.convert(saved),HttpStatus.CREATED);		
	}


}
