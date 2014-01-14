package com.resourcesHumaines.metier.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * un objet de cette classe represente un collaborateur de l'organisation
 */
public class Collaborateur implements Serializable,Cloneable{
	
	/**
	 * l'identifiant du collaborateur
	 */
	private Long idCollaborateur;
	
	/**
	 * matricule du collaborateur
	 */
	private int matricule;
	
	/**
	 * nom du collaborateur
	 */
	private String nom;
	
	/**
	 * prenom du collaborateur
	 */
	private String prenom;
	
	/**
	 * abreviation du collaborateur
	 */
	private String abreviation;
	
	/**
	 * sexe du collaborateur
	 */
	private char sexe;
	
	/**
	 * site d'affectation du collaborateur
	 */
	private String site;
	
	/**
	 * business unit
	 */
	private String bu;
	
	/**
	 * la liste des diplomes du collaborateur
	 */
	private List<Diplome> diplomes = new ArrayList<Diplome>();
	
	/**
	 * la date d'embauche du collaborateur
	 */
	private Date dateEmbauche;
	
	/**
	 * mois BAP
	 */
	private String moisBap;
	
	/**
	 * date dedepart du collaborateur c est a partir de ce champs qu'on deduit si le collaborateur
	 * est un ancien collaborateur ou non
	 */
	private Date dateDepart;
	
	/**
	 * ladate du participation du collaborateur au seminaire 
	 * c est a partir de ce champs qu'on deduit si le collaborateur a particite ou non 
	 * au seminaire d'integration
	 */
	private Date dateParticipation;
	
	/**
	 * la liste des postes aux quelles le collaborateur a ete affecte  
	 */
	private List<Poste> postes = new ArrayList<Poste>();
	
	/**
	 * la liste des postes de niveau APP aux quelles le collaborateur a ete affecte  
	 */
	private List<PosteAPP> postesApp = new ArrayList<PosteAPP>();
	
	/**
	 * la liste representant levolution de salaire du collaborateur
	 */
	private List<Salaire> salaires = new ArrayList<Salaire>();
	
	/**
	 * la liste des competences du collaborateur apartir de cette liste qu'on deduit 
	 * les technologies maîtrisees par le collaborateur
	 */
	private List<Competence> competences = new ArrayList<Competence>();
	
	/**
	 * la liste des affectations du collaborateur aux differentes managers RH
	 */
	private List<Affectation> affectations = new ArrayList<Affectation>();
	
	private String email;
	
	/**
	 * constructeur par defaut necessaire pour le mecanisme de reflexion utilise par les frameworks
	 */
	public Collaborateur() {
		
	}

	/**
	 * @return the idCollaborateur
	 */
	public Long getIdCollaborateur() {
		return idCollaborateur;
	}

	/**
	 * @param idCollaborateur the idCollaborateur to set
	 */
	public void setIdCollaborateur(Long idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
	}

	/**
	 * @return the matricule
	 */
	public int getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the abreviation
	 */
	public String getAbreviation() {
		return abreviation;
	}

	/**
	 * @param abreviation the abreviation to set
	 */
	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}

	/**
	 * @return the sexe
	 */
	public char getSexe() {
		return sexe;
	}

	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	/**
	 * @return the site
	 */
	public String getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}

	/**
	 * @return the bu
	 */
	public String getBu() {
		return bu;
	}

	/**
	 * @param bu the bu to set
	 */
	public void setBu(String bu) {
		this.bu = bu;
	}

	/**
	 * @return the diplomes
	 */
	public List<Diplome> getDiplomes() {
		return diplomes;
	}

	/**
	 * @param diplomes the diplomes to set
	 */
	public void setDiplomes(List<Diplome> diplomes) {
		this.diplomes = diplomes;
	}

	/**
	 * @return the dateEmbauche
	 */
	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	/**
	 * @param dateEmbauche the dateEmbauche to set
	 */
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	/**
	 * @return the moisBap
	 */
	public String getMoisBap() {
		return moisBap;
	}

	/**
	 * @param moisBap the moisBap to set
	 */
	public void setMoisBap(String moisBap) {
		this.moisBap = moisBap;
	}

	/**
	 * @return the dateDepart
	 */
	public Date getDateDepart() {
		return dateDepart;
	}

	/**
	 * @param dateDepart the dateDepart to set
	 */
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	/**
	 * @return the dateParticipation
	 */
	public Date getDateParticipation() {
		return dateParticipation;
	}

	/**
	 * @param dateParticipation the dateParticipation to set
	 */
	public void setDateParticipation(Date dateParticipation) {
		this.dateParticipation = dateParticipation;
	}

	/**
	 * @return the postes
	 */
	public List<Poste> getPostes() {
		return postes;
	}

	/**
	 * @param postes the postes to set
	 */
	public void setPostes(List<Poste> postes) {
		this.postes = postes;
	}

	/**
	 * @return the postesApp
	 */
	public List<PosteAPP> getPostesApp() {
		return postesApp;
	}

	/**
	 * @param postesApp the postesApp to set
	 */
	public void setPostesApp(List<PosteAPP> postesApp) {
		this.postesApp = postesApp;
	}

	/**
	 * @return the salaires
	 */
	public List<Salaire> getSalaires() {
		return salaires;
	}

	/**
	 * @param salaires the salaires to set
	 */
	public void setSalaires(List<Salaire> salaires) {
		this.salaires = salaires;
	}

	/**
	 * @return the competences
	 */
	public List<Competence> getCompetences() {
		return competences;
	}

	/**
	 * @param competences the competences to set
	 */
	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Collaborateur [idCollaborateur=" + idCollaborateur
				+ ", matricule=" + matricule + ", nom=" + nom + ", prenom="
				+ prenom + ", abreviation=" + abreviation + ", sexe=" + sexe
				+ ", site=" + site + ", bu=" + bu + ", diplomes=" + diplomes
				+ ", dateEmbauche=" + dateEmbauche + ", moisBap=" + moisBap
				+ ", dateDepart=" + dateDepart + ", dateParticipation="
				+ dateParticipation + ", postes=" + postes + ", postesApp="
				+ postesApp + ", salaires=" + salaires + ", competences="
				+ competences + ", affectations=" + affectations + "]";
	}
	
	/**
	 * methode de clone pour que son appel lors d'une affectation engendre l'affectation de la reference
	 *  d'une nouvelle instance et non pas la reference du meme objet
	 */
	@Override
	public Collaborateur clone() {
    	Collaborateur o = null;
    	try {
      		// On récupère l'instance à renvoyer par l'appel de la 
      		// méthode super.clone()
      		o = (Collaborateur)super.clone();
    	} catch(CloneNotSupportedException cnse) {
      		// Ne devrait jamais arriver car nous implémentons 
      		// l'interface Cloneable
      		cnse.printStackTrace(System.err);
	    }
	    // on renvoie le clone
	    return o;
  	}
	
	//equals et hashcode
}
