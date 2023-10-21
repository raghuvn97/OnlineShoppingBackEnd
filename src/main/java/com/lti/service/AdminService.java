package com.lti.service;

import java.util.List;

import com.lti.dto.RetailerSignUp;

public interface AdminService {
	public List<RetailerSignUp> showAllRetailers();
    public String approveProduct(int pId );
  }
