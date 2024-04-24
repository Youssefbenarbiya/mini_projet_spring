package com.youssef.equipes.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEquipe;
	private String nomEquipe;
	private int rankEquipe;
	private Date dateCreation;
	public Equipe() {
		super();
		}
	
	public Equipe(String nomEquipe, int rankEquipe, Date dateCreation) {
		super();
		this.nomEquipe = nomEquipe;
		this.rankEquipe = rankEquipe;
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Equipe [idEquipe=" + idEquipe + ", nomEquipe=" + nomEquipe + ", rankEquipe=" + rankEquipe
				+ ", dateCreation=" + dateCreation + "]";
	}
	public Long getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}
	public String getNomEquipe() {
		return nomEquipe;
	}
	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}
	public int getRankEquipe() {
		return rankEquipe;
	}
	public void setRankEquipe(int rankEquipe) {
		this.rankEquipe = rankEquipe;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

}
