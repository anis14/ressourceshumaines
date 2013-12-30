/**
 * 
 */
package com.resourcesHumaines.dao.impl;

import java.io.Serializable;

import com.resourcesHumaines.dao.TechnologieDao;
import com.resourcesHumaines.metier.bo.Technologie;

/**
 * classe implimentant les services de gestion d'access aux donnees pour les objets metier 
 * Technologie
 */
public class TechnologieDaoImpl extends GenericDaoImpl<Technologie, Serializable> implements TechnologieDao{

	public TechnologieDaoImpl() {
		super(Technologie.class);
		
	}

}
