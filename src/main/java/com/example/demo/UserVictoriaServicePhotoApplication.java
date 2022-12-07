package com.example.demo;

import java.util.Map;
import java.util.Properties;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserVictoriaServicePhotoApplication {
	public static void sendEmail(Session session, String toEmail, String subject, String body){
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      //msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      //msg.addHeader("format", "flowed");
	      //msg.addHeader("Content-Transfer-Encoding", "8bit");
	      msg.setFrom(new InternetAddress("lingengx@gmail.com", "NoReply-JD"));
	      msg.setReplyTo(InternetAddress.parse("andiasdi8888@gmail.com", false));
	      //msg.setSubject(subject, "UTF-8");
	      //msg.setText(body, "UTF-8");
	      msg.setSentDate(new Date());
	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}

	public static void main(String[] args) {
		SpringApplication.run(UserVictoriaServicePhotoApplication.class, args);
        System.out.println("SimpleEmail Start");
		String smtpHostServer = "smtp.gmail.com";
	    String emailID = "andiasdi8888@gmail.com";
	    
	    Properties props = System.getProperties();

	    props.put("mail.smtp.host", smtpHostServer);

	    Session session = Session.getInstance(props, null);
	    
	    sendEmail(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");

		
	}

}
