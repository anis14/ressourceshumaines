/**
 * 
 */
package com.resourcesHumaines.dao;

import java.io.Serializable;

import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Privilege;

/**
 *c'est une interface qui offre les services de gestion d'access aux donnees pour les objets
 *privilege
 */
public interface PrivilegeDao extends GenericDao<Privilege, Serializable>{
	
	/**
	 * service permettant de recuperer un privilege par son titre
	 * @param pTitre
	 * @return
	 * @throws EntityNotFoundException
	 */
	public Privilege recherchePrivilegeParTitre(String pTitre) throws EntityNotFoundException;

}
