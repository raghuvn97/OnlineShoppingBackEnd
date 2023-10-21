package com.lti.service;

import java.util.List;

import com.lti.dto.Product;

public interface ProductService {
	public List<Product> getAllProduct();
	public Product getProductById(int pId);
	public List<Product> getProductBySearch(String keyword);
	public List<Product> sortProduct(String by, int order);
	public List<Product> filterProduct(String brand, int s, int e);
	public boolean deleteProduct(int pId);
}
