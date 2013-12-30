/**
 * 
 */
package com.resourcesHumaines.dao.impl;

import java.io.Serializable;

import com.resourcesHumaines.dao.CompetenceDao;
import com.resourcesHumaines.metier.bo.Competence;

/**
 * classe implimentant les services de gestion d'access aux donnees pour les objets metier 
 * Competence
 */
public class CompetenceDaoImpl extends GenericDaoImpl<Competence, Serializable> implements CompetenceDao{

	public CompetenceDaoImpl() {
		super(Competence.class);
	}

}
