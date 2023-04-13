package com.email.app;
//Refer this video: https://youtu.be/l0J-Edn76js
//For Google password generator: https://www.youtube.com/watch?v=IWxwWFTlTUQ&ab_channel=MakersGroup

import java.io.File;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class App {

	private static void sendEmail(String subject, String message, String to, String from) {

		// Variable for gmail
		String host = "smtp.gmail.com";

		// get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES " + properties);

		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Step 1: to get the session object..
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("chiragahirmiit@gmail.com", "pkgooybknpftufyu");
			}
		});
		session.setDebug(true);

		// Step 2: compose message
		MimeMessage m = new MimeMessage(session);

		try {
			m.setFrom(from);
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			m.setText(message);

			// Step 3 : send the message using Transport class
			Transport.send(m);
			System.out.println("Sent success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void sendEmailWithAttachment(String subject, String message, String to, String cc, String from) {

		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();

		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Step 1: to get the session object..
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("chiragahirmiit@gmail.com", "pkgooybknpftufyu");
			}
		});
		session.setDebug(true);

		// Step 2: compose message
		MimeMessage m = new MimeMessage(session);

		try {
			m.setFrom(from);
			//Attching all recepients
			InternetAddress[] iAddressArray = InternetAddress.parse(to);
			m.addRecipients(Message.RecipientType.TO, iAddressArray);
			//Attching all cc recepients
			InternetAddress[] icAddressArray = InternetAddress.parse(cc);
			m.addRecipients(Message.RecipientType.CC, icAddressArray);
			m.setSubject(subject);

			// Attachment
			String filePath = "D:\\MIIT\\web_apps\\Email_API\\src\\main\\java\\com\\email\\app\\SuccessFactor.png";
			
			MimeMultipart mimeMultipart = new MimeMultipart();
			MimeBodyPart textMime = new MimeBodyPart(); //attching text 
			MimeBodyPart fileMime = new MimeBodyPart(); //attching file

			textMime.setText(message);

			File file = new File(filePath);
			fileMime.attachFile(file);

			mimeMultipart.addBodyPart(textMime);
			mimeMultipart.addBodyPart(fileMime);

			m.setContent(mimeMultipart);
			
			// Step 3 : send the message using Transport class
			Transport.send(m);
			System.out.println("Sent success");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("Hello chirag.");
		String subject = "Do Not Reply";
		String message = "Kindly do not reply on this email. This is sample testing of mail API.";
		String to = "ahirchirag8125@gmail.com,ahirchirag1459@gmail.com,keralp312@gmail.com";
		String cc = "chiragahir@outlookemail.ca";
		String from = "chiragahirmiit@gmail.com";
		// sendEmail(subject,message,to,from);
		sendEmailWithAttachment(subject, message, to, cc, from);
	}

}
