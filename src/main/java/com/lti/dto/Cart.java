package com.lti.dto;

public class Cart {
	private int cId;
	private int pId;
	private int qty;
	private String pImage1;
	private String pName;
	private String pBrand;
	private int pPrice;
	private int totalPrice;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public String getpName() {
		return pName;
	}
	public Cart(int pId, int qty, String pName, String pBrand, int pPrice, int cId, int totalPrice, String pImage1) {
		super();
		this.pId = pId;
		this.qty = qty;
		this.pName = pName;
		this.pBrand = pBrand;
		this.pPrice = pPrice;
		this.cId = cId;
		this.totalPrice = totalPrice;
		this.pImage1 = pImage1;
	}
	public String getpImage1() {
		return pImage1;
	}
	public void setpImage1(String pImage1) {
		this.pImage1 = pImage1;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpBrand() {
		return pBrand;
	}
	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
