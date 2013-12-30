/**
 * 
 */
package com.resourcesHumaines.service;

import java.util.Date;
import java.util.List;

import com.resourcesHumaines.metier.bo.Collaborateur;
import com.resourcesHumaines.metier.bo.Competence;
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
public interface CollaborateurService {

	/**
	 * methode permettant d'ajouter un collaborateur
	 * @param pCollaborateur l'objet collaborateur contenant les informations de base
	 * @param pPoste Objet poste auquel le collaborateur est affecte
	 * @param pPosteApp Objet poste de niveau APP auquel le collaborateur est affecte
	 * @param pSalaire Objet representant le salaire du colaborateur
	 * @param pCompetences une liste des competences du collaborateur
	 * @param pManagerRh le manager RHauquel le collaborateur a ete affecte
	 */
	public void ajouterCollaborateur(Collaborateur pCollaborateur,
			Poste pPoste, PosteAPP pPosteApp, Salaire pSalaire,
			List<Competence> pCompetences, ManagerRH pManagerRh);
	
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
	public Collaborateur rechercheParMatricule(String pMatricule) throws EntityNotFoundSericeException;
	
	/**
	 * methode permettant de rechercher un collaborateur par abreviation
	 * @param pAbreviation
	 * @return
	 * @throws EntityNotFoundSericeException l'exeption a lever en cas de problemes
	 */
	public Collaborateur rechercheParAbreviation(String pAbreviation) throws EntityNotFoundSericeException;

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
			boolean pParticiteAuSeminaire,float pSalaireMin, float pSalaireMax);
	
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
}
