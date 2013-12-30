/**
 * 
 */
package com.resourcesHumaines.dao.impl;

import java.io.Serializable;

import com.resourcesHumaines.dao.SalaireDao;
import com.resourcesHumaines.metier.bo.Salaire;

/**
 * classe implimentant les services de gestion d'access aux donnees pour les objets metier 
 * Salaire
 */
public class SalaireDaoImpl extends GenericDaoImpl<Salaire, Serializable> implements SalaireDao{

	public SalaireDaoImpl() {
		super(Salaire.class);
	}

}
