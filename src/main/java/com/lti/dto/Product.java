package com.lti.dto;

public class Product {
	private int pId;
	private String pName;
	private String pBrand;
	private int pPrice;
	private String pImage1;
	private String pImage2;
	private String pImage3;
	private String pImage4;
	private String pDescription;

	public String getpImage2() {
		return pImage2;
	}

	public void setpImage2(String pImage2) {
		this.pImage2 = pImage2;
	}

	public String getpImage3() {
		return pImage3;
	}

	public void setpImage3(String pImage3) {
		this.pImage3 = pImage3;
	}

	public String getpImage4() {
		return pImage4;
	}

	public void setpImage4(String pImage4) {
		this.pImage4 = pImage4;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public Product(String pImage1, String pImage2, String pImage3, String pImage4, String pDescription, int pId,
			String pName, String pBrand, int pPrice) {
		super();
		this.pImage1 = pImage1;
		this.pImage2 = pImage2;
		this.pImage3 = pImage3;
		this.pImage4 = pImage4;
		this.pDescription = pDescription;
		this.pId = pId;
		this.pName = pName;
		this.pBrand = pBrand;
		this.pPrice = pPrice;
	}

	public String getpImage1() {
		return pImage1;
	}

	public void setpImage1(String pImage1) {
		this.pImage1 = pImage1;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
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

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

}
