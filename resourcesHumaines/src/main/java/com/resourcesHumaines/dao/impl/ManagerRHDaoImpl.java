/**
 * 
 */
package com.resourcesHumaines.dao.impl;

import java.io.Serializable;

import com.resourcesHumaines.dao.ManagerRHDao;
import com.resourcesHumaines.metier.bo.ManagerRH;

/**
 * classe implimentant les services de gestion d'access aux donnees pour les objets metier 
 * ManagerRH
 */
public class ManagerRHDaoImpl extends GenericDaoImpl<ManagerRH, Serializable> implements ManagerRHDao{

	public ManagerRHDaoImpl() {
		super(ManagerRH.class);
	}

}
