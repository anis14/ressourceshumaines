package com.resourcesHumaines.metier.bo;

import java.util.List;

/**
 * un objet de cette classe represente un responsable de l'organisation ayant un role 
 * manager des ressources humaines
 */
public class ManagerRH extends Responsable {

	/**
	 * le statut du manager RH
	 */
	private boolean statut;
	
	/**
	 * la liste des affectations du collaborateur au manager RH
	 */
	private List<Affectation> affectations;

	/**
	 * @return the statut
	 */
	public boolean isStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	/**
	 * @return the affectations
	 */
	public List<Affectation> getAffectations() {
		return affectations;
	}

	/**
	 * @param affectations the affectations to set
	 */
	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

	/**
	 * methode de clone pour que son appel lors d'une affectation engendre l'affectation de la reference
	 *  d'une nouvelle instance et non pas la reference du meme objet
	 */
	@Override
	public ManagerRH clone() {
    	ManagerRH mRH = null;
    	// On récupère l'instance à renvoyer par l'appel de la 
		// méthode super.clone()
		mRH = (ManagerRH)super.clone();
	    // on renvoie le clone
	    return mRH;
  	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() +"ManagerRH [statut=" + statut + ", affectations=" + affectations
				+ "]";
	}
	
	
	
	//equals et hashcode
}
