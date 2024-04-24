package com.youssef.equipes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youssef.equipes.entities.Equipe;
import com.youssef.equipes.repo.EquipeRepository;

@Service
public class EquipeServiceImpl implements EquipeService{
	@Autowired
	EquipeRepository equipeRepository;
	@Override
	public Equipe saveEquipe(Equipe p) {
		// TODO Auto-generated method stub
		return equipeRepository.save(p);
	}

	@Override
	public Equipe updateEquipe(Equipe p) {
		// TODO Auto-generated method stub
		return equipeRepository.save(p);
	}

	@Override
	public void deleteEquipe(Equipe p) {
		// TODO Auto-generated method stub
		equipeRepository.delete(p);
	}

	@Override
	public void deleteEquipeById(Long id) {
		equipeRepository.deleteById(id);		
	}

	@Override
	public Equipe getEquipe(Long id) {
		// TODO Auto-generated method stub
		return equipeRepository.findById(id).get();
	}

	@Override
	public List<Equipe> getAllEquipes() {
		// TODO Auto-generated method stub
		return equipeRepository.findAll();
	}
	
}
