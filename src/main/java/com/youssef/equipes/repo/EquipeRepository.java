package com.youssef.equipes.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youssef.equipes.entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}
