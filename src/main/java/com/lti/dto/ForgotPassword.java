package com.lti.dto;

public class ForgotPassword {
	private String email;
	private String password;
	private String otp;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "ForgotPassword [email=" + email + ", password=" + password + ", otp=" + otp + "]";
	}

	
}
