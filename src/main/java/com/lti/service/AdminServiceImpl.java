package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.RetailerSignUp;
import com.lti.repository.AdminRepository;
import com.lti.repository.RetailerRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private RetailerRepository retailerRepository;
	
	@Autowired 
	private AdminRepository adminRepository;
	
	@Override
	public List<RetailerSignUp> showAllRetailers() {
		// TODO Auto-generated method stub
		return this.retailerRepository.showAllRetailers();
	}

	@Override
	public String approveProduct(int pId) {
		// TODO Auto-generated method stub
		return this.adminRepository.approveProduct(pId);
	}

}
