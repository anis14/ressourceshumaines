package com.resourcesHumaines.metier.bo;

import java.io.Serializable;

public class Competence implements Serializable{

	/**
	 * l'identifiant de la competence
	 */
	private Long idCompetence;
	
	/**
	 * titre dela competence
	 */
	private String titre;
	
	/**
	 * le niveau d'expertise de 1 a 5
	 */
	private int niveauExpertise;
	
	/**
	 * la technologie qui concerne la competence
	 */
	private Technologie technologie;
	
	
	/**
	 * constructeur par defaut necessaire pour le mecanisme de reflexion utilise par les frameworks
	 */
	public Competence() {
		
	}


	/**
	 * constructeur pour initialiser l'etat d'une competence
	 * @param titre titre de la competence
	 * @param niveauExpertise le niveau d'expertise 
	 * @param technologie la technologie 
	 */
	public Competence(String titre, int niveauExpertise, Technologie technologie) {
		super();
		this.titre = titre;
		this.niveauExpertise = niveauExpertise;
		this.technologie = technologie;
	}


	/**
	 * @return the idCompetence
	 */
	public Long getIdCompetence() {
		return idCompetence;
	}


	/**
	 * @param idCompetence the idCompetence to set
	 */
	public void setIdCompetence(Long idCompetence) {
		this.idCompetence = idCompetence;
	}


	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}


	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}


	/**
	 * @return the niveauExpertise
	 */
	public int getNiveauExpertise() {
		return niveauExpertise;
	}


	/**
	 * @param niveauExpertise the niveauExpertise to set
	 */
	public void setNiveauExpertise(int niveauExpertise) {
		this.niveauExpertise = niveauExpertise;
	}


	/**
	 * @return the technologie
	 */
	public Technologie getTechnologie() {
		return technologie;
	}


	/**
	 * @param technologie the technologie to set
	 */
	public void setTechnologie(Technologie technologie) {
		this.technologie = technologie;
	}
	
	
	//equals et hashcode
	
}
