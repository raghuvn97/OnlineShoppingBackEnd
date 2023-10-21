package com.lti.dto;

public class AddProduct {
	private String pBrand;
	private String pCategory;
	private String pSubCategory;
	private String pDescription;
	private String pImage1;
	private String pImage2;
	private String pImage3;
	private String pImage4;
	private String pName;
	private int pPrice;
	private int pQty;

	public AddProduct() {
		// TODO Auto-generated constructor stub
	}

	public String getpBrand() {
		return pBrand;
	}

	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getpSubCategory() {
		return pSubCategory;
	}

	public void setpSubCategory(String pSubCategory) {
		this.pSubCategory = pSubCategory;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public String getpImage1() {
		return pImage1;
	}

	public void setpImage1(String pImage1) {
		this.pImage1 = pImage1;
	}

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

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getpQty() {
		return pQty;
	}

	public void setpQty(int pQty) {
		this.pQty = pQty;
	}

	public AddProduct(String pBrand, String pCategory, String pSubCategory, String pDescription, String pImage1,
			String pImage2, String pImage3, String pImage4, String pName, int pPrice, int pQty) {
		super();
		this.pBrand = pBrand;
		this.pCategory = pCategory;
		this.pSubCategory = pSubCategory;
		this.pDescription = pDescription;
		this.pImage1 = pImage1;
		this.pImage2 = pImage2;
		this.pImage3 = pImage3;
		this.pImage4 = pImage4;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pQty = pQty;
	}

}
