package com.lti.service;

import com.lti.dto.Login;

public interface EmailService {

	public void sendEmailForOTP(String email,String otp,String subject);
	public void sendEmailForRetailerAdd(Login login,String subject);


}
