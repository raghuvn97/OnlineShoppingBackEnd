package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductPictures {
	
	private int pId;
	private MultipartFile pImage1;
	private MultipartFile pImage2;
	private MultipartFile pImage3;
	private MultipartFile pImage4;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public MultipartFile getpImage1() {
		return pImage1;
	}
	public void setpImage1(MultipartFile pImage1) {
		this.pImage1 = pImage1;
	}
	public MultipartFile getpImage2() {
		return pImage2;
	}
	public void setpImage2(MultipartFile pImage2) {
		this.pImage2 = pImage2;
	}
	public MultipartFile getpImage3() {
		return pImage3;
	}
	public void setpImage3(MultipartFile pImage3) {
		this.pImage3 = pImage3;
	}
	public MultipartFile getpImage4() {
		return pImage4;
	}
	public void setpImage4(MultipartFile pImage4) {
		this.pImage4 = pImage4;
	}
	
	
	
	
	

}
