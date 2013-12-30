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
	public Collaborateur rechercheParMatricule(String pMatricule)
			throws EntityNotFoundException {

		List<Object> objets = getHibernateTemplate().find(
				"FROM Collaborateur WHERE matricule = ?", pMatricule);
		if (objets.size() == 0) {
			throw new EntityNotFoundException(
					"aucun collaborateur trouve avec cette matricule");
		} else if (objets.size() > 1) {
			throw new EntityNotFoundException(
					"plusieurs collaborateurs ont la meme matricule");
		}
		return (Collaborateur) objets.get(0);
	}

	/**
	 * implimentation de la methode permettant de rechercher un collaborateur
	 * par abreviation
	 */
	public Collaborateur rechercheParAbreviation(String pAbreviation)
			throws EntityNotFoundException {
		List<Object> objets = getHibernateTemplate().find(
				"FROM Collaborateur WHERE abreviation = ?", pAbreviation);
		if (objets.size() == 0) {
			throw new EntityNotFoundException(
					"aucun collaborateur trouve avec cette matricule");
		} else if (objets.size() > 1) {
			throw new EntityNotFoundException(
					"plusieurs collaborateurs ont la meme matricule");
		}
		return (Collaborateur) objets.get(0);
	}

	/**
	 * implimentation de la methode permettant de rechercher des collaborateurs
	 * par plusieurs criteres
	 */
	public List<Collaborateur> rechercheAvancee(String pNom, String pPrenom,
			char pSexe, String pBu, Date pDateEmbauche, Date pDateDepart,
			boolean pParticiteAuSeminaire, float pSalaireMin, float pSalaireMax) {
		// like en hibernateTemplate
		List<Object> objets = getHibernateTemplate()
				.find("FROM Collaborateur col WHERE col.nom like ? and col.prenom like ?" +
						" and col.sexe like ?",
						"%" + pNom + "%", "%" + pPrenom + "%",
						"%" + pSexe + "%");
		List<Collaborateur> collaborateurs = new ArrayList<Collaborateur>();
		for (Object objet : objets) {
			collaborateurs.add((Collaborateur) objet);
		}
		return collaborateurs;
	}

}
