package com.lti.repository;

import java.util.List;

import com.lti.dto.AddProduct;
import com.lti.dto.PlacedOrder;
import com.lti.dto.Product;
import com.lti.dto.RetailerSignUp;
import com.lti.dto.UserSignUp;
import com.lti.entity.RetailerTable;
import com.lti.entity.UserTable;
import com.lti.exception.CustomerException;

public interface RetailerRepository {
	public int getRetailerByEmailAndPassword(String email, String password) throws CustomerException;
	public RetailerTable getRetailerByEmail(String email) throws CustomerException;
	public int addRetailer(RetailerSignUp newRetailer);
    public boolean updateProductPic(int  pId, String newFileName,String newFileName2,String newFileName3,String newFileName4);
	public RetailerTable updateRetailer(RetailerSignUp updateRetailer);
	public AddProduct updateProduct(AddProduct updateProduct, int pId);
	public List<Product> showMyProducts(int rId);
	public List<RetailerSignUp> showAllRetailers();
	public int addProduct(AddProduct product, int rId);
	public RetailerSignUp getRetailerById(int rId);
	public boolean deleteRetailer(int rId);
}
