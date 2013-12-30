package com.resourcesHumaines.metier.bo;

import java.io.Serializable;
import java.util.Date;

public class Salaire implements Serializable{

	private Long idSalaire;
	
	private float salaire;
	
	private Date dateAffectation;
	
	private boolean salaireActuel;
	
	/**
	 * constructeur par defaut necessaire pour le mecanisme de reflexion utilise par les frameworks
	 */
	public Salaire() {
		
	}

	public Salaire(float salaire, Date dateAffectation, boolean salaireActuel) {
		super();
		this.salaire = salaire;
		this.dateAffectation = dateAffectation;
		this.salaireActuel = salaireActuel;
	}

	/**
	 * @return the idSalaire
	 */
	public Long getIdSalaire() {
		return idSalaire;
	}

	/**
	 * @param idSalaire the idSalaire to set
	 */
	public void setIdSalaire(Long idSalaire) {
		this.idSalaire = idSalaire;
	}

	
	/**
	 * @return the salaire
	 */
	public float getSalaire() {
		return salaire;
	}

	/**
	 * @param salaire the salaire to set
	 */
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	/**
	 * @return the dateAffectation
	 */
	public Date getDateAffectation() {
		return dateAffectation;
	}

	/**
	 * @param dateAffectation the dateAffectation to set
	 */
	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	/**
	 * @return the salaireActuel
	 */
	public boolean isSalaireActuel() {
		return salaireActuel;
	}

	/**
	 * @param salaireActuel the salaireActuel to set
	 */
	public void setSalaireActuel(boolean salaireActuel) {
		this.salaireActuel = salaireActuel;
	}
	
	//equals et hashcode
}
