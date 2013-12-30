package com.resourcesHumaines.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.resourcesHumaines.metier.bo.Collaborateur;
import com.resourcesHumaines.metier.bo.Competence;
import com.resourcesHumaines.metier.bo.ManagerRH;
import com.resourcesHumaines.metier.bo.Poste;
import com.resourcesHumaines.metier.bo.PosteAPP;
import com.resourcesHumaines.metier.bo.Salaire;
import com.resourcesHumaines.metier.bo.Technologie;
import com.resourcesHumaines.service.CollaborateurService;
import com.resourcesHumaines.service.exception.EntityNotFoundSericeException;

public class Test {

	public static void main(String[] args) {
		System.out.println("debut");
		ApplicationContext cntx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CollaborateurService cs = (CollaborateurService) cntx
				.getBean("collaborateurService");
		List<Collaborateur> cls = cs.rechercheAvancee("be", "youness", 'M',
				"BU", new Date(), new Date(), true, 12000, 20000);
		System.out.println(cls.size());
		for(Collaborateur col : cls){
			System.out.println("------------------");
			System.out.println("nom : " +col.getNom());
			System.out.println("prenom : " +col.getPrenom());
			System.out.println("dateEmbauche : " +col.getDateEmbauche());
			System.out.println("particite : " +col.getDateParticipation() != null);
			List<Salaire> ss = col.getSalaires();
			for(Salaire s :ss){
				if(s.isSalaireActuel()){
					System.out.println("salaire actuel : " + s.getSalaire());
				}
			}
			
		}
		// try {
		// System.out.println(cs.rechercheParAbreviation("blb").getNom());
		// } catch (EntityNotFoundSericeException e) {
		// System.out.println(e.getMessage());
		// }
		// Technologie t1 = new Technologie("jsf");
		// Technologie t2 = new Technologie("struts2");
		// Competence comp1 = new Competence("dev jsf", 2, t1);
		// Competence comp2 = new Competence("dev des app web ac str2", 4, t2);
		// List<Competence> comps = new ArrayList<Competence>();
		// comps.add(comp1);
		// comps.add(comp2);
		// Poste p = new Poste("poste1", new Date(), true);
		// PosteAPP pAPP = new PosteAPP("posteApp", new Date(), true);
		// Salaire s = new Salaire(12000, new Date(), true);
		// ManagerRH mrh = new ManagerRH();
		// mrh.setNom("ben");
		// Collaborateur col = new Collaborateur();
		// col.setNom("belhassan");
		// col.setPrenom("youness");
		// col.setAbreviation("bly");
		// col.setMatricule("mat1");
		// cs.ajouterCollaborateur(col, p, pAPP, s, comps, mrh);
		// System.out.println(cs.getAll().size());
		System.out.println("fin");
	}
}
