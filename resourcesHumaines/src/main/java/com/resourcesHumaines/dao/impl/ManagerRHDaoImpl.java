/**
 * 
 */
package com.resourcesHumaines.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.resourcesHumaines.dao.ManagerRHDao;
import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Collaborateur;
import com.resourcesHumaines.metier.bo.ManagerRH;

/**
 * classe implimentant les services de gestion d'access aux donnees pour les objets metier 
 * ManagerRH
 */
public class ManagerRHDaoImpl extends GenericDaoImpl<ManagerRH, Serializable> implements ManagerRHDao{

	public ManagerRHDaoImpl() {
		super(ManagerRH.class);
	}

	/**
	 * implimentation de la methode permettant de rechercher des managers par motcle
	 */
	public List<ManagerRH> rechercheParMotCle(String pMotCle) {
		List<Object> objets = getHibernateTemplate().find(
				"FROM ManagerRH manager WHERE manager.nom like ? OR manager.prenom like ?",
				"%"+pMotCle+"%","%"+pMotCle+"%");
		List<ManagerRH> managersRH = new ArrayList<ManagerRH>();
		for (Object objet : objets) {
			managersRH.add((ManagerRH) objet);
		}
		return managersRH;
	}
	
	

}
