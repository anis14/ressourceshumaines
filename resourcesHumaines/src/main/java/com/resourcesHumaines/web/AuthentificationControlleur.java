package com.resourcesHumaines.web;

import java.io.IOException;
import java.util.Collection;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthentificationControlleur extends DefaultControlleur{

	private String username;
	
	private String password;
	
	public String login() throws IOException, ServletException {

		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();

		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
				.getRequestDispatcher("/j_spring_security_check?j_username="
						+ username + "&j_password=" + password);

		dispatcher.forward((ServletRequest) context.getRequest(),
				(ServletResponse) context.getResponse());

		FacesContext.getCurrentInstance().responseComplete();
		// It's OK to return null here because Faces is just going to exit.

		return null;
	}
	
	public void redirect() throws IOException {

		String contextPath  = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() ;
		Collection ath = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();

		if (ath.contains(new GrantedAuthorityImpl("ROLE_MANAGERRH"))) {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(contextPath+userPage("acceuil"));
		}
		else if (ath.contains(new GrantedAuthorityImpl("ROLE_ADMIN"))) {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect(contextPath+adminPage("acceuil"));
		}
	}

	public void logout() throws IOException, ServletException{
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();

		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
				.getRequestDispatcher("/j_spring_security_logout");

		dispatcher.forward((ServletRequest) context.getRequest(),
				(ServletResponse) context.getResponse());

		FacesContext.getCurrentInstance().responseComplete();
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
