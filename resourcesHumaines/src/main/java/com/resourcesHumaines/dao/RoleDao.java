/**
 * 
 */
package com.resourcesHumaines.dao;

import java.io.Serializable;

import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Privilege;
import com.resourcesHumaines.metier.bo.Role;

/**
 *c'est une interface qui offre les services de gestion d'access aux donnees pour les objets
 *role
 */
public interface RoleDao extends GenericDao<Role, Serializable>{
	
	/**
	 * service permettant de recuperer un role par son titre
	 * @param pTitre
	 * @return
	 * @throws EntityNotFoundException
	 */
	public Role rechercheRoleParTitre(String pTitre) throws EntityNotFoundException;

}
