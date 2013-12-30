/**
 * 
 */
package com.resourcesHumaines.metier.bo;

import java.io.Serializable;

/**
 *c'est une classe dont les objets representent les permissions des utilisateurs
 */
public class Privilege implements Serializable{

	/**
	 * l'identifiant d'un Privilege
	 */
	private Long idPrivilege;
	
	/**
	 * le titre d'un Privilege
	 */
	private String titre;
	
	/**
	 * constructeur par defaut necessaire pour le mecanisme de reflexion utilise par les frameworks
	 */
	public Privilege(){
		
	}

	/**
	 * constructeur pour initialiser l'etat des objets 
	 * @param titrele titre de privilege
	 */
	public Privilege(String titre) {
		super();
		this.titre = titre;
	}

	/**
	 * @return the idPrivilege
	 */
	public Long getIdPrivilege() {
		return idPrivilege;
	}

	/**
	 * @param idPrivilege the idPrivilege to set
	 */
	public void setIdPrivilege(Long idPrivilege) {
		this.idPrivilege = idPrivilege;
	}

	/**
	 * @return le titre de privilige
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre le titre a setter
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	//equals et hashcode
	
}
