/**
 * 
 */
package com.resourcesHumaines.metier.bo;

import java.io.Serializable;

/**
 * une classe dont une instance represente le compte d'un utilisateur
 */
public class Compte implements Serializable{
	
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
	private Role role;
	
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
	
	//equals et hashcode
	
}
