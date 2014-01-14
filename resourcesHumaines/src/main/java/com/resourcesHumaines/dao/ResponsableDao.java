package com.resourcesHumaines.dao;

import java.io.Serializable;

import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Responsable;

/**
 *c'est une interface qui offre les services de gestion d'access aux donnees pour les objets
 * Responsable de l'organisation necessaire pour creer un utilisateur de l'application
 * et de realiser l'authentification
 */
public interface ResponsableDao extends GenericDao<Responsable, Serializable>{

	/**
	 * rechercher un Responsable par login
	 * @param pLogin le login de l'utilisateur a rechercher
	 * @return l'utilisateur trouvee
	 * @throws EntityNotFoundException
	 */
	public Responsable RechercheParLogin(String pLogin) throws EntityNotFoundException;
	
	
}
