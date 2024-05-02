package com.youssef.equipes;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.youssef.equipes.entities.Equipe;
import com.youssef.equipes.services.EquipeService;

@SpringBootApplication
public class EquipesApplication implements CommandLineRunner {
	
	@Autowired
	private EquipeService equipeService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(EquipesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//equipeService.saveEquipe(new Equipe("Real madrid", 2, new Date()));
		//equipeService.saveEquipe(new Equipe("Chealse", 3, new Date()));
		//equipeService.saveEquipe(new Equipe("Manchester city", 7, new Date()));	
		repositoryRestConfiguration.exposeIdsFor(Equipe.class);
	}
}
