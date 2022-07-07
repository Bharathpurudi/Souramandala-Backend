package com.souramandala.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.souramandala.entity.Address;
@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>  {
	
	@Query(value = "SELECT * FROM address a WHERE a.cust_id=?1",nativeQuery = true)
	public List<Address> findAllByCustId(int custId);
	

}
