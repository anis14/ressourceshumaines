package com.resourcesHumaines.dao;

import java.io.Serializable;
import java.util.List;

import com.resourcesHumaines.dao.exception.EntityNotFoundException;

/**
 * est une interface generique qui offre un ensemble de services pour gerer la persistence 
 * des donnees 
 *
 * @param <T> ce parametre represente le type des objets
 * @param <I> ce parametre represente le type d'indentifiant des objets
 */
public interface GenericDao<T,I extends Serializable> {
	
	/**
	 * est une methode generique permet de persister un objet metier
	 * @param pObject l'objet a pirsister 
	 * @return l'objet persisté
	 */
	public T create(T pObject);
	
	/**
	 * cette methode permet de rechercher un objet persitente a partir
	 * d'un identifiant 
	 * @param pId l'identifiant de l'objet a chercher
	 * @return l'objet trouvé
	 * @throws EntityNotFoundException l'exception a generer au cas au aucune entite trouve
	 */
	public T getById(I pId) throws EntityNotFoundException;
	
	
	/**
	 * cette methode permet de retourner la liste des objets de type T
	 * @return la liste des objets metier trouvés
	 */
	public List<T> getAll();
	
	/**
	 * est une methode generique qui permet de mettre a jour un objet metier
	 * @param pObject c est l'objet metier a mettre a jour
	 */
	public void update(T pObject);
	
	/**
	 * est une methode generique qui permet de supprimer un objet metier
	 * @param pId l'identifiant de l'objet a supprimer
	 * @throws EntityNotFoundException l'exception a generer au cas au aucune entite trouve
	 */
	public void delete(I pId) throws EntityNotFoundException;

}

