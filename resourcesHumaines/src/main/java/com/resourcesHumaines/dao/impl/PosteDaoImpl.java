/**
 * 
 */
package com.resourcesHumaines.dao.impl;

import java.io.Serializable;

import com.resourcesHumaines.dao.PosteDao;
import com.resourcesHumaines.metier.bo.Poste;

/**
 *classe  qui implimente les services de gestion d'access aux donnees pour les objets metier 
 *Poste
 */
public class PosteDaoImpl extends GenericDaoImpl<Poste, Serializable> implements PosteDao{

	public PosteDaoImpl() {
		super(Poste.class);
	}

}
