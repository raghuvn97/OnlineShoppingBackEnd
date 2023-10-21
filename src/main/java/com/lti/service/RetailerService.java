package com.lti.service;

import java.util.List;

import com.lti.dto.AddProduct;
import com.lti.dto.Product;
import com.lti.dto.RetailerSignUp;
import com.lti.entity.RetailerTable;
import com.lti.exception.CustomerException;

public interface RetailerService {
	public int loginRetailer(String rEmail, String rPassword) throws CustomerException;
	public int addRetailer(RetailerSignUp newRetailer);
	public int addProduct(AddProduct product, int rId);
	public void updateProductPic(int  pId, String newFileName1,String newFileName2,String newFileName3,String newFileName4);
	public RetailerTable updateRetailer(RetailerSignUp updateRetailer);
	public AddProduct updateProduct(AddProduct updateProduct, int pId);
	public List<Product> getMyProducts(int rId);
	public RetailerSignUp getRetailerById(int rId);
	public boolean deleteRetailer(int rId);
}
