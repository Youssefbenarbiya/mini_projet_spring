package com.youssef.equipes.services;
import java.util.List;

import com.youssef.equipes.entities.Equipe;
public interface EquipeService {
	Equipe saveEquipe(Equipe p);
	Equipe updateEquipe(Equipe p);
	void deleteEquipe(Equipe p);
	void deleteEquipeById(Long id);
	Equipe getEquipe(Long id);
	List<Equipe> getAllEquipes();
}




