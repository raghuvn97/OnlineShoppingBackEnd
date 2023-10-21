package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RetailerSignUp;
import com.lti.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping(path = "/approveProduct/{pId}")
	public String approvestatusProduct(@PathVariable int pId) {

		   
		return adminService.approveProduct(pId);
	}

	@GetMapping(path = "/showAllRetailers")
	public List<RetailerSignUp> showAllRetailers() {
		return this.adminService.showAllRetailers();
	}

}
