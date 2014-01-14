package com.resourcesHumaines.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.resourcesHumaines.dao.PrivilegeDao;
import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.ManagerRH;
import com.resourcesHumaines.metier.bo.Privilege;


/**
 * l'implimentation des services de gestion d'access aux donnees pour les objets
 * privilege
 */
public class PrivilegeDaoImpl extends GenericDaoImpl<Privilege, Serializable> implements PrivilegeDao{

	public PrivilegeDaoImpl() {
		super(Privilege.class);
	}

	public Privilege recherchePrivilegeParTitre(String pTitre)
			throws EntityNotFoundException {
		List<Object> objets = getHibernateTemplate().find(
				"FROM Privilege privilege WHERE privilege.titre = ?",pTitre);
		if (objets.size() == 0) {	
			throw new EntityNotFoundException(
					"aucun privilege trouve avec ce titre");
		}else if(objets.size() > 1){
			throw new EntityNotFoundException(
					"plusieurs privileges ont le meme titre");
		}
		else{
			return (Privilege)objets.get(0);
		}
	}

}
