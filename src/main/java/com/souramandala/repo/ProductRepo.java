package com.souramandala.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.souramandala.entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	public List<Product> findAllByProductCategory(String categoryName);
	
	public List<Product> findByProductNameContainingIgnoreCase(String product);
	
	public Product findByProductId(int prodId);
	
	public void deleteByProductId(int productId);
	
	@Query(value="UPDATE product p SET p.stock_quantity=?1 WHERE p.product_id=?2", nativeQuery = true)
	public void updateQuantity(int updatedQuantity,int productId);
	

}
