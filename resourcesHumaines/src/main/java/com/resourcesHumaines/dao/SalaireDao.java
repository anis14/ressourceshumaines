/**
 * 
 */
package com.resourcesHumaines.dao;

import java.io.Serializable;

import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Salaire;

/**
 * interface representant les services de gestion d'access aux donnees pour les objets metier 
 * Salaire
 */
public interface SalaireDao extends GenericDao<Salaire, Serializable>{
	
	/**
	 * methode permettant de retourner le salaire maximum des collaborateurs 
	 * cette valeur est necessaire our initialiser le champs SalaireMax de la recherche avancee
	 * @return
	 * @throws EntityNotFoundException
	 */
	public float getMaxSalaire() throws EntityNotFoundException;

}
