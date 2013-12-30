/**
 * 
 */
package com.resourcesHumaines.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Collaborateur;

/**
 *c'est une interface qui offre les services de gestion d'access aux donnees pour les objets
 *collaborateurs
 */
public interface CollaborateurDao extends GenericDao<Collaborateur, Serializable>{

	/**
	 * methode permettant de recherche un collaborateur par matricule
	 * @param pMatricule
	 * @return
	 * @throws EntityNotFoundException l'exception a lever en cas d'erreurs
	 */
	Collaborateur rechercheParMatricule(String pMatricule) throws EntityNotFoundException;

	/**
	 * methode permettant de recherche un collaborateur par abreviation
	 * @param pAbreviation
	 * @return
	 * @throws EntityNotFoundException l'exception a lever en cas d'erreurs
	 */
	Collaborateur rechercheParAbreviation(String pAbreviation) throws EntityNotFoundException;

	/**
	 * methode permettant de rechercher des collaborateurs par plusieurs criteres
	 * @param pNom
	 * @param pPrenom
	 * @param pSexe
	 * @param pBu
	 * @param pDateEmbauche
	 * @param pDateDepart
	 * @param pParticiteAuSeminaire
	 * @param pSalaireMin
	 * @param pSalaireMax
	 * @return
	 */
	List<Collaborateur> rechercheAvancee(String pNom, String pPrenom,
			char pSexe, String pBu, Date pDateEmbauche, Date pDateDepart,
			boolean pParticiteAuSeminaire, float pSalaireMin, float pSalaireMax);
	
}
