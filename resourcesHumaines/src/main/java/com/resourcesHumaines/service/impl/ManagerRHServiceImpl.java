package com.resourcesHumaines.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import com.resourcesHumaines.dao.AffectationDao;
import com.resourcesHumaines.dao.CollaborateurDao;
import com.resourcesHumaines.dao.CompteDao;
import com.resourcesHumaines.dao.ManagerRHDao;
import com.resourcesHumaines.dao.ResponsableDao;
import com.resourcesHumaines.dao.RoleDao;
import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Affectation;
import com.resourcesHumaines.metier.bo.Collaborateur;
import com.resourcesHumaines.metier.bo.Compte;
import com.resourcesHumaines.metier.bo.ManagerRH;
import com.resourcesHumaines.metier.bo.Responsable;
import com.resourcesHumaines.metier.bo.Role;
import com.resourcesHumaines.service.ManagerRHService;
import com.resourcesHumaines.service.exception.DuplicateLoginException;
import com.resourcesHumaines.service.exception.EntityNotFoundSericeException;

public class ManagerRHServiceImpl implements ManagerRHService{

	private ManagerRHDao managerRHDao;
	
	private CompteDao compteDao;
	
	private RoleDao roleDao;
	
	private AffectationDao affectationDao;
	
	private CollaborateurDao collaborateurDao;
	
	public void ajouterManagerRH(ManagerRH pManagerRH,Compte pCompte)
			throws EntityNotFoundSericeException, DuplicateLoginException {
		try {
			Role role = roleDao.rechercheRoleParTitre("ROLE_MANAGERRH");
			pCompte.setRole(role);
			ShaPasswordEncoder encoder = new ShaPasswordEncoder();
			String cryptedPassword = encoder.encodePassword(pCompte.getPassword(),pCompte.getLogin());
			pCompte.setPassword(cryptedPassword);
			compteDao.create(pCompte);
			pManagerRH.setCompte(pCompte);
			managerRHDao.create(pManagerRH);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundSericeException(e.getMessage(),e);
		}
		catch(DataIntegrityViolationException e){
			throw new DuplicateLoginException();
		}
		
	}
	
	public void desactiverCompteManagerRH(ManagerRH pManagerRH)
			throws EntityNotFoundSericeException {
		pManagerRH.setStatut(false);
		managerRHDao.update(pManagerRH);
		
	}

	public void affecterCollaborateur(ManagerRH pManagerRH,
			Collaborateur pCollaborateur,Date pDateAffectation) throws EntityNotFoundSericeException {
		
		Affectation affectation = new Affectation();
		affectation.setDateAffectation(pDateAffectation);
		affectationDao.create(affectation);
		pManagerRH.getAffectations().add(affectation);
		managerRHDao.update(pManagerRH);
		for(Affectation aff : pCollaborateur.getAffectations()){
			aff.setActuelle(false);
		}
		affectation.setActuelle(true);
		pCollaborateur.getAffectations().add(affectation);
		collaborateurDao.update(pCollaborateur);
		
	}


	public void modifierManagerRH(ManagerRH pManagerRH) {
		managerRHDao.update(pManagerRH);
		
	}

	public List<ManagerRH> rechercheParMotCle(String pMotCle)
			throws EntityNotFoundSericeException {
		return managerRHDao.rechercheParMotCle(pMotCle);
	}

	public ManagerRH getById(Long pId) throws EntityNotFoundSericeException {
		try {
			return managerRHDao.getById(pId);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundSericeException(e.getMessage(), e);
		}
	}

	public void delete(Long pId) throws EntityNotFoundSericeException {
		
		try {
			managerRHDao.delete(pId);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundSericeException(e.getMessage(), e);
		}
	}

	public List<ManagerRH> getAll() {
		return managerRHDao.getAll();
	}

	/**
	 * @return the managerRHDao
	 */
	public ManagerRHDao getManagerRHDao() {
		return managerRHDao;
	}

	/**
	 * @param managerRHDao the managerRHDao to set
	 */
	public void setManagerRHDao(ManagerRHDao managerRHDao) {
		this.managerRHDao = managerRHDao;
	}

	/**
	 * @return the compteDao
	 */
	public CompteDao getCompteDao() {
		return compteDao;
	}

	/**
	 * @param compteDao the compteDao to set
	 */
	public void setCompteDao(CompteDao compteDao) {
		this.compteDao = compteDao;
	}

	/**
	 * @return the affectationDao
	 */
	public AffectationDao getAffectationDao() {
		return affectationDao;
	}

	/**
	 * @param affectationDao the affectationDao to set
	 */
	public void setAffectationDao(AffectationDao affectationDao) {
		this.affectationDao = affectationDao;
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

	/**
	 * @return the collaborateurDao
	 */
	public CollaborateurDao getCollaborateurDao() {
		return collaborateurDao;
	}

	/**
	 * @param collaborateurDao the collaborateurDao to set
	 */
	public void setCollaborateurDao(CollaborateurDao collaborateurDao) {
		this.collaborateurDao = collaborateurDao;
	}

	
	
	
}
