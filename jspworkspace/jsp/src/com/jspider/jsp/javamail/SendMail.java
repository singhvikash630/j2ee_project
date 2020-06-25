package com.jspider.jsp.javamail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail
{
	public static void main(String[] args) throws MessagingException
	{
		String fromAddr="singh.vikash630@gmail.com";
		String subject="text mail";
		String mailContent="hi..h r u?";
		String[] toAddr={"singh.vikash630@gmail.com","singh.vikash630@gmail.com"};
		
		Properties prop=new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable","true");
		prop.put("mail.smtp.host","smtp.gmail.com");
		prop.put("mail.smtp.port","587");
		
		MyGmailAuthenticator gmailAuthenticator=new MyGmailAuthenticator();
		Session session=Session.getDefaultInstance(prop,gmailAuthenticator);
		Message message=new MimeMessage(session);
		InternetAddress addrFrom=new InternetAddress(fromAddr);
		InternetAddress[] addrTo=new InternetAddress[toAddr.length];
		
		for(int i=0;i<toAddr.length;i++)
		{
			addrTo[i]=new InternetAddress(toAddr[i]);
		}
		message.setFrom(addrFrom);
		message.setRecipients(Message.RecipientType.TO,addrTo);
		message.setSubject(subject);
		//message.setText(mailContent);
		message.setContent(mailContent,"text/html");
		Transport.send(message);
		System.out.println("Mail send...");
		
		
	}

}
