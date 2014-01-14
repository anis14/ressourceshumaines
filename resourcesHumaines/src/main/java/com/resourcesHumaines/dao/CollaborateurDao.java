/**
 * 
 */
package com.resourcesHumaines.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Collaborateur;
import com.resourcesHumaines.metier.bo.ManagerRH;

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
	List<Collaborateur> rechercheParMatricule(int pMatricule) throws EntityNotFoundException;

	/**
	 * methode permettant de recherche un collaborateur d'un manager rH par abreviation
	 * ou toutes les collaborateur si la requete est demande par un ambassadeur RH ...
	 * @param pAbreviation
	 * @return
	 * @throws EntityNotFoundException l'exception a lever en cas d'erreurs
	 */
	List<Collaborateur> rechercheParAbreviation(String pAbreviation,String pLogin) throws EntityNotFoundException;

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
			boolean pParticiteAuSeminaire, float pSalaireMin, float pSalaireMax ,String pManagerRH,String pSite);
	
}
