package com.resourcesHumaines.util;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import com.resourcesHumaines.dao.ResponsableDao;
import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Privilege;
import com.resourcesHumaines.metier.bo.Responsable;

public class HasPermission implements PermissionEvaluator{

	private ResponsableDao responsableDao;
	
	public boolean hasPermission(Authentication authentificated, Object arg1, Object pPrivilege) {
		
			try {
				Responsable responsable =  responsableDao.RechercheParLogin(authentificated.getName());
				List<Privilege> privileges = responsable.getCompte().getRole().getPrivileges();
				for(Privilege privilege : privileges){
					System.out.println(pPrivilege.toString()+ " : " +privilege.getTitre());
					if(privilege.getTitre().equals(pPrivilege.toString())){
						System.out.println("has");
						return true;
					}
				}
			} catch (EntityNotFoundException e) {
				System.out.println("err");
				return false;
			}
		System.out.println("anonymous");
		return false;
	}

	public boolean hasPermission(Authentication arg0, Serializable arg1,
			String arg2, Object arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the responsableDao
	 */
	public ResponsableDao getResponsableDao() {
		return responsableDao;
	}

	/**
	 * @param responsableDao the responsableDao to set
	 */
	public void setResponsableDao(ResponsableDao responsableDao) {
		this.responsableDao = responsableDao;
	}
	
	

}
