package com.resourcesHumaines.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.resourcesHumaines.dao.AffectationDao;
import com.resourcesHumaines.dao.CollaborateurDao;
import com.resourcesHumaines.dao.CompetenceDao;
import com.resourcesHumaines.dao.DiplomeDao;
import com.resourcesHumaines.dao.ManagerRHDao;
import com.resourcesHumaines.dao.PosteAPPDao;
import com.resourcesHumaines.dao.PosteDao;
import com.resourcesHumaines.dao.SalaireDao;
import com.resourcesHumaines.dao.TechnologieDao;
import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Affectation;
import com.resourcesHumaines.metier.bo.Collaborateur;
import com.resourcesHumaines.metier.bo.Competence;
import com.resourcesHumaines.metier.bo.Diplome;
import com.resourcesHumaines.metier.bo.ManagerRH;
import com.resourcesHumaines.metier.bo.Poste;
import com.resourcesHumaines.metier.bo.PosteAPP;
import com.resourcesHumaines.metier.bo.Salaire;
import com.resourcesHumaines.service.CollaborateurService;
import com.resourcesHumaines.service.exception.EntityNotFoundSericeException;
import com.resourcesHumaines.util.EnvoiEmail;

public class CollaborateurServiceImpl implements CollaborateurService {

	/**
	 * objet pour gerer l'access des objets collaborateurs
	 */
	private CollaborateurDao collaborateurDao;

	/**
	 * pour gerer l'accees aux objets Poste d'un collaborateur
	 */
	private PosteDao posteDao;

	/**
	 * pour gerer l'access aux objets PosteAPP d'un collaborateur
	 */
	private PosteAPPDao posteAPPDao;

	/**
	 * pour gerer l'accees aux objets Salaire d'un collaborateur
	 */
	private SalaireDao salaireDao;

	/**
	 * pour gerer l'accees aux objets Competences d'un collaborateur
	 */
	private CompetenceDao competenceDao;

	/**
	 * pour gerer l'accees aux objets Technologie d'un collaborateur
	 */
	private TechnologieDao technologieDao;
	
	/**
	 * pour gerer l'accees aux objets Diplomes d'un collaborateur
	 */
	private DiplomeDao diplomeDao;
	
	/**
	 * pour gerer l'accees aux objets ManagerRH d'un collaborateur
	 */
	private ManagerRHDao managerRHDao;

	/**
	 * pour gerer l'accees aux objets Affecter d'un collaborateur
	 */
	private AffectationDao affecterDao;

	/**
	 * l'implimentation de la methode qui permet d'ajouter un collaborateur
	 * @throws EntityNotFoundSericeException 
	 */
	public void ajouterCollaborateur(Collaborateur pCollaborateur,
			Poste pPoste, PosteAPP pPosteApp, Salaire pSalaire,
			List<Competence> pCompetences,List<Diplome> pDiplomes, ManagerRH pManagerRh) throws EntityNotFoundSericeException {
		System.out.println("debut");
		System.out.println(pPoste.getTitre());
		posteAPPDao.create(pPosteApp);
		salaireDao.create(pSalaire);
		for (Competence competence : pCompetences) {
			technologieDao.create(competence.getTechnologie());
			competenceDao.create(competence);
		}
		pCollaborateur.setDiplomes(new ArrayList<Diplome>());
		for(Diplome diplome : pCollaborateur.getDiplomes()){
			diplomeDao.create(diplome);
		}
		pCollaborateur.setPostes(new ArrayList<Poste>());
		pCollaborateur.getPostes().add(pPoste);
		pCollaborateur.getPostesApp().add(pPosteApp);
		pCollaborateur.getSalaires().add(pSalaire);
		pCollaborateur.setCompetences(pCompetences);
		for(Diplome dip : pDiplomes){
			diplomeDao.create(dip);
		}
		pCollaborateur.setDiplomes(pDiplomes);
		Affectation affectation = new Affectation();
		affectation.setDateAffectation(new Date());
		affecterDao.create(affectation);
		pCollaborateur.getAffectations().add(affectation);
		pManagerRh.getAffectations().add(affectation);
		managerRHDao.update(pManagerRh);
		collaborateurDao.create(pCollaborateur);
		try {
			EnvoiEmail.envoyerEmail("benelhassan.youness@gmail.com");
		} catch (IOException e) {
			throw new EntityNotFoundSericeException(e.getMessage(), e);
		}
	}

	/**
	 * l'implimentation de la methode qui permet de modifier un collaborateur
	 */
	public void modifierCollaborateur(Collaborateur pCollaborateur) {

		collaborateurDao.update(pCollaborateur);
	}

	/**
	 * l'implimentation de la methode qui permet de rechercher un collaborateur
	 * par son matricule
	 */
	public List<Collaborateur> rechercheParMatricule(int pMatricule)
			throws EntityNotFoundSericeException {

		List<Collaborateur> collaborateurs = new ArrayList<Collaborateur>();
		try {
			 collaborateurs = collaborateurDao.rechercheParMatricule(pMatricule);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundSericeException(e.getMessage(), e);
		}
		return collaborateurs;
	}

	/**
	 * l'implimentation de la methode qui permet de rechercher un collaborateur
	 * par abreviation
	 */
	public List<Collaborateur> rechercheParAbreviation(String pAbreviation,String pLongin)
			throws EntityNotFoundSericeException {
		List<Collaborateur> collaborateurs = new ArrayList<Collaborateur>();
		try {
			collaborateurs = collaborateurDao
					.rechercheParAbreviation(pAbreviation,pLongin);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundSericeException(e.getMessage(), e);
		}
		return collaborateurs;
	}

	/**
	 * l'implimentation de la methode qui permet de rechercher des
	 * collaborateurs par plusieurs criteres
	 */
	public List<Collaborateur> rechercheAvancee(String pNom, String pPrenom,
			char pSexe, String pBu, Date pDateEmbauche, Date pDateDepart,
			boolean pParticiteAuSeminaire, float pSalaireMin, float pSalaireMax ,String pManagerRH,String pSite) {

		return collaborateurDao.rechercheAvancee(pNom, pPrenom, pSexe, pBu,
				pDateEmbauche, pDateDepart, pParticiteAuSeminaire, pSalaireMin,
				pSalaireMax ,pManagerRH,pSite);
	}

	public Collaborateur getById(Long pId) throws EntityNotFoundSericeException {
		try {
			return collaborateurDao.getById(pId);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundSericeException(e.getMessage(), e);
		}
	}

	public void delete(Long pId) throws EntityNotFoundSericeException {
		
		try {
			collaborateurDao.delete(pId);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundSericeException(e.getMessage(), e);
		}
		
	}

	public List<Collaborateur> getAll() {
		
		return collaborateurDao.getAll();
	}

	public float getMaxSalaire() throws EntityNotFoundSericeException {
		try {
			return salaireDao.getMaxSalaire();
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundSericeException(e.getMessage(), e);
		}
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

	/**
	 * @return the posteDao
	 */
	public PosteDao getPosteDao() {
		return posteDao;
	}

	/**
	 * @param posteDao the posteDao to set
	 */
	public void setPosteDao(PosteDao posteDao) {
		this.posteDao = posteDao;
	}

	/**
	 * @return the posteAPPDao
	 */
	public PosteAPPDao getPosteAPPDao() {
		return posteAPPDao;
	}

	/**
	 * @param posteAPPDao the posteAPPDao to set
	 */
	public void setPosteAPPDao(PosteAPPDao posteAPPDao) {
		this.posteAPPDao = posteAPPDao;
	}

	/**
	 * @return the salaireDao
	 */
	public SalaireDao getSalaireDao() {
		return salaireDao;
	}

	/**
	 * @param salaireDao the salaireDao to set
	 */
	public void setSalaireDao(SalaireDao salaireDao) {
		this.salaireDao = salaireDao;
	}

	/**
	 * @return the competenceDao
	 */
	public CompetenceDao getCompetenceDao() {
		return competenceDao;
	}

	/**
	 * @param competenceDao the competenceDao to set
	 */
	public void setCompetenceDao(CompetenceDao competenceDao) {
		this.competenceDao = competenceDao;
	}

	/**
	 * @return the technologieDao
	 */
	public TechnologieDao getTechnologieDao() {
		return technologieDao;
	}

	/**
	 * @param technologieDao the technologieDao to set
	 */
	public void setTechnologieDao(TechnologieDao technologieDao) {
		this.technologieDao = technologieDao;
	}

	/**
	 * @return the diplomeDao
	 */
	public DiplomeDao getDiplomeDao() {
		return diplomeDao;
	}

	/**
	 * @param diplomeDao the diplomeDao to set
	 */
	public void setDiplomeDao(DiplomeDao diplomeDao) {
		this.diplomeDao = diplomeDao;
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
	 * @return the affecterDao
	 */
	public AffectationDao getAffecterDao() {
		return affecterDao;
	}

	/**
	 * @param affecterDao the affecterDao to set
	 */
	public void setAffecterDao(AffectationDao affecterDao) {
		this.affecterDao = affecterDao;
	}

	public void modifierDiplome(Diplome pDiplome)
			throws EntityNotFoundSericeException {
		diplomeDao.update(pDiplome);
		
	}


	
}
