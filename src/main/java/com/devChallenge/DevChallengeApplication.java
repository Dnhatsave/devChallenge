package com.devChallenge;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devChallenge.domain.Pais;
import com.devChallenge.repository.PaisRepository;

@SpringBootApplication
public class DevChallengeApplication  implements CommandLineRunner{

	@Autowired
	private PaisRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(DevChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
				
		
		Pais moz = new Pais(null, "Mozambique", "Maputo", "sul", "sudeste", "Baixa");
		Pais rsa = new Pais(null, "South Africa", "NelsPruit", "sul", "sudeste", "Mpumalanga");

		
		
		repo.saveAll(Arrays.asList(moz,rsa));
		
		
		
		
	}

}
