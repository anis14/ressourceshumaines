package com.resourcesHumaines.service.impl;

import java.util.List;

import com.resourcesHumaines.dao.RoleDao;
import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Role;
import com.resourcesHumaines.service.RoleService;
import com.resourcesHumaines.service.exception.EntityNotFoundSericeException;

public class RoleServiceImpl implements RoleService{

	private RoleDao roleDao;
	
	
	
	public void creerProfil(Role pRole) throws EntityNotFoundSericeException {
		roleDao.create(pRole);
		
	}

	public void modifierProfil(Role pRole) throws EntityNotFoundSericeException {
		roleDao.update(pRole);
	}

	public void suprimerProfil(Long pId) throws EntityNotFoundSericeException {
		try {
			roleDao.delete(pId);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundSericeException(e.getMessage(),e);
		}
	}
	
	
	public List<Role> getAll() throws EntityNotFoundSericeException {
		return roleDao.getAll();
	}

	public Role getById(Long pId) throws EntityNotFoundSericeException {
		
		Role role = getById(pId);
		return role;
		
	}
	

	/**
	 * @return the roleDao
	 */
	public RoleDao getRoleDao() {
		return roleDao;
	}

	/**
	 * @param roleDao the roleDao to set
	 */
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

}
