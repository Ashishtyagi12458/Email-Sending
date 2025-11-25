package com.Email.Service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;


@Service
public class EmailService {
	
	
	public boolean sendEmail(String to, String subject, String message) {
		
		  if (to == null || to.trim().isEmpty()) {
	            System.out.println("Receiver email is missing");
	            return false;
	        }
		
		boolean f=false;
		String from="tyagiashish1503@gmail.com";
		
		String host="smtp.gmail.com";
		
		// Get system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES"+properties);
		
		// Sitting Importent Information
		//set host
		
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		// 1 step to sending message
		// set session
		Session session=Session.getInstance(properties,new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("tyagiashish1503@gmail.com", "TYashish@85");
			}
				
		});
		session.setDebug(true);
        //Compose the message
		MimeMessage m=new MimeMessage(session);
		try {
		
			
			m.setFrom(from);
			//adding recipit frome message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to.trim()));
			
			//adding subject message
			m.setSubject(subject==null?"":subject);
			
			//adding text to message
			m.setText(message==null?"":message);
			
	//Step 3: sending message
			Transport.send(m);
			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

}
