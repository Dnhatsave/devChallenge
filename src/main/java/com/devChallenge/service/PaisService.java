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
	
	public Pais findByNome( String nome) {
		Pais pais = repo.findByNome(nome);

		if(pais == null) {
			throw new  ObjectNotFoundException("Pais nao encontrado nome = " + nome);
		}
		return pais;
	}
	
	public Pais findByCapital( String capital) {
		Pais pais = repo.findByCapital(capital);

		if(pais == null) {
			throw new  ObjectNotFoundException("Capital nao encontrada nome = " + capital);
		}
		return pais;
	}
	
	public Pais findByRegiao( String regiao) {
		Pais pais = repo.findByRegiao(regiao);

		if(pais == null) {
			throw new  ObjectNotFoundException("Regiao nao encontrada nome = " + regiao);
		}
		return pais;
	}
	
	public Pais findBySubRegiao( String subRegiao) {
		Pais pais = repo.findBySubRegiao(subRegiao);

		if(pais == null) {
			throw new  ObjectNotFoundException("SubRegiao nao encontrado nome = " + subRegiao);
		}
		return pais;
	}
	public Pais findByArea( String area) {
		Pais pais = repo.findByArea(area);

		if(pais == null) {
			throw new  ObjectNotFoundException("Area nao encontrado nome = " + area);
		}
		return pais;
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
