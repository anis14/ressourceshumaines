package com.resourcesHumaines.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.resourcesHumaines.dao.GenericDao;
import com.resourcesHumaines.dao.exception.EntityNotFoundException;

/**
 * une classe genereci qui offre un ensemble de services generiques pour gerer le stockage de donnees
 *
 * @param <T>
 * @param <I>
 */
public class GenericDaoImpl<T, I extends Serializable> extends
		HibernateDaoSupport implements GenericDao<T, Serializable> {

	/**
	 * Represente la classe de l'objet metier manipulé
	 **/
	private Class<T> persistentClass;

	/**
	 * constructeur qui permet d'initialiser la classe persistent
	 * 
	 * @param persistentClass
	 *            la classe des objets a persister
	 */
	public GenericDaoImpl(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	/**
	 * implimentation de la methode qui permet de persister les objets metier
	 */
	public T create(T pObject) {
		getHibernateTemplate().save(pObject);
		return pObject;
	}

	/**
	 * implimentation de la methode qui permet de rechercher un objet metier
	 * persistent par son id
	 */
	public T getById(Serializable pId) throws EntityNotFoundException {

		T objet = getHibernateTemplate().get(persistentClass, pId);

		if (objet == null) {
			throw new EntityNotFoundException("aucune entite trouvé");
		}

		return objet;
	}

	/**
	 * implimentation de la methode qui permet de retourner toutes les objets
	 * metiers de type T
	 */
	public List<T> getAll() {
		return getHibernateTemplate().loadAll(persistentClass);
	}

	/**
	 * implimentation de la methode qui permet de mettre a jour un objet metier
	 */
	public void update(T pObject) {
		getHibernateTemplate().update(pObject);

	}

	/**
	 * implimentation de la methode qui permet de supprimer un objet metier
	 */
	public void delete(Serializable pId) throws EntityNotFoundException {

		T objet;
		try {
			objet = getById(pId);
			getHibernateTemplate().delete(objet);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException(e.getMessage(), e);
		}

	}

	/**
	 * @return the persistentClass
	 */
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	/**
	 * @param persistentClass
	 *            the persistentClass to set
	 */
	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

}
