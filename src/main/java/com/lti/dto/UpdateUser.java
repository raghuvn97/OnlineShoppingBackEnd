package com.lti.dto;

public class UpdateUser {
	private int uId;
	private String uName;
	private String uEmail;
	private String uPassword;
	private String uAddress;
	private long uMobile;
	public UpdateUser() {
		// TODO Auto-generated constructor stub
	}
	public UpdateUser(int uId, String uName, String uEmail, String uPassword, String uAddress, long uPhone) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.uAddress = uAddress;
		this.uMobile = uPhone;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
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
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	public long getuPhone() {
		return uMobile;
	}
	public void setuPhone(long uPhone) {
		this.uMobile = uPhone;
	}
	
}
