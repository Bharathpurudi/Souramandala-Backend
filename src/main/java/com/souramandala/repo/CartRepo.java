package com.souramandala.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.souramandala.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>  {
	
	@Query(value = "SELECT * from cart c WHERE c.cust_id=?", nativeQuery = true)
	public Cart findCartIdByCustId(int custId);
	
	//@Query(value="SELECT * FROM cart c INNER JOIN order_entity oe ON c.cart_id=oe.cart_id INNER JOIN order_products op ON oe.order_id=op.order_id WHERE c.cust_id=?", nativeQuery = true)
	public Cart findBycartId(int custId);

}
