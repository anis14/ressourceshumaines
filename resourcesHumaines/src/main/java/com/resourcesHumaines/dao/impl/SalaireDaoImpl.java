/**
 * 
 */
package com.resourcesHumaines.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.resourcesHumaines.dao.SalaireDao;
import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Collaborateur;
import com.resourcesHumaines.metier.bo.Salaire;

/**
 * classe implimentant les services de gestion d'access aux donnees pour les objets metier 
 * Salaire
 */
public class SalaireDaoImpl extends GenericDaoImpl<Salaire, Serializable> implements SalaireDao{

	public SalaireDaoImpl() {
		super(Salaire.class);
	}

	public float getMaxSalaire() throws EntityNotFoundException {
		List<Object> objets = getHibernateTemplate().find(
				"FROM Salaire WHERE salaire = (Select max(salaire) from Salaire)");
		if (objets.size() == 0) {	
			throw new EntityNotFoundException(
					"aucun collaborateur trouve avec cette matricule");
		}
		
		return ((Salaire)objets.get(0)).getSalaire();
	}

}
