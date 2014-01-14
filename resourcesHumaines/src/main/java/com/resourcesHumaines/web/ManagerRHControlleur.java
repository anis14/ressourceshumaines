package com.resourcesHumaines.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.resourcesHumaines.metier.bo.Compte;
import com.resourcesHumaines.metier.bo.ManagerRH;
import com.resourcesHumaines.service.ManagerRHService;
import com.resourcesHumaines.service.exception.DuplicateLoginException;
import com.resourcesHumaines.service.exception.EntityNotFoundSericeException;

public class ManagerRHControlleur extends DefaultControlleur{
	/**
	 * attribut permettant d'offrir les services de gestion des managersRH
	 */
	private ManagerRHService managerRHService;

	/**
	 * attribut permettant de stockers les informations d'un managerRH lors d'un ajout ...
	 */
	private ManagerRH managerRH = new ManagerRH();
	
	/**
	 * attribut necessaire lors de l'ajout d'un manager il encapsule les informations du son compte
	 */
	private Compte compte = new Compte();
	
	/**
	 * liste ds managers necessaires pour effectuer des recherches ..
	 */
	private List<ManagerRH> managers = new ArrayList<ManagerRH>();
	
	private String motCle;
	
	/**
	 * attribut necssaire lors d'execution de quelque traitement de recherche
	 */
	private ManagerRH managerRHRecherche = new ManagerRH();
	
	/**
	 * methode qui renvoi vers le formulaire d'ajout d'un manager RH
	 * @return
	 */
	public String gererManagerRH(){
		return adminPage("ajouterManagerRH")+ "?faces-redirect=true";
	}
	
	/**
	 * methode pour ajouter un manager RH
	 */
	public void ajouterManagerRH() {
		try {
			managerRH.setStatut(true);
			try {
				compte.setLogin(managerRH.getEmail());
				compte.setPassword(managerRH.getNom());
				managerRHService.ajouterManagerRH(managerRH, compte);
			} catch (DuplicateLoginException e) {
				addErrorMessage(null, "cette adresse email existe deja", "");
			}
			managerRH= new ManagerRH();
			addInfoMessage(null, "le manager est ajoute avec success", "");
		} catch (EntityNotFoundSericeException e) {
			//tracer et ....
			System.out.println(e.getMessage());
			addErrorMessage(null, "erreur lors de l'ajout veuillez ressayer", "");
		}
	}
	
	/**
	 * methode appeler a'aide d'une requete ajax pour initialiser le compte apres la saisi du nom du manager 
	 */
	public void preparerCompte(){
		compte.setLogin(managerRH.getEmail());
		compte.setPassword(managerRH.getNom());
		System.out.println(compte.getLogin());
		System.out.println(compte.getPassword());
	}
	
	
	public void rechercheParMotCle(){
		try {
			managers = managerRHService.rechercheParMotCle(motCle);
		} catch (EntityNotFoundSericeException e) {
			//tracer ...
			System.out.println(e.getMessage());
		}
	}
	
	
	public void modifierManager(){
		if(!validerManager()){
			managerRHService.modifierManagerRH(managerRHRecherche);
			for(int i=0 ;i<managers.size();i++){
				if(managers.get(i).getIdResponsable() == managerRHRecherche.getIdResponsable()){
					managers.set(i,managerRHRecherche.clone());
					break;
				}
			}
			addInfoMessage("", "les informations du manager ont etes modifies avec success", "");
		}
		managerRHRecherche = new ManagerRH();
	}
	
	public boolean validerManager(){
		boolean existeErreur = false;
		if("".equals(managerRHRecherche.getNom())){
			existeErreur = true;
			addErrorMessage("", "le nom est obligatoire", "");
		}
		if("".equals(managerRHRecherche.getPrenom())){
			existeErreur = true;
			addErrorMessage("", "le prenom est obligatoire", "");
		}
		if(!(managerRHRecherche.getEmail().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))){
			existeErreur = true;
			addErrorMessage("", "l'email n'est pas valide", "");
		}
		return existeErreur;
	}
	
	public void test(){
		System.out.println(managerRHRecherche.getNom());
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
	 * @return the managerRH
	 */
	public ManagerRH getManagerRH() {
		return managerRH;
	}

	/**
	 * @param managerRH the managerRH to set
	 */
	public void setManagerRH(ManagerRH managerRH) {
		this.managerRH = managerRH;
	}

	
	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
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
	 * @return the managerRHRecherche
	 */
	public ManagerRH getManagerRHRecherche() {
		return managerRHRecherche;
	}

	/**
	 * @param managerRHRecherche the managerRHRecherche to set
	 */
	public void setManagerRHRecherche(ManagerRH managerRHRecherche) {
		this.managerRHRecherche = managerRHRecherche;
	}

	/**
	 * @return the motCle
	 */
	public String getMotCle() {
		return motCle;
	}

	/**
	 * @param motCle the motCle to set
	 */
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	
	

}
