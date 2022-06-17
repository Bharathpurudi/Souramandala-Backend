package com.souramandala.repo;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.souramandala.entity.Customer;


@Repository
@Transactional
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	public Customer findBycustId(int custId);
	
	public Customer findByuserName(String userName);
	
	public Customer findByfirstName(String firstName);
	
	@Modifying
	@Query(value="UPDATE customers c SET c.first_name=?1, c.last_name=?2, c.password=?3, c.mobile_num=?4, c.mail_id=?5 WHERE c.cust_id=?6",nativeQuery = true)
	public void updateCustomerDetails(String firstName, String lastName, String password, String mobNum, String mailId, int custId);
	

}
