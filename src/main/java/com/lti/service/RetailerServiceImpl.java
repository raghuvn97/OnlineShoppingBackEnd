package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.AddProduct;
import com.lti.dto.Product;
import com.lti.dto.RetailerSignUp;
import com.lti.entity.ProductTable;
import com.lti.entity.RetailerTable;
import com.lti.exception.CustomerException;
import com.lti.repository.RetailerRepository;

@Service
public class RetailerServiceImpl implements RetailerService {
	
	
	@Autowired
	private RetailerRepository retailerRepository;

	@Override
	@Transactional
	public int addRetailer(RetailerSignUp newRetailer) {
		// TODO Auto-generated method stub
		int id = 0;
		try
		{
			RetailerTable user = this.retailerRepository.getRetailerByEmail(newRetailer.getuEmail());
			return -100;
		}
		catch(NullPointerException e)
		{
			return -100;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			id = this.retailerRepository.addRetailer(newRetailer);
		}
		return id;
	}

	@Override
	public int  addProduct(AddProduct product, int rId) {
		// TODO Auto-generated method stub
		return this.retailerRepository.addProduct(product, rId);
	}

	@Override
	public RetailerTable updateRetailer(RetailerSignUp updateRetailer) {
		// TODO Auto-generated method stub
		return this.retailerRepository.updateRetailer(updateRetailer);
	}

	@Override
	public AddProduct updateProduct(AddProduct updateProduct, int pId) {
		// TODO Auto-generated method stub
		return this.retailerRepository.updateProduct(updateProduct, pId);
	}

	@Override
	public List<Product> getMyProducts(int rId) {
		// TODO Auto-generated method stub
		return this.retailerRepository.showMyProducts(rId);
	}

	@Override
	public int loginRetailer(String rEmail, String rPassword) throws CustomerException {
		// TODO Auto-generated method stub
		return this.retailerRepository.getRetailerByEmailAndPassword(rEmail, rPassword);
	}

	@Override
	public RetailerSignUp getRetailerById(int rId) {
		// TODO Auto-generated method stub
		return this.retailerRepository.getRetailerById(rId);
	}

	@Override
	public boolean deleteRetailer(int rId) {
		retailerRepository.deleteRetailer(rId);
		return true;
	}

	@Override
	public void updateProductPic(int  pId, String newFileName1,String newFileName2,String newFileName3,String newFileName4) {
		retailerRepository.updateProductPic(pId, newFileName1,newFileName2,newFileName3,newFileName4);
	}
	
}
