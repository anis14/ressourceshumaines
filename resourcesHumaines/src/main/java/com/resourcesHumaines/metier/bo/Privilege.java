/**
 * 
 */
package com.resourcesHumaines.metier.bo;

import java.io.Serializable;
import java.util.List;

/**
 *c'est une classe dont les objets representent les permissions des utilisateurs
 */
public class Privilege implements Serializable,Cloneable{

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
		return "Privilege [idPrivilege=" + idPrivilege + ", titre=" + titre
				+ "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null){
			return false;
		}
		if(this == obj){
			return true;
		}
		if(!(obj instanceof Privilege)){
			return false;
		}
		Privilege privilege = (Privilege)obj;
		if(!(idPrivilege.equals(privilege.getIdPrivilege()))){
			return false;
		}
		return true;
		
			
	}
	
	//equals et hashcode
	
}
