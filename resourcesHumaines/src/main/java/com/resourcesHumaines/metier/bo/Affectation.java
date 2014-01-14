package com.resourcesHumaines.metier.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * un objet de cette classe represente une affectation d'un collaborateur a un manager RH
 */
public class Affectation implements Serializable,Comparable<Affectation>{

	/**
	 * l'identifiant de l'affectation
	 */
	private Long idAffectation;
	
	/**
	 * la date d'affectation du collaborateur au manager RH
	 */
	private Date dateAffectation;
	
	/**
	 * le collaborateur affecte au manager
	 */
	private Collaborateur collaborateur;
	
	/**
	 * le manager manager RH au quelle le collaborateur a ete affecte
	 */
	private ManagerRH managerRH;
	
	private boolean actuelle = true;
	
	/**
	 * constructeur par defaut necessaire pour le mecanisme de reflexion utilise par les frameworks
	 */
	public Affectation() {

	}

	/**
	 * constructeur pour initialiser l'etat d'un objet affectation
	 * @param dateAffectation
	 * @param collaborateur
	 * @param managerRH
	 */
	public Affectation(Date dateAffectation, Collaborateur collaborateur,
			ManagerRH managerRH) {
		super();
		this.dateAffectation = dateAffectation;
		this.collaborateur = collaborateur;
		this.managerRH = managerRH;
	}

	/**
	 * @return the idAffectation
	 */
	public Long getIdAffectation() {
		return idAffectation;
	}

	/**
	 * @param idAffectation the idAffectation to set
	 */
	public void setIdAffectation(Long idAffectation) {
		this.idAffectation = idAffectation;
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
	 * @return the collaborateur
	 */
	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	/**
	 * @param collaborateur the collaborateur to set
	 */
	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	/**
	 * @return the managerRH
	 */
	public ManagerRH getManagerRH() {
		return managerRH;
	}

	/**
	 * @param managerRH the managerRH to set
	 */
	public void setManagerRH(ManagerRH managerRH) {
		this.managerRH = managerRH;
	}

	
	
	/**
	 * @return the actuelle
	 */
	public boolean isActuelle() {
		return actuelle;
	}

	/**
	 * @param actuelle the actuelle to set
	 */
	public void setActuelle(boolean actuelle) {
		this.actuelle = actuelle;
	}

	/**
	 * necessaire pour le trie des tableaux 
	 */
	public int compareTo(Affectation o) {
		return this.dateAffectation.compareTo(o.dateAffectation);
	}
	
	
	//equals et hashcode
	
}
