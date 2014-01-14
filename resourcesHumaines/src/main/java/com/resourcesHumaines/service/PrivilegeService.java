package com.resourcesHumaines.service;

import java.util.List;

import com.resourcesHumaines.metier.bo.Privilege;
import com.resourcesHumaines.service.exception.EntityNotFoundSericeException;

/**
 * c est une interface representant les fonctionnalites metier pour gerer les privileges
 */
public interface PrivilegeService {

	/**
	 * service permettant de creer une autorisation utilisateur
	 * @throws EntityNotFoundSericeException
	 */
	public void creerPermission(Privilege pPrivilege) throws EntityNotFoundSericeException;
	
	/**
	 * service pour modifier une autorisation
	 * @throws EntityNotFoundSericeException
	 */
	public void modifierPermission(Privilege pPrivilege) throws EntityNotFoundSericeException;
	
	/**
	 * service permettant de supprimer une autorisation utilisateur
	 * @param pId
	 * @throws EntityNotFoundSericeException
	 */
	public void suprimerPermission(Long pId) throws EntityNotFoundSericeException;
	
	/**
	 * renvoi tous les permissions de l'application
	 * @return
	 * @throws EntityNotFoundSericeException
	 */
	public List<Privilege> getAll() throws EntityNotFoundSericeException;
	
	/**
	 * renvoi un role par son ID
	 * @param pId
	 * @return
	 * @throws EntityNotFoundSericeException
	 */
	public Privilege getById(Long pId) throws EntityNotFoundSericeException;
}
