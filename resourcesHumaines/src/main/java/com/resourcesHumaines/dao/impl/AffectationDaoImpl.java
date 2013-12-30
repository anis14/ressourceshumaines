/**
 * 
 */
package com.resourcesHumaines.dao.impl;

import java.io.Serializable;

import com.resourcesHumaines.dao.AffectationDao;
import com.resourcesHumaines.metier.bo.Affectation;

/**
 * classe implimentant les services de gestion d'access aux donnees pour les objets metier 
 * Affectation
 */
public class AffectationDaoImpl extends GenericDaoImpl<Affectation, Serializable> implements AffectationDao{

	public AffectationDaoImpl() {
		super(Affectation.class);
	}

}
