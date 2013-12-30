package com.resourcesHumaines.metier.bo;

import java.io.Serializable;
import java.util.List;

/**
 * c'est une classe dont les objets representent les Roles des utilisateurs au sien de l'organisation
 */
public class Role implements Serializable{
	
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
	private List<Privilege> privileges;
	
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
	
	// equals and hashcode
	
}
