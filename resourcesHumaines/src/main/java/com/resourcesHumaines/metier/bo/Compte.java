/**
 * 
 */
package com.resourcesHumaines.metier.bo;

import java.io.Serializable;

/**
 * une classe dont une instance represente le compte d'un utilisateur
 */
public class Compte implements Serializable,Cloneable{
	
	/**
	 * l'identifiant du compte
	 */
	private Long idCompte;
	
	/**
	 * le login
	 */
	private String login;
	
	/**
	 * lel mot de passe du compte
	 */
	private String password;
	
	/**
	 * le role que possede le proprietaire du compte
	 */
	private Role role = new Role();
	
	/**
	 * constructeur par defaut necessaire pour le mecanisme de reflexion utilise par les frameworks
	 */
	public Compte(){
		
	}

	/**
	 * constructeur pour initialiserl'etat d'un compte
	 * @param login le login du comte
	 * @param password	le mot de passe du compte
	 * @param role le role du compte
	 */
	public Compte(String login, String password, Role role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}

	/**
	 * @return the idCompte
	 */
	public Long getIdCompte() {
		return idCompte;
	}

	/**
	 * @param idCompte the idCompte to set
	 */
	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
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
		return "Compte [idCompte=" + idCompte + ", login=" + login
				+ ", password=" + password + ", role=" + role + "]";
	}
	
	
	//equals et hashcode
	
}
