package com.resourcesHumaines.metier.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * un objet de cette classe represente un poste auquel un collaborateur est affecte 
 */
public class Poste implements Serializable{
	
	/**
	 * l'identifiant du poste
	 */
	private Long idPoste;
	
	/**
	 * titre du poste
	 */
	private String titre;
	
	/**
	 * la date d'affectation du collaborateur au poste
	 */
	private Date dateAffectation;
	
	/**
	 * boolean qui est positione a true si le poste est le poste actuel de collaborateur 
	 */
	private boolean posteActuel;
	
	/**
	 * constructeur par defaut necessaire pour le mecanisme de reflexion utilise par les frameworks
	 */
	public Poste() {

	}

	/**
	 * constructeur pour initialiser l'etat d'un objet poste
	 * @param titre le titre du poste
	 * @param dateAffectation la date d'affectation du poste
	 * @param posteActuel
	 */
	public Poste(String titre, Date dateAffectation, boolean posteActuel) {
		super();
		this.titre = titre;
		this.dateAffectation = dateAffectation;
		this.posteActuel = posteActuel;
	}

	/**
	 * @return the idPoste
	 */
	public Long getIdPoste() {
		return idPoste;
	}

	/**
	 * @param idPoste the idPoste to set
	 */
	public void setIdPoste(Long idPoste) {
		this.idPoste = idPoste;
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
	 * @return the posteActuel
	 */
	public boolean isPosteActuel() {
		return posteActuel;
	}

	/**
	 * @param posteActuel the posteActuel to set
	 */
	public void setPosteActuel(boolean posteActuel) {
		this.posteActuel = posteActuel;
	}


	
	//equals et hashcode

}
