/**
 * 
 */
package com.resourcesHumaines.service;

import java.util.Date;
import java.util.List;

import com.resourcesHumaines.metier.bo.Collaborateur;
import com.resourcesHumaines.metier.bo.Competence;
import com.resourcesHumaines.metier.bo.Diplome;
import com.resourcesHumaines.metier.bo.ManagerRH;
import com.resourcesHumaines.metier.bo.Poste;
import com.resourcesHumaines.metier.bo.PosteAPP;
import com.resourcesHumaines.metier.bo.Salaire;
import com.resourcesHumaines.service.exception.EntityNotFoundSericeException;

/**
 * c est une interface representant les fonctionnalites metier pour gerer les
 * collaborateurs
 * 
 */
public interface CollaborateurService{

	/**
	 * methode permettant d'ajouter un collaborateur
	 * @param pCollaborateur
	 * @param pPoste
	 * @param pPosteApp
	 * @param pSalaire
	 * @param pCompetences
	 * @param pDiplomes
	 * @param pManagerRh
	 * @exception EntityNotFoundSericeException
	 */
	public void ajouterCollaborateur(Collaborateur pCollaborateur,
			Poste pPoste, PosteAPP pPosteApp, Salaire pSalaire,
			List<Competence> pCompetences,List<Diplome> pDiplomes, ManagerRH pManagerRh) throws EntityNotFoundSericeException;
	
	/**
	 * methode permettant de mettre a jour un collaborateur
	 * @param pCollaborateur
	 */
	public void modifierCollaborateur(Collaborateur pCollaborateur);
	
	/**
	 * methode permettant de rechercher un collaborateur par matricule
	 * @param pMatricule
	 * @return
	 * @throws EntityNotFoundSericeException l'exeption a lever en cas de problemes
	 */
	public List<Collaborateur> rechercheParMatricule(int pMatricule) throws EntityNotFoundSericeException;
	
	/**
	 * methode permettant de rechercher un collaborateur par abreviation
	 * @param pAbreviation
	 * @param pLogin
	 * @return
	 * @throws EntityNotFoundSericeException l'exeption a lever en cas de problemes
	 */
	public List<Collaborateur> rechercheParAbreviation(String pAbreviation,String pLogin) throws EntityNotFoundSericeException;

	/**
	 * methode permettant de rechercher des collaborateurs par plusieures criteres
	 * @param pNom
	 * @param pPrenom
	 * @param pSexe
	 * @param pBu
	 * @param pDateEmbauche
	 * @param pDateDepart
	 * @param pParticiteAuSeminaire
	 * @param salaireMin
	 * @return
	 */
	public List<Collaborateur> rechercheAvancee(String pNom,String pPrenom, char pSexe, String pBu, Date pDateEmbauche,Date pDateDepart,
			boolean pParticiteAuSeminaire,float pSalaireMin, float pSalaireMax ,String pManagerRH,String pSite);
	
	/**
	 * retourner un collaborateur par son identifiant
	 * @param pId
	 * @return
	 * @throws EntityNotFoundSericeException 
	 */
	public Collaborateur getById(Long pId) throws EntityNotFoundSericeException;
	
	/**
	 * supprimer un collaborateur
	 * @param pId
	 * @throws EntityNotFoundSericeException 
	 */
	public void delete(Long pId) throws EntityNotFoundSericeException;
	
	/**
	 * retourner la liste des collaborateurs
	 * @return
	 */
	public List<Collaborateur> getAll();
	/**
	 * service permettant de retourner le salaire maximum afin d'initialiser la recherche avancee
	 * @return
	 * @throws EntityNotFoundSericeException
	 */
	
	public float getMaxSalaire() throws EntityNotFoundSericeException;
	
	/**
	 * methode mermettant de modifier les information concrnant le diplome d'un collaborateur
	 * @param pDiplome
	 * @throws EntityNotFoundSericeException
	 */
	public void modifierDiplome(Diplome pDiplome) throws EntityNotFoundSericeException;
	
}
