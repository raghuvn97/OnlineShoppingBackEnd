package com.lti.repository;

import java.util.List;

import com.lti.dto.Product;
import com.lti.entity.ProductTable;
import com.lti.exception.CartException;

public interface ProductRepository {
	public List<Product> getAllProducts();
	public Product  getProductById(int pId);
	public List<Product> getProductBySearchKeyWord(String keyword);
	public List<Product> sortProduct(String by, int order);
	public List<Product> filterProduct(String brand, int s, int e);
	public boolean deleteProduct(int pId);
}
