package com.devChallenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.devChallenge.domain.Pais;
import com.devChallenge.repository.PaisRepository;
import com.devChallenge.service.exception.ObjectNotFoundException;

@Service
public class PaisService {

	@Autowired
	private PaisRepository repo;
	
	public Pais find( Integer id) {
		Optional<Pais>  usr = repo.findById(id);
		
		return usr.orElseThrow(() -> new ObjectNotFoundException("Pais nao encontrado id = " + id));
	}
	
	public Pais insert(Pais pais) {
		pais.setId(null);
		return repo.save(pais);
	}
	
	public Pais update(Pais pais) {
		Pais newPais= find(pais.getId());
		updateData(newPais,pais);
		return repo.save(pais);
	}
	private void updateData(Pais newPais,Pais pais) {
		newPais.setNome(pais.getNome());
		newPais.setCapital(pais.getCapital());
		newPais.setRegiao(pais.getRegiao());
		newPais.setSubRegiao(pais.getSubRegiao());
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	
	public List<Pais> findAll(){
		return repo.findAll();
	}
	
	public Page<Pais> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage, Direction.valueOf(direction), orderBy);
		
		return repo.findAll(pageRequest);
	}
}
