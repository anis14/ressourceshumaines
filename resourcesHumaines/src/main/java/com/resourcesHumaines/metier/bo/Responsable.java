/**
 * 
 */
package com.resourcesHumaines.metier.bo;

import java.io.Serializable;

/**
 * un objet de cette classe represente un responsable de l'organisation
 */
public class Responsable implements Serializable,Cloneable{

	/**
	 * l'identifiant du responsable
	 */
	private Long idResponsable;
	
	/**
	 * le nom du responsable
	 */
	private String nom;
	
	/**
	 * le prenom du responsable
	 */
	private String prenom;
	
	/**
	 * l'email du responsable
	 */
	private String email;
	
	/**
	 * le compte du responsable
	 */
	private Compte compte;
	
	/**
	 * constructeur par defaut necessaire pour le mecanisme de reflexion utilise par les frameworks
	 */
	public Responsable(){
		
	}

	/**
	 * constructeur pour initialiser l'etat de l'objet
	 * @param nom le nom du responsable 
	 * @param prenom le renom du responsable
	 * @param email l'email du responsable
	 * @param compte le compte du responsable
	 */
	public Responsable(String nom, String prenom, String email, Compte compte) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.compte = compte;
	}

	/**
	 * @return the idResponsable
	 */
	public Long getIdResponsable() {
		return idResponsable;
	}

	/**
	 * @param idResponsable the idResponsable to set
	 */
	public void setIdResponsable(Long idResponsable) {
		this.idResponsable = idResponsable;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	/**
	 * methode de clone pour que son appel lors d'une affectation engendre l'affectation de la reference
	 *  d'une nouvelle instance et non pas la reference du meme objet
	 */
	@Override
	public Object clone() {
    	Object o = null;
    	try {
      		// On récupère l'instance à renvoyer par l'appel de la 
      		// méthode super.clone()
      		o = super.clone();
    	} catch(CloneNotSupportedException cnse) {
      		// Ne devrait jamais arriver car nous implémentons 
      		// l'interface Cloneable
      		cnse.printStackTrace(System.err);
	    }
	    // on renvoie le clone
	    return o;
  	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Responsable [idResponsable=" + idResponsable + ", nom=" + nom
				+ ", prenom=" + prenom + ", email=" + email + ", compte="
				+ compte + "]";
	}
	
	
	//equals et hashcode
	
}
