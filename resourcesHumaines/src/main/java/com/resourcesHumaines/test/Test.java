package com.resourcesHumaines.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.resourcesHumaines.dao.RoleDao;
import com.resourcesHumaines.dao.exception.EntityNotFoundException;
import com.resourcesHumaines.dao.impl.RoleDaoImpl;
import com.resourcesHumaines.metier.bo.Affectation;
import com.resourcesHumaines.metier.bo.Collaborateur;
import com.resourcesHumaines.metier.bo.Competence;
import com.resourcesHumaines.metier.bo.Compte;
import com.resourcesHumaines.metier.bo.Diplome;
import com.resourcesHumaines.metier.bo.ManagerRH;
import com.resourcesHumaines.metier.bo.Poste;
import com.resourcesHumaines.metier.bo.PosteAPP;
import com.resourcesHumaines.metier.bo.Privilege;
import com.resourcesHumaines.metier.bo.Role;
import com.resourcesHumaines.metier.bo.Salaire;
import com.resourcesHumaines.metier.bo.Technologie;
import com.resourcesHumaines.service.CollaborateurService;
import com.resourcesHumaines.service.ManagerRHService;
import com.resourcesHumaines.service.exception.EntityNotFoundSericeException;
import com.resourcesHumaines.util.EnvoiEmail;

public class Test {

	public static void main(String[] args) {
		System.out.println("debut");
		ApplicationContext cntx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CollaborateurService cs = (CollaborateurService) cntx
				.getBean("collaborateurServiceTarget");
		
//		try {
//			Collaborateur collaborateur = cs.getById(new Long(2));
//			System.out.println(collaborateur.getAffectations().size());
//		} catch (EntityNotFoundSericeException e) {
//			System.out.println(e.getMessage());
//		}
		
		
/*		ManagerRHService managerRHService = (ManagerRHService)cntx.getBean("managerRHServiceTarget");
		try {
			System.out.println(managerRHService.rechercheParMotCle("you").size());
		} catch (EntityNotFoundSericeException e) {
			System.out.println(e.getMessage());
		}
*/
		
//		ManagerRH managerRH = new ManagerRH();
//		managerRH.setEmail("benelhassan.abderrahim@gmail.com");
//		managerRH.setNom("benelhassan");
//		managerRH.setPrenom("abderrahim");
//		managerRH.setStatut(true);
//		Compte compte= new Compte();
//		compte.setLogin("abderrahimIng");
//		compte.setPassword("abderrahimIng");
//		
//		Privilege privilege = new Privilege("MODIFIER_COLLABORATEUR");
//		Privilege privilege2 = new Privilege("AFFICHER_STATISQTIQUES");
//		
//		Role role = new Role("ROLE_MANAGERRH");
//		role.getPrivileges().add(privilege);
//		role.getPrivileges().add(privilege2);
//		Role role = null;
//		try {
//			RoleDao roleDao = (RoleDao)cntx.getBean("roleDao");
//			role = roleDao.rechercheRoleParTitre("ROLE_MANAGERRH");
//		} catch (EntityNotFoundException e1) {
//			System.out.println(e1.getMessage());
//		}
//		compte.setRole(role);
//		ManagerRHService managerRHService = (ManagerRHService)cntx.getBean("managerRHServiceTarget");
//		try {
//			managerRHService.ajouterManagerRH(managerRH, compte);
//		} catch (EntityNotFoundSericeException e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//			EnvoiEmail.envoyerEmail("youness.bene@gmail.com");
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
/*		try {
			cs.delete(new Long(10));
		} catch (EntityNotFoundSericeException e) {
			System.out.println(e.getMessage());
		}*/
		
//		List<Collaborateur> cls = cs.rechercheAvancee("be", "youness", 'M',
//				"BU", new Date(), new Date(), true, 12000, 20000);
//		System.out.println(cls.size());
//		for(Collaborateur col : cls){
//			System.out.println("------------------");
//			System.out.println("nom : " +col.getNom());
//			System.out.println("prenom : " +col.getPrenom());
//			System.out.println("dateEmbauche : " +col.getDateEmbauche());
//			System.out.println("particite : " +col.getDateParticipation() != null);
//			List<Salaire> ss = col.getSalaires();
//			for(Salaire s :ss){
//				if(s.isSalaireActuel()){
//					System.out.println("salaire actuel : " + s.getSalaire());
//				}
//			}
//			
//		}
		
		
//		 try {
//		 System.out.println(cs.rechercheParMatricule("mat1").getNom());
//		 } catch (EntityNotFoundSericeException e) {
//		 System.out.println(e.getMessage());
//		 }
/*		 Technologie t1 = new Technologie("jsf");
		 Technologie t2 = new Technologie("struts2");
		 Competence comp1 = new Competence("dev jsf", 2, t1);
		 Competence comp2 = new Competence("dev des app web ac str2", 4, t2);
		 List<Competence> comps = new ArrayList<Competence>();
		 comps.add(comp1);
		 comps.add(comp2);
		 Poste p = new Poste("poste1", new Date(), true);
		 PosteAPP pAPP = new PosteAPP("posteApp", new Date(), true);
		 Salaire s = new Salaire(12000, new Date(), true);
		 ManagerRHService managerRHService = (ManagerRHService)cntx.getBean("managerRHServiceTarget");
		 ManagerRH managerRH = null;
		try {
			managerRH = managerRHService.getById(new Long(1));
			 Collaborateur col = new Collaborateur();
			 col.setNom("belhassan");
			 col.setPrenom("youness");
			 col.setAbreviation("bly");
			 col.setMatricule(12345);
			 List<Diplome> dips = new ArrayList<Diplome>();
			 dips.add(new Diplome("bac + 2", "esto", "nationale", "etatique", "2008"));
			 cs.ajouterCollaborateur(col, p, pAPP, s, comps,dips, managerRH);
		} catch (EntityNotFoundSericeException e1) {
			System.out.println(e1);
		}
		
*/
//			try {
//				Collaborateur col = cs.getById(new Long(1));
//				System.out.println(col.getNom());
//				System.out.println("affectations : " + col.getAffectations().size());
//				for(Affectation a : col.getAffectations()){
//					System.out.println(a);
//				}
//			} catch (EntityNotFoundSericeException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		 System.out.println(cs.getAll().size());
		System.out.println("fin");
	}
}
