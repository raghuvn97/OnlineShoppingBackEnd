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
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Product;
import com.lti.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	

	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "/getProductById/{pId}") 
	public Product getProductById(@PathVariable String pId)
	{
		
		return this.productService.getProductById(Integer.parseInt(pId));
	}
	
	@GetMapping(path = "/getProductBySearch/{pSearch}") 
	public List<Product> getProductBySearch(@PathVariable String pSearch, HttpServletRequest request)
	{
		List<Product> prod=this.productService.getProductBySearch(pSearch);
		//    ProductTable product=productService.getProductById(Integer.parseInt(pId));
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
				
		return this.productService.getProductBySearch(pSearch);
	}
	
	@GetMapping(path = "/sortProduct/{by}/{order}")
	public List<Product> sortProduct(@PathVariable String by, @PathVariable String order)
	{
		return this.productService.sortProduct(by, Integer.parseInt(order));
	}
	
	@GetMapping(path = "/filterProduct/{brand}/{s}/{e}") 
	public List<Product> sortProduct(@PathVariable String brand, @PathVariable String s, @PathVariable String e)
	{
		return this.productService.filterProduct(brand, Integer.parseInt(s), Integer.parseInt(e));
	}
	@DeleteMapping(path = "/deleteMyproduct/{pId}") 
	public ResponseEntity<HttpStatus> deleteMyProduct(@PathVariable String pId)
	{
		try
		{
			boolean status = this.productService.deleteProduct(Integer.parseInt(pId));
			if (status) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}}

	@GetMapping(path = "/getAllProduct")
	public List<Product> getAllProduct(HttpServletRequest request)
	{ 
		 List<Product> prod=this.productService.getAllProduct();
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
		
		return this.productService.getAllProduct();
	}
	

}
