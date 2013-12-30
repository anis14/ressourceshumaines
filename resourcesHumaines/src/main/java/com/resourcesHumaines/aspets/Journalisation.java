/**
 * 
 */
package com.resourcesHumaines.aspets;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

/**
 *est une classe representant les aspets permetant de gerer la journalisation de l application
 */
public class Journalisation {

	/**
	 * l'objet permettant de tracer les actions
	 */
	private Logger log = Logger.getLogger(Journalisation.class);
	
	/**
	 * l'aspect contenant le traitement a executer au debut de la methode intercepte
	 * @param pJoinPoint un objet contenant des information de la methode intercepte
	 */
	public void avantExecution(JoinPoint pJoinPoint){
		//afficher un message contenant le nom de la methode 
		log.info("debut de la methode " + pJoinPoint.getSignature().getName() + " de la classe : " +
				""+ pJoinPoint.getTarget().getClass());
	}
	
	/**
	 * l'aspect contenant le traitement a executer a la fin de la methode intercepte
	 * @param pJoinPoint un objet contenant des information de la methode intercepte
	 */
	public void apresExecution(JoinPoint pJoinPoint){
		//afficher un message contenant le nom de la methode 
		log.info("fin de la methode " + pJoinPoint.getSignature().getName() + " de la classe : " +
				""+ pJoinPoint.getTarget().getClass());
	}
	
	/**
	 * l'aspect contenant le traitement a executer en cas d'interception d'une exception
	 * @param pJoinPoint un objet contenant des information de la methode intercepte
	 */
	public void enException(JoinPoint pJoinPoint){
		//afficher un message contenant le nom de la methode 
		log.info("exception dans la methode " + pJoinPoint.getSignature().getName() + " de la classe : " +
				""+ pJoinPoint.getTarget().getClass());
	}
	
}
