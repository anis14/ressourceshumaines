package com.resourcesHumaines.service.impl;

import java.util.List;

import com.resourcesHumaines.dao.PrivilegeDao;
import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Privilege;
import com.resourcesHumaines.service.PrivilegeService;
import com.resourcesHumaines.service.exception.EntityNotFoundSericeException;

public class PrivilegeServiceImpl implements PrivilegeService{

	private PrivilegeDao privilegeDao;
	
	public void creerPermission(Privilege pPrivilege)
			throws EntityNotFoundSericeException {
		
		privilegeDao.create(pPrivilege);
		
	}

	public void modifierPermission(Privilege pPrivilege)
			throws EntityNotFoundSericeException {
		privilegeDao.update(pPrivilege);
	}

	public void suprimerPermission(Long pId)
			throws EntityNotFoundSericeException {
		try {
			privilegeDao.delete(pId);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundSericeException(e.getMessage(), e);
		}
	}

	public List<Privilege> getAll() throws EntityNotFoundSericeException {
		return privilegeDao.getAll();
	}

	public Privilege getById(Long pId) throws EntityNotFoundSericeException {
		try {
			return privilegeDao.getById(pId);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundSericeException(e.getMessage(), e);
		}
	}

	/**
	 * @return the privilegeDao
	 */
	public PrivilegeDao getPrivilegeDao() {
		return privilegeDao;
	}

	/**
	 * @param privilegeDao the privilegeDao to set
	 */
	public void setPrivilegeDao(PrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}

}
