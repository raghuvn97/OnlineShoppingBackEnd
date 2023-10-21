package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.Product;
import com.lti.entity.ProductTable;
import com.lti.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	

	@Override
	public List<Product> getAllProduct() {
		
		return this.productRepository.getAllProducts();
	}

	@Override
	public Product getProductById(int pId) {
		// TODO Auto-generated method stub
		return this.productRepository.getProductById(pId);
	}

	@Override
	public List<Product> getProductBySearch(String keyword) {
		// TODO Auto-generated method stub
		return this.productRepository.getProductBySearchKeyWord(keyword);
	}

	@Override
	public List<Product> sortProduct(String by, int order) {
		// TODO Auto-generated method stub
		return this.productRepository.sortProduct(by, order);
	}

	@Override
	public List<Product> filterProduct(String brand, int s, int e) {
		// TODO Auto-generated method stub
		return this.productRepository.filterProduct(brand, s, e);
	}

	@Override
	public boolean deleteProduct(int pId) {
	     productRepository.deleteProduct(pId);
		return true;
	}

}
