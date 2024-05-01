package com.youssef.equipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.youssef.equipes.entities.Equipe;
import com.youssef.equipes.services.EquipeService;

@Controller
public class EquipeController {
	@Autowired
	EquipeService equipeService;
	
	@RequestMapping("/ListeEquipes")
	public String listeEquipes(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<Equipe> prods = equipeService.getAllEquipesParPage(page, size);
		modelMap.addAttribute("equipes", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeEquipes";
	
	
	
	}
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createEquipe";
	}
	@RequestMapping("/saveEquipe")
	public String saveEquipe(@ModelAttribute("equipe") Equipe equipe,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date));
	equipe.setDateCreation(dateCreation);
	Equipe saveEquipe = equipeService.saveEquipe(equipe);
	String msg ="equipe enregistré avec Id "+saveEquipe.getIdEquipe();
	modelMap.addAttribute("msg", msg);
	return "createEquipe";
	}
	@RequestMapping("/supprimerEquipe")
	public String supprimerEquipe(@RequestParam("id") Long id,
	ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	equipeService.deleteEquipeById(id);
	Page<Equipe> prods = equipeService.getAllEquipesParPage(page,size);
			modelMap.addAttribute("equipes", prods);
			modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);

			return "listeEquipes";
	}
	@RequestMapping("/modifierEquipe")
	public String editerEquipe(@RequestParam("id") Long id,
	ModelMap modelMap)
	{
	Equipe p= equipeService.getEquipe(id);
	modelMap.addAttribute("equipe", p);
	return "editerEquipe";
	}
	@RequestMapping("/updateEquipe")
	public String updateEquipe(@ModelAttribute("equipe") Equipe
	equipe, @RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date));
	equipe.setDateCreation(dateCreation);
	equipeService.updateEquipe(equipe);
	List<Equipe> prods = equipeService.getAllEquipes();
	modelMap.addAttribute("equipes", prods);
	return "listeEquipes";
	}
	}

