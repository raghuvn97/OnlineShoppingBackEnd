package com.lti.dto;

public class RetailerSignUp {

	private int rId;
	private String uName;
	private String uEmail;
	private String uPassword;
	private long uPhone;

	public RetailerSignUp() {
		// TODO Auto-generated constructor stub
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public long getuPhone() {
		return uPhone;
	}

	public void setuPhone(long uPhone) {
		this.uPhone = uPhone;
	}

	public RetailerSignUp(String uName, String uEmail, String uPassword, long uPhone, int rId) {
		super();
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.uPhone = uPhone;
		this.rId = rId;
	}

}
