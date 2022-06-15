package com.souramandala.service;

import java.util.List;

import com.souramandala.entity.Product;
import com.souramandala.exception.CustomerException;

public interface ProductService {
	
	public abstract Product getProductById(int proId);
	
	public abstract String createManyProducts(List<Product> products);
	
	public abstract String createProduct(Product product) throws CustomerException;
	
	public abstract List<Product> getAllProductsByCategory(String categoryName);
	
	public abstract List<Product> getAllProductsLike(String categoryName);
	
	public abstract List<Product> getAllProducts();
	
	//public abstract String updateProductQuantity());

}
