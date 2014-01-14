/**
 * 
 */
package com.resourcesHumaines.dao.impl;

import java.io.Serializable;

import com.resourcesHumaines.dao.CompteDao;
import com.resourcesHumaines.metier.bo.Compte;

/**
 * classe implimentant les services de gestion d'access aux donnees pour les objets metier 
 * Compte
 */
public class CompteDaoImpl extends GenericDaoImpl<Compte, Serializable> implements CompteDao{

	public CompteDaoImpl() {
		super(Compte.class);
	}

}
