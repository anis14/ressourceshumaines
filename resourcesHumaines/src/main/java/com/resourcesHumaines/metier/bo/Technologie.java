/**
 * 
 */
package com.resourcesHumaines.metier.bo;

import java.io.Serializable;

/**
 *un objet de cette classe representeune technologie maitrisee par un collaborateur
 */
public class Technologie implements Serializable{

	private Long idTechnologie;
	
	private String titre;
	
	/**
	 * constructeur par defaut necessaire pour le mecanisme de reflexion utilise par les frameworks
	 */
	public Technologie() {
	
	}

	public Technologie(String titre) {
		super();
		this.titre = titre;
	}

	/**
	 * @return the idTechnologie
	 */
	public Long getIdTechnologie() {
		return idTechnologie;
	}

	/**
	 * @param idTechnologie the idTechnologie to set
	 */
	public void setIdTechnologie(Long idTechnologie) {
		this.idTechnologie = idTechnologie;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	// equals et hashcode
}
