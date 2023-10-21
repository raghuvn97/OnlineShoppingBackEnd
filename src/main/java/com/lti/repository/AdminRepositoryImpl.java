package com.lti.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.ProductTable;

@Repository
@Transactional
public class AdminRepositoryImpl implements AdminRepository{
  
	@Autowired
	EntityManager entityManager;
	
	
	@Override
	public String approveProduct(int pid) {
		ProductTable product=entityManager.find(ProductTable.class, pid);
		product.setApprove_status(1);
		return "Product Approved";
	}

}
