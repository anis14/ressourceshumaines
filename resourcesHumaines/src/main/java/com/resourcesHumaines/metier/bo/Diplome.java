package com.resourcesHumaines.metier.bo;

import java.io.Serializable;

/**
 * 
 *un objet de cette classe represente un diplome 
 */
public class Diplome implements Serializable{

	/**
	 * l'identifiant
	 */
	private Long idDiplome;
	
	/**
	 * niveau d'etudes bac+2 ...
	 */
	private String niveau;
	
	/**
	 * ecole
	 */
	private String ecole;
	
	/**
	 * type de l'ecole
	 */
	private String typeEcole;
	
	/**
	 * type de diplome
	 */
	private String typeDiplome;
	
	/**
	 * promotion
	 */
	private String promotion;
	
	/**
	 * constructeur par defaut necessaire pour le mecanisme de reflexion utilise par les frameworks
	 */
	public Diplome(){
		
	}

	/**
	 * constructeur pour inisialiser les informations d'un objet diplome
	 * @param niveau
	 * @param ecole
	 * @param typeEcole
	 * @param typeDiplome
	 * @param promotion
	 */
	public Diplome(String niveau, String ecole, String typeEcole,
			String typeDiplome, String promotion) {
		super();
		this.niveau = niveau;
		this.ecole = ecole;
		this.typeEcole = typeEcole;
		this.typeDiplome = typeDiplome;
		this.promotion = promotion;
	}

	/**
	 * @return the idDiplome
	 */
	public Long getIdDiplome() {
		return idDiplome;
	}

	/**
	 * @param idDiplome the idDiplome to set
	 */
	public void setIdDiplome(Long idDiplome) {
		this.idDiplome = idDiplome;
	}

	/**
	 * @return the niveau
	 */
	public String getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau the niveau to set
	 */
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	/**
	 * @return the ecole
	 */
	public String getEcole() {
		return ecole;
	}

	/**
	 * @param ecole the ecole to set
	 */
	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	/**
	 * @return the typeEcole
	 */
	public String getTypeEcole() {
		return typeEcole;
	}

	/**
	 * @param typeEcole the typeEcole to set
	 */
	public void setTypeEcole(String typeEcole) {
		this.typeEcole = typeEcole;
	}

	/**
	 * @return the typeDiplome
	 */
	public String getTypeDiplome() {
		return typeDiplome;
	}

	/**
	 * @param typeDiplome the typeDiplome to set
	 */
	public void setTypeDiplome(String typeDiplome) {
		this.typeDiplome = typeDiplome;
	}

	/**
	 * @return the promotion
	 */
	public String getPromotion() {
		return promotion;
	}

	/**
	 * @param promotion the promotion to set
	 */
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	
	// equals et hashcode
	
	
}
