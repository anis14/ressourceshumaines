package com.resourcesHumaines.dao.impl;

import java.io.Serializable;

import com.resourcesHumaines.dao.DiplomeDao;
import com.resourcesHumaines.metier.bo.Diplome;

/**
 * classe implimentant les services de gestion d'access aux donnees pour les objets metier 
 * Diplome
 */
public class DiplomeDaoImpl extends GenericDaoImpl<Diplome, Serializable> implements DiplomeDao{

	public DiplomeDaoImpl() {
		super(Diplome.class);
	}

}
