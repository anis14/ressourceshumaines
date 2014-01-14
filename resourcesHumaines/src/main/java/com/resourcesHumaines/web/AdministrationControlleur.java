package com.resourcesHumaines.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.resourcesHumaines.metier.bo.Privilege;
import com.resourcesHumaines.metier.bo.Role;
import com.resourcesHumaines.service.PrivilegeService;
import com.resourcesHumaines.service.RoleService;
import com.resourcesHumaines.service.exception.EntityNotFoundSericeException;

public class AdministrationControlleur extends DefaultControlleur{

	private RoleService roleService;
	
	private PrivilegeService priviligeService;

	/**
	 * necessaire pour creer un nouveau profil
	 */
	private Role role = new Role();
	
	/**
	 * necessaire pour creer une nouvelle permission
	 */
	private Privilege privilege = new Privilege();
	
	/**
	 * necesaire pour recuperer la liste des roles 
	 */
	private List<Role> roles;
	
	private List<Privilege> privileges =new ArrayList<Privilege>();
	
	private List<Privilege> noPermission = new ArrayList<Privilege>();
	
	@PostConstruct
	public void init(){
		try {
			roles = roleService.getAll();
			privileges = priviligeService.getAll();
		} catch (EntityNotFoundSericeException e) {
			//tracer ....
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * methode pour creer un role
	 */
	public void ajouterRole(){
		try {
			roleService.creerProfil(role);
			roles =roleService.getAll();
			role = new Role();
			addInfoMessage(null, "le role est ajoute avec success", "");
		} catch (EntityNotFoundSericeException e) {
			// tracer...
			System.out.println(e.getMessage());
			addErrorMessage(null, "ereur lors d'ajout du profil", "");
		}
	}
	
	public void ajouterPrivilege(){
		try {
			priviligeService.creerPermission(privilege);
			privileges = priviligeService.getAll();
			addInfoMessage(null, "la permission est ajoute avec success", "");
			privilege = new Privilege();
		} catch (EntityNotFoundSericeException e) {
			// tracer ...
			System.out.println(e.getMessage());
			addErrorMessage(null, "ereur lors d'ajout de la permission", "");
		}
	}
	
	public void preparerPrivileges(Role pRole){
		role = pRole;
		noPermission = new ArrayList<Privilege>();
		System.out.println(pRole.getIntitule());
		for(Privilege priv : privileges)
		{
			if(!(pRole.getPrivileges().contains(priv))){
				noPermission.add(priv);
			}
		}
	}
	
	
	public void retirer(Privilege pPrivilege){
		role.getPrivileges().remove(pPrivilege);
		try {
			roleService.modifierProfil(role);
			preparerPrivileges(role);
			addInfoMessage(null, "la premission a ete retiree avec success", "");
		} catch (EntityNotFoundSericeException e) {
			//tracer...
			addErrorMessage(null, "Erreur lors de l'operation", "");
		}
		
	}
	
	public void ajouter(Privilege pPrivilege){
		role.getPrivileges().add(pPrivilege);
		try {
			roleService.modifierProfil(role);
			preparerPrivileges(role);
			addInfoMessage(null, "la premission a ete ajoutee avec success", "");
		} catch (EntityNotFoundSericeException e) {
			//tracer...
			addErrorMessage(null, "Erreur lors de l'operation", "");
		}
	}
	
	public void terminer(){
		role = new Role();
		privilege = new Privilege();
	}
	
	/**
	 * @return the roleService
	 */
	public RoleService getRoleService() {
		return roleService;
	}

	/**
	 * @param roleService the roleService to set
	 */
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * @return the priviligeService
	 */
	public PrivilegeService getPriviligeService() {
		return priviligeService;
	}

	/**
	 * @param priviligeService the priviligeService to set
	 */
	public void setPriviligeService(PrivilegeService priviligeService) {
		this.priviligeService = priviligeService;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the rivilege
	 */
	public Privilege getPrivilege() {
		return privilege;
	}

	/**
	 * @param rivilege the rivilege to set
	 */
	public void setPrivilege(Privilege rivilege) {
		this.privilege = rivilege;
	}

	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the privileges
	 */
	public List<Privilege> getPrivileges() {
		return privileges;
	}

	/**
	 * @param privileges the privileges to set
	 */
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	/**
	 * @return the noPermission
	 */
	public List<Privilege> getNoPermission() {
		return noPermission;
	}

	/**
	 * @param noPermission the noPermission to set
	 */
	public void setNoPermission(List<Privilege> noPermission) {
		this.noPermission = noPermission;
	}
	
	
	
	
	
}
