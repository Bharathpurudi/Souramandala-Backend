package com.souramandala.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.souramandala.entity.OrderEntity;
@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {
	
	
	public List<OrderEntity> findByOrderIdNot(int orderId);

}
