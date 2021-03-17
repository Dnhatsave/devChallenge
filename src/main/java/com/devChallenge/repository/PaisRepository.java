package com.devChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devChallenge.domain.Pais;


@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

	@Transactional(readOnly = true)
	Pais findByNome(String nome);
	
	@Transactional(readOnly = true)
	Pais findByCapital(String capital);
	
	@Transactional(readOnly = true)
	Pais findByRegiao(String regiao);
	
	@Transactional(readOnly = true)
	Pais findBySubRegiao(String subRegiao);
	
	@Transactional(readOnly = true)
	Pais findByArea(String area);
}
