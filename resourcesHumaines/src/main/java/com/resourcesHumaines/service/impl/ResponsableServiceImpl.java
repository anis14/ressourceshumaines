package com.resourcesHumaines.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.resourcesHumaines.dao.ResponsableDao;
import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Responsable;
import com.resourcesHumaines.metier.bo.Role;
import com.resourcesHumaines.service.ResponsableService;
import com.resourcesHumaines.service.exception.DuplicateLoginException;
import com.resourcesHumaines.service.exception.EntityNotFoundSericeException;

/**
 * 
 *classe presentant une implimentation de l'interface offrant les services de gestion des utilisateurs
 */
public class ResponsableServiceImpl implements ResponsableService,UserDetailsService{

	private ResponsableDao responsableDao;
	
	public UserDetails loadUserByUsername(String pLogin)
			throws UsernameNotFoundException {
		Responsable responsable;
		Collection<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		try {
			responsable = responsableDao.RechercheParLogin(pLogin);
			System.out.println(responsable.getEmail());
		} catch (EntityNotFoundException e) {
			System.out.println("exceprion : " + e.getMessage());
			throw new UsernameNotFoundException("informations incorrectes", e);
		}
		Role role = responsable.getCompte().getRole();
		roles.add(new GrantedAuthorityImpl(role.getIntitule()));
		User user = new User(responsable.getCompte().getLogin(), responsable.getCompte().getPassword(), roles);
		return user;
	}

	public void creerCompte(Responsable pResponsable)
			throws EntityNotFoundSericeException, DuplicateLoginException {
		
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
