/**
 * 
 */
package com.resourcesHumaines.dao.impl;

import java.io.Serializable;

import com.resourcesHumaines.dao.PosteAPPDao;
import com.resourcesHumaines.metier.bo.PosteAPP;

/**
 * classe implimentant les services de gestion d'access aux donnees pour les objets metier 
 * Poste de niveau APP
 */
public class PosteAPPDaoImpl extends GenericDaoImpl<PosteAPP, Serializable> implements PosteAPPDao{

	public PosteAPPDaoImpl() {
		super(PosteAPP.class);
	}

}
