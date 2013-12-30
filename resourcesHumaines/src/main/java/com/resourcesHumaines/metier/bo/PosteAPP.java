/**
 * 
 */
package com.resourcesHumaines.metier.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * un objet de cette classe represente un poste de niveau APP d'un collaborateur
 */
public class PosteAPP implements Serializable{
	
	private Long idPosteApp;
	
	private String titre;
	
	private Date dateAffectation;
	
	private boolean posteActuel;
	
	/**
	 * constructeur par defaut necessaire pour le mecanisme de reflexion utilise par les frameworks
	 */
	public PosteAPP() {

	}

	public PosteAPP(String titre, Date dateAffectation, boolean posteActuel) {
		super();
		this.titre = titre;
		this.dateAffectation = dateAffectation;
		this.posteActuel = posteActuel;
	}

	/**
	 * @return the idPosteApp
	 */
	public Long getIdPosteApp() {
		return idPosteApp;
	}

	/**
	 * @param idPosteApp the idPosteApp to set
	 */
	public void setIdPosteApp(Long idPosteApp) {
		this.idPosteApp = idPosteApp;
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
