package com.souramandala.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.souramandala.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>  {
	
	@Query(value = "SELECT * from cart c WHERE c.cust_id=?", nativeQuery = true)
	public Cart findCartIdByCustId(int custId);

}
