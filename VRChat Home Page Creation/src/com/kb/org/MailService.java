package com.kb.org;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {
	private char[] alpha = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
	String host = "smtp.naver.com";
	final String user = "cont00";
	final String password = "dreamcome854612!";

	// String to = "ruserive@gmail.com";

	public String getAlpha() {
		char[] temp = new char[4];
			temp[0] = alpha[(int) (Math.random() * 8)];
			temp[1] = alpha[(int) (Math.random() * 8)];
			temp[2] = alpha[(int) (Math.random() * 8)];
			temp[3] = alpha[(int) (Math.random() * 8)];
		return new String(temp);
	}

	public String sendMail(String Mailaddress) {
		System.out.println("Mailaddress = " + Mailaddress);
		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(Mailaddress));

			// Subject
			message.setSubject("Your confirmation email.");

			String makeCode = getAlpha();
			// Text
			// message.setText("If you are right, click on the link below.");
			message.setText(makeCode);

			// send the message
			Transport.send(message);
			System.out.println("message sent successfully...");
			return makeCode;
		} catch (MessagingException e) {
			e.printStackTrace();
			return null;
		}
	}
}