package com.lti.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AddProduct;
import com.lti.dto.Login;
import com.lti.dto.Product;
import com.lti.dto.ProductPictures;
import com.lti.dto.RetailerSignUp;
import com.lti.entity.RetailerTable;
import com.lti.exception.CustomerException;
import com.lti.service.PictureUploadService;
import com.lti.service.RetailerService;

@RestController
@CrossOrigin
public class RetailerController {
	

	@Autowired
	private RetailerService retailerService;
	
	@Autowired
	private PictureUploadService picuploadService;

	@PostMapping(path = "/addNewRetailer") //passed
	public int addNewRetailer(@RequestBody RetailerSignUp newRetailer)
	{
		return this.retailerService.addRetailer(newRetailer);
	}
	 
	@PostMapping(path = "/addProduct/{rId}") //passed
	
	public int addProduct(@RequestBody AddProduct product, @PathVariable String rId)
	{
		return this.retailerService.addProduct(product, Integer.parseInt(rId));
	}
	@PutMapping(path = "/updateRetailer") //passed
	public RetailerTable updateRetailer(@RequestBody RetailerSignUp updateRetailer)
	{
		return this.retailerService.updateRetailer(updateRetailer);
	}
	
	@PutMapping(path = "/updateProduct/{pId}") //passed
	public AddProduct updateProduct(@RequestBody AddProduct updateProduct, @PathVariable String pId)
	{
		return this.retailerService.updateProduct(updateProduct, Integer.parseInt(pId));
	}
	
	@GetMapping(path = "/getMyProduct/{rId}")
	public List<Product> getMyProduct(@PathVariable String rId,HttpServletRequest request)
	{
		List<Product> prod=this.retailerService.getMyProducts(Integer.parseInt(rId));
        for(Product product:prod) {
			
			String projPath = request.getServletContext().getRealPath("/");
			String tempDownloadPath = projPath+"/downloads/";
			
			File f = new File(tempDownloadPath);
			if(!f.exists())
				f.mkdir();
			
			String targetFile1 = tempDownloadPath+product.getpImage1();
			String targetFile2 = tempDownloadPath+product.getpImage2();
			String targetFile3 = tempDownloadPath+product.getpImage3();
			String targetFile4 = tempDownloadPath+product.getpImage4();
			System.out.println(tempDownloadPath);
			
			String uploadedImagesPath = "G:/uploads/";
			String sourceFile1 = uploadedImagesPath+product.getpImage1();
			String sourceFile2 = uploadedImagesPath+product.getpImage2();
			String sourceFile3= uploadedImagesPath+product.getpImage3();
			String sourceFile4 = uploadedImagesPath+product.getpImage4();
			
			try {
				FileCopyUtils.copy(new File(sourceFile1), new File(targetFile1));
				FileCopyUtils.copy(new File(sourceFile2), new File(targetFile2));
				FileCopyUtils.copy(new File(sourceFile3), new File(targetFile3));
				FileCopyUtils.copy(new File(sourceFile4), new File(targetFile4));
				
				
				System.out.println("done");
			}catch(IOException e) {
				e.printStackTrace();
				System.out.println("not done");
			}
			
		}
		return this.retailerService.getMyProducts(Integer.parseInt(rId));
	}
	@PostMapping(path = "/retailerLogin") //passed
	public int retailerLogin(@RequestBody Login login)
	{
		try {
			return this.retailerService.loginRetailer(login.getEmail(), login.getPassword());
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -100;
		}
	}
	@GetMapping(path = "/getRetailerById/{rId}")
	public RetailerSignUp getRetailerById(@PathVariable String rId)
	{
		return this.retailerService.getRetailerById(Integer.parseInt(rId));
	}

	@DeleteMapping(path = "/deleteRetailer/{rId}") 
	public ResponseEntity<HttpStatus> deleteRetailer(@PathVariable String rId)
	{
		try
		{
			boolean ok = this.retailerService.deleteRetailer(Integer.parseInt(rId));
			return new ResponseEntity<>(HttpStatus.OK);
	}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}}
	
	
	@PostMapping("/picupload")
	public String upload(ProductPictures productpics) {
		
		this.picuploadService.uploadProductPics(productpics);
		return "upload product successfully";
	}

}
