package com.souramandala.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.souramandala.entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	public void deleteByProductId(int productId);

}
