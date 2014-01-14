package com.resourcesHumaines.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.resourcesHumaines.dao.ResponsableDao;
import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Responsable;

public class ResponsableDaoImpl extends GenericDaoImpl<Responsable, Serializable> implements ResponsableDao{

	public ResponsableDaoImpl() {
		super(Responsable.class);
	}

	public Responsable RechercheParLogin(String pLogin)
			throws EntityNotFoundException {
		List<Responsable> responsables = getHibernateTemplate().find("FROM Responsable WHERE compte.login = ?",pLogin);
		System.out.println("log2");
		if(responsables == null || responsables.size()==0){
			
			throw new EntityNotFoundException("login incorrect");
		}
		else if(responsables.size() > 1){
			throw new EntityNotFoundException("plusieurs compte ac le mm log attention admin");
		}
		else{
			return responsables.get(0);
		}
	}

}
