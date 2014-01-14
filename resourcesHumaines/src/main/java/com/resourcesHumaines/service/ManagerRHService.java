/**
 * 
 */
package com.resourcesHumaines.service;

import java.util.Date;
import java.util.List;

import com.resourcesHumaines.metier.bo.Collaborateur;
import com.resourcesHumaines.metier.bo.Compte;
import com.resourcesHumaines.metier.bo.ManagerRH;
import com.resourcesHumaines.service.exception.DuplicateLoginException;
import com.resourcesHumaines.service.exception.EntityNotFoundSericeException;

/**
  * c est une interface representant les fonctionnalites metier pour gerer les
 * 	managerRH
 */
public interface ManagerRHService {
	
	/**
	 * service pour ajouter un manager RH
	 * @param pManagerRH les informations du base du manager
	 * @param pRole un role a assigner au manager il precise les permissions 
	 * @throws EntityNotFoundSericeException
	 * @throws DuplicateLoginException 
	 */
	public void ajouterManagerRH(ManagerRH pManagerRH,Compte pCompte) throws EntityNotFoundSericeException, DuplicateLoginException;
	
	/**
	 * service pour desactiver le compte d'un managerRH
	 * @param pManagerRH
	 * @throws EntityNotFoundSericeException
	 */
	public void desactiverCompteManagerRH(ManagerRH pManagerRH)throws EntityNotFoundSericeException;
	
	/**
	 * service permetant d'affecter un collaborateur a un managerRH
	 * @param pManagerRH
	 * @param pCollaborateur
	 * @param pDateAffectation
	 * @throws EntityNotFoundSericeException
	 */
	public void affecterCollaborateur(ManagerRH pManagerRH,Collaborateur pCollaborateur,Date pDateAffectation)throws EntityNotFoundSericeException;
	
	/**
	 * methode permettant de mettre a jour un managerRH
	 * @param pCollaborateur
	 */
	public void modifierManagerRH(ManagerRH pManagerRH);
	
	/**
	 * methode permettant de rechercher des managers RH par mot cle
	 * @param pMotCle
	 * @return
	 * @throws EntityNotFoundSericeException l'exeption a lever en cas de problemes
	 */
	public List<ManagerRH> rechercheParMotCle(String pMotCle) throws EntityNotFoundSericeException;

	
	/**
	 * retourner un managerRH par son identifiant
	 * @param pId
	 * @return
	 * @throws EntityNotFoundSericeException 
	 */
	public ManagerRH getById(Long pId) throws EntityNotFoundSericeException;
	
	/**
	 * supprimer un managerRH
	 * @param pId
	 * @throws EntityNotFoundSericeException 
	 */
	public void delete(Long pId) throws EntityNotFoundSericeException;
	
	/**
	 * retourner la liste des managersRH
	 * @return
	 */
	public List<ManagerRH> getAll();

}
