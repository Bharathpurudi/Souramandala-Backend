package com.souramandala.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.souramandala.entity.Product;
import com.souramandala.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(value="product/createProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@GetMapping(value="product/getAllProducts/{catName}")
	public List<Product> getAllProductsByCategory(@PathVariable String catName){
		return productService.getAllProductsByCategory(catName);
	}
	
	@PostMapping(value="product/createProducts", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createProducts(@RequestBody List<Product> products) {
		return productService.createManyProducts(products);
	}
	
	@GetMapping(value="product/getAllProductsLike/{catName}")
	public List<Product> getAllProductsLike(@PathVariable String catName){
		return productService.getAllProductsLike(catName);
	}
	
	
	/*
	 * @PutMapping(value="/product/updatequantity") public String
	 * updateProductQuantity(@PathVariable int updtQantity, @PathVariable int
	 * prodId) { return productService.updateProductQuantity(updtQantity, prodId); }
	 */
	
	

}
