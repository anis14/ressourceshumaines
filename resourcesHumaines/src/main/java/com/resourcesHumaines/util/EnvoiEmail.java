package com.resourcesHumaines.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;

/**
 * est une classes utilitaire permettant d'envoyer un email 
 */
public class EnvoiEmail {

	public static void envoyerEmail(String pTo) throws IOException{
		Properties properties = new Properties();
	      FileInputStream input;
		try {
			input = new FileInputStream(new ClassPathResource("configuration.properties").getFile());
					//FileInputStream("src/main/resources/configuration.properties");
		} catch (FileNotFoundException e1) {
			throw e1;
		}
	 
	   try {
			properties.load(input);
			} catch (IOException e) {
				throw e;
	      }
	   finally{
	          try {
				input.close();
			} catch (IOException e) {
				throw e;
			}
	   }
	   	
	   	final String username = (String) properties.get("email");
		final String password = (String) properties.get("pass");
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", properties.get("gmailHost").toString());
		props.put("mail.smtp.port", properties.get("portSMTP").toString());
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(properties.get("email").toString()));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(pTo));
			message.setSubject(properties.get("sujet").toString());
			message.setText(properties.get("contenu").toString());
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	   }
}
