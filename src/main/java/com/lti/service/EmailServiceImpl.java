package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.lti.dto.Login;
@Service
public class EmailServiceImpl implements EmailService {

		@Autowired
	    private MailSender mailSender;
		
	    public void sendEmailForOTP(String email,String otp,String subject) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("buyzaarshopping@outlook.com");
	        message.setTo(email);
	        message.setSubject(subject);
	        message.setText(otp);
	        mailSender.send(message);
	}
		@Override
		public void sendEmailForRetailerAdd(Login login, String subject) {
			SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("buyzaarshopping@outlook.com");
	        message.setTo(login.getEmail());
	        message.setSubject(subject);
	        String cred = "Emailid "+login.getEmail() + " " +"Password "+ login.getPassword();
	        message.setText(cred);
	        mailSender.send(message);
		}
		
}