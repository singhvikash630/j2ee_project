package com.jspider.jsp.javamail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class MyGmailAuthenticator extends Authenticator 
{
	protected PasswordAuthentication getPasswordAuthentication()
	{
	return new PasswordAuthentication("javamailsingh.vikash630@gmail.com","vikashsingh1");
	}

}
