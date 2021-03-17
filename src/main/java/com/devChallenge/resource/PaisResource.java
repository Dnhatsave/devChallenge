package com.devChallenge.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devChallenge.domain.Pais;
import com.devChallenge.service.PaisService;

@RestController
@RequestMapping(value = "/paises")
public class PaisResource {

	@Autowired
	private PaisService service;
	
	@RequestMapping(value="/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<Pais> find(@PathVariable Integer id) {
		
		Pais pais = service.find(id);
		return ResponseEntity.ok().body(pais);
	}
	
	@RequestMapping(value="/nome" ,method=RequestMethod.GET)
	public ResponseEntity<Pais> findNome(@RequestParam(value = "value") String nome) {
		
		Pais pais = service.findByNome(nome);
		return ResponseEntity.ok().body(pais);
	}
	
	@RequestMapping(value="/capital" ,method=RequestMethod.GET)
	public ResponseEntity<Pais> findByCapital(@RequestParam(value = "value") String capital) {
		
		Pais pais = service.findByCapital(capital);
		return ResponseEntity.ok().body(pais);
	}
	
	@RequestMapping(value="/regiao" ,method=RequestMethod.GET)
	public ResponseEntity<Pais> findbyRegiao(@RequestParam(value = "value") String regiao) {
		
		Pais pais = service.findByRegiao(regiao);
		return ResponseEntity.ok().body(pais);
	}
	
	@RequestMapping(value="/subregiao" ,method=RequestMethod.GET)
	public ResponseEntity<Pais> findBySubRegiao(@RequestParam(value = "value") String subregiao) {
		
		Pais pais = service.findBySubRegiao(subregiao);
		return ResponseEntity.ok().body(pais);
	}
	
	@RequestMapping(value="/area" ,method=RequestMethod.GET)
	public ResponseEntity<Pais> findByArea(@RequestParam(value = "value") String area) {
		
		Pais pais = service.findByArea(area);
		return ResponseEntity.ok().body(pais);
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Pais>> findAll() {
		
		List<Pais> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> adicionar(@Valid @RequestBody Pais pais){
		pais = service.insert(pais);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(pais.getId()).toUri();
		return ResponseEntity.created(uri).build();	
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Pais pais, @PathVariable Integer id){
		pais.setId(id);
		pais = service.update(pais);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<Pais>> findPage(
			@RequestParam(value="page", defaultValue ="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue ="24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue ="nome") String orderBy,
			@RequestParam(value="direction", defaultValue ="ASC") String direction) {
		
		Page<Pais> list = service.findPage(page,linesPerPage,orderBy,direction);
		return ResponseEntity.ok().body(list);
	}

}
