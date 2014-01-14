/**
 * 
 */
package com.resourcesHumaines.dao;

import java.io.Serializable;
import java.util.List;

import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.ManagerRH;

/**
 * interface representant les services de gestion d'access aux donnees pour les objets metier 
 * ManaerRH
 */
public interface ManagerRHDao extends GenericDao<ManagerRH, Serializable>{
	
	/**
	 * service pour retrouver l'ensemble des managers RH qui repond a la valeur de motcle
	 * @param pMotCle
	 * @return
	 */
	public List<ManagerRH> rechercheParMotCle(String pMotCle);
	

}
