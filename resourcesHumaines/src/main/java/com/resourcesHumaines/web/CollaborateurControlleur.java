package com.resourcesHumaines.web;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.resourcesHumaines.metier.bo.Affectation;
import com.resourcesHumaines.metier.bo.Collaborateur;
import com.resourcesHumaines.metier.bo.Competence;
import com.resourcesHumaines.metier.bo.Diplome;
import com.resourcesHumaines.metier.bo.ManagerRH;
import com.resourcesHumaines.metier.bo.Poste;
import com.resourcesHumaines.metier.bo.PosteAPP;
import com.resourcesHumaines.metier.bo.Salaire;
import com.resourcesHumaines.service.CollaborateurService;
import com.resourcesHumaines.service.ManagerRHService;
import com.resourcesHumaines.service.exception.EntityNotFoundSericeException;

/**
 * c est la classe permettant de controller les requetes concernant la gestion
 * des collaborateurs tel que l'ajout la modification ... des collaborateurs
 */
public class CollaborateurControlleur extends DefaultControlleur {

	/**
	 * service permettant d'offrir les service de gestion des collaborateurs
	 */
	private CollaborateurService collaborateurService;
	
	private ManagerRHService managerRHService;
	
	/**
	 * un attribut collaborateur necessaire pour recuperer les informations d'un
	 * collaborateur qui viennet d'une requet d'ajout d'un collaborateur
	 */
	private Collaborateur collaborateur = new Collaborateur();

	private Collaborateur collaborateur2 = new Collaborateur();
	
	/**
	 * les des collaborateur pour stocker les collaborateurs lors de la
	 * recherche ...
	 */
	private List<Collaborateur> collaborateurs = new ArrayList<Collaborateur>();

	private String abreviation;

	private String matricule;

	private List<String> mois = new ArrayList<String>();

	private String[] moisAnnee = new DateFormatSymbols().getMonths();

	private boolean participe;

	private Diplome diplome = new Diplome();

	private Diplome diplome2 = new Diplome();
	
	private int numeroLigne;

	private List<Diplome> diplomes = new ArrayList<Diplome>();

	private Competence competence = new Competence();
	
	private Competence competence2 = new Competence();

	private List<Competence> competences = new ArrayList<Competence>();

	private Poste poste = new Poste();

	private PosteAPP posteApp = new PosteAPP();

	private Salaire salaire = new Salaire();

	private List<ManagerRH> managers = new ArrayList<ManagerRH>();
	
	private ManagerRH managerRH = new ManagerRH();
	
	private ManagerRH ancienManager = new ManagerRH();
	
	private Long idManagerRH;

	private float salaireMinimum;

	private float salaireMAximum;
	
	private String nom;
	
	private String prenom;
	
	private String bu;
	
	private Date dateEmbauche;
	
	private char sexe;
	
	private String site;

	public CollaborateurControlleur() {
		initMois();
	}
	
	
	@PostConstruct
	public void init(){
		managers = managerRHService.getAll();
		try {
			salaireMAximum = collaborateurService.getMaxSalaire();
		} catch (EntityNotFoundSericeException e) {
			//tracer ...
			System.out.println(e.getMessage());
		}
	}

	/**
	 * returner vers la page permettant d'afficher le formulaire d'ajout d'un
	 * collaborateur
	 * 
	 * @return
	 */
	public String nouveauCollaborateur() {
		return userPage("ajouterCollaborateur") + "?faces-redirect=true";
	}

	/**
	 * methode pour le controle d'ajout d'un collaborateur
	 */
	public String ajouterCollaborateur() {
		poste.setDateAffectation(new Date());
		poste.setPosteActuel(true);
		posteApp.setDateAffectation(new Date());
		posteApp.setPosteActuel(true);
		salaire.setDateAffectation(new Date());
		salaire.setSalaireActuel(true);
		for(int i=0;i<managers.size();i++){
			if(managers.get(i).getIdResponsable().equals(idManagerRH)){
				managerRH = managers.get(i);
				break;
			}
		}
		try {
			collaborateurService.ajouterCollaborateur(collaborateur, poste,
					posteApp, salaire, competences, diplomes, managerRH);
		} catch (EntityNotFoundSericeException e) {
			// tracer et afficher msg d'erreur a l'utilisateur
			System.out.println(e.getMessage());
		}
		collaborateur = new Collaborateur();
		addInfoMessage(null, "le collaborateur est ajoute avec success", "");
		return userPage("acceuil") + "?faces-redirect=true";
	}

	public void designerManagerRH(){
		for(int i=0;i<managers.size();i++){
			if(managers.get(i).getIdResponsable().equals(idManagerRH)){
				managerRH = managers.get(i);
				break;
			}
		}
		try {
			collaborateur2 = collaborateurService.getById(collaborateur2.getIdCollaborateur());
			managerRHService.affecterCollaborateur(managerRH.clone(), collaborateur2, new Date());
			rechercheAvancee();
		} catch (EntityNotFoundSericeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * methode pour modifier un collaborateur
	 */
	public void modifierCollaborateur(){
		boolean existeErreur = false;
		existeErreur = validerCollaborateur();
		if(!existeErreur){
			collaborateurService.modifierCollaborateur(collaborateur);
			for(int i=0;i<collaborateurs.size();i++){
				if(collaborateurs.get(i).getIdCollaborateur() == collaborateur.getIdCollaborateur()){
					collaborateurs.set(i, collaborateur.clone());
					break;
				}
			}
			addInfoMessage(null, "le collaborateur est modifie avec success", "");
		}
	}
	
/**
 * methode pour valider les informationsd'un collaborateur
 * @return
 */
private boolean validerCollaborateur() {
		boolean existeErreur = false;
		if(!(String.valueOf(collaborateur.getMatricule()).matches("[0-9]{5}"))){
			existeErreur = true;
			addErrorMessage(null, "matricule n'est pas valide", "");
		}
		if(collaborateur.getPrenom().equals("")){
			existeErreur = true;
			addErrorMessage(null, "le prenom est obligatoire", "");
		}
		if(collaborateur.getNom().equals("")){
			existeErreur = true;
			addErrorMessage(null, "le nom est obligatoire", "");
		}
		if(!collaborateur.getAbreviation().matches("[a-zA-Z]{3}")){
			existeErreur = true;
			addErrorMessage(null, "l'abreviation n'est pas valide", "");
		}
		if(!collaborateur.getBu().matches("[a-zA-Z]{3}[a-zA-Z0-9]")){
			existeErreur = true;
			addErrorMessage(null, "business unit n'est pas valide", "");
		}
		if(!collaborateur.getEmail().matches("[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})")){
			existeErreur = true;
			addErrorMessage(null, "adresse email non valide", "");
		}
		return existeErreur;
	}

//	public void affectation(){
//		
//	}
//	
////	public void supprimerCollaborateur(){
////		System.out.println(collaborateur.getIdCollaborateur());
////		System.out.println(collaborateur.getMatricule());
////		if(collaborateur.getIdCollaborateur() != null){
////			try {
////				collaborateurService.delete(collaborateur.getIdCollaborateur());
////				collaborateurs.remove(collaborateur);
////			} catch (EntityNotFoundSericeException e) {
////				//tracer et afficher un msg dans le context
////				System.out.println(e.getMessage());
////			}
////		}
////	}
	
	public String rechercheParMatricule() {
		try {
			
			int mat = Integer.valueOf(matricule);
			collaborateurs = collaborateurService.rechercheParMatricule(mat);
		} catch (EntityNotFoundSericeException e) {
			// traitement de l'exception
			// tracer dans le fichier de journalisation
			return errorPage() + "?faces-redirect=true";
		}
		return userPage("resultatRecherche") + "?faces-redirect=true";
	}
	
	
	/**
	 * methode pour verifier lors de l'ajout d'un collaborateur qu'il n'existe pas 
	 * un autre collaborateur avec la meme matricule
	 */
	public void verifierMatricule(){
		try {
			int mat = Integer.valueOf(collaborateur.getMatricule());
			List<Collaborateur> cols = collaborateurService.rechercheParMatricule(mat);
			if(cols.size() > 0){
				addErrorMessage(null, "cette matricule existe deja", "");
				System.out.println("existe");
			}
		} catch (EntityNotFoundSericeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void rechercheParAbreviation() {
		collaborateurs = new ArrayList<Collaborateur>();
		String roleManagerRH = "ROLE_MANAGERRH";
		String loginManagerRH = "";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(hasRole(auth, roleManagerRH)){
			loginManagerRH = auth.getName();
		}
		try {
			collaborateurs = collaborateurService.rechercheParAbreviation(abreviation,loginManagerRH);
			System.out.println(collaborateurs.size());
		} catch (EntityNotFoundSericeException e) {
			// traitement de l'exception
			// tracer dans le fichier de journalisation
		}
	}
	

	/**
	 * methode pour effectuer une recherche avancee sur la totalite des coaborateurs
	 * @return
	 */
	public void rechercheAvancee() {
		collaborateurs = collaborateurService.rechercheAvancee(
				nom, prenom,sexe, bu,dateEmbauche,null, participe, salaireMinimum,salaireMAximum,"",site);
	}

	/**
	 * methode por effectuer une recherche avance seulement sur les collaborateur affecter au manager RH connecte et effectuant la recherche
	 */
	public void rechercheAvanceeParManager() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		collaborateurs = collaborateurService.rechercheAvancee(
				nom, prenom,sexe, bu,dateEmbauche,null, participe, salaireMinimum,salaireMAximum,auth.getName(),site);
	}
	
	/**
	 * ajouter une formation au collaborateur
	 */
	public void ajouterFormation() {
		System.out.println("acole : " + diplome.getEcole());
		System.out.println("collaborateur" + collaborateur2.getNom());
		boolean existeErreur = validerDiplome(diplome);
		//si on ajoute la formation lors de la modification d'un collaborateur
		if(!existeErreur){
			if(collaborateur2.getIdCollaborateur() != null){
				System.out.println(collaborateur2.getNom());
				collaborateur2.getDiplomes().add(diplome.clone());
				collaborateurService.modifierCollaborateur(collaborateur2);
				System.out.println(collaborateur2.getNom());
			}
			else {
				// si on ajoute la formation lors de l'ajout d'un collaborateur
				diplomes.add(diplome.clone());
			}
			addInfoMessage(null, "la formation est ajoutee avec success", "");
		}
		diplome = new Diplome();
	}

	public void modifierFormation() {
		boolean existeErreur = false;
		existeErreur = validerDiplome(diplome2);
		if(!existeErreur){
			
				collaborateur.getDiplomes().set(numeroLigne, diplome2.clone());
				try {
					collaborateurService.modifierDiplome(diplome2.clone());
				} catch (EntityNotFoundSericeException e) {
					System.out.println(e.getMessage());
				}
		}
		diplome2 = new Diplome();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String roleManager = "ROLE_MANAGERRH";
		boolean isManager = hasRole(auth,roleManager);
		if(isManager){
			rechercheAvanceeParManager();
		}
		else {
			rechercheAvancee();
		}
		
	}
	
	public boolean hasRole(Authentication authe,String role){
		for(GrantedAuthority auth : authe.getAuthorities()){
			if(auth.getAuthority().equals(role)){
				return true;
			}
		}
		return false;
	}
	
	public void modifierFormationAjout(){
		boolean existeErreur = false;
		existeErreur = validerDiplome(diplome2);
		if(!existeErreur){
				System.out.println(numeroLigne);
				System.out.println(diplome2.getEcole());
				diplomes.set(numeroLigne, diplome2);
				addInfoMessage(null, "la formation est modifie avec success", "");
			}
		diplome2 = new Diplome();
	}
	
	public void supprimerFormation(int numeroLigne){
		diplomes.remove(numeroLigne);
		addInfoMessage(null, "la formation a ete supprimee avec success", "");
	}
	
	/** 
	 * methode privee pour valider les champs obligatoires d'une formation
	 * @return
	 */
	private boolean validerDiplome(Diplome pDiplome) {
		boolean existeErreur = false;
		System.out.println("ecole : " + pDiplome.getEcole());
		System.out.println(pDiplome.getPromotion());
		if(pDiplome.getEcole().equals("")){
			existeErreur = true;
			addErrorMessage(null, "l'ecole est obligatoire", "");
		}
		if(!pDiplome.getPromotion().matches("[0-9]{4}")){
			existeErreur = true;
			addErrorMessage(null, "promotion n'est pas valide", "");
		}
		return existeErreur;
	}

	/**
	 * ajouter une competence au collaborateur
	 */
	public void ajouterCompetence() {
		boolean existeErreur = validerCompetence(competence);
		if(!existeErreur){
			competences.add(competence);
			competence = new Competence();
			addInfoMessage(null, "la competence est ajoutee avec success", "");
		}
	}

	/**
	 * methode our modifier la competence d'un collaborateur
	 */
	public void modifierCompetence(){
		boolean existeErreur = false;
		existeErreur = validerCompetence(competence2);
		if(!existeErreur){
			competences.set(numeroLigne, competence2.clone());
			competence2 = new Competence();
			addInfoMessage(null, "la competence est modifie avec success", "");
//			for(int i=0;i<collaborateur.getCompetences().size();i++){
//				if(collaborateur.getCompetences().get(i).getIdCompetence() == competence.getIdCompetence()){
//					collaborateur.getCompetences().set(i, competence);
//					break;
//				}
//			}
//			collaborateurService.modifierCollaborateur(collaborateur);
		}
	}
	
	public void modifierCompetenceAjout(){
		boolean existeErreur = false;
		existeErreur = validerCompetence(competence2);
		if(!existeErreur){
			competences.set(numeroLigne, competence2.clone());
			competence2 = new Competence();
		}
	}
	
	public void supprimerCompetence(int numeroLigne){
		competences.remove(numeroLigne);
		addInfoMessage(null, "la competence a ete supprimee avec success", "");
	}
	
	/** 
	 * methode privee pour valider les champs obligatoires d'une competence
	 * @return
	 */
	private boolean validerCompetence(Competence pCompetence) {
		boolean existeErreur = false;
		if(pCompetence.getTitre().equals("")){
			existeErreur = true;
			addErrorMessage(null, "le titre de la competence est obligatoire", "");
		}
		if(pCompetence.getTechnologie().getTitre().matches("")){
			existeErreur = true;
			addErrorMessage(null, "la technologies est obligatoire", "");
		}
		return existeErreur;
	}
	
	/**
	 * pour mettre a jour le champs abreviation lors de la saisi du nom,prenom
	 * du collaborateur
	 */
	public void updateAbreviation() {
		if ((collaborateur.getNom() != null)
				&& (collaborateur.getPrenom() != null)
				&& (collaborateur.getPrenom().length() >= 1) && (collaborateur.getNom().length() >= 2)) {
			String abreviation = collaborateur.getPrenom().substring(0, 1)
					+ collaborateur.getNom().substring(0, 2);
			collaborateur.setAbreviation(abreviation);
		}
	}

	/**
	 * methode pour initialiser le tebleau des mois
	 */
	public void initMois() {
		mois.add("Janvier");
		mois.add("Fevrier");
		mois.add("Mars");
		mois.add("Avril");
		mois.add("Mai");
		mois.add("Juin");
		mois.add("Juillet");
		mois.add("Aout");
		mois.add("Septembre");
		mois.add("Octobre");
		mois.add("Novembre");
		mois.add("Decembre");
	}

	/**
	 * mettre a jour le champ mois abp apres la saisi de la date d'embauche
	 * 
	 * @param event
	 */
	public void updateMoisABP(SelectEvent event) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(collaborateur.getDateEmbauche());
		int jour = calendar.get(Calendar.DAY_OF_MONTH);
		int numeroMois = calendar.get(Calendar.MONTH);
		if (jour > 15 && numeroMois < 11) {
			numeroMois += 1;
		}
		mois = new ArrayList<String>();
		initMois();
		String moisABP = mois.remove(numeroMois);
		System.out.println(mois);
		mois.add(0, moisABP);
		System.out.println(mois);
	}

	/**
	 * necessaire pour le composant wizard de primefaces lors du clique sur les
	 * bouttons next et back
	 * 
	 * @param event
	 * @return
	 */
	public String onFlowProcess(FlowEvent event) {
		List<Collaborateur> cols = null;
		try {
			int mat = Integer.valueOf(collaborateur.getMatricule());
			cols = collaborateurService.rechercheParMatricule(mat);
		} catch (EntityNotFoundSericeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!(cols == null) && (cols.size() > 0)){
			addErrorMessage(null, "cette matricule existe deja", "");
			System.out.println("existe");
			return event.getOldStep();
		}else
		{
			return event.getNewStep();
		}
	}

//	public void onRowToggle(ToggleEvent event) {
//		
//    }  
	
	public void onRowToggle(Collaborateur col){
		collaborateur = null;
		salaire = new Salaire();
		poste = new Poste();
		posteApp = new PosteAPP();
        try {
			collaborateur = collaborateurService.getById(col.getIdCollaborateur());
		} catch (EntityNotFoundSericeException e) {
			System.out.println(e.getMessage());
		}
        for(Salaire sal : collaborateur.getSalaires()){
        	if(sal.isSalaireActuel()){
        		salaire = sal;
        		break;
        	}
        }
        for(Poste pos : collaborateur.getPostes()){
        	if(pos.isPosteActuel()){
        		poste = pos;
        		break;
        	}
        }
        for(PosteAPP posAPP : collaborateur.getPostesApp()){
        	if(posAPP.isPosteActuel()){
        		posteApp = posAPP;
        		break;
        	}
        }
        int size = collaborateur.getAffectations().size();
        if(size > 0){
        	Collections.sort(collaborateur.getAffectations());
            System.out.println("sizeeee"+size);
            if(size > 1){
            	
            	ancienManager = collaborateur.getAffectations().get(size-2).getManagerRH();
            }
            managerRH = collaborateur.getAffectations().get(size-1).getManagerRH();
        }
        System.out.println(collaborateur.getNom());
	}
	
	/**
	 * @return the collaborateurService
	 */
	public CollaborateurService getCollaborateurService() {
		return collaborateurService;
	}

	/**
	 * @param collaborateurService
	 *            the collaborateurService to set
	 */
	public void setCollaborateurService(
			CollaborateurService collaborateurService) {
		this.collaborateurService = collaborateurService;
	}

	
	
	/**
	 * @return the managerRHService
	 */
	public ManagerRHService getManagerRHService() {
		return managerRHService;
	}

	/**
	 * @param managerRHService the managerRHService to set
	 */
	public void setManagerRHService(ManagerRHService managerRHService) {
		this.managerRHService = managerRHService;
	}

	/**
	 * @return the collaborateur
	 */
	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	/**
	 * @param collaborateur
	 *            the collaborateur to set
	 */
	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	/**
	 * @return the collaborateurs
	 */
	public List<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}

	/**
	 * @param collaborateurs
	 *            the collaborateurs to set
	 */
	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	/**
	 * @return the abreviation
	 */
	public String getAbreviation() {
		return abreviation;
	}

	/**
	 * @param abreviation
	 *            the abreviation to set
	 */
	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}

	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the mois
	 */
	public List<String> getMois() {
		return mois;
	}

	/**
	 * @param mois
	 *            the mois to set
	 */
	public void setMois(List<String> mois) {
		this.mois = mois;
	}

	/**
	 * @return the participe
	 */
	public boolean isParticipe() {
		return participe;
	}

	/**
	 * @param participe
	 *            the participe to set
	 */
	public void setParticipe(boolean participe) {
		this.participe = participe;
	}

	/**
	 * @return the diplome
	 */
	public Diplome getDiplome() {
		return diplome;
	}

	/**
	 * @param diplome
	 *            the diplome to set
	 */
	public void setDiplome(Diplome diplome) {
		this.diplome = diplome;
	}

	/**
	 * @return the competence
	 */
	public Competence getCompetence() {
		return competence;
	}

	/**
	 * @param competence
	 *            the competence to set
	 */
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	
	
	/**
	 * @return the competence2
	 */
	public Competence getCompetence2() {
		return competence2;
	}


	/**
	 * @param competence2 the competence2 to set
	 */
	public void setCompetence2(Competence competence2) {
		this.competence2 = competence2;
	}


	/**
	 * @return the managerRH
	 */
	public ManagerRH getManagerRH() {
		return managerRH;
	}

	/**
	 * @param managerRH
	 *            the managerRH to set
	 */
	public void setManagerRH(ManagerRH managerRH) {
		this.managerRH = managerRH;
	}
	
	

	/**
	 * @return the managers
	 */
	public List<ManagerRH> getManagers() {
		return managers;
	}

	/**
	 * @param managers the managers to set
	 */
	public void setManagers(List<ManagerRH> managers) {
		this.managers = managers;
	}

	/**
	 * @return the poste
	 */
	public Poste getPoste() {
		return poste;
	}

	/**
	 * @param poste
	 *            the poste to set
	 */
	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	/**
	 * @return the posteApp
	 */
	public PosteAPP getPosteApp() {
		return posteApp;
	}

	/**
	 * @param posteApp
	 *            the posteApp to set
	 */
	public void setPosteApp(PosteAPP posteApp) {
		this.posteApp = posteApp;
	}

	/**
	 * @return the salaire
	 */
	public Salaire getSalaire() {
		return salaire;
	}

	/**
	 * @param salaire
	 *            the salaire to set
	 */
	public void setSalaire(Salaire salaire) {
		this.salaire = salaire;
	}

	/**
	 * @return the diplomes
	 */
	public List<Diplome> getDiplomes() {
		return diplomes;
	}

	/**
	 * @param diplomes
	 *            the diplomes to set
	 */
	public void setDiplomes(List<Diplome> diplomes) {
		this.diplomes = diplomes;
	}

	/**
	 * @return the competences
	 */
	public List<Competence> getCompetences() {
		return competences;
	}

	/**
	 * @param competences
	 *            the competences to set
	 */
	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	/**
	 * @return the diplome2
	 */
	public Diplome getDiplome2() {
		return diplome2;
	}

	/**
	 * @param diplome2
	 *            the diplome2 to set
	 */
	public void setDiplome2(Diplome diplome2) {
		this.diplome2 = diplome2;
	}

	
	
	/**
	 * @return the numeroLigne
	 */
	public int getNumeroLigne() {
		return numeroLigne;
	}


	/**
	 * @param numeroLigne the numeroLigne to set
	 */
	public void setNumeroLigne(int numeroLigne) {
		this.numeroLigne = numeroLigne;
	}


	/**
	 * @return the salaireMinimum
	 */
	public float getSalaireMinimum() {
		return salaireMinimum;
	}

	/**
	 * @param salaireMinimum
	 *            the salaireMinimum to set
	 */
	public void setSalaireMinimum(float salaireMinimum) {
		this.salaireMinimum = salaireMinimum;
	}

	/**
	 * @return the salaireMAximum
	 */
	public float getSalaireMAximum() {
		return salaireMAximum;
	}

	/**
	 * @param salaireMAximum
	 *            the salaireMAximum to set
	 */
	public void setSalaireMAximum(float salaireMAximum) {
		this.salaireMAximum = salaireMAximum;
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
	 * @return the idManagerRH
	 */
	public Long getIdManagerRH() {
		return idManagerRH;
	}


	/**
	 * @param idManagerRH the idManagerRH to set
	 */
	public void setIdManagerRH(Long idManagerRH) {
		this.idManagerRH = idManagerRH;
	}


	/**
	 * @return the ancienManager
	 */
	public ManagerRH getAncienManager() {
		return ancienManager;
	}


	/**
	 * @param ancienManager the ancienManager to set
	 */
	public void setAncienManager(ManagerRH ancienManager) {
		this.ancienManager = ancienManager;
	}


	/**
	 * @return the collaborateur2
	 */
	public Collaborateur getCollaborateur2() {
		return collaborateur2;
	}


	/**
	 * @param collaborateur2 the collaborateur2 to set
	 */
	public void setCollaborateur2(Collaborateur collaborateur2) {
		this.collaborateur2 = collaborateur2;
	}

	
	
}
