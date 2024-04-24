package com.youssef.equipes;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.youssef.equipes.entities.Equipe;
import com.youssef.equipes.repo.EquipeRepository;

@SpringBootTest
class EquipesApplicationTests {

	@Autowired
	private EquipeRepository equipeRepository;
	@Test
	public void testCreateEquipe() {
		Equipe equip = new Equipe("PC asus",5,new Date());
		equipeRepository.save(equip);
	}
	@Test
	public void testFindEquipe()
	{
	Equipe p = equipeRepository.findById(1L).get();
	System.out.println(p);
	}
	@Test
	public void testUpdateEquipe()
	{
	Equipe p = equipeRepository.findById(1L).get();
	p.setRankEquipe(6);
	equipeRepository.save(p);
	}
	@Test
	public void testDeleteEquipe()
	{
	equipeRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousEquipes()
	{
	List<Equipe> prods = equipeRepository.findAll();
	for (Equipe p : prods)
	{
	System.out.println(p);
	}
	}

}
