package com.resourcesHumaines.service;

import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Responsable;
import com.resourcesHumaines.service.exception.DuplicateLoginException;
import com.resourcesHumaines.service.exception.EntityNotFoundSericeException;

public interface ResponsableService {

	/**
	 * cette methode permet de creer un compte
	 * @param pResponsable l'utilisateur qui veut creer le compte
	 * @throws EntityNotFoundSericeException
	 * @throws DuplicateLoginException 
	 */
	public void creerCompte(Responsable pResponsable) throws EntityNotFoundSericeException, DuplicateLoginException;

}
