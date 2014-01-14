/**
 * 
 */
package com.resourcesHumaines.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.resourcesHumaines.dao.RoleDao;
import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Privilege;
import com.resourcesHumaines.metier.bo.Role;

/**
 * l'implimentation des services de gestion d'access aux donnees pour les objets
 * role
 */
public class RoleDaoImpl extends GenericDaoImpl<Role, Serializable> implements RoleDao{

	public RoleDaoImpl() {
		super(Role.class);
	}

	public Role rechercheRoleParTitre(String pTitre)
			throws EntityNotFoundException {
		
		List<Object> objets = getHibernateTemplate().find(
				"FROM Role role WHERE role.intitule = ?",pTitre);
		if (objets.size() == 0) {	
			throw new EntityNotFoundException(
					"aucun role trouve avec ce titre");
		}else if(objets.size() > 1){
			throw new EntityNotFoundException(
					"plusieurs roles ont le meme titre");
		}
		else{
			return (Role)objets.get(0);
		}
	}

}
