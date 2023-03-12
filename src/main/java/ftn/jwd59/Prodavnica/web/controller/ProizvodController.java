package ftn.jwd59.Prodavnica.web.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ftn.jwd59.Prodavnica.model.Proizvod;
import ftn.jwd59.Prodavnica.service.ProizvodService;
import ftn.jwd59.Prodavnica.support.ProizvodDtoToProizvod;
import ftn.jwd59.Prodavnica.support.ProizvodToProizvodDto;
import ftn.jwd59.Prodavnica.web.dto.ProizvodDTO;


@RestController
@RequestMapping(value="/api/proizvodi")
@Validated
public class ProizvodController {

	@Autowired
	ProizvodService proizvodService;

	@Autowired
	ProizvodToProizvodDto toDto;

	@Autowired
	ProizvodDtoToProizvod toProizvod;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProizvodDTO> create(@Valid @RequestBody ProizvodDTO dto) {
		Proizvod P = toProizvod.convert(dto);
		Proizvod saved = proizvodService.save(P);

		return new ResponseEntity<>(toDto.convert(saved), HttpStatus.CREATED);
	}

	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<ProizvodDTO> getOne(@PathVariable Long id){
		Proizvod proizvod = proizvodService.findOneById(id);

		if(proizvod != null) {
			return new ResponseEntity<>(toDto.convert(proizvod), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProizvodDTO> update(@PathVariable Long id, @Valid @RequestBody ProizvodDTO dto){

		if(!id.equals(dto.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Proizvod P = toProizvod.convert(dto);
		Proizvod saved = proizvodService.save(P);

		return new ResponseEntity<>(toDto.convert(saved),HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Proizvod P = proizvodService.delete(id);

		if(P != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<ProizvodDTO>> getAll(
			@RequestParam(required = false) Long kategorijaId,
			@RequestParam(required = false) Integer minCena,
			@RequestParam(required = false) Integer maxCena,
			@RequestParam(value= "pageNo", defaultValue ="0") Integer pageNo){

		Page<Proizvod> page= proizvodService.find(kategorijaId, minCena, maxCena, pageNo);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages",Integer.toString(page.getTotalPages()));

		return new ResponseEntity<>(toDto.convert(page.getContent()), headers, HttpStatus.OK);

	}
}
