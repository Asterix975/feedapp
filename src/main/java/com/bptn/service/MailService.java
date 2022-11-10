package com.bptn.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service; 

@Service
public class MailService {
	
	final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass()); 

	@Async
	public void sendEmail() throws AddressException, MessagingException {

		   Properties props = new Properties();
		   
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");

           /*
		    * As this example uses Gmail, please ensure a new password is 
            * created properly with the Google two-step verification feature.
		    */    
        
		   logger.debug ("Connecting to Gmail:...");  
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("hassan.asterix@gmail.com", "mkfpevodnkcroxwb");
		      }
		   });
		   
		   Message msg = new MimeMessage(session);
		   
		   msg.setFrom(new InternetAddress("hassan.asterix@gmail.com", false));

           /* Recipient */
		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("hassan.asterix@gmail.com")); //or isntead of email use recepient, passing as a variable
		   msg.setSubject("I Love Spring Mail");
		   msg.setContent("Welcome to Spring Mail", "text/html");
		   msg.setSentDate(new Date());

		   Multipart multipart = new MimeMultipart(); //Create a MultiPart Message 

		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent("I love Spring", "text/html");
		   multipart.addBodyPart(messageBodyPart); // Add the body to the MultiPart
		   
		   /*
		   MimeBodyPart attachPart = new MimeBodyPart();
		   attachPart.attachFile("/var/tmp/bptn.png");
		   multipart.addBodyPart(attachPart);*/ // Add the attachment to the MultiPart
		   
		   msg.setContent(multipart);
		   
		   Transport.send(msg);  
		   
		   logger.debug("Email Sent"); 
		}
}