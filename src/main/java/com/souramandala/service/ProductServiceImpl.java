
package com.souramandala.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souramandala.entity.Product;
import com.souramandala.exception.CustomerException;
import com.souramandala.repo.ProductRepo;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo productRepo;

	@Override
	public String createProduct(Product product) throws CustomerException {
		productRepo.save(product);
		return "Product Added Successfully";
	}

	@Override
	public List<Product> getAllProductsByCategory(String categoryName) {
		return productRepo.findAllByProductCategory(categoryName);
	}

	@Override
	public String createManyProducts(List<Product> products) {
		productRepo.saveAll(products);
		return "Products Saved Successfully";
	}

	@Override
	public List<Product> getAllProductsLike(String categoryName) {
		return productRepo.findByProductNameContainingIgnoreCase(categoryName);
	}

	@Override
	public Product getProductById(int proId) {
		Product tempProd = new Product();
		tempProd= productRepo.findByProductId(proId);
		if(tempProd==null) {
			throw new CustomerException("No Product Found");
		}else {
			return tempProd;
		}
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	/*
	 * @Override public String updateProductQuantity(int updatedQuantity,int prodId)
	 * { productRepo.updateQuantity(updatedQuantity, prodId); return
	 * "Quantity Updated"; }
	 */
	

}
