package com.cyu.laclad.utils;

import java.security.SecureRandom;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Utils {

	private static final Random RANDOM = new SecureRandom();
	public static final String validCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static final int PASWWORD_LENGHT = 8;
	
	public static String generateRandomPassword() {
        String password = new String();
        for (int i = 0; i < PASWWORD_LENGHT; i++) {
        	int index = (int)(RANDOM.nextDouble()*validCharacters.length());
        	password += validCharacters.substring(index, index)+1;
			
		}
        return password;
    }
	
	public static class SMTPAuthenticator extends Authenticator {
		private PasswordAuthentication authentication;
		
		public SMTPAuthenticator(String login, String password) {
			authentication = new PasswordAuthentication(login, password);
		}
		
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return authentication;
		}
	}
	
	public static void sendEmail(String email, String name, String newPssword) {

		try {
			String login = "ajcr81@gmail.com";
			String password = "GM@jcr81";
		
			Properties props = new Properties();
			props.put("mail.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "25");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			
			Authenticator auth = new SMTPAuthenticator(login, password);
			Session session = Session.getInstance(props, auth);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("laclad@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("New Password");
			message.setText("Dear ," + name + "this is your password for the LACLAD application: " + newPssword);
			//Transport.send(message);
		
			System.out.println("Done");
	
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
