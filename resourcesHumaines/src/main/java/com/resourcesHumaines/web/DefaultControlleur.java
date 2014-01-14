/**
 * 
 */
package com.resourcesHumaines.web;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * c'est la classe mere de toutes les classes controlleurs il permet d'offrir un ensemble 
 * de services necessaires pour toutes les sous classes
 *
 */
public class DefaultControlleur{

	/**
	 * les chemins des dossiers contenant les pages 
	 */
	public static final String PAGES_FOLDER = "/pages/";
	public static final String PAGES_ADMIN_FOLDER = "/pages/admin/";
	public static final String PAGES_USER_FOLDER = "/pages/user/";
	public static final String PAGES_TYPE = ".xhtml";
	
	/**
	 * pour recuperer le contexte de l'application
	 * @return
	 */
	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * recuperer le contexte del'application
	 * @return
	 */
	protected Application getApplication() {
		return getFacesContext().getApplication();
	}

	/**
	 * recuperer la session utilisateur
	 * @return
	 */
	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * recuperer la requete utilisateur
	 * @return
	 */
	protected HttpServletRequest getRequest() {
		HttpServletRequest request = (HttpServletRequest) getFacesContext()
				.getExternalContext().getRequest();
		return request;
	}

	/**
	 * recuperer la valeur d'un parametre dans la requete
	 * @param name
	 * @return
	 */
	protected String getParameter(String name) {
		HttpServletRequest request = getRequest();
		return request.getParameter(name);
	}

	/**
	 * retourner une page d'administration dont le nom est passe en parametre
	 * @param page
	 * @return
	 */
	protected String adminPage(String page) {

		return PAGES_ADMIN_FOLDER + page + PAGES_TYPE;
	}

	/**
	 * retourner la page d'erreur
	 * @return
	 */
	protected String errorPage() {

		return PAGES_USER_FOLDER + "error" + PAGES_TYPE;
	}

	/**
	 * rtourner la page utilisateur dont le nom est passe en parametre 
	 * @param page
	 * @return
	 */
	protected String userPage(String page) {

		return PAGES_USER_FOLDER + page + PAGES_TYPE;
	}

	/**
	 * ajouter un message d'information dans le contexte jsf sur un composant 
	 * @param idComponent
	 * @param summary
	 * @param detail
	 */
	protected void addInfoMessage(String idComponent, String summary,
			String detail) {
		
		FacesContext context = FacesContext.getCurrentInstance(); 
	    context.addMessage(null, new FacesMessage(summary, detail)); 
//		FacesContext.getCurrentInstance().addMessage(idComponent,
//				new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));

	}

	/**
	 * ajouter un message d'erreur dans le contexte jsf sur un composant 
	 * @param idComponent
	 * @param summary
	 * @param detail
	 */
	protected void addErrorMessage(String idComponent, String summary,
			String detail) {
		FacesContext.getCurrentInstance().addMessage(idComponent,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));

	}
}
