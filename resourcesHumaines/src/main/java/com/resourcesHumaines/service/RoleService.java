package com.resourcesHumaines.service;

import java.util.List;

import com.resourcesHumaines.metier.bo.Role;
import com.resourcesHumaines.service.exception.EntityNotFoundSericeException;

/**
 * c est une interface representant les fonctionnalites metier pour la partie administration
 */
public interface RoleService {

	/**
	 * service permettant de creer un profil utilisateur
	 * @throws EntityNotFoundSericeException
	 */
	public void creerProfil(Role pRole) throws EntityNotFoundSericeException;
	
	/**
	 * service pour modifier un profil
	 * @throws EntityNotFoundSericeException
	 */
	public void modifierProfil(Role pRole) throws EntityNotFoundSericeException;
	
	/**
	 * service permettant de supprimer un profil utilisateur
	 * @param pId
	 * @throws EntityNotFoundSericeException
	 */
	public void suprimerProfil(Long pId) throws EntityNotFoundSericeException;
	
	/**
	 * renvoi tous les roles correspondant aux profils de l'application
	 * @return
	 * @throws EntityNotFoundSericeException
	 */
	public List<Role> getAll() throws EntityNotFoundSericeException;
	
	/**
	 * renvoi un role par son ID
	 * @param pId
	 * @return
	 * @throws EntityNotFoundSericeException
	 */
	public Role getById(Long pId) throws EntityNotFoundSericeException;
}
