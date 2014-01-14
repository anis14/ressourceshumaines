package com.resourcesHumaines.metier.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * c'est une classe dont les objets representent les Roles des utilisateurs au sien de l'organisation
 */
public class Role implements Serializable,Cloneable{
	
	/**
	 * l'identifiant du role
	 */
	private Long idRole;
	
	/**
	 * l'intitule du role
	 */
	private String intitule;
	
	/**
	 * la liste des permissions qui possedent les utilisateur qui ont un Role donnes 
	 */
	private List<Privilege> privileges = new ArrayList<Privilege>();
	
	/**
	 * constructeur par defaut necessaire pour le mecanisme de reflexion utilise par les frameworks
	 */
	public Role(){
		
	}

	/**
	 * constructeur our initialiser l'intitule du role
	 * @param intitule
	 */
	public Role(String intitule) {
		super();
		this.intitule = intitule;
	}

	/**
	 * @return the idRole
	 */
	public Long getIdRole() {
		return idRole;
	}

	/**
	 * @param idRole the idRole to set
	 */
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	/**
	 * @return the intitule
	 */
	public String getIntitule() {
		return intitule;
	}

	/**
	 * @param intitule the intitule to set
	 */
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	/**
	 * @return the privileges
	 */
	public List<Privilege> getPrivileges() {
		return privileges;
	}

	/**
	 * @param privileges the privileges to set
	 */
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
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
		return "Role [idRole=" + idRole + ", intitule=" + intitule
				+ ", privileges=" + privileges + "]";
	}
	
	
	
	// equals and hashcode
	
}
