/**
 * 
 */
package com.resourcesHumaines.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.resourcesHumaines.dao.CollaborateurDao;
import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.metier.bo.Collaborateur;
import com.resourcesHumaines.metier.bo.ManagerRH;

/**
 * l'implimentation des services de gestion d'access aux donnees pour les objets
 * collaborateurs
 */
public class CollaborateurDaoImpl extends
		GenericDaoImpl<Collaborateur, Serializable> implements CollaborateurDao {

	public CollaborateurDaoImpl() {
		super(Collaborateur.class);
	}

	/**
	 * implimentation de la methode permettant de rechercher un collaborateur
	 * par matricule
	 */
	public List<Collaborateur> rechercheParMatricule(int pMatricule)
			throws EntityNotFoundException {

		List<Object> objets = getHibernateTemplate().find(
				"FROM Collaborateur WHERE matricule = ?",pMatricule);
		if (objets.size() == 0) {	
			throw new EntityNotFoundException(
					"aucun collaborateur trouve avec cette matricule");
		}
		List<Collaborateur> collaborateurs = new ArrayList<Collaborateur>();
		for (Object objet : objets) {
			collaborateurs.add((Collaborateur) objet);
		}
		return collaborateurs;
	}

	/**
	 * implimentation de la methode permettant de rechercher un collaborateur
	 * par abreviation
	 */
	public List<Collaborateur> rechercheParAbreviation(String pAbreviation,String pLogin)
			throws EntityNotFoundException {
		List<Object> objets = getHibernateTemplate().find(
				"FROM Collaborateur col inner join fetch col.affectations aff" +
				" WHERE col.abreviation like ? and aff.managerRH.compte.login like ? and aff.actuelle = true","%"+ pAbreviation +"%","%"+pLogin+"%");
		if (objets.size() == 0) {
			throw new EntityNotFoundException(
					"aucun collaborateur trouve avec cette matricule");
		} 
		List<Collaborateur> collaborateurs = new ArrayList<Collaborateur>();
		for (Object objet : objets) {
			collaborateurs.add((Collaborateur) objet);
		}
		return collaborateurs;
	}

	/**
	 * implimentation de la methode permettant de rechercher des collaborateurs
	 * par plusieurs criteres
	 */
	public List<Collaborateur> rechercheAvancee(String pNom, String pPrenom,
			char pSexe, String pBu, Date pDateEmbauche, Date pDateDepart,
			boolean pParticiteAuSeminaire, float pSalaireMin, float pSalaireMax ,String pManagerRH,String pSite) {
		String dateP;
		if(pParticiteAuSeminaire == false){
			dateP = "null";
		}
		else {
			dateP = "not null";
		}
		if(pSexe == '\u0000'){
			pSexe = '_';
		}
		
		List<Object> objets = getHibernateTemplate()
				.find("FROM Collaborateur col  inner join fetch col.salaires sal inner join fetch col.affectations aff WHERE col.nom like ? and col.prenom like ?" +
						" and col.sexe like ? and col.bu like ? and col.dateParticipation is "+dateP+" and sal.salaireActuel = true" +
								" and sal.salaire <= ? and sal.salaire >= ? and aff.managerRH.compte.login like ? and aff.actuelle = true",
						"%" + pNom + "%", "%" + pPrenom + "%",pSexe,"%" + pBu + "%",pSalaireMax,pSalaireMin,"%"+pManagerRH+"%");
		List<Collaborateur> collaborateurs = new ArrayList<Collaborateur>();
		for (Object objet : objets) {
			collaborateurs.add((Collaborateur) objet);
		}
		System.out.println(collaborateurs.size() + "in dao");
		return collaborateurs;
	}

}
