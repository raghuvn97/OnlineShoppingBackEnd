package com.lti.dto;

public class PlacedOrder {
	private int pId;
	private String pImage;
	private String pBrand;
	private int pPrice;
	private String pOrderDate;
	private int pQty;
	private String pType;
	private String pName;
	public PlacedOrder(String pName, int pId, String pImage, String pBrand, int pPrice, String pOrderDate, int pQty, String pType) {
		super();
		this.pName = pName;
		this.pId = pId;
		this.pImage = pImage;
		this.pBrand = pBrand;
		this.pPrice = pPrice;
		this.pOrderDate = pOrderDate;
		this.pQty = pQty;
		this.pType = pType;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public int getpQty() {
		return pQty;
	}
	public void setpQty(int pQty) {
		this.pQty = pQty;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public String getpBrand() {
		return pBrand;
	}
	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public String getpOrderDate() {
		return pOrderDate;
	}
	public void setpOrderDate(String pOrderDate) {
		this.pOrderDate = pOrderDate;
	}
	
}
