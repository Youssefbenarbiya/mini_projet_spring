package com.youssef.equipes.RESTControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.youssef.equipes.entities.Equipe;
import com.youssef.equipes.services.EquipeService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EquipeRESTController {
	
	@Autowired
	EquipeService equipeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Equipe> getAllEquipes() {
	return equipeService.getAllEquipes();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Equipe getEquipeById(@PathVariable("id") Long id) {
	return equipeService.getEquipe(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Equipe createEquipe(@RequestBody Equipe produit) {
	return equipeService.saveEquipe(produit);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Equipe updateEquipe(@RequestBody Equipe produit) {
	return equipeService.updateEquipe(produit);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteEquipe(@PathVariable("id") Long id)
	{
	equipeService.deleteEquipeById(id);
	}
	@RequestMapping(value="/equipeLig/{idCat}",method = RequestMethod.GET)
	public List<Equipe> getEquipesByCatId(@PathVariable("idCat") Long idCat) {
	return equipeService.findByLigueId(idCat);
	}
}
